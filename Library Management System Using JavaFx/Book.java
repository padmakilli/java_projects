package com.rgt.training.session2basics.libraryjavafx.fx;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final StringProperty title;
    private final StringProperty author;

    public Book(String title, String author) {
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getAuthor() {
        return author.get();
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public StringProperty authorProperty() {
        return author;
    }
}
