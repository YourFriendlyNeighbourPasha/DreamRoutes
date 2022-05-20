package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.freight.FreightCreateDto;
import com.redscarf.dreamroutes.dto.freight.FreightDto;
import com.redscarf.dreamroutes.mappers.interfaces.FreightMapper;
import com.redscarf.dreamroutes.services.interfaces.FreightService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.FreightController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:24
 * @Version FreightController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/freights")
@Api(value = "Freight Controller")
public class FreightController {

    private final FreightService service;
    private final FreightMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<FreightDto>> getAll(@RequestParam Integer pageNumber,
                                                   @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<FreightDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<FreightDto> create(
            @RequestBody @Valid FreightCreateDto freight) {
        var saved = service.save(mapper.fromCreateDtoToEntity(freight));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<FreightDto> update(@RequestBody @Valid FreightDto freight) {
        var updated = service.save(mapper.fromDtoToEntity(freight));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody @Valid FreightDto freight) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(freight)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }



}
