package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (BookRepository repository){
		
		return(args) -> {
			Book b1 = new Book("Jussi tarina","jussi", "1997", "951-98548-9-4", "9.50" ) ;
			Book b2 = new Book("Rene tarina","Rene", "2001", "951-98728-10-4", "12.50" ) ;
			Book b3 = new Book("Lotr","Tolkien", "1967", "951-98548-9-4", "19.99" ) ;
			
			
			repository.save(b1) ;
			repository.save(b2) ;
			repository.save(b3) ;
	};
		
	}

}
