package com.dhdigital.book.api.model.backend;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class BookEnquiryRequest {
	
	@JsonProperty("isbn")
	private int isbn;
	
//	Parameterized Constructor
	public BookEnquiryRequest(int isbn) {
		super();
		this.isbn = isbn;
	}
	
	public BookEnquiryRequest() {
//		Default Constructor
	}

//	Getters and Setters
	
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

//	toString:
	
	@Override
	public String toString() {
		return "BookEnquiry [isbn=" + isbn + "]";
	}

}
