package com.rgt.training.session2basics.vechile.impl;

public abstract class Vehicle implements VehicleOperations {
	private String licensePlate;
	private String make;
	private String model;
	private boolean isAvailable;
	private int pricePerDay;
	
	public int getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public boolean isAvailable() {
		return this.isAvailable;
	}
	@Override
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Vehicle [licensePlate=" + licensePlate + ", make=" + make + ", model=" + model + ", isAvailable="
				+ isAvailable + ", pricePerDay=" + pricePerDay + "]";
	}
}