package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.Freight;
import com.redscarf.dreamroutes.services.interfaces.FreightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.FreightController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:24
 * @Version FreightController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/freights")
public class FreightController {

    private final FreightService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<Freight>> getAll(@RequestParam Integer pageNumber,
                                                @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Freight> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Freight> create(@RequestBody Freight freight) {
        Freight value = Freight.builder()
                               .weight(freight.getWeight())
                               .type(freight.getType())
                               .description(freight.getDescription())
                               .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Freight> update(@RequestBody Freight freight) {
        Freight value = Freight.builder()
                               .id(freight.getId())
                               .weight(freight.getWeight())
                               .type(freight.getType())
                               .description(freight.getDescription())
                               .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Freight freight) {
        return ResponseEntity.ok(service.delete(freight));
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
