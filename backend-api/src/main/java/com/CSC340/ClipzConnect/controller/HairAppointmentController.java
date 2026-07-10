package com.CSC340.ClipzConnect.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CSC340.ClipzConnect.entity.HairAppointment;
import com.CSC340.ClipzConnect.service.HairAppointmentService;

@RestController
@RequestMapping("/api/hair-appointments")
public class HairAppointmentController {
    
    private final HairAppointmentService hairAppointmentService;

    public HairAppointmentController(HairAppointmentService hairAppointmentService) {
        this.hairAppointmentService = hairAppointmentService;
    }

    @PostMapping
    public ResponseEntity<HairAppointment> bookHairAppointment(@RequestBody HairAppointment hairAppointment) {
        HairAppointment createdAppointment = hairAppointmentService.createHairAppointment(hairAppointment);
        return ResponseEntity.ok(createdAppointment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HairAppointment> getHairAppointmentById(@PathVariable Long id) {
        HairAppointment hairAppointment = hairAppointmentService.getAppointmentById(id);
        return ResponseEntity.ok(hairAppointment);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<HairAppointment>> getHairAppointmentsByCustomer(@PathVariable Long customerId) {
        List<HairAppointment> hairAppointments = hairAppointmentService.getAppointmentsByCustomerId(customerId);
        return ResponseEntity.ok(hairAppointments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HairAppointment> updateHairAppointment(@PathVariable Long id, @RequestBody HairAppointment hairAppointment) {
        hairAppointment.setId(id);
        HairAppointment updated = hairAppointmentService.updateHairAppointment(hairAppointment);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<HairAppointment> cancelHairAppointment(@PathVariable Long id) {
        HairAppointment cancelled = hairAppointmentService.cancelHairAppointment(id);
        if (cancelled == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cancelled);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHairAppointment(@PathVariable Long id) {
        hairAppointmentService.deleteHairAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
