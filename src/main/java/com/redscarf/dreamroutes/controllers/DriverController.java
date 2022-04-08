package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.Driver;
import com.redscarf.dreamroutes.services.interfaces.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:23
 * @Version DriverController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/drivers")
public class DriverController {

    private final DriverService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<Driver>> getAll(@RequestParam Integer pageNumber,
                                               @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Driver> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {

        Driver value = Driver.builder()
                             .firstName(driver.getFirstName())
                             .middleName(driver.getMiddleName())
                             .lastName(driver.getLastName())
                             .birthday(driver.getBirthday())
                             .employedOn(driver.getEmployedOn())
                             .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        Driver value = Driver.builder()
                             .id(driver.getId())
                             .firstName(driver.getFirstName())
                             .middleName(driver.getMiddleName())
                             .lastName(driver.getLastName())
                             .birthday(driver.getBirthday())
                             .employedOn(driver.getEmployedOn())
                             .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Driver driver) {
        return ResponseEntity.ok(service.delete(driver));
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
