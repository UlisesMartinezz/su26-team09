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

import com.CSC340.ClipzConnect.entity.Timeslot;
import com.CSC340.ClipzConnect.service.TimeslotService;

@RestController
@RequestMapping("/api/timeslots")
public class TimeslotController {
    
    private final TimeslotService timeslotService;

    public TimeslotController(TimeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }

    @GetMapping("/barber/{barberId}")
    public ResponseEntity<List<Timeslot>> getTimeslotsByBarberId(@PathVariable Long barberId) {
        List<Timeslot> timeslots = timeslotService.getTimeslotsByBarberId(barberId);
        return ResponseEntity.ok(timeslots);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Timeslot> getTimeslotById(@PathVariable Long id) {
        Timeslot timeslot = timeslotService.getTimeslotById(id);
        if (timeslot == null) {
        return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(timeslot);
    }

    @GetMapping("/barber/{barberId}/available")
    public ResponseEntity<List<Timeslot>> getAvailableTimeslotsByBarberId(@PathVariable Long barberId) {
        List<Timeslot> availableTimeslots = timeslotService.getAvailableTimeslotsByBarberId(barberId);
        return ResponseEntity.ok(availableTimeslots);
    }

    @PostMapping
    public ResponseEntity<Timeslot> createTimeslot(@RequestBody Timeslot timeslot) {
        Timeslot createdTimeslot = timeslotService.createTimeslot(timeslot);
        return ResponseEntity.ok(createdTimeslot);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Timeslot> updateTimeslot(@PathVariable Long id, @RequestBody Timeslot timeslot) {
        Timeslot updatedTimeslot = timeslotService.updateTimeslot(id, timeslot);
        if (updatedTimeslot == null) {
        return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTimeslot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeslot(@PathVariable Long id) {
        timeslotService.deleteTimeslot(id);
        return ResponseEntity.noContent().build();
    }
}
