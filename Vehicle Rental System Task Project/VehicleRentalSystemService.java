package com.rgt.training.session2basics.vechile.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rgt.training.session2basics.vechile.dto.customer.Customer;
import com.rgt.training.session2basics.vechile.dto.rental.Rental;
import com.rgt.training.session2basics.vechile.dto.vehicle.Bike;
import com.rgt.training.session2basics.vechile.dto.vehicle.Car;
import com.rgt.training.session2basics.vechile.dto.vehicle.MotorCycle;
import com.rgt.training.session2basics.vechile.impl.Vehicle;

public class VehicleRentalSystemService {
	private List<Customer> customers = null;
	private RentalService rentalService = null;

	public VehicleRentalSystemService() {
		customers = new ArrayList<>();
		rentalService = new RentalService();
	}

	private String addVehicle(Vehicle vehicle) {
		List<Vehicle> vehicles = rentalService.getVehicles();
		List<Vehicle> listVehicles = new ArrayList<>();
		String message = "";
		if (vehicles.size() > 0) {
			for (Vehicle vehicle2 : vehicles) {
				if (vehicle2 != null) {
					boolean equals = vehicle2.getLicensePlate().equalsIgnoreCase(vehicle.getLicensePlate());
					if (equals) {
						message = "vechile exists";
						break;
					}
				}
			}
		} else {
			listVehicles.add(vehicle);
			rentalService.setVehicles(listVehicles);
			message = "added successfully";
		}
		boolean equalsIgnoreCase = message.equalsIgnoreCase("vechile exists");
		boolean equalsIgnoreCase2 = message.equalsIgnoreCase("added successfully");
		if ((!equalsIgnoreCase) && (!equalsIgnoreCase2)) {
			listVehicles.add(vehicle);
			vehicles.addAll(listVehicles);
			rentalService.setVehicles(vehicles);
			message = "added successfully";
		}
		System.out.println(message);
		return message;
	}

	private boolean removeVehicle(String numberToDelete) {
		boolean returnType = true;
		List<Vehicle> vehicles = rentalService.getVehicles();
		if (vehicles.size() > 0) {
			for (Vehicle vehicle2 : vehicles) {
				if (vehicle2 != null) {
					boolean equals = vehicle2.getLicensePlate().equalsIgnoreCase(numberToDelete);
					if (equals) {
						int indexOf = vehicles.indexOf(vehicle2);
						rentalService.getVehicles().remove(indexOf);
						System.out.println("removed successfully");
						returnType = false;
					}
				}
			}
		} else {
			System.out.println("you dont have any vehicles to remove! Add new Vechile");
			returnType = false;
		}
		return returnType;
	}

	private void updateVehicle(String numberPlate, boolean available) {
		List<Vehicle> vehicles = rentalService.getVehicles();
		String message = "";
		if (vehicles.size() > 0) {
			for (Vehicle vehicle2 : vehicles) {
				if (vehicle2 != null) {
					boolean updatingVechile = vehicle2.getLicensePlate().equalsIgnoreCase(numberPlate);
					if (updatingVechile) {
						int indexOf = vehicles.indexOf(vehicle2);
						vehicle2.setAvailable(available);
						rentalService.getVehicles().set(indexOf, vehicle2);
						message = "vehicle updated successfully";
						break;
					}
				}
			}
		} else {
			message = "you dont have vehicle to update! please add vehicle";
		}

		boolean equalsIgnoreCase = message.equalsIgnoreCase("vehicle updated successfully");
		boolean equalsIgnoreCase2 = message.equalsIgnoreCase("you dont have vehicle to update! please add vehicle");
		if ((!equalsIgnoreCase) && (!equalsIgnoreCase2)) {
			message = "vehcile is not in list";
		}
		System.out.println(message);
	}

	private void findAvailableVechiles() {
		List<Vehicle> vehicles = rentalService.getVehicles();
		if (vehicles.size() > 0) {
			for (Vehicle vehicle : vehicles) {
//				if (vehicle.isAvailable()) {
				System.out.println(vehicle);
//				}
			}
		} else {
			System.out.println("you dont have any vehicle! please add vehicle");
		}

	}

