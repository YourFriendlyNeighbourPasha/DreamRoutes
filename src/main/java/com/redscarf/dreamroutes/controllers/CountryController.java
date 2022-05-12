package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.country.CountryCreateDto;
import com.redscarf.dreamroutes.dto.country.CountryDto;
import com.redscarf.dreamroutes.mappers.interfaces.CountryMapper;
import com.redscarf.dreamroutes.services.interfaces.sequences.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.CountryController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|04:23
 * @Version CountryController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/countries")
public class CountryController {

    private final CountryService service;
    private final CountryMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<CountryDto>> getAll(@RequestParam Integer pageNumber,
                                                   @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<CountryDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CountryDto> create(
            @RequestBody @Valid CountryCreateDto country) {
        var saved = service.save(mapper.fromCreateDtoToEntity(country));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<CountryDto> update(
            @RequestBody @Valid CountryDto country) {
        var updated = service.save(mapper.fromDtoToEntity(country));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(
            @RequestBody @Valid CountryDto country) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(country)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
