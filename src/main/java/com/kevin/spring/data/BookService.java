package com.kevin.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	public Book save(Book book) {
		return this.repository.save(book);
	}
	

}
