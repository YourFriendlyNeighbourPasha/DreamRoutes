package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.DriverLicense;
import com.redscarf.dreamroutes.services.interfaces.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:23
 * @Version DriverLicenseController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/drives-licenses")
public class DriverLicenseController {

    private final DriverLicenseService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<DriverLicense>> getAll(@RequestParam Integer pageNumber,
                                                      @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<DriverLicense> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<DriverLicense> create(@RequestBody DriverLicense driverLicense) {

        DriverLicense value = DriverLicense.builder()
                                           .number(driverLicense.getNumber())
                                           .issuingAuthority(driverLicense.getIssuingAuthority())
                                           .issuedAt(driverLicense.getIssuedAt())
                                           .expirationDate(driverLicense.getExpirationDate())
                                           .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<DriverLicense> update(@RequestBody DriverLicense driverLicense) {
        DriverLicense value = DriverLicense.builder()
                                           .id(driverLicense.getId())
                                           .number(driverLicense.getNumber())
                                           .issuingAuthority(driverLicense.getIssuingAuthority())
                                           .issuedAt(driverLicense.getIssuedAt())
                                           .expirationDate(driverLicense.getExpirationDate())
                                           .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody DriverLicense driverLicense) {
        return ResponseEntity.ok(service.delete(driverLicense));
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