	private String createCustomer(Customer addCustomer) {
		List<Customer> customersList = new ArrayList<>();
		String message = "";
		if (customers.size() > 0) {
			for (Customer customer : customers) {
				if (customer == null) {
					customers.add(addCustomer);
					message = "customer created";
					System.out.println(message);
					break;
				} else {
					boolean equals = customer.getId().equalsIgnoreCase(addCustomer.getId().toLowerCase());
					if (equals) {
						message = "customer exists";
						break;
					}

				}
			}
		} else {
			customers.add(addCustomer);
			message = "customer created";
		}
		boolean equalsIgnoreCase = message.equalsIgnoreCase("customer created");
		boolean equalsIgnoreCase2 = message.equalsIgnoreCase("customer exists");
		if ((!equalsIgnoreCase) && (!equalsIgnoreCase2)) {
			customersList.add(addCustomer);
			customers.addAll(customersList);
			message = "customer created";
		}
		System.out.println(message);
		return message;
	}

	private void findCustomers() {
		String message = "";
		List<Customer> customerList = new ArrayList<>();
		customerList.addAll(customers);
		if (customerList.size() > 0) {
			for (Customer customer : customers) {
				System.out.println(customer);
			}
		} else {
			message = "you dont have customer! please add customer";
		}
		System.out.println(message);
	}

	private void findRentedVehicle() {
		List<Rental> rentals = rentalService.getRentals();
		if (rentals.size() > 0) {
			for (Rental rental : rentals) {
				System.out.println(rental);
			}
		} else {
			System.out.println("No Vehicles are Rented!");
		}
	}

