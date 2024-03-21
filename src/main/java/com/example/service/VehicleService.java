package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.VehicleEntity;
import com.example.repository.VehicleRepo;

@Service
public class VehicleService {
	
	@Autowired
	VehicleRepo vehiclerepo;

	public VehicleEntity addData(VehicleEntity entity) {
		return vehiclerepo.save(entity) ;
	}

	public List<VehicleEntity> getData() {
		return vehiclerepo.findAll();
	}

	public Optional<VehicleEntity> getById(Long id) {
		return vehiclerepo.findById(id);
	}

	
	public void deleteDataById(Long id) {
		vehiclerepo.deleteById(id);
		
	}

	
}
