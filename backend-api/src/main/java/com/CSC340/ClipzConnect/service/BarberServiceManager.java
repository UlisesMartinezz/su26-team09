package com.CSC340.ClipzConnect.service;

import com.CSC340.ClipzConnect.entity.Barber;
import com.CSC340.ClipzConnect.entity.BarberService;
import com.CSC340.ClipzConnect.repository.BarberRepository;
import com.CSC340.ClipzConnect.repository.BarberServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Named BarberServiceManager to avoid a name clash with the BarberService entity
@Service
public class BarberServiceManager {

    private final BarberServiceRepository serviceRepository;
    private final BarberRepository barberRepository;

    public BarberServiceManager(BarberServiceRepository serviceRepository, BarberRepository barberRepository) {
        this.serviceRepository = serviceRepository;
        this.barberRepository  = barberRepository;
    }

    public List<BarberService> getServicesByBarberId(Long barberId) {
        return serviceRepository.findByBarberId(barberId);
    }

    public BarberService getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public BarberService addService(Long barberId, BarberService service) {
        Barber barber = barberRepository.findById(barberId).orElse(null);
        if (barber == null) return null;
        service.setBarber(barber);
        return serviceRepository.save(service);
    }

    public BarberService updateService(Long serviceId, BarberService updated) {
        BarberService existing = serviceRepository.findById(serviceId).orElse(null);
        if (existing == null) return null;
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setDurationMinutes(updated.getDurationMinutes());
        return serviceRepository.save(existing);
    }

    public void deleteService(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }
}
