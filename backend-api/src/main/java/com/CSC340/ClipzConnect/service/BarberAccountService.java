package com.CSC340.ClipzConnect.service;

import com.CSC340.ClipzConnect.entity.Barber;
import com.CSC340.ClipzConnect.repository.BarberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarberAccountService {

    private final BarberRepository barberRepository;

    public BarberAccountService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    public Optional<Barber> getBarberById(Long id) {
        return barberRepository.findById(id);
    }

    public Optional<Barber> checkLogin(String email, String password) {
        return barberRepository.findByEmailAndPassword(email, password);
    }

    public Barber createBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    public Barber updateBarber(Long id, Barber updatedBarber) {
        Barber existing = barberRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setFirstName(updatedBarber.getFirstName());
        existing.setLastName(updatedBarber.getLastName());
        existing.setEmail(updatedBarber.getEmail());
        existing.setPhoneNumber(updatedBarber.getPhoneNumber());
        existing.setLocation(updatedBarber.getLocation());
        existing.setBio(updatedBarber.getBio());

        if (updatedBarber.getPassword() != null && !updatedBarber.getPassword().isBlank()) {
            existing.setPassword(updatedBarber.getPassword());
        }
        if (updatedBarber.getThumbnailUrl() != null && !updatedBarber.getThumbnailUrl().isBlank()) {
            existing.setThumbnailUrl(updatedBarber.getThumbnailUrl());
        }
        return barberRepository.save(existing);
    }

    public void deleteBarber(Long id) {
        barberRepository.deleteById(id);
    }
}
