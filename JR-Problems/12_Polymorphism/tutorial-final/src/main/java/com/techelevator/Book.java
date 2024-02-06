package com.techelevator;

/**
 * Book
 */
public class Book extends MediaItem {

	private String author;

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(String title, String author, double price) {
	    super(title, price);
	    this.author = author;
	}
	
	public Book() {
		super();
	}

	@Override
	public String toString() {
	    return "Title: " + this.getTitle() + ", Author: " + author + ", Price: $" + this.getPrice();
	}
}
