package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo (CategoryRepository crepository, UserRepository urepository, BookRepository brepository){
		
		return(args) -> {
			
			Category c1 = new Category("Fantasy");
			Category c2 = new Category("Thriller") ;
			Category c3 = new Category("Scifi") ;
			Category c4 = new Category("Biography") ;
			crepository.save(c1) ;
			crepository.save(c2) ;
			crepository.save(c3) ;
			crepository.save(c4) ;
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			Book b1 = new Book("Jussi tarina","jussi", "1997", "951-98548-9-4", "9.50", crepository.findByName("Fantasy").get(0) ) ;
			Book b2 = new Book("Rene tarina","Rene", "2001", "951-98728-10-4", "12.50",crepository.findByName("Thriller").get(0) ) ;
			Book b3 = new Book("Lotr","Tolkien", "1967", "951-98548-9-4", "19.99", crepository.findByName("Scifi").get(0) ) ;
			
			
			brepository.save(b1) ;
			brepository.save(b2) ;
			brepository.save(b3) ;
	};
		
	}

}
