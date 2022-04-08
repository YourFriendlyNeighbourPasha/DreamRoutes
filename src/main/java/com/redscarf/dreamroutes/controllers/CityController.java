package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.City;
import com.redscarf.dreamroutes.services.interfaces.sequences.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.CityController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:20
 * @Version CityController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/cities")
public class CityController {

    private final CityService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<City>> getAll(@RequestParam Integer pageNumber,
                                             @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<City> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<City> create(@RequestBody City city) {
        City value = City.builder()
                         .name(city.getName())
                         .region(city.getRegion())
                         .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<City> update(@RequestBody City city) {
        City value = City.builder()
                         .id(city.getId())
                         .name(city.getName())
                         .region(city.getRegion())
                         .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody City city) {
        return ResponseEntity.ok(service.delete(city));
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
