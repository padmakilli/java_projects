package com.rgt.training.session2basics.library.dto;

public class Book {
	
	/*  Book title name */
	private String title;
	
	/*  Book author name */
	private String author;

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public Book() {
		super();
		this.title = "";
		this.author = "";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}