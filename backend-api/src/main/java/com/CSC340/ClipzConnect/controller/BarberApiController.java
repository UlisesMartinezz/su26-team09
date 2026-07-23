package com.CSC340.ClipzConnect.controller;

import com.CSC340.ClipzConnect.entity.Barber;
import com.CSC340.ClipzConnect.service.BarberAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/barbers")
public class BarberApiController {

    private final BarberAccountService barberAccountService;

    public BarberApiController(BarberAccountService barberAccountService) {
        this.barberAccountService = barberAccountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barber> getBarberById(@PathVariable Long id) {
        return barberAccountService.getBarberById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<Barber>> getAllBarbers() {
        List<Barber> barbers = barberAccountService.getAllBarbers();
        if (barbers.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(barbers);
    }

    @PostMapping()
    public ResponseEntity<Barber> createBarber(@RequestBody Barber barber) {
        Barber created = barberAccountService.createBarber(barber);
        return ResponseEntity.created(null).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barber> updateBarber(@PathVariable Long id,
                                               @RequestBody Barber updatedBarber) {
        try {
            Barber barber = barberAccountService.updateBarber(id, updatedBarber);
            return ResponseEntity.ok(barber);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBarber(@PathVariable Long id) {
        barberAccountService.deleteBarber(id);
        return ResponseEntity.noContent().build();
    }
}

