package com.CSC340.ClipzConnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CSC340.ClipzConnect.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCustomerId(Long customerId);
    List<Review> findByBarberId(Long barberId);
}
