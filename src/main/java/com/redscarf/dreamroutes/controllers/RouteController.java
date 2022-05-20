package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.route.RouteCreateDto;
import com.redscarf.dreamroutes.dto.route.RouteDto;
import com.redscarf.dreamroutes.mappers.interfaces.RouteMapper;
import com.redscarf.dreamroutes.services.interfaces.RouteService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.RouteController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:26
 * @Version RouteController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/routes")
@Api(value = "Route Controller")
public class RouteController {

    private final RouteService service;
    private final RouteMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<RouteDto>> getAll(@RequestParam Integer pageNumber,
                                                 @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<RouteDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<RouteDto> create(@RequestBody @Valid RouteCreateDto route) {
        var saved = service.save(mapper.fromCreateDtoToEntity(route));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<RouteDto> update(@RequestBody @Valid RouteDto route) {
        var updated = service.save(mapper.fromDtoToEntity(route));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody @Valid RouteDto route) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(route)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }



}
