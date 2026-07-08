package com.CSC340.ClipzConnect.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties({ "reviews", "hairAppointments" })
    @JoinColumn(nullable = false)
    private Customer customer;

    @ManyToOne
    @JsonIgnoreProperties({ "reviews", "timeslots" })
    @JoinColumn(nullable = false)
    private Barber barber;

    private int rating;
    private String comments;
    private String replyText;

    public Review(Customer customer, Barber barber, int rating, String comments, 
        String replyText) {
        this.customer = customer;
        this.barber = barber;
        this.rating = rating;
        this.comments = comments;
        this.replyText = replyText;
    }
}
