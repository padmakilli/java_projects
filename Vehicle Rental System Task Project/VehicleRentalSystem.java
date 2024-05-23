package com.rgt.training.session2basics.vechile.main;

import com.rgt.training.session2basics.vechile.service.VehicleRentalSystemService;

public class VehicleRentalSystem {

	public static void main(String[] args) {
		VehicleRentalSystemService rentalSystem = new VehicleRentalSystemService();
		rentalSystem.menu();
	}
}