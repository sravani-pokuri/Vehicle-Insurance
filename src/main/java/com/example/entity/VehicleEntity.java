package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vinsurance")
public class VehicleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String vehicleType;
	private int vehicleMake;
	private int valueOfInsurance;
	private int premiumCharges;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(int vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public int getValueOfInsurance() {
		return valueOfInsurance;
	}
	public void setValueOfInsurance(int valueOfInsurance) {
		this.valueOfInsurance = valueOfInsurance;
	}
	public int getPremiumCharges() {
		return premiumCharges;
	}
	public void setPremiumCharges(int premiumCharges) {
		this.premiumCharges = premiumCharges;
	}
	public VehicleEntity(long id, String vehicleType, int vehicleMake, int valueOfInsurance, int premiumCharges) {
		super();
		this.id = id;
		this.vehicleType = vehicleType;
		this.vehicleMake = vehicleMake;
		this.valueOfInsurance = valueOfInsurance;
		this.premiumCharges = premiumCharges;
	}
	public VehicleEntity() {
		super();
	}

}
