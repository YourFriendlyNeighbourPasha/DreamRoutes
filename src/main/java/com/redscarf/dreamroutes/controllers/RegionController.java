package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.Region;
import com.redscarf.dreamroutes.services.interfaces.sequences.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.RegionController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|06:40
 * @Version RegionController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/regions")
public class RegionController {

    private final RegionService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<Region>> getAll(@RequestParam Integer pageNumber,
                                               @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Region> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Region> create(@RequestBody Region region) {
        Region value = Region.builder()
                             .name(region.getName())
                             .country(region.getCountry())
                             .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Region> update(@RequestBody Region region) {
        Region value = Region.builder()
                             .id(region.getId())
                             .name(region.getName())
                             .country(region.getCountry())
                             .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Region region) {
        return ResponseEntity.ok(service.delete(region));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());
    }

}
