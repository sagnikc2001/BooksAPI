package com.dhdigital.book.api.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.apache.camel.component.jackson.JacksonDataFormat;

import com.dhdigital.book.api.model.backend.BookEnquiryRequest;
import com.dhdigital.book.api.model.backend.BookEnquiryResponse;
import com.dhdigital.book.api.model.frontend.*;

@Component
public class BooksRouteBuilder extends RouteBuilder{
	
	@Autowired
	private Environment env;

	@Override
	public void configure() throws Exception {
		
		restConfiguration()
		 .bindingMode(RestBindingMode.json);
		
		rest("api")
		
//		To get books by ISBN using POST method - http://localhost:8082/api/Book
		.post("/Book")
		 .type(BookEnquiryRequest.class)
		 .outType(BookResponse.class)
		 .consumes("application/json")
		 .to("direct:invoke");
		
		
		from("direct:invoke")
//		 .log("log1 : ${body}")
		 .to("bean:bookService?method=setBookRequest")
//		 .log("log2 : ${body}")
		 .marshal().json(JsonLibrary.Jackson, BookEnquiryResponse.class) //Marshsalling to json
//		 .log("log3 : ${body}")
		 .to(env.getProperty("BACK_URL"))  //Bridgepoint to connect to this URL succesfully -- http://localhost:8080/api/books/get?bridgeEndpoint=true
//		 .log("log4 : ${body}")
		 .unmarshal(new JacksonDataFormat(BookRequest.class)) //Unmarshalling to Backend object
//		 .log("log5 : ${body}")
		 .to("bean:bookService?method=getBooksResponse");
//		 .log("log6 : ${body}")
	}
		
	}

