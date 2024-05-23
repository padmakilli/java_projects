package com.rgt.training.session2basics.library.main;

import java.util.Scanner;

import com.rgt.training.session2basics.library.service.LibraryManagementSystem;

public class Library {
	
	LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
	
	/*
	 * main invokes this to choose options 
	 * and switch case will invoke the required
	 * method from LibraryManagementSystem class
	 * and validates 
	 */
	public void libraryMenu() {
		Scanner scanner = new Scanner(System.in);
		int options = 0;
		while (true) {
			String title = "";
			String author = "";
			System.out.println("Library Managerment System");
			System.out.println("1. Add Book");
			System.out.println("2. Add Patron");
			System.out.println("3. Borrow Book");
			System.out.println("4. Return Book");
			System.out.println("5. Exit");
			System.out.print("Enter your choice : ");
			String next = scanner.next();

			/* validation for the about inputs */
			char indexOf = next.charAt(0);
			int output = (int) indexOf;
			
			/*
			 * its for validation to get 1st char from input and removes the unwanted data
			 * it handles number format exception also
			 */
			if (output > 48 && output < 54) {
				String values = "" + indexOf;
				options = Integer.parseInt(values);
			}

			switch (options) {
			case 1:
				System.out.println("Enter Book title : ");
				title = scanner.next();

				System.out.println("Enter Book author : ");
				author = scanner.next();

				/*
				 * this method used to add the books
				 */
				libraryManagementSystem.addBook(title, author);
				break;
			case 2:
				System.out.println("Enter Patron Name : ");
				author = scanner.next();

				/*
				 * this method used to add the patrons
				 */
				libraryManagementSystem.addPatron(author, scanner);
				break;
			case 3:
				System.out.println("Enter Patron Name : ");
				author = scanner.next();

				System.out.println("Enter Book Title : ");
				title = scanner.next();

				/*
				 * this method used to borrow a book
				 */
				libraryManagementSystem.borrowBook(author, title, scanner);
				break;
			case 4:
				System.out.println("Enter Patron Name : ");
				author = scanner.next();

				System.out.println("Enter Book Title : ");
				title = scanner.next();

				/*
				 * this method used to return a books
				 */
				libraryManagementSystem.returnBook(author, title, scanner);
				break;
			case 5:
				System.out.println("Successfully exited !");
				
				/*
				 * this method used to exit
				 */
				libraryManagementSystem.defalutMessage(scanner);
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}
	
	public static void main(String[] args) {
		
		/*
		 * Creating the object to rum the functionality
		 */
		Library library = new Library();
		
		/*
		 * to invoke the libraryMenu for Library Management system
		 */
		library.libraryMenu();
	}
	
}
