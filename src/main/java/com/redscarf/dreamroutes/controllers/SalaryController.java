package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.dto.salary.SalaryCreateDto;
import com.redscarf.dreamroutes.dto.salary.SalaryDto;
import com.redscarf.dreamroutes.mappers.interfaces.SalaryMapper;
import com.redscarf.dreamroutes.services.interfaces.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.SalaryController
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:26
 * @Version SalaryController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/salaries")
public class SalaryController {

    private final SalaryService service;
    private final SalaryMapper mapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<SalaryDto>> getAll(@RequestParam Integer pageNumber,
                                                  @RequestParam Integer pageSize) {
        var response = service.findAll(pageNumber, pageSize)
                              .map(mapper::fromEntityToDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<SalaryDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mapper.fromEntityToDto(service.findById(UUID.fromString(id))));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<SalaryDto> create(@RequestBody @Valid SalaryCreateDto salary) {
        var saved = service.save(mapper.fromCreateDtoToEntity(salary));

        return ResponseEntity.ok(mapper.fromEntityToDto(saved));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<SalaryDto> update(@RequestBody @Valid SalaryDto salary) {
        var updated = service.save(mapper.fromDtoToEntity(salary));

        return ResponseEntity.ok(mapper.fromEntityToDto(updated));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody @Valid SalaryDto salary) {
        return ResponseEntity.ok(service.delete(mapper.fromDtoToEntity(salary)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }

}
