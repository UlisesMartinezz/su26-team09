
package com.CSC340.ClipzConnect.repository;

import com.CSC340.ClipzConnect.entity.BarberService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarberServiceRepository extends JpaRepository<BarberService, Long> {

    List<BarberService> findByBarberId(Long barberId);
}
