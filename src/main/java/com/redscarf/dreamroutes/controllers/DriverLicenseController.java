package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.driverlicense.DriverLicenseCreateDto;
import com.redscarf.dreamroutes.dto.driverlicense.DriverLicenseDto;
import com.redscarf.dreamroutes.mappers.interfaces.DriverLicenseMapper;
import com.redscarf.dreamroutes.services.interfaces.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:23
 * @Version DriverLicenseController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/drives-licenses")
public class DriverLicenseController {

    private final DriverLicenseService service;
    private final DriverLicenseMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<DriverLicenseDto>> getAll(@RequestParam Integer pageNumber,
                                                         @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<DriverLicenseDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<DriverLicenseDto> create(
            @RequestBody @Valid DriverLicenseCreateDto driverLicense) {
        var saved = service.save(mapper.fromCreateDtoToEntity(driverLicense));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<DriverLicenseDto> update(
            @RequestBody @Valid DriverLicenseDto driverLicense) {
        var updated = service.save(mapper.fromDtoToEntity(driverLicense));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody @Valid DriverLicenseDto driverLicense) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(driverLicense)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }



}
