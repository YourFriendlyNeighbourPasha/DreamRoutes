package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.city.CityCreateDto;
import com.redscarf.dreamroutes.dto.city.CityDto;
import com.redscarf.dreamroutes.mappers.interfaces.CityMapper;
import com.redscarf.dreamroutes.services.interfaces.sequences.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.CityController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:20
 * @Version CityController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/cities")
public class CityController {

    private final CityService service;
    private final CityMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<CityDto>> getAll(@RequestParam Integer pageNumber,
                                                @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<CityDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CityDto> create(
            @RequestBody @Valid CityCreateDto city) {
        var saved = service.save(mapper.fromCreateDtoToEntity(city));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<CityDto> update(
            @RequestBody @Valid CityDto city) {
        var updated = service.save(mapper.fromDtoToEntity(city));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody @Valid CityDto city) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(city)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
