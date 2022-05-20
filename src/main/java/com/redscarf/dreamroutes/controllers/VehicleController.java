package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.vehicle.VehicleCreateDto;
import com.redscarf.dreamroutes.dto.vehicle.VehicleDto;
import com.redscarf.dreamroutes.mappers.interfaces.VehicleMapper;
import com.redscarf.dreamroutes.services.interfaces.VehicleService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.VehicleController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:26
 * @Version VehicleController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehicles")
@Api(value = "Vehicle Controller")
public class VehicleController {

    private final VehicleService service;
    private final VehicleMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<VehicleDto>> getAll(@RequestParam Integer pageNumber,
                                                   @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<VehicleDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<VehicleDto> create(@RequestBody @Valid VehicleCreateDto vehicle) {
        var saved = service.save(mapper.fromCreateDtoToEntity(vehicle));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<VehicleDto> update(@RequestBody @Valid VehicleDto vehicle) {
        var updated = service.save(mapper.fromDtoToEntity(vehicle));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody @Valid VehicleDto vehicle) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(vehicle)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }



}
