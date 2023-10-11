package com.dhdigital.book.api;

import org.apache.camel.CamelContext;
import org.apache.camel.component.http.HttpComponent;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApiApplication.class, args);
	}
	
	// Configuring Camel context
    @Bean
    public CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                // Adding the HTTP component to the Camel context
                context.addComponent("http", new HttpComponent());
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
                // Performing additional configuration if needed after Camel context starts
            }
        };
    }

}
