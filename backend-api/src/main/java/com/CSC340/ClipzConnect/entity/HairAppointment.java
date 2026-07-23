package com.CSC340.ClipzConnect.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hair_appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class HairAppointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties({ "hairAppointments" })
    @JoinColumn(nullable = false)
    private Customer customer;

    @ManyToOne
    @JsonIgnoreProperties({ "hairAppointments" })
    @JoinColumn(nullable = false)
    private BarberService barberService;

    @OneToOne
    @JsonIgnoreProperties({ "barber" })
    @JoinColumn(nullable = false)
    private Timeslot timeslot;

    private String notes;
    private String status;
    private String location;

    public HairAppointment(Customer customer, BarberService barberService, Timeslot timeslot, 
        String customerRequests, String appointmentStatus, String location) {
        this.customer = customer;
        this.barberService = barberService;
        this.timeslot = timeslot;
        this.notes = customerRequests;
        this.status = appointmentStatus;
        this.location = location;
    }
}
