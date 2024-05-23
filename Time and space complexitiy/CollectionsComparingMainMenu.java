package com.rgt.training.session2basics.collections.main;

import java.util.Scanner;

import com.rgt.training.session2basics.collections.helper.CollectionsHelper;

public class CollectionsComparingMainMenu {
	
	CollectionsHelper helper = new CollectionsHelper();
	
	/**
	 * displayMenu method to display the options and invoke 
	 * the other methods
	 * */
	private int displayMenu(Scanner scanner) {
		System.out.println("Collections Comparision");
		System.out.println("1. Insert operations");
		System.out.println("2. Update operations");
		System.out.println("3. Read operations");
		System.out.println("4. delete operations");
		System.out.println("5. exit");
		System.out.print("Choose an option: ");
		int nextInt = scanner.nextInt();
		return nextInt;
	}
	
	/**
	 * invoke the methods for the comparison operations
	 * */
	public void collectionsComparingMainMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			choice = displayMenu(scanner);
			switch (choice) {
			case 1:
				helper.insert(scanner);
				break;
			case 2:
				helper.update(scanner);
				break;
			case 3:
				helper.read();
				break;
			case 4:
				helper.delete();
				break;
			
			default:
				System.out.println("Invalid option. Please try again.");
			}

			System.out.println();
		} while (1 != 5);
	}
	
}
