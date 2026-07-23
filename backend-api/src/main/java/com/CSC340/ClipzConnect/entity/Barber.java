package com.CSC340.ClipzConnect.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barbers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String phoneNumber;
    private String location;
    private String thumbnailUrl;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String accountStatus = "ACTIVE";

    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BarberService> services = new ArrayList<>();

    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Timeslot> timeslots = new ArrayList<>();

    @OneToMany(mappedBy = "barber")
    private List<Review> reviews = new ArrayList<>();
}
