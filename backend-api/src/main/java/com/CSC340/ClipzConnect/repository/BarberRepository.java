package com.CSC340.ClipzConnect.repository;

import com.CSC340.ClipzConnect.entity.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Long> {

    Optional<Barber> findByEmail(String email);

    Optional<Barber> findByEmailAndPassword(String email, String password);
}
