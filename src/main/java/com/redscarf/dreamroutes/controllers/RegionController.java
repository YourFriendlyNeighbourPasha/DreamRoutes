package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.region.RegionCreateDto;
import com.redscarf.dreamroutes.dto.region.RegionDto;
import com.redscarf.dreamroutes.mappers.interfaces.RegionMapper;
import com.redscarf.dreamroutes.services.interfaces.sequences.RegionService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.RegionController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|06:40
 * @Version RegionController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/regions")
@Api(value = "Region Controller")
public class RegionController {

    private final RegionService service;
    private final RegionMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<RegionDto>> getAll(@RequestParam Integer pageNumber,
                                                  @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<RegionDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<RegionDto> create(@RequestBody @Valid RegionCreateDto region) {
        var saved = service.save(mapper.fromCreateDtoToEntity(region));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<RegionDto> update(@RequestBody @Valid RegionDto region) {
        var updated = service.save(mapper.fromDtoToEntity(region));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody @Valid RegionDto region) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(region)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
