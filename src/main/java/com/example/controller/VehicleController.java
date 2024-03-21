package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.VehicleEntity;
import com.example.repository.VehicleRepo;
import com.example.service.VehicleService;

@RestController
@RequestMapping("api/insurance")
@CrossOrigin("http://localhost:3000")
public class VehicleController {

	@Autowired
	private VehicleService vehicleservice;

	@PostMapping("/add-insurance")
	public ResponseEntity<String> addInsurance(@RequestBody VehicleEntity entity) {
		VehicleEntity addedEntity = vehicleservice.addData(entity);
		if (addedEntity != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Data added successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
		}
	}

	@GetMapping("/all-data")
	public ResponseEntity<?> getAllData() {
	    List<VehicleEntity> data = vehicleservice.getData();
	    Map<String, Object> response = new HashMap<>();

	    if (data.isEmpty()) {
	        response.put("message", "No data available");
	    } else {
	        response.put("message", "Data fetched successfully");
	        response.put("data", data);
	    }

	    return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getSingleData(@PathVariable Long id){
		Optional<VehicleEntity> data = vehicleservice.getById(id);
	    Map<String, Object> response = new HashMap<>();
	    if (data.isEmpty()) {
	        response.put("message", "No data available");
	    } else {
	        response.put("message", "Data fetched successfully");
	        response.put("data", data);
	    }

	    return ResponseEntity.ok(response);
	}
		


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDataById(@PathVariable Long id) {
		try {
			vehicleservice.deleteDataById(id);

			return ResponseEntity.ok("Data deleted successfully");
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete data");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateData(@PathVariable Long id, @RequestBody VehicleEntity entity) {
		entity.setId(id);
		VehicleEntity updatedEntity = vehicleservice.addData(entity);

		if (updatedEntity != null) {

			return ResponseEntity.ok("Data updated successfully");
		} else {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update data");
		}
	}
}