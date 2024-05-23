package com.rgt.training.session2basics.online_shopping.main;

import java.util.Scanner;

import com.rgt.training.session2basics.online_shopping.dto.User;
import com.rgt.training.session2basics.online_shopping.serviceimpl.OnlineShoppingService;

/**
 * OnlineShoppingMainHelper class used to invoke methods
 */
public class OnlineShoppingMainHelper {

	OnlineShoppingService onlineShoppingService = new OnlineShoppingService();

	/**
	 * stringScanner for handling exceptions by scanner class
	 */
	public String stringScanner(Scanner scanner) {
		String name="";
		boolean str = false;
		while (!str) {
			try {
				name = scanner.next();
				str = true;
			} catch (Exception e) {
				System.out.println("invalid input format");
			}
		}
		return name;
	}
	
	/**
	 * intScanner for handling exceptions by scanner class
	 */
	public int intScanner(Scanner scanner) {
		int name=0;
		boolean str = false;
		while (!str) {
			try {
				name =  Integer.parseInt(scanner.next());
				str = true;
			} catch (Exception e) {
				System.out.println("invalid input format");
			}
		}
		return name;
	}
	
	/**
	 * onlineShoppingMainMenu method which invokes service class methods
	 */
	public void onlineShoppingMainMenu() {
		Scanner scanner = new Scanner(System.in);
		int options;
		User account = new User();
		while (true) {
			String username = "";
			String password = "";
			String saveAndUnSave = "";
			System.out.println("Welcome to the RGTMessaging!");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");

			try {
				options = intScanner(scanner);
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("invalid input format");
				options = 0;
			}

			switch (options) {
			case 1:
				System.out.println("ENTER USERNAME");
				username = stringScanner(scanner);
				account.setUserName(username);

				System.out.println("ENTER PASSWORD");
				password = stringScanner(scanner);
				account.setPassword(password);

				System.out.println("ENTER Y to save and N clear the data");
				saveAndUnSave = stringScanner(scanner);
				switch (saveAndUnSave.toLowerCase()) {
				case "y":
					onlineShoppingService.registerUser(account);
					System.out.println("Account Created Successfully!");
					break;
				case "n":
					System.out.println("Account is not Created");
					account.clear();
					defalutMessage(scanner);
					break;
				default:
					System.out.println("Invalid option. Please try again.");
				}
				break;
			case 2:
				System.out.println("ENTER USERNAME");
				username = scanner.next();

				System.out.println("ENTER PASSWORD");
				password = scanner.next();

				boolean login = onlineShoppingService.login(username, password);
				if (login) {
					this.loggedInUSerData(username, scanner);
				} else {
					System.out.println("invalid username or password");
				}
				break;
			case 3:
				System.out.println("Exited Successfully");
				defalutMessage(scanner);
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	/**
	 * loggedInUSerData is used if user logins successfully
	 */
	public void loggedInUSerData(String username, Scanner scanner) {
		int choice;
		do {
			System.out.println("Please choose an option " + username + " :");
			System.out.println("1. List Products");
			System.out.println("2. Add Product");
			System.out.println("3. get product by name");
			System.out.println("4. Add to Cart");
			System.out.println("5. My Carts");
			System.out.println("6. Remove Product From Cart");
			System.out.println("7. Get total price");
			System.out.println("8. PlaceOrders");
			System.out.println("9. View Orders Placed");
			System.out.println("10. Get total price of Orders Placed");
			System.out.println("11. CheckOut");
			System.out.println("12. Logout");
			System.out.print("Choose an option: ");

			choice = intScanner(scanner);
			Scanner scanner2 = new Scanner(System.in);

			switch (choice) {
			case 1:
				onlineShoppingService.loadAllProducts();
				break;
			case 2:
				onlineShoppingService.saveProduct(scanner2);
				break;
			case 3:
				onlineShoppingService.getProductByName(scanner);
				break;
			case 4:
				onlineShoppingService.addProductToCart(scanner2, username);
				break;
			case 5:
				onlineShoppingService.getMyCarts(username);
				break;
			case 6:
				onlineShoppingService.removeProductFromCart(scanner, username);
				break;
			case 7:
				onlineShoppingService.getTotalPrice(username);
				break;
			case 8:
				onlineShoppingService.placeOrder(username);
				break;
			case 9:
				onlineShoppingService.getPlacedOrders(username);
				break;
			case 10:
				onlineShoppingService.getTotalPriceOfPlacedOrders(username);
				break;
			case 11:
				onlineShoppingService.placeOrderOrPurchase(username);
				break;
			case 12:
				onlineShoppingService.getOrderHistory(username);
				break;
			case 13:
				System.out.println("You have logged out successfully");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 13);
	}

	/**
	 * defalutMessage used to show some default message to user
	 */
	public void defalutMessage(Scanner scanner) {
		int option;
		do {
			System.out.println("     click 1 to go to Main Menu     ");
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("invalid input format");
				option = 0;
			}
		} while (option != 1);
	}
}
