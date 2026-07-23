package com.CSC340.ClipzConnect.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "barber_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarberService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

    private Integer durationMinutes;
}
