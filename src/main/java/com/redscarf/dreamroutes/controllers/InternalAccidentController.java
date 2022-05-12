package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.internalaccident.InternalAccidentCreateDto;
import com.redscarf.dreamroutes.dto.internalaccident.InternalAccidentDto;
import com.redscarf.dreamroutes.mappers.interfaces.InternalAccidentMapper;
import com.redscarf.dreamroutes.services.interfaces.InternalAccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalAccidentController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:25
 * @Version InternalAccidentController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/internal-accidents")
public class InternalAccidentController {

    private final InternalAccidentService service;
    private final InternalAccidentMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<InternalAccidentDto>> getAll(@RequestParam Integer pageNumber,
                                                            @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<InternalAccidentDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<InternalAccidentDto> create(
            @RequestBody @Valid InternalAccidentCreateDto internalAccident) {
        var saved = service.save(mapper.fromCreateDtoToEntity(internalAccident));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<InternalAccidentDto> update(@RequestBody @Valid InternalAccidentDto internalAccident) {
        var updated = service.save(mapper.fromDtoToEntity(internalAccident));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(
            @RequestBody @Valid InternalAccidentDto internalAccident) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(internalAccident)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }

}
