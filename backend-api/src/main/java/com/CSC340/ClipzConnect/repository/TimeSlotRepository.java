package com.CSC340.ClipzConnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CSC340.ClipzConnect.entity.Timeslot;

@Repository
public interface  TimeSlotRepository extends JpaRepository<Timeslot, Long> {
    List<Timeslot> findByBarberId(Long barberId);

    List<Timeslot> findAvailableByBarberId(Long barberId);

    List<Timeslot> findByIsAvailable(Boolean isAvailable);
}
