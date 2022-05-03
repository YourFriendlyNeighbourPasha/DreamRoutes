package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.InternalShippingTaskReport;
import com.redscarf.dreamroutes.services.interfaces.InternalShippingTaskReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalShippingTaskReportController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:25
 * @Version InternalShippingTaskReportController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/internal-shipping-task-reports")
public class InternalShippingTaskReportController {

    private final InternalShippingTaskReportService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<InternalShippingTaskReport>> getAll(@RequestParam Integer pageNumber,
                                                                   @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<InternalShippingTaskReport> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<InternalShippingTaskReport> create(@RequestBody InternalShippingTaskReport internalShippingTaskReport) {
        return ResponseEntity.ok(service.save(internalShippingTaskReport));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<InternalShippingTaskReport> update(@RequestBody InternalShippingTaskReport internalShippingTaskReport) {
        return ResponseEntity.ok(service.save(internalShippingTaskReport));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody InternalShippingTaskReport internalShippingTaskReport) {
        return ResponseEntity.ok(service.delete(internalShippingTaskReport));
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
