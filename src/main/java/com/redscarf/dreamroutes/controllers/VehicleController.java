package com.redscarf.dreamroutes.controllers;

import com.redscarf.dreamroutes.models.Vehicle;
import com.redscarf.dreamroutes.services.interfaces.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.VehicleController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.04.2022|03:26
 * @Version VehicleController: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final VehicleService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<Vehicle>> getAll(@RequestParam Integer pageNumber,
                                                @RequestParam Integer pageSize) {
        return ResponseEntity.ok(service.findAll(pageNumber, pageSize));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {
        Vehicle value = Vehicle.builder()
                               .manufacturerTitle(vehicle.getManufacturerTitle())
                               .model(vehicle.getModel())
                               .vehicleCode(vehicle.getVehicleCode())
                               .weightCapacity(vehicle.getWeightCapacity())
                               .build();

        return ResponseEntity.ok(service.save(value));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle) {
        Vehicle value = Vehicle.builder()
                               .id(vehicle.getId())
                               .manufacturerTitle(vehicle.getManufacturerTitle())
                               .model(vehicle.getModel())
                               .vehicleCode(vehicle.getVehicleCode())
                               .weightCapacity(vehicle.getWeightCapacity())
                               .build();

        return ResponseEntity.ok(service.save(value));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(service.delete(vehicle));
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
