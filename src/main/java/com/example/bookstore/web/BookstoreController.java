package com.example.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {
	@Autowired
		private BookRepository repository ;
	
	@Autowired
		private CategoryRepository crepository;
	
	
		@RequestMapping(value="/login")
		public String login() {	
        return "login";
		}	
	
	
		@RequestMapping(value="/books", method = RequestMethod.GET)
		public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
			}    
	
	
		@RequestMapping("/booklist")
		public String booklist (Model model) {
		model.addAttribute("books", repository.findAll()) ;
		return "booklist" ;
				
	}
		@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {	
	    	return repository.findById(id);
	    }       
		
		@RequestMapping(value="/add")
		public String addBook(Model model){
			model.addAttribute("book", new Book());
			model.addAttribute("categories",crepository.findAll());
			return"addbook";
			
		}
		
		@RequestMapping(value="/save",method=RequestMethod.POST)
		public String save(Book book){
			repository.save(book);
			return"redirect:booklist";
			}
		
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value ="/delete/{id}",method =RequestMethod.GET)
		public String deleteBook (@PathVariable("id") Long id, Model model) {
			repository.deleteById(id);
			return"redirect:../booklist" ;
			}
		
		@RequestMapping (value = "/edit/{id}")
		public String addBook(@PathVariable("id")Long id, Model model){
			model.addAttribute("book", repository.findById(id));
			model.addAttribute("categories",crepository.findAll());
			return "editbook";
		}
	
}
