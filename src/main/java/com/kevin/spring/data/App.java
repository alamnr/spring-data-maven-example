package com.kevin.spring.data;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	
  public static void main(String[] args) {
    System.out.println("Hello World!");
    
    try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class)){
    	BookService service = context.getBean(BookService.class);
        Book book = new Book(null,"chudna modna",new Date(),33,new BigDecimal("35.50"), null, null, null, null);
        System.out.println(service.save(book));
    }
    
    
  }
}
