package com.rgt.training.session2basics.vechile.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.rgt.training.session2basics.vechile.dto.rental.Rental;
import com.rgt.training.session2basics.vechile.impl.RentalCostCalculator;
import com.rgt.training.session2basics.vechile.impl.Vehicle;

public class RentalService implements RentalCostCalculator {

	private List<Vehicle> vehicles;
    private List<Rental> rentals;
    
	public RentalService() {
		super();
		this.vehicles = new ArrayList<>();
		this.rentals = new ArrayList<>();
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	@Override
	public BigDecimal calculateRentalCost(Rental rental) {
		BigDecimal multiply = null;
			Duration between = Duration.between(rental.getStartTime(), rental.getEndTime());
			long days = between.toDays();
			if (days==0) {
				Vehicle rentedVehicle = rental.getRentedVehicle();
				int pricePerDay = rentedVehicle.getPricePerDay();
				BigDecimal valueOf = BigDecimal.valueOf(pricePerDay);
				multiply = valueOf.multiply(BigDecimal.valueOf(1));
			}else {
				Vehicle rentedVehicle = rental.getRentedVehicle();
				int pricePerDay = rentedVehicle.getPricePerDay();
				BigDecimal valueOf = BigDecimal.valueOf(pricePerDay);
				multiply = valueOf.multiply(BigDecimal.valueOf(days));
			}
			
		return multiply;
	}	
}
