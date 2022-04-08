package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.ExternalShippingTaskReport;
import com.redscarf.dreamroutes.services.interfaces.ExternalShippingTaskReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskReportController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:24
 * @Version ExternalShippingTaskReportController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/external-shipping-task-reports")
public class ExternalShippingTaskReportController {

    private final ExternalShippingTaskReportService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<ExternalShippingTaskReport>> getAll(@RequestParam Integer pageNumber,
                                                                   @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<ExternalShippingTaskReport> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ExternalShippingTaskReport> create(@RequestBody ExternalShippingTaskReport externalShippingTaskReport) {
        ExternalShippingTaskReport value = ExternalShippingTaskReport.builder()
                                                                     .destinationTime(externalShippingTaskReport.getDestinationTime())
                                                                     .externalShippingTask(externalShippingTaskReport.getExternalShippingTask())
                                                                     .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ExternalShippingTaskReport> update(@RequestBody ExternalShippingTaskReport externalShippingTaskReport) {
        ExternalShippingTaskReport value = ExternalShippingTaskReport.builder()
                                                                     .id(externalShippingTaskReport.getId())
                                                                     .destinationTime(externalShippingTaskReport.getDestinationTime())
                                                                     .externalShippingTask(externalShippingTaskReport.getExternalShippingTask())
                                                                     .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody ExternalShippingTaskReport externalShippingTaskReport) {
        return ResponseEntity.ok(service.delete(externalShippingTaskReport));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());
    }

}
