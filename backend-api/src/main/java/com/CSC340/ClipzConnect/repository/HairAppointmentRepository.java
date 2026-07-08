package com.CSC340.ClipzConnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CSC340.ClipzConnect.entity.HairAppointment;

@Repository
public interface HairAppointmentRepository extends JpaRepository<HairAppointment, Long> {
    HairAppointment findByCustomerIdAndTimeslotId(Long customerId, Long timeslotId);
    List<HairAppointment> findByBarberServiceId(Long barberServiceId);
    List<HairAppointment> findByCustomerId(Long customerId);
    List<HairAppointment> findByBarberServiceBarberId(Long barberId);
}
