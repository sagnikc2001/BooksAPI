package com.dhdigital.book.api.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhdigital.book.api.model.backend.BookEnquiryRequest;
import com.dhdigital.book.api.model.backend.BookEnquiryResponse;
import com.dhdigital.book.api.model.frontend.BookRequest;
import com.dhdigital.book.api.model.frontend.BookResponse;



@Service("bookService")
public class BookService {
	
//	Generates BooksResponse for sending to Backend
	public void getBooksResponse(Exchange exchange) throws Exception{
		
		Message oMessage = exchange.getIn();
		
		BookRequest bookRequestFrontend = oMessage.getBody(BookRequest.class); // Getting object of BoolRequest Class
		
		BookResponse bookResponseFrontend = new BookResponse();  // Creating new object of BooksResponse
		
//		Mapping values of BookRequest to BookResponse
		
		bookResponseFrontend.setBookNumber(bookRequestFrontend.getId());
		bookResponseFrontend.setBook(bookRequestFrontend.getBookName());
		bookResponseFrontend.setBookGenre(bookRequestFrontend.getGenre());
		bookResponseFrontend.setAuthorName(bookRequestFrontend.getAuthor());
		bookResponseFrontend.setQuantity(bookRequestFrontend.getQty());
		
//		System.out.println(bookResponseFrontend.toString());
		
		oMessage.setBody("");
		
		oMessage.setBody(bookResponseFrontend); // Setting body of BookResponse to body
		
	}
	
	public BookEnquiryResponse setBookRequest(Exchange exchange) throws Exception{
		
		Message oMessage = exchange.getIn();
		
		BookEnquiryRequest oBookEnquiryRequest = oMessage.getBody(BookEnquiryRequest.class);
		
		BookEnquiryResponse oBookEnquiryResponse = new BookEnquiryResponse();
		
		oBookEnquiryResponse.setIsbn(oBookEnquiryRequest.getIsbn());
		
		return oBookEnquiryResponse;
	
	}

}
