package com.CSC340.ClipzConnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CSC340.ClipzConnect.entity.Timeslot;
import com.CSC340.ClipzConnect.repository.TimeSlotRepository;

@Service
public class TimeslotService {
    
    private final TimeSlotRepository timeSlotRepository;

    public TimeslotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    public List<Timeslot> getAvailableTimeslotsByBarberId(Long barberId) {
        return timeSlotRepository.findAvailableByBarberId(barberId);
    }

    public Timeslot getTimeslotById(Long timeslotId) {
        return timeSlotRepository.findById(timeslotId).orElse(null);
    }

    public List<Timeslot> getTimeslotsByBarberId(Long barberId) {
        return timeSlotRepository.findByBarberId(barberId);
    }

    public Timeslot createTimeslot(Timeslot timeslot) {
        return timeSlotRepository.save(timeslot);
    }

    public Timeslot updateTimeslot(Long id, Timeslot timeslot) {
        Timeslot existingTimeslot = timeSlotRepository.findById(id).orElse(null);
        if (existingTimeslot != null) {
            existingTimeslot.setStartTime(timeslot.getStartTime());
            existingTimeslot.setEndTime(timeslot.getEndTime());
            existingTimeslot.setBarber(timeslot.getBarber());
            existingTimeslot.setIsAvailable(timeslot.getIsAvailable());
        }
        return timeSlotRepository.save(timeslot);
    }

    public Boolean assignTimeslotToSession(Long timeslotId) {
        Timeslot timeslot = timeSlotRepository.findById(timeslotId).orElse(null);
        if (timeslot != null && timeslot.getIsAvailable()) {
            timeslot.setIsAvailable(false);
            timeSlotRepository.save(timeslot);
            return true;
        }
        return false;
    }

    public void deleteTimeslot(Long timeslotId) {
        timeSlotRepository.deleteById(timeslotId);
    }

    public List<Timeslot> getAvailableTimeslots(){
        return timeSlotRepository.findByIsAvailable(true);
    }
}