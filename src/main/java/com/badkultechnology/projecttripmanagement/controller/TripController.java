package com.badkultechnology.projecttripmanagement.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.badkultechnology.projecttripmanagement.DTO.TripDTO;
import com.badkultechnology.projecttripmanagement.entity.TripStatus;
import com.badkultechnology.projecttripmanagement.service.TripService;
import com.badkultechnology.projecttripmanagement.service.TripService.TripSummary;

import java.time.LocalDate;

//This class controller used for starting the services like 

@RestController
@RequestMapping("/api/trips")
public class TripController {

	@Autowired
	private TripService service;

	@PostMapping
	public ResponseEntity<TripDTO> create(@Valid @RequestBody TripDTO dto) {
		return ResponseEntity.ok(service.createTrip(dto));
	}

	@GetMapping
	public ResponseEntity<Page<TripDTO>> getAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id,asc") String sort) {

		String[] parts = sort.split(",");
		String sortField = parts[0];
		Sort.Direction dir = parts.length > 1 && "desc".equalsIgnoreCase(parts[1]) ? Sort.Direction.DESC
				: Sort.Direction.ASC;
		Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortField));
		return ResponseEntity.ok(service.getAllTrips(pageable));
	}

	// Its used for get the trip detials by using the id and its important to rember
	// the id
	@GetMapping("/{id}")
	public ResponseEntity<TripDTO> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getTripById(id));
	}

	// This mapping is used for update the trip with the help of id
	// DTO use for updating details "like destination , dates , "
	@PutMapping("/{id}")
	public ResponseEntity<TripDTO> update(@PathVariable Integer id, @Valid @RequestBody TripDTO dto) {
		return ResponseEntity.ok(service.updateTrip(id, dto));
	}

	// This mapping is used for delete the trip with using id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteTrip(id);
		return ResponseEntity.noContent().build();
	}

	// Its a search mapping use for searching the trips with 0 to 10
	@GetMapping("/search")
	public ResponseEntity<Page<TripDTO>> search(@RequestParam String destination,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchByDestination(destination, pageable));
	}

	@GetMapping("/filter")
	public ResponseEntity<Page<TripDTO>> filter(@RequestParam TripStatus status,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.filterByStatus(status, pageable));
	}

	@GetMapping("/daterange")
	public ResponseEntity<Page<TripDTO>> daterange(@RequestParam String start, @RequestParam String end,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		LocalDate s = LocalDate.parse(start);
		LocalDate e = LocalDate.parse(end);
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.getByDateRange(s, e, pageable));
	}

	@GetMapping("/summary")
	public ResponseEntity<TripSummary> summary() {
		return ResponseEntity.ok(service.getSummary());
	}
}
