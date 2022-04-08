package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.InternalAccident;
import com.redscarf.dreamroutes.services.interfaces.InternalAccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalAccidentController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:25
 * @Version InternalAccidentController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/internal-accidents")
public class InternalAccidentController {

    private final InternalAccidentService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<InternalAccident>> getAll(@RequestParam Integer pageNumber,
                                                         @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<InternalAccident> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<InternalAccident> create(@RequestBody InternalAccident internalAccident) {
        InternalAccident value = InternalAccident.builder()
                                                 .happenedAt(internalAccident.getHappenedAt())
                                                 .description(internalAccident.getDescription())
                                                 .internalShippingTaskReport(internalAccident.getInternalShippingTaskReport())
                                                 .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<InternalAccident> update(@RequestBody InternalAccident internalAccident) {
        InternalAccident value = InternalAccident.builder()
                                                 .id(internalAccident.getId())
                                                 .happenedAt(internalAccident.getHappenedAt())
                                                 .description(internalAccident.getDescription())
                                                 .internalShippingTaskReport(internalAccident.getInternalShippingTaskReport())
                                                 .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody InternalAccident internalAccident) {
        return ResponseEntity.ok(service.delete(internalAccident));
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
