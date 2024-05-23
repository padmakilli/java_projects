package com.rgt.training.session2basics.vechile.impl;

import java.math.BigDecimal;

import com.rgt.training.session2basics.vechile.dto.rental.Rental;

public interface RentalCostCalculator {
	BigDecimal calculateRentalCost(Rental rental);
}