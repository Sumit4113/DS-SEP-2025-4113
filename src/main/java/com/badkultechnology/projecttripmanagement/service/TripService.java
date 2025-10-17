package com.badkultechnology.projecttripmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.badkultechnology.projecttripmanagement.DTO.TripDTO;
import com.badkultechnology.projecttripmanagement.entity.TripStatus;

import java.time.LocalDate;

public interface TripService {
    TripDTO createTrip(TripDTO dto);
    Page<TripDTO> getAllTrips(Pageable pageable);
    TripDTO getTripById(Integer id);
    TripDTO updateTrip(Integer id, TripDTO dto);
    void deleteTrip(Integer id);
    Page<TripDTO> searchByDestination(String destination, Pageable pageable);
    Page<TripDTO> filterByStatus(TripStatus status, Pageable pageable);
    Page<TripDTO> getByDateRange(LocalDate start, LocalDate end, Pageable pageable);
    TripSummary getSummary();

    class TripSummary {
        public long totalTrips;
        public Double minPrice;
        public Double maxPrice;
        public Double averagePrice;

        public TripSummary(long totalTrips, Double minPrice, Double maxPrice, Double averagePrice) {
            this.totalTrips = totalTrips;
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
            this.averagePrice = averagePrice;
        }
    }
}
