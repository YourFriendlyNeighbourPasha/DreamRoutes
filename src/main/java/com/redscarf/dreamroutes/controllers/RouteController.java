package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.Route;
import com.redscarf.dreamroutes.services.interfaces.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.RouteController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:26
 * @Version RouteController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/routes")
public class RouteController {

    private final RouteService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<Route>> getAll(@RequestParam Integer pageNumber,
                                              @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Route> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Route> create(@RequestBody Route route) {
        Route value = Route.builder()
                           .title(route.getTitle())
                           .type(route.getType())
                           .distance(route.getDistance())
                           .firstCity(route.getFirstCity())
                           .secondCity(route.getSecondCity())
                           .estimatedTime(route.getEstimatedTime())
                           .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Route> update(@RequestBody Route route) {
        Route value = Route.builder()
                           .id(route.getId())
                           .title(route.getTitle())
                           .type(route.getType())
                           .distance(route.getDistance())
                           .firstCity(route.getFirstCity())
                           .secondCity(route.getSecondCity())
                           .estimatedTime(route.getEstimatedTime())
                           .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Route route) {
        return ResponseEntity.ok(service.delete(route));
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