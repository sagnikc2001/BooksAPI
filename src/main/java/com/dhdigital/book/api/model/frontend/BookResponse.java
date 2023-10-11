package com.dhdigital.book.api.model.frontend;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class BookResponse {
	
	@JsonProperty("bookNumber")
	private int bookNumber;
	
	@JsonProperty("book")
	private String book;
	
	@JsonProperty("authorName")
	private String authorName;
	
	@JsonProperty("bookGenre")
	private String bookGenre;
	
	@JsonProperty("quantity")
	private int quantity;

//	Getters and Setters
	
	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	Default Constructor
	
	public BookResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

//	Parameterized Constructor
	
	public BookResponse(int bookNumber, String book, String authorName, String bookGenre, int quantity) {
		super();
		this.bookNumber = bookNumber;
		this.book = book;
		this.authorName = authorName;
		this.bookGenre = bookGenre;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BookResponse [bookNumber=" + bookNumber + ", book=" + book + ", authorName=" + authorName
				+ ", bookGenre=" + bookGenre + ", quantity=" + quantity + "]";
	}
}
