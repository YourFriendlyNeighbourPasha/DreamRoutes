package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.city.CityCreateDto;
import com.redscarf.dreamroutes.dto.city.CityDto;
import com.redscarf.dreamroutes.mappers.interfaces.CityMapper;
import com.redscarf.dreamroutes.services.interfaces.sequences.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "City Controller")
public class CityController {

    private final CityService service;
    private final CityMapper mapper;

    @ApiOperation(
            value = "Retrieve a page of stored cities which accompanied with pagination parameters",
            response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The page is retrieved successfully!"),
            @ApiResponse(code = 401, message = "You're not authorized. Please, authorize."),
            @ApiResponse(code = 403, message = "The access is forbidden!"),
            @ApiResponse(code = 404, message = "The data is not found.")
    })
    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<CityDto>> getAll(@RequestParam Integer pageNumber,
                                                @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize).map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @ApiOperation(
            value = "Retrieve a stored city which accompanied with ID parameter",
            response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The entity is retrieved successfully!"),
            @ApiResponse(code = 401, message = "You're not authorized. Please, authorize."),
            @ApiResponse(code = 403, message = "The access is forbidden!"),
            @ApiResponse(code = 404, message = "The data is not found.")
    })
    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<CityDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(id)));
    }

    @ApiOperation(
            value = "Create a new city which accompanied with required params",
            response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The entity is created successfully!"),
            @ApiResponse(code = 401, message = "You're not authorized. Please, authorize."),
            @ApiResponse(code = 403, message = "The access is forbidden!"),
            @ApiResponse(code = 404, message = "The entity is not created as it not found.")
    })
    @PostMapping(value = "/create")
    public ResponseEntity<CityDto> create(
            @RequestBody @Valid CityCreateDto city) {
        var saved = service.save(mapper.fromCreateDtoToEntity(city));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @ApiOperation(
            value = "Updates an existing city which accompanied with required params",
            response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The entity is updated successfully!"),
            @ApiResponse(code = 401, message = "You're not authorized. Please, authorize."),
            @ApiResponse(code = 403, message = "The access is forbidden!"),
            @ApiResponse(code = 404, message = "The entity is not updated as it not found.")
    })
    @PutMapping(value = "/update")
    public ResponseEntity<CityDto> update(
            @RequestBody @Valid CityDto city) {
        var updated = service.save(mapper.fromDtoToEntity(city));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @ApiOperation(
            value = "Deletes an existing city which accompanied with required params",
            response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The entity is deleted successfully!"),
            @ApiResponse(code = 401, message = "You're not authorized. Please, authorize."),
            @ApiResponse(code = 403, message = "The access is forbidden!"),
            @ApiResponse(code = 404, message = "The entity is not deleted as it not found.")
    })
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody @Valid CityDto city) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(city)));
    }

    @ApiOperation(
            value = "Create a new city which accompanied with required params",
            response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The entity is created successfully!"),
            @ApiResponse(code = 401, message = "You're not authorized. Please, authorize."),
            @ApiResponse(code = 403, message = "The access is forbidden!"),
            @ApiResponse(code = 404, message = "The entity is not created.")
    })
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
