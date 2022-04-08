package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.DriverLicenseCategory;
import com.redscarf.dreamroutes.services.interfaces.sequences.DriverLicenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseCategoryController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|06:36
 * @Version DriverLicenseCategoryController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/driver-license-categories")
public class DriverLicenseCategoryController {

    private final DriverLicenseCategoryService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<DriverLicenseCategory>> getAll(@RequestParam Integer pageNumber,
                                                              @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<DriverLicenseCategory> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<DriverLicenseCategory> create(@RequestBody DriverLicenseCategory driverLicenseCategory) {
        DriverLicenseCategory value = DriverLicenseCategory.builder()
                                                           .code(driverLicenseCategory.getCode())
                                                           .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<DriverLicenseCategory> update(@RequestBody DriverLicenseCategory driverLicenseCategory) {
        DriverLicenseCategory value = DriverLicenseCategory.builder()
                                                           .id(driverLicenseCategory.getId())
                                                           .code(driverLicenseCategory.getCode())
                                                           .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody DriverLicenseCategory driverLicenseCategory) {
        return ResponseEntity.ok(service.delete(driverLicenseCategory));
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
