package com.dhdigital.book.api.model.frontend;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class BookRequest {
	
//	According to the format we are getting from Backend
	
	@JsonProperty("id")
	private int id;

	@JsonProperty("bookName")
	private String bookName;

	@JsonProperty("author")
	private String author;

	@JsonProperty("genre")
	private String genre;
	
	@JsonProperty("qty")
	private int qty;

//	Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int bookNumber) {
		this.id = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

//	Parameterized Constructor
	
	public BookRequest(int id, String bookName, String author, String genre, int qty) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.genre = genre;
		this.qty = qty;
	}

//	Default Constructor
	
	public BookRequest() {
		super();
	}

//	toString
	
	@Override
	public String toString() {
		return "BookRequest [id=" + id + ", bookName=" + bookName + ", author=" + author + ", genre="
				+ genre + ", qty=" + qty + "]";
	}


}
