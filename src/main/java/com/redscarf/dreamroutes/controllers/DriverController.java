package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.driver.DriverCreateDto;
import com.redscarf.dreamroutes.dto.driver.DriverDto;
import com.redscarf.dreamroutes.mappers.interfaces.DriverMapper;
import com.redscarf.dreamroutes.services.interfaces.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:23
 * @Version DriverController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/drivers")
public class DriverController {

    private final DriverService service;
    private final DriverMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<DriverDto>> getAll(@RequestParam Integer pageNumber,
                                                  @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<DriverDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<DriverDto> create(@RequestBody @Valid DriverCreateDto driver) {
        var saved = service.save(mapper.fromCreateDtoToEntity(driver));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<DriverDto> update(@RequestBody @Valid DriverDto driver) {
        var updated = service.save(mapper.fromDtoToEntity(driver));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody @Valid DriverDto driver) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(driver)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }

}
