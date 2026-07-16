package com.CSC340.ClipzConnect.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

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
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String accountStatus;
    
    @Column(nullable = false)
    private String location;

    private String thumbnailUrl;

    public Customer(String firstName, String lastName, String email, String phoneNumber, String password, String accountStatus, 
        String location, String thumbnailUrl){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.password = password;
            this.accountStatus = accountStatus;
            this.location = location;
            this.thumbnailUrl = thumbnailUrl;
    }

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties({"customer"})
    private List<HairAppointment> hairAppointments;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties({"customer"})
    private List<Review> reviews;
}
