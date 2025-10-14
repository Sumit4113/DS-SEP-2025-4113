package com.projecttrip.service;

import com.projecttrip.DTO.TripDTO;
import com.projecttrip.entity.Trip;
import com.projecttrip.entity.TripStatus;
import com.projecttrip.exception.ResourceNotFoundException;
import com.projecttrip.repository.TripRepo;

import com.projecttrip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepo repo;

    // Manual conversion methods
    private TripDTO toDto(Trip entity) {
        TripDTO dto = new TripDTO();
        dto.setId(entity.getId());
        dto.setDestination(entity.getDestination());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setPrice(entity.getPrice());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    private Trip toEntity(TripDTO dto) {
        Trip entity = new Trip();
        entity.setId(dto.getId());
        entity.setDestination(dto.getDestination());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setPrice(dto.getPrice());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    @Override
    public TripDTO createTrip(TripDTO dto) {
        Trip saved = repo.save(toEntity(dto));
        return toDto(saved);
    }

    @Override
    public Page<TripDTO> getAllTrips(Pageable pageable) {
        return repo.findAll(pageable).map(this::toDto);
    }

    @Override
    public TripDTO getTripById(Integer id) {
        Trip trip = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found with id " + id));
        return toDto(trip);
    }

    @Override
    public TripDTO updateTrip(Integer id, TripDTO dto) {
        Trip existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found with id " + id));
        existing.setDestination(dto.getDestination());
        existing.setStartDate(dto.getStartDate());
        existing.setEndDate(dto.getEndDate());
        existing.setPrice(dto.getPrice());
        existing.setStatus(dto.getStatus());
        Trip saved = repo.save(existing);
        return toDto(saved);
    }

    @Override
    public void deleteTrip(Integer id) {
        if (!repo.existsById(id))
            throw new ResourceNotFoundException("Trip not found with id " + id);
        repo.deleteById(id);
    }

    @Override
    public Page<TripDTO> searchByDestination(String destination, Pageable pageable) {
        return repo.findByDestinationContainingIgnoreCase(destination, pageable).map(this::toDto);
    }

    @Override
    public Page<TripDTO> filterByStatus(TripStatus status, Pageable pageable) {
        return repo.findByStatus(status, pageable).map(this::toDto);
    }

    @Override
    public Page<TripDTO> getByDateRange(LocalDate start, LocalDate end, Pageable pageable) {
        return repo.findByDateRange(start, end, pageable).map(this::toDto);
    }

    @Override
    public TripSummary getSummary() {
        long total = repo.count();
        Double min = repo.findMinPrice();
        Double max = repo.findMaxPrice();
        Double avg = repo.findAvgPrice();
        return new TripSummary(total, min == null ? 0.0 : min, max == null ? 0.0 : max, avg == null ? 0.0 : avg);
    }
}
