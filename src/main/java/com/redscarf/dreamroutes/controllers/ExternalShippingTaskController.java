package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.externalshippingtask.ExternalShippingTaskCreateDto;
import com.redscarf.dreamroutes.dto.externalshippingtask.ExternalShippingTaskDto;
import com.redscarf.dreamroutes.mappers.interfaces.ExternalShippingTaskMapper;
import com.redscarf.dreamroutes.services.interfaces.ExternalShippingTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:24
 * @Version ExternalShippingTaskController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/external-shipping-tasks")
public class ExternalShippingTaskController {

    private final ExternalShippingTaskService service;
    private final ExternalShippingTaskMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<ExternalShippingTaskDto>> getAll(@RequestParam Integer pageNumber,
                                                                @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<ExternalShippingTaskDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ExternalShippingTaskDto> create(
            @RequestBody @Valid ExternalShippingTaskCreateDto externalShippingTask) {
        var saved = service.save(mapper.fromCreateDtoToEntity(externalShippingTask));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ExternalShippingTaskDto> update(
            @RequestBody ExternalShippingTaskDto externalShippingTask) {
        var updated = service.save(mapper.fromDtoToEntity(externalShippingTask));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(
            @RequestBody ExternalShippingTaskDto externalShippingTask) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(externalShippingTask)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }

}
