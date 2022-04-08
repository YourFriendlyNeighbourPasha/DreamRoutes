package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.ExternalShippingTask;
import com.redscarf.dreamroutes.services.interfaces.ExternalShippingTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:24
 * @Version ExternalShippingTaskController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/external-shipping-tasks")
public class ExternalShippingTaskController {

    private final ExternalShippingTaskService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<ExternalShippingTask>> getAll(@RequestParam Integer pageNumber,
                                                             @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<ExternalShippingTask> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ExternalShippingTask> create(@RequestBody ExternalShippingTask externalShippingTask) {
        ExternalShippingTask value = ExternalShippingTask.builder()
                                                         .vehicle(externalShippingTask.getVehicle())
                                                         .route(externalShippingTask.getRoute())
                                                         .freight(externalShippingTask.getFreight())
                                                         .extraDriver(externalShippingTask.getExtraDriver())
                                                         .driver(externalShippingTask.getDriver())
                                                         .departureTime(externalShippingTask.getDepartureTime())
                                                         .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ExternalShippingTask> update(@RequestBody ExternalShippingTask externalShippingTask) {
        ExternalShippingTask value = ExternalShippingTask.builder()
                                                         .id(externalShippingTask.getId())
                                                         .vehicle(externalShippingTask.getVehicle())
                                                         .route(externalShippingTask.getRoute())
                                                         .freight(externalShippingTask.getFreight())
                                                         .extraDriver(externalShippingTask.getExtraDriver())
                                                         .driver(externalShippingTask.getDriver())
                                                         .departureTime(externalShippingTask.getDepartureTime())
                                                         .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody ExternalShippingTask externalShippingTask) {
        return ResponseEntity.ok(service.delete(externalShippingTask));
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
