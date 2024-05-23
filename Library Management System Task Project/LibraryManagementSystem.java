package com.rgt.training.session2basics.library.service;

import java.util.Scanner;

import com.rgt.training.session2basics.library.dto.Book;
import com.rgt.training.session2basics.library.dto.Patron;

public class LibraryManagementSystem {

	/* to give constant value 
	 * for total no of books 
	 */
	private static final int MAX_BOOKS = 10;

	/* to give constant value 
	 * for total no of patrons 
	 */
	private static final int MAX_PATRONS = 5;

	/* total no of books title list */
	private static String[] booksTitle = new String[MAX_BOOKS];

	/*  total no of books list*/
	private static Book[] books = new Book[MAX_BOOKS];

	/*  total no of patrons list*/
	private static Patron[] patrons = new Patron[MAX_PATRONS];

	/*
	 * public void libraryManagementMainMenu() { Scanner scanner = new
	 * Scanner(System.in); int options = 0; while (true) { String title = ""; String
	 * author = ""; System.out.println("Library Managerment System");
	 * System.out.println("1. Add Book"); System.out.println("2. Add Patron");
	 * System.out.println("3. Borrow Book"); System.out.println("4. Return Book");
	 * System.out.println("5. Exit"); System.out.print("Enter your choice : ");
	 * String next = scanner.next();
	 * 
	 * validation for the about inputs
	 * 
	 * char indexOf = next.charAt(0); int output = (int) indexOf; if (output > 48 &&
	 * output < 54) {
	 * 
	 * 
	 * its for validation to get 1st char from input and removes the unwanted data
	 * it handles number format exception also
	 * 
	 * String values = "" + indexOf; options = Integer.parseInt(values); }
	 * 
	 * switch (options) { case 1: System.out.println("Enter Book title : "); title =
	 * scanner.next();
	 * 
	 * System.out.println("Enter Book author : "); author = scanner.next();
	 * 
	 * addBook(title, author); break; case 2:
	 * System.out.println("Enter Patron Name : "); author = scanner.next();
	 * 
	 * addPatron(author, scanner); break; case 3:
	 * System.out.println("Enter Patron Name : "); author = scanner.next();
	 * 
	 * System.out.println("Enter Book Title : "); title = scanner.next();
	 * 
	 * borrowBook(author, title, scanner); break; case 4:
	 * System.out.println("Enter Patron Name : "); author = scanner.next();
	 * 
	 * System.out.println("Enter Book Title : "); title = scanner.next();
	 * 
	 * returnBook(author, title, scanner); break; case 5:
	 * System.out.println("Successfully exited !"); defalutMessage(scanner); break;
	 * default: System.out.println("Invalid option. Please try again."); } } }
	 */
	
	

	/*
	 * this method used to check the list of books before 
	 * adding the books to library management system
	 * 
	 * here we check the total list of books and
	 * check there availability of books and validation
	 * on the given size also
	 * 
	 * here we have checked the books that are we adding
	 * existed books are not 
	 */
	public boolean addBookCheckMethod(String title) {
		boolean bookAvailable = true;
		int bookAvailableCheck = 0;
		for (int i = 0; i < booksTitle.length; i++) {
			bookAvailableCheck = i;
			if (bookAvailableCheck == (MAX_BOOKS - 1)) {
				if (booksTitle[i] != null) {
					System.out.println("cannot add more books! please try again later!");
					return false;
				}
			}
			if (booksTitle[i] != null) {
				boolean equals = booksTitle[i].equals(title);
				if (equals) {
					System.out.println("Book already exists! : " + title + " please add new book");
					bookAvailable = false;
					return bookAvailable;
				}
			} else {
				booksTitle[i] = title;
				return bookAvailable;
			}
		}
		return bookAvailable;
	}

	/*
	 * here first we invoked a method to checks the 
	 * books title list and got the result of boolean
	 * 
	 * on base of boolean value we are travering the
	 * loop and then again checking that book is present
	 * or not
	 * if the book not there then we are adding the book
	 * to books list 
	 * 
	 */
	public Book addBook(String title, String author) {
		boolean addBookCheckMethod = addBookCheckMethod(title);
		Book book = null;
		if (addBookCheckMethod) {
			for (int j = 0; j < books.length; j++) {
				book = books[j];
				if (book == null) {
					book = new Book(title, author);
					books[j] = book;
					System.out.println("Book Added Successfully !");
					return book;
				}
			}
		}
		return book;
	}

	/*
	 * here first we invoked a method to checks the 
	 * patrons list for the list of partons and validating
	 * the patrons list
	 *
	 * the checking total list of patrons where data exist
	 * or null exist, if the partons is not null then 
	 * checking the patron the new patron name and if the 
	 * name not exist  return empty patron 
	 * 
	 * in else block we diectly add the patron and return	 * 
	 * 
	 */
	public Patron addPatron(String name, Scanner scanner) {
		Patron patron = null;
		int patronAvailableCheck = 0;
		for (int j = 0; j < patrons.length; j++) {
			patronAvailableCheck = j;
			if (patronAvailableCheck == (MAX_PATRONS - 1)) {
				if (patrons[j] != null) {
					System.out.println("cannot add more patrons! please try again later!");
					return null;
				}

			}
			if (patrons[j] != null) {
				if (name.equals(patrons[j].getName())) {
					System.out.println("Patron Already Exits!");
					return patron;
				}
			} else {
				patron = new Patron(name, null);
				patrons[j] = patron;
				System.out.println("Patron Added Successfully");
				return patron;
			}
		}
		return patron;
	}
	
