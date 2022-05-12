package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.externalaccident.ExternalAccidentCreateDto;
import com.redscarf.dreamroutes.dto.externalaccident.ExternalAccidentDto;
import com.redscarf.dreamroutes.mappers.interfaces.ExternalAccidentMapper;
import com.redscarf.dreamroutes.services.interfaces.ExternalAccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalAccidentController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:23
 * @Version ExternalAccidentController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/external-accidents")
public class ExternalAccidentController {

    private final ExternalAccidentService service;
    private final ExternalAccidentMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<ExternalAccidentDto>> getAll(@RequestParam Integer pageNumber,
                                                            @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<ExternalAccidentDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ExternalAccidentDto> create(
            @RequestBody @Valid ExternalAccidentCreateDto externalAccident) {
        var saved = service.save(mapper.fromCreateDtoToEntity(externalAccident));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ExternalAccidentDto> update(
            @RequestBody @Valid ExternalAccidentDto externalAccident) {
        var updated = service.save(mapper.fromDtoToEntity(externalAccident));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(
            @RequestBody @Valid ExternalAccidentDto externalAccident) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(externalAccident)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }

}
