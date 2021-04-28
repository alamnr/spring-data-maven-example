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
@ContextConfiguration(locations = "/test-application-context.xml")
public class SpringDataXmlConfigTest {
	
	@Autowired
	BookService service;
	
	@Test
	public void testBokkPersistenceXml() {
		Book book = service.save(new Book(null, "Logan", new Date(), 0, new BigDecimal(85.5)));
		assertNotNull(book.getBookId());
		System.out.println(book);
	}

}
