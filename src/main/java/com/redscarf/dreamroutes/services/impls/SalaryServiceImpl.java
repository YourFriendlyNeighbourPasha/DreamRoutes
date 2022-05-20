package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.BaseModel;
import com.redscarf.dreamroutes.models.Salary;
import com.redscarf.dreamroutes.repositories.interfaces.*;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.SalaryService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Transactional
public class SalaryServiceImpl extends GenericServiceImpl<Salary>
        implements SalaryService {

    private final DriverRepository driverRepository;
    //#region Internal Shippings repos
    private final InternalShippingTaskRepository internalShippingTaskRepository;
    private final InternalShippingTaskReportRepository internalShippingTaskReportRepository;
    private final InternalAccidentRepository internalAccidentRepository;
    //endregion
    //#region External Shippings repos
    private final ExternalShippingTaskRepository externalShippingTaskRepository;
    private final ExternalShippingTaskReportRepository externalShippingTaskReportRepository;
    private final ExternalAccidentRepository externalAccidentRepository;
    //endregion

    public SalaryServiceImpl(
            SalaryRepository repository,
            DriverRepository driverRepository,
            InternalShippingTaskRepository internalShippingTaskRepository,
            InternalShippingTaskReportRepository internalShippingTaskReportRepository,
            InternalAccidentRepository internalAccidentRepository,
            ExternalShippingTaskRepository externalShippingTaskRepository,
            ExternalShippingTaskReportRepository externalShippingTaskReportRepository,
            ExternalAccidentRepository externalAccidentRepository
    ) {
        super(repository);
        this.driverRepository = driverRepository;
        this.internalAccidentRepository = internalAccidentRepository;
        this.internalShippingTaskRepository = internalShippingTaskRepository;
        this.internalShippingTaskReportRepository = internalShippingTaskReportRepository;
        this.externalShippingTaskRepository = externalShippingTaskRepository;
        this.externalShippingTaskReportRepository = externalShippingTaskReportRepository;
        this.externalAccidentRepository = externalAccidentRepository;
    }

    @Override
    public Salary calculateSalaryForDriverById(UUID driverId) {
        if (!driverRepository.findById(driverId).isPresent()) {
            throw new NoSuchElementException("The driver with ID " + driverId.toString() + "does not exist!");
        }

        //#region Calculate salary by internal tasks
        // Find all internal shipping tasks connected with driver
        var internalShippingTaskList = internalShippingTaskRepository.findByDriverId(driverId);

        var internalShippingTaskReports = internalShippingTaskList
                .stream()
                .map(BaseModel::getId)
                .map(internalShippingTaskReportRepository::findByInternalShippingTaskId)
                .collect(Collectors.toList());

        var internalAccidents = internalShippingTaskReports
                .stream()
                .map(BaseModel::getId)
                .map(internalAccidentRepository::findByInternalShippingTaskReportId)
                .collect(Collectors.toList());

        BigDecimal finalSalary = new BigDecimal("0.0");
        BigDecimal bonusSalary = new BigDecimal("0.0");

        // Calculating the amount of time
        if (!internalShippingTaskList.isEmpty() &&
                !internalShippingTaskReports.isEmpty() &&
                !internalShippingTaskList.contains(null) &&
                !internalShippingTaskReports.contains(null)
        ) {
            for (var ist : internalShippingTaskList) {
                var istReport = internalShippingTaskReports
                        .stream()
                        .filter(el -> el.getInternalShippingTask().getId() == ist.getId())
                        .findFirst().get();

                long expectedTime = ChronoUnit.SECONDS.between(ist.getDepartureTime(),
                        ist.getDepartureTime().plusSeconds(ist.getRoute().getEstimatedTime())
                );
                long actualTime = ChronoUnit.SECONDS.between(ist.getDepartureTime(), istReport.getDestinationTime());

                BigDecimal routeRate = ist.getRoute().getType().getRate();
                BigDecimal freightRate = ist.getFreight().getType().getRate();
                BigDecimal hourlyRate = new BigDecimal(expectedTime / 3600);

                if (expectedTime > actualTime) {
                    finalSalary = finalSalary.add(hourlyRate).multiply(routeRate);
                    finalSalary = finalSalary.add(finalSalary.multiply(freightRate));
                    bonusSalary = bonusSalary.add(new BigDecimal((expectedTime - actualTime) / 3600))
                                             .multiply(routeRate);
                    bonusSalary = bonusSalary.add(bonusSalary.multiply(freightRate));
                }

                if (expectedTime == actualTime) {
                    finalSalary = finalSalary.add(hourlyRate).multiply(routeRate);
                    finalSalary = finalSalary.add(finalSalary.multiply(freightRate));
                }

                if (expectedTime < actualTime) {
                    if (actualTime - expectedTime >= 3600) {
                        finalSalary = finalSalary.add(hourlyRate);
                        finalSalary = finalSalary.subtract(new BigDecimal((actualTime - expectedTime) / 3600))
                                                 .multiply(routeRate);
                        finalSalary = finalSalary.add(finalSalary.multiply(freightRate));
                    } else {
                        finalSalary = finalSalary.add(hourlyRate);
                        finalSalary = finalSalary.add(finalSalary.multiply(freightRate))
                                                 .multiply(routeRate);
                    }
                }

                if (!internalAccidents.isEmpty() && !internalAccidents.contains(null)) {
                    var internalAccident = internalAccidents
                            .stream()
                            .filter(el -> el.getInternalShippingTaskReport().getId() == istReport.getId())
                            .findFirst().get();

                    if (internalAccident != null) {
                        finalSalary = finalSalary.add(internalAccident.getPenalty());
                    }
                }
            }
        }

        //endregion

        //#region Calculate salary by external tasks
        // Find all external shipping tasks connected with driver
        var externalShippingTaskList = externalShippingTaskRepository.findByDriverId(driverId);
        externalShippingTaskList.addAll(externalShippingTaskRepository.findByExtraDriverId(driverId));

        var externalShippingTaskReports = externalShippingTaskList
                .stream()
                .map(BaseModel::getId)
                .map(externalShippingTaskReportRepository::findByExternalShippingTaskId)
                .collect(Collectors.toList());

        var externalAccidents = externalShippingTaskReports
                .stream()
                .map(BaseModel::getId)
                .map(externalAccidentRepository::findByExternalShippingTaskReportId)
                .collect(Collectors.toList());

        // Calculating the amount of time
        if (!externalShippingTaskList.isEmpty() &&
                !externalShippingTaskReports.isEmpty() &&
                !externalShippingTaskList.contains(null) &&
                !externalShippingTaskReports.contains(null)
        ) {
            for (var est : externalShippingTaskList) {
                var estReport = externalShippingTaskReports
                        .stream()
                        .filter(el -> el.getExternalShippingTask().getId() == est.getId())
                        .findFirst().get();

                long expectedTime = ChronoUnit.SECONDS.between(est.getDepartureTime(),
                        est.getDepartureTime().plusSeconds(est.getRoute().getEstimatedTime())
                );
                long actualTime = ChronoUnit.SECONDS.between(est.getDepartureTime(), estReport.getDestinationTime());

                BigDecimal routeRate = est.getRoute().getType().getRate();
                BigDecimal freightRate = est.getFreight().getType().getRate();
                BigDecimal hourlyRate = new BigDecimal(expectedTime / 3600);

                if (expectedTime > actualTime) {
                    finalSalary = finalSalary.add(hourlyRate).multiply(routeRate);
                    finalSalary = finalSalary.add(finalSalary.multiply(freightRate));
                    bonusSalary = bonusSalary.add(new BigDecimal((expectedTime - actualTime) / 3600))
                                             .multiply(routeRate);
                    bonusSalary = bonusSalary.add(bonusSalary.multiply(freightRate));
                }

                if (expectedTime == actualTime) {
                    finalSalary = finalSalary.add(hourlyRate).multiply(routeRate);
                    finalSalary = finalSalary.add(finalSalary.multiply(freightRate));
                }

                if (expectedTime < actualTime) {
                    if (expectedTime - actualTime >= 3600) {
                        finalSalary = finalSalary.add(hourlyRate);
                        finalSalary = finalSalary.subtract(new BigDecimal((actualTime - expectedTime) / 3600))
                                                 .multiply(routeRate);
                        finalSalary = finalSalary.add(finalSalary.multiply(freightRate));
                    }
                }

                if (!externalAccidents.isEmpty() && !externalAccidents.contains(null)) {
                    var externalAccident = externalAccidents
                            .stream()
                            .filter(el -> el.getExternalShippingTaskReport().getId() == estReport.getId())
                            .findFirst().get();

                    if (externalAccident != null) {
                        finalSalary = finalSalary.add(externalAccident.getPenalty());
                    }
                }
            }
        }

        //endregion

        Salary result = new Salary();
        result.setDriver(driverRepository.findById(driverId).get());
        result.setCost(finalSalary);
        result.setBonusCost(bonusSalary);

        return repository.save(result);
    }
}