	/*
	 * here first we invoked a method to checks the 
	 * patrons list for the list of partons and validating
	 * the patrons list
	 *
	 * if patron is not null then internally we check the patron
	 * name by given patron name and if it matches then we check
	 * the patrons book field is null then add the book then we give 
	 * boolean value by true else default is false only and based on 
	 * it we iterate the books title list and if the values present 
	 * then we check that given book name is there is book list or
	 * not if exits then we set the book to patron and return boolean 
	 * value and based on boolean value we print message.
	 * 
	 * else we wont add the book to patron and print the message
	 * and based on boolean field we print message
	 * 
	 */
	public void borrowBook(String patronName, String bookTitle, Scanner scanner) {
		boolean borrowed = false;
		Patron patron = null;
		for (int j = 0; j < patrons.length; j++) {
			Patron patron2 = patrons[j];
			if (patron2 != null) {
				String borrowedBook = patrons[j].getBorrowedBook();
				String nameOfPatron = patrons[j].getName();
				if (nameOfPatron.equals(patronName)) {
					if (borrowedBook == null) {
						patron = patrons[j];
						borrowed = true;
						break;
//						patron.setBorrowedBook(bookTitle);
					} else {
						System.out.println("Please return the perious book and then Borrow the book! ");
						break;
					}
				}
			}

		}
		boolean availableBooks = false;
		if (borrowed) {
			for (int i = 0; i < booksTitle.length; i++) {
				if (booksTitle[i] != null) {
					String bookAvailable = booksTitle[i];
					if (bookAvailable.equals(bookTitle)) {
						patron.setBorrowedBook(bookTitle);
						availableBooks = true;
					}
				}

			}
		}

		if (availableBooks) {
			System.out.println("Successfully You Have Borrowed Book !");
		} else {
			System.out.println("You Cannot Borrow this Book or Book is not there in our list");
		}
	}

	/*
	 * here first we invoked a method to checks the 
	 * patrons list for the list of partons and validating
	 * the patrons list
	 * 
	 * if the patron is not null and then name of patron and
	 * given patron name exists then we return boolean data
	 * 
	 * again we iterate the books list for given book name
	 * if the lists book is not null and the name of book is 
	 * equals with given name we return boolean data
	 * 
	 * based on first boolean data we iterate the patrons list 
	 * and that patron is not null and the patron name is equals
	 * with given name then checks for patrons book data is
	 * if null prints patron has not taken any book and if not null 
	 * and if not null then it checks for second boolean data if its 
	 * true it removes book from the patron.
	 * else it prints books message that book is not there in list
	 * 
	 */
	public void returnBook(String patronName, String bookTitle, Scanner scanner) {
		boolean returncheck = false;
		for (int i = 0; i < patrons.length; i++) {
			if (patrons[i] != null) {
				if (patrons[i].getName().equals(patronName)) {
					returncheck = true;
				}
			}
		}
		boolean availableList = false;
		for (int j = 0; j < booksTitle.length; j++) {
			String booksTitleAvailableCheck = booksTitle[j];
			if (booksTitleAvailableCheck != null) {
				if (booksTitleAvailableCheck.equals(bookTitle)) {
					availableList = true;
				}
			}
		}
		if (returncheck) {
			for (int i = 0; i < patrons.length; i++) {
				if (patrons[i] != null) {
					String patronsName = patrons[i].getName();
					if (patronsName.equals(patronName)) {
						String borrowedBook = patrons[i].getBorrowedBook();
						if (borrowedBook != null) {
							if (availableList) {
//								for (int j = 0; j < booksTitle.length; j++) {
//									String booksTitleAvailableCheck = booksTitle[j];
//									if (booksTitleAvailableCheck.equals(bookTitle)) {
										patrons[i].setBorrowedBook(null);
										System.out.println("you have return the borrowed book successfully !");
										break;
//									}
//								}
							} else {
								System.out.println("Please Return Borrowed Book only !");
								System.out.println("This Book is not in Our List! Please Return Valid Book");
								break;
							}
						} else {
							System.out.println("Since Now You have not Borrowed any Book !");
							break;
						}
					}

				}
			}
		} else {
			System.out.println("Your not there in Patron list");
		}
	}

	/*
	 * here first we invoked a method for showing some defalut 
	 * message like while we exit the code etc.,
	 * 
	 */
	public void defalutMessage(Scanner scanner) {
		int res = 0;
		do {
			System.out.println("     						        ");
			System.out.println("     <			------------------			 >       ");
			System.out.println("     						        ");
			System.out.println("           	    click 1 to go to Main Menu          ");
			System.out.println("     						        ");
			System.out.println("     <			------------------			 >       ");
			System.out.println("     						        ");
			try {
				res = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Enter Valid option");
			}
		} while (res != 1);
	}

	/*
	 * public int validInput(Scanner scanner) { int res = 0; boolean returns = true;
	 * do { try { res = scanner.nextInt(); returns = true; } catch (Exception e) {
	 * System.out.println("Enter Valid option"); break; } } while (returns); return
	 * res; }
	 */

	/*
	 * public static void main(String[] args) { LibraryManagementSystem library =
	 * new LibraryManagementSystem(); library.libraryManagementMainMenu(); }
	 */
}
