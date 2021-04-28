package com.kevin.spring.data;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfiguration.class)
public class SpringDataJavaConfigTest {
	
	@Autowired
	BookService service ;
	
	@Test
	public void testBookPersistent() {
		Book book = service.save(new Book(null,"khurram",new Date(),90,new BigDecimal("34.75")));
		assertNotNull(book.getBookId());
		System.out.println(book);
	}

}
