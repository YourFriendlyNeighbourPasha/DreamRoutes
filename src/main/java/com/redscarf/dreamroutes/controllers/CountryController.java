package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.Country;
import com.redscarf.dreamroutes.services.interfaces.sequences.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.CountryController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|04:23
 * @Version CountryController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/countries")
public class CountryController {

    private final CountryService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<Country>> getAll(@RequestParam Integer pageNumber,
                                                @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Country> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Country> create(@RequestBody Country country) {
        Country value = Country.builder()
                               .name(country.getName())
                               .code(country.getCode())
                               .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Country> update(@RequestBody Country country) {
        Country value = Country.builder()
                               .id(country.getId())
                               .name(country.getName())
                               .code(country.getCode())
                               .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Country country) {
        return ResponseEntity.ok(service.delete(country));
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
