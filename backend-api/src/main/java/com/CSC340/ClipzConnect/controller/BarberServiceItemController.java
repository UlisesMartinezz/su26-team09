package com.CSC340.ClipzConnect.controller;

import com.CSC340.ClipzConnect.entity.BarberService;
import com.CSC340.ClipzConnect.service.BarberServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/barber-services")
public class BarberServiceItemController {

    private final BarberServiceManager barberServiceManager;

    public BarberServiceItemController(BarberServiceManager barberServiceManager) {
        this.barberServiceManager = barberServiceManager;
    }

    @GetMapping("/barber/{barberId}")
    public ResponseEntity<List<BarberService>> getServicesByBarber(@PathVariable Long barberId) {
        List<BarberService> services = barberServiceManager.getServicesByBarberId(barberId);
        if (services.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberService> getServiceById(@PathVariable Long id) {
        BarberService service = barberServiceManager.getServiceById(id);
        if (service == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service);
    }

    @PostMapping("/barber/{barberId}")
    public ResponseEntity<BarberService> addService(@PathVariable Long barberId, @RequestBody BarberService service) {
        BarberService created = barberServiceManager.addService(barberId, service);
        if (created == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.created(null).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarberService> updateService(@PathVariable Long id, @RequestBody BarberService updatedService) {
        try {
            BarberService service = barberServiceManager.updateService(id, updatedService);
            return ResponseEntity.ok(service);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        barberServiceManager.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}

