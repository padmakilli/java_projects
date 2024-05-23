package com.rgt.training.session2basics.library.dto;

public class Patron {
	
	/* patron name */
	private String name;
	
	/* patron borrowed name */
	private String borrowedBook;

	public Patron(String name, String borrowedBook) {
		super();
		this.name = name;
		this.borrowedBook = borrowedBook;
	}

	public Patron() {
		super();
		this.name = "";
		this.borrowedBook = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBorrowedBook() {
		return borrowedBook;
	}

	public void setBorrowedBook(String borrowedBook) {
		this.borrowedBook = borrowedBook;
	}
}