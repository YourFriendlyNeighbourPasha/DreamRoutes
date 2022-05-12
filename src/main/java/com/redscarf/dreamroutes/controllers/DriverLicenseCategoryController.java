package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.driverlicensecategory.DriverLicenseCategoryCreateDto;
import com.redscarf.dreamroutes.dto.driverlicensecategory.DriverLicenseCategoryDto;
import com.redscarf.dreamroutes.mappers.interfaces.DriverLicenseCategoryMapper;
import com.redscarf.dreamroutes.services.interfaces.sequences.DriverLicenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseCategoryController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|06:36
 * @Version DriverLicenseCategoryController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/driver-license-categories")
public class DriverLicenseCategoryController {

    private final DriverLicenseCategoryService service;
    private final DriverLicenseCategoryMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<DriverLicenseCategoryDto>> getAll(@RequestParam Integer pageNumber,
                                                                 @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<DriverLicenseCategoryDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<DriverLicenseCategoryDto> create(
            @RequestBody @Valid DriverLicenseCategoryCreateDto driverLicenseCategory) {
        var saved = service.save(mapper.fromCreateDtoToEntity(driverLicenseCategory));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<DriverLicenseCategoryDto> update(
            @RequestBody @Valid DriverLicenseCategoryDto driverLicenseCategory) {
        var updated = service.save(mapper.fromDtoToEntity(driverLicenseCategory));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody @Valid DriverLicenseCategoryDto driverLicenseCategory) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(driverLicenseCategory)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteById(id));
    }



}
