package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.internalshippingtask.InternalShippingTaskCreateDto;
import com.redscarf.dreamroutes.dto.internalshippingtask.InternalShippingTaskDto;
import com.redscarf.dreamroutes.mappers.interfaces.InternalShippingTaskMapper;
import com.redscarf.dreamroutes.services.interfaces.InternalShippingTaskService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalShippingTaskController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:25
 * @Version InternalShippingTaskController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/internal-shipping-tasks")
@Api(value = "Internal Shipping Task Controller")
public class InternalShippingTaskController {

    private final InternalShippingTaskService service;
    private final InternalShippingTaskMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<InternalShippingTaskDto>> getAll(@RequestParam Integer pageNumber,
                                                                @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<InternalShippingTaskDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<InternalShippingTaskDto> create(
            @RequestBody @Valid InternalShippingTaskCreateDto internalShippingTask) {
        var saved = service.save(mapper.fromCreateDtoToEntity(internalShippingTask));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<InternalShippingTaskDto> update(
            @RequestBody @Valid InternalShippingTaskDto internalShippingTask) {
        var updated = service.save(mapper.fromDtoToEntity(internalShippingTask));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(
            @RequestBody @Valid InternalShippingTaskDto internalShippingTask) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(internalShippingTask)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }



}
