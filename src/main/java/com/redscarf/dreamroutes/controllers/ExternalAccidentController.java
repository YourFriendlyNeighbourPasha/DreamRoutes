package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.ExternalAccident;
import com.redscarf.dreamroutes.services.interfaces.ExternalAccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalAccidentController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:23
 * @Version ExternalAccidentController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/external-accidents")
public class ExternalAccidentController {

    private final ExternalAccidentService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<ExternalAccident>> getAll(@RequestParam Integer pageNumber,
                                                         @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<ExternalAccident> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ExternalAccident> create(@RequestBody ExternalAccident externalAccident) {
        return ResponseEntity.ok(service.save(externalAccident));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ExternalAccident> update(
            @RequestBody ExternalAccident externalAccident) {

        return ResponseEntity.ok(service.save(externalAccident));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody ExternalAccident externalAccident) {
        return ResponseEntity.ok(service.delete(externalAccident));
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
