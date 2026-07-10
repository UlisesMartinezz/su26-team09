package com.CSC340.ClipzConnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CSC340.ClipzConnect.entity.HairAppointment;
import com.CSC340.ClipzConnect.repository.HairAppointmentRepository;

@Service
public class HairAppointmentService {
    
    private final HairAppointmentRepository hairAppointmentRepository;

    public HairAppointmentService(HairAppointmentRepository hairAppointmentRepository) {
        this.hairAppointmentRepository = hairAppointmentRepository;
    }

    public List<HairAppointment> getAppointmentsByCustomerId(Long customerId) {
        return hairAppointmentRepository.findByCustomerId(customerId);
    }

    public List<HairAppointment> getAppointmentsByBarberServiceId(Long barberServiceId) {
        return hairAppointmentRepository.findByBarberServiceId(barberServiceId);
    }

    public HairAppointment createHairAppointment(HairAppointment hairAppointment) {
        return hairAppointmentRepository.save(hairAppointment);
    }

    public HairAppointment getAppointmentById(Long appointmentId) {
        return hairAppointmentRepository.findById(appointmentId).orElse(null);
    }

    public void deleteHairAppointment(Long appointmentId) {
        hairAppointmentRepository.deleteById(appointmentId);
    }

    public HairAppointment updateHairAppointment(HairAppointment hairAppointment) {
        HairAppointment existingAppointment = hairAppointmentRepository.findById(hairAppointment.getId()).orElse(null);
        if (existingAppointment != null) {
            existingAppointment.setCustomer(hairAppointment.getCustomer());
            existingAppointment.setBarberService(hairAppointment.getBarberService());
            existingAppointment.setTimeslot(hairAppointment.getTimeslot());
            existingAppointment.setStatus(hairAppointment.getStatus());
            existingAppointment.setNotes(hairAppointment.getNotes());
            existingAppointment.setLocation(hairAppointment.getLocation());
        }
        return hairAppointmentRepository.save(hairAppointment);
    }

    public HairAppointment cancelHairAppointment(Long appointmentId) {
        HairAppointment existingAppointment = hairAppointmentRepository.findById(appointmentId).orElse(null);
        if (existingAppointment != null) {
            existingAppointment.setStatus("Cancelled");
            return hairAppointmentRepository.save(existingAppointment);
        }
        return null;
    }
}