	private void createReservation(String customerid, String vehicleNumber, String start, String end) {
		boolean vehicleCheck = false;
		boolean customerCheck = false;
		boolean dateCheck = false;
		String message = "";
		List<Vehicle> vehicles = rentalService.getVehicles();
//		int indexOf = vehicles.indexOf(vehicle);
//		Vehicle vehicle2 = vehicles.get(indexOf);
//		boolean available = vehicle2.isAvailable();
//		if (available) {
//			Rental rental = new Rental();
//			rental.setCustomer(customer);
//			rental.setRentedVehicle(vehicle2);
//		}
		if (vehicles.size() > 0) {
			for (Vehicle vehicle2 : vehicles) {
				if (vehicle2 != null) {
//					boolean vehicleModelCheck = vehicle2.getModel().equalsIgnoreCase(vehicle.getModel());
					boolean vehicleNumberCheck = vehicle2.getLicensePlate()
							.equalsIgnoreCase(vehicleNumber.toLowerCase());
					if (vehicleNumberCheck) {
						boolean available = vehicle2.isAvailable();
						if (available) {
							vehicleCheck = true;
							for (Customer custom : customers) {
								if (custom != null) {
									boolean customerCheckId = custom.getId().equalsIgnoreCase(customerid.toLowerCase());
									if (customerCheckId) {
										customerCheck = true;
										if (start != null && end != null) {
											LocalDateTime startTime = dateTime(start);
											LocalDateTime endTime = dateTime(end);
											if (startTime != null && endTime != null) {
												boolean dateTimeValidation = dateTimeValidation(startTime, endTime);
												if (dateTimeValidation) {
													dateCheck = true;
												Rental rental = new Rental();
												rental.setStartTime(startTime);
												rental.setEndTime(endTime);
												rental.setCustomer(custom);
												rental.setRentedVehicle(vehicle2);
												vehicle2.setAvailable(false);
												int indexOf = rentalService.getVehicles().indexOf(vehicle2);
												rentalService.getVehicles().set(indexOf, vehicle2);
												rentalService.getRentals().add(rental);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		if (vehicleCheck) {
			if (customerCheck) {
				if (dateCheck) {
					message = "Rented vechile succeddfully";
				}else {
					message = "invalid dates";
				}
			} else {
				message = "customer is not available in list";
			}
		} else {
			message = "vehicle is not available in list or is in the rent";
		}
		System.out.println(message);
	}

	private boolean dateTimeValidation(LocalDateTime start, LocalDateTime end) {
		boolean after = end.isAfter(start);
		return after;
	}

	private LocalDateTime dateTime(String dateTime) {
		LocalDateTime start = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd@HH:mm");
			start = LocalDateTime.parse(dateTime, formatter);
			return start;
		} catch (Exception e) {
			return start;
		}
	}

	private String modifyReservation(Customer customer, Vehicle vehicle, String startTime, String endTime) {
		List<Rental> rentals = rentalService.getRentals();
		String message = "";
		for (Rental rental : rentals) {
			if (rental != null) {
				Customer customer2 = rental.getCustomer();
				Vehicle rentedVehicle = rental.getRentedVehicle();
				String id = customer2.getId();
				String licensePlate = rentedVehicle.getLicensePlate();
				boolean customerIdCheck = customer.getId().equalsIgnoreCase(id);
				boolean vehicleNumberCheck = vehicle.getLicensePlate().equalsIgnoreCase(licensePlate);
				if (vehicleNumberCheck && customerIdCheck) {
					if (startTime != null && endTime != null) {
						LocalDateTime start = dateTime(startTime);
						LocalDateTime end = dateTime(endTime);
						if (start != null && end != null) {
							boolean dateTimeValidation = dateTimeValidation(start, end);
							if (dateTimeValidation) {
								rental.setStartTime(start);
								rental.setEndTime(end);
								int indexOf = rentalService.getRentals().indexOf(rental);
								rentalService.getRentals().set(indexOf, rental);
								message = "modified successfully";
							} else {
//								start date should not be more than end date
								message = "Start Time Should not be more than End Time";
							}
						} else {
//							message invalid dates time format
							message = "Invalid Start and End Time Format";
						}
					} else {
//						logic for time exceptions;
						message = "Start and End Time should not be Empty";
					}

				} else {
					message = "Invalid customer or vehicle details";
				}

			} else {
				message = "No Rentals till now! Please Add new Rental / Reservations";
			}
		}
		return message;
	}

	public void cancelReservation(Customer customer, Vehicle vehicle) {

	}
	
	public void totalCost(String id) {
		String message = "";
		boolean customerCheck = false;
		BigDecimal calculateRentalCost = null;
		List<Rental> rentals = rentalService.getRentals();
		if (rentals.size()>0) {
			for (Rental rental : rentals) {
				if (rental!=null) {
					Customer customer = rental.getCustomer();
					boolean equalsIgnoreCase = customer.getId().equalsIgnoreCase(id);
					if (equalsIgnoreCase) {
						customerCheck = true;
						calculateRentalCost = rentalService.calculateRentalCost(rental);
						message = " total cost : ";
						break;
//						System.out.println(calculateRentalCost);
					}else {
						message = "No Rental Present with the given id";
					}
				}
//				Customer customer = rental.getCustomer();
//				boolean equalsIgnoreCase = customer.getId().equalsIgnoreCase(id);
//				if (equalsIgnoreCase) {
//					customerCheck = false;
//					Vehicle rentedVehicle = rental.getRentedVehicle();
//					int indexOf = rentalService.getVehicles().indexOf(rentedVehicle);
//					rentedVehicle.setAvailable(true);
//					rentalService.getVehicles().set(indexOf, rentedVehicle);
//				}
			}
		}else {
			message = "No vehicle are in Rent";
		}
		if (customerCheck) {
			System.out.println(message + calculateRentalCost);
		}else {
			System.out.println(message);
		}
	}
	
	public void returnVehicle(String id) {
		String message = "";
		boolean customerCheck = false;
		List<Rental> rentals = rentalService.getRentals();
		if (rentals.size()>0) {
			for (Rental rental : rentals) {
				if (rental!=null) {
					Customer customer = rental.getCustomer();
					boolean equalsIgnoreCase = customer.getId().equalsIgnoreCase(id);
					if (equalsIgnoreCase) {
						customerCheck = true;
						int indexOf = rentalService.getRentals().indexOf(rental);
						rentalService.getRentals().set(indexOf, null);
						message = "successfully returned the vehicle";
						break;
					}
				}
			}
		}else {
			message = "No vehicle are in Rent";
		}
		if (customerCheck) {
			System.out.println(message);
		}else {
			if (message.equals(null)) {
				System.out.println("customer not exists in rental");
			}else {
				System.out.println(message);
			}
		}
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Welcome to Vehicle Rental System");
			System.out.println("1. Add Vehicle");
			System.out.println("2. See Vehicle");
			System.out.println("3. Remove Vehicle");
			System.out.println("4. Update Vehicle availablility");
			System.out.println("5. Add Customer");
			System.out.println("6. See Customer");
			System.out.println("7. Rent a Vehicle");
			System.out.println("8. See all Rented Vehicle");
			System.out.println("9. Return Vehicle");
			System.out.println("10. Calculate Rental Cost");
			System.out.println("11. Logout");
			System.out.print("Choose an option: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Add Vehicle");
				/* to check the balance */
				int option;
				do {
					System.out.println("1. Car");
					System.out.println("2. Bike");
					System.out.println("3. Cycle");
					System.out.println("4. exit");
					option = scanner.nextInt();
					Vehicle vehicle = null;
					switch (option) {
					case 1: {
						vehicle = new Car();
						vehicle.setAvailable(true);

						System.out.println("enter plate");
						String number = scanner.next();
						vehicle.setLicensePlate(number);

						System.out.println("enter make");
						String make = scanner.next();
						vehicle.setMake(make);

						System.out.println("enter model");
						String model = scanner.next();
						vehicle.setModel(model);
						
						System.out.println("enter price");
						int price = scanner.nextInt();
						vehicle.setPricePerDay(price);

						addVehicle(vehicle);
						break;
					}
					case 2: {
						vehicle = new Bike();
						vehicle.setAvailable(true);

						System.out.println("enter plate");
						String number = scanner.next();
						vehicle.setLicensePlate(number);

						System.out.println("enter make");
						String make = scanner.next();
						vehicle.setMake(make);

						System.out.println("enter model");
						String model = scanner.next();
						vehicle.setModel(model);
						
						System.out.println("enter price");
						int price = scanner.nextInt();
						vehicle.setPricePerDay(price);

						addVehicle(vehicle);
						break;
					}
					case 3: {
						vehicle = new MotorCycle();
						vehicle.setAvailable(true);

						System.out.println("enter plate");
						String number = scanner.next();
						vehicle.setLicensePlate(number);

						System.out.println("enter make");
						String make = scanner.next();
						vehicle.setMake(make);

						System.out.println("enter model");
						String model = scanner.next();
						vehicle.setModel(model);
						
						System.out.println("enter price");
						int price = scanner.nextInt();
						vehicle.setPricePerDay(price);

						addVehicle(vehicle);
						break;
					}
					case 4:{
						System.out.println("successfully exited");
						break;
					}
					default:
						System.out.println("invalid option");
					}
					
				} while (option != 4);
				
				break;
			case 2:;
				findAvailableVechiles();
				break;
			case 3:
				System.out.println("Remove Vehicle");

				System.out.println("enter plate");
				String numberToDelete = scanner.next();

				boolean removeVehicle = removeVehicle(numberToDelete.toLowerCase());
				if (removeVehicle) {
					System.out.println("This Vehicle is not in our list");
				}
				break;
			case 4:
				/* to check transactions */
				System.out.println("Update Vehicle");
				System.out.println("enter number");
				String numberToUpdate = scanner.next();

				System.out.println("enter number");
				boolean available = scanner.nextBoolean();

				updateVehicle(numberToUpdate, available);

				break;
			case 5:
				System.out.println("add customer");
				Customer customer = new Customer();

				System.out.println("enter first name");
				String fn = scanner.next();
				customer.setFirstName(fn);

				System.out.println("enter last name");
				String ln = scanner.next();
				customer.setLastName(ln);

				System.out.println("enter id");
				String id = scanner.next();
				customer.setId(id);

				createCustomer(customer);

				break;
			case 6:
				System.out.println("Avalilable Customers");
				findCustomers();
				break;
			case 7:
				System.out.println("Rent a vehicle");
				System.out.println("enter customer id");
				String customID = scanner.next();
				System.out.println("enter vehicle number");
				String vechilenumber = scanner.next();
				System.out.println("enter start date and time");
				String start = scanner.next();
				System.out.println("enter end date and time");
				String end = scanner.next();
				try {
					createReservation(customID, vechilenumber, start, end);
				} catch (Exception e) {
					System.out.println("invalid dates");
				}
				break;
			case 8:
				System.out.println("All Rented Vehicles");
				findRentedVehicle();

				break;
			case 9:
				System.out.println("All Rented Vehicles");
				System.out.println("enter customerid");
				String returnId = scanner.next();
				returnVehicle(returnId);
				
				break;
			case 10:
				System.out.println("All Rented Vehicles");
				System.out.println("enter customerid");
				String totalCostID = scanner.next();
				totalCost(totalCostID);
				break;
			case 11:
				System.out.println("exited");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}

			System.out.println();
		} while (choice != 11);
	}
}