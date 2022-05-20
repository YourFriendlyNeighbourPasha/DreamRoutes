package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.internalshippingtaskreport.InternalShippingTaskReportCreateDto;
import com.redscarf.dreamroutes.dto.internalshippingtaskreport.InternalShippingTaskReportDto;
import com.redscarf.dreamroutes.mappers.interfaces.InternalShippingTaskReportMapper;
import com.redscarf.dreamroutes.services.interfaces.InternalShippingTaskReportService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalShippingTaskReportController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:25
 * @Version InternalShippingTaskReportController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/internal-shipping-task-reports")
@Api(value = "Internal Shipping Task Report Controller")
public class InternalShippingTaskReportController {

    private final InternalShippingTaskReportService service;
    private final InternalShippingTaskReportMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<InternalShippingTaskReportDto>> getAll(@RequestParam Integer pageNumber,
                                                                      @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<InternalShippingTaskReportDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<InternalShippingTaskReportDto> create(
            @RequestBody @Valid InternalShippingTaskReportCreateDto internalShippingTaskReport) {
        var saved = service.save(mapper.fromCreateDtoToEntity(internalShippingTaskReport));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<InternalShippingTaskReportDto> update(
            @RequestBody @Valid InternalShippingTaskReportDto internalShippingTaskReport) {
        var updated = service.save(mapper.fromDtoToEntity(internalShippingTaskReport));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(
            @RequestBody @Valid InternalShippingTaskReportDto internalShippingTaskReport) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(internalShippingTaskReport)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }

}
