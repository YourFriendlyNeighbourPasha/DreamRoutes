package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.externalshippingtaskreport.ExternalShippingTaskReportCreateDto;
import com.redscarf.dreamroutes.dto.externalshippingtaskreport.ExternalShippingTaskReportDto;
import com.redscarf.dreamroutes.mappers.interfaces.ExternalShippingTaskReportMapper;
import com.redscarf.dreamroutes.services.interfaces.ExternalShippingTaskReportService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskReportController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:24
 * @Version ExternalShippingTaskReportController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/external-shipping-task-reports")
@Api(value = "External Shipping Task Report Controller")
public class ExternalShippingTaskReportController {

    private final ExternalShippingTaskReportService service;
    private final ExternalShippingTaskReportMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<ExternalShippingTaskReportDto>> getAll(@RequestParam Integer pageNumber,
                                                                      @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<ExternalShippingTaskReportDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ExternalShippingTaskReportDto> create(
            @RequestBody @Valid ExternalShippingTaskReportCreateDto externalShippingTaskReport) {
        var saved = service.save(mapper.fromCreateDtoToEntity(externalShippingTaskReport));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ExternalShippingTaskReportDto> update(
            @RequestBody @Valid ExternalShippingTaskReportDto externalShippingTaskReport) {
        var updated = service.save(mapper.fromDtoToEntity(externalShippingTaskReport));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(
            @RequestBody @Valid ExternalShippingTaskReportDto externalShippingTaskReport) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(externalShippingTaskReport)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }



}
