package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.Salary;
import com.redscarf.dreamroutes.services.interfaces.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.SalaryController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:26
 * @Version SalaryController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/salaries")
public class SalaryController {

    private final SalaryService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<Salary>> getAll(@RequestParam Integer pageNumber,
                                               @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Salary> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Salary> create(@RequestBody Salary salary) {
        return ResponseEntity.ok(service.save(salary));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Salary> update(@RequestBody Salary salary) {
        return ResponseEntity.ok(service.save(salary));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Salary salary) {
        return ResponseEntity.ok(service.delete(salary));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(UUID.fromString(id)));
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());
    }

}
