package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.InternalShippingTask;
import com.redscarf.dreamroutes.services.interfaces.InternalShippingTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalShippingTaskController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:25
 * @Version InternalShippingTaskController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/internal-shipping-tasks")
public class InternalShippingTaskController {

    private final InternalShippingTaskService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<InternalShippingTask>> getAll(@RequestParam Integer pageNumber,
                                                             @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<InternalShippingTask> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<InternalShippingTask> create(@RequestBody InternalShippingTask internalShippingTask) {
        InternalShippingTask value = InternalShippingTask.builder()
                                                         .vehicle(internalShippingTask.getVehicle())
                                                         .route(internalShippingTask.getRoute())
                                                         .freight(internalShippingTask.getFreight())
                                                         .driver(internalShippingTask.getDriver())
                                                         .departureTime(internalShippingTask.getDepartureTime())
                                                         .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<InternalShippingTask> update(@RequestBody InternalShippingTask internalShippingTask) {
        InternalShippingTask value = InternalShippingTask.builder()
                                                         .id(internalShippingTask.getId())
                                                         .vehicle(internalShippingTask.getVehicle())
                                                         .route(internalShippingTask.getRoute())
                                                         .freight(internalShippingTask.getFreight())
                                                         .driver(internalShippingTask.getDriver())
                                                         .departureTime(internalShippingTask.getDepartureTime())
                                                         .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody InternalShippingTask internalShippingTask) {
        return ResponseEntity.ok(service.delete(internalShippingTask));
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
