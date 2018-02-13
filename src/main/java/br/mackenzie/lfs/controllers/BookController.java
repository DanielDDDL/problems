package br.mackenzie.lfs.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.mackenzie.lfs.model.Book;
import br.mackenzie.lfs.model.dto.BookDTO;
import br.mackenzie.lfs.service.BookService;
import br.mackenzie.lfs.util.PersistedEntitiesObjectMapper;

@Controller
public class BookController {
	
	private BookService service;
	private PersistedEntitiesObjectMapper em;
	
	@Autowired
	public BookController(BookService service, PersistedEntitiesObjectMapper em) {
		this.service = service;
		this.em = em;
	}
	
	@RequestMapping(value = "/book/new", method = RequestMethod.GET)
	public ModelAndView initBookCreation () {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", new BookDTO());
		mav.setViewName("book_add");
		return mav;
		
	}
	
	@RequestMapping(value = "/book/new", method = RequestMethod.POST)
	public String proccessBookCreation (@ModelAttribute("book") @Valid BookDTO bookDTO, BindingResult results, ModelMap model) {
				
		if(results.hasErrors()) 
			return "book_add";
		
		service.addBook(em.convertDTOToEntity(bookDTO, Book.class));
		
		model.addAttribute("message", "Book successfully registered");
		return "thymeleaf/simplemessage";
	}
	
	@RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
	public ModelAndView initEditing (@PathVariable("id") Long id) {
		
		Book book = service.getBook(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", em.convertEntityToDTO(book, BookDTO.class));
		mav.setViewName("book_edit");
		return mav;
	}

	@RequestMapping(value = "/book/edit", method = RequestMethod.POST)
	public ModelAndView initEditing (@ModelAttribute @Valid BookDTO bookDTO, BindingResult results) {
				
		ModelAndView mav = new ModelAndView();
		
		if(results.hasErrors()) {
			mav.addObject("book", bookDTO);
			mav.setViewName("book_edit");
			return mav;
		}
		
		service.editBook(em.convertDTOToEntity(bookDTO, Book.class));
		
		mav.setViewName("thymeleaf/simplemessage");
		mav.addObject("message", "Book successfully edited");
		return mav;
	}
	
}
