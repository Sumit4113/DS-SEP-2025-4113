package com.projecttrip.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projecttrip.entity.Trip;
import com.projecttrip.entity.TripStatus;

import java.time.LocalDate;

public interface TripRepo extends JpaRepository<Trip, Integer> {

    Page<Trip> findByDestinationContainingIgnoreCase(String destination, Pageable pageable);

    Page<Trip> findByStatus(TripStatus status, Pageable pageable);

    @Query("SELECT t FROM Trip t WHERE t.startDate >= :start AND t.endDate <= :end")
    Page<Trip> findByDateRange(@Param("start") LocalDate start, @Param("end") LocalDate end, Pageable pageable);

    @Query("SELECT MIN(t.price) FROM Trip t")
    Double findMinPrice();

    @Query("SELECT MAX(t.price) FROM Trip t")
    Double findMaxPrice();

    @Query("SELECT AVG(t.price) FROM Trip t")
    Double findAvgPrice();
}
