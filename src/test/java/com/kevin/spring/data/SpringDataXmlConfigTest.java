package com.kevin.spring.data;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat; 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-application-context.xml")
public class SpringDataXmlConfigTest {

	@Autowired
	BookService service;

	@Autowired
	BookRepository repository;

	@Autowired
	ReadOnlyBookRepository readOnlyBookRepository;

	@Before
	public void setup() {
		List<Book> bookList = new ArrayList<Book>();
		for (int i = 1; i <= 12; i++) {
			// service.save(new Book(null,"Book-"+i,new Date(),45+i,new
			// BigDecimal(75.55+i)));
			// bookList.add(new Book(null,"Book-"+i,new Date(),45+i,new
			// BigDecimal(75.55+i)));
			switch (i) {
			case 1: {
				bookList.add(new Book(null, "Animal Farm", new Date(), 45 + i, new BigDecimal(75.55 + i)));
				break;
			}
			case 2: {
				bookList.add(new Book(null, "Play It as It Lays", new Date(), 45 + i, new BigDecimal(75.55 + i)));
				break;
			}
			case 3: {
				bookList.add(new Book(null, "The Particular Sadness of Lemon Cake", new Date(), 45 + i,
						new BigDecimal(75.55 + i)));
				break;
			}
			case 4: {
				bookList.add(new Book(null, "As I Lay Dying", new Date(), 45 + i, new BigDecimal(75.55 + i)));
				break;
			}
			case 5: {
				bookList.add(new Book(null, "Skippy Dies", new Date(), 45 + i, new BigDecimal(75.55 + i)));
				break;
			}
			case 6: {
				bookList.add(new Book(null, "The God of Small Things", new Date(), 45 + i, new BigDecimal(75.55 + i)));
				break;
			}
			case 7: {
				bookList.add(new Book(null, "The Unbearable Lightness of Being", new Date(), 45 + i,
						new BigDecimal(75.55 + i)));
				break;
			}
			case 8: {
				bookList.add(new Book(null, "Her Body & Other Parties", new Date(), 45 + i, new BigDecimal(75.55 + i)));
				break;
			}
			case 9: {
				bookList.add(new Book(null, "Brief Interviews with Hideous Men", new Date(), 45 + i,
						new BigDecimal(75.55 + i)));
				break;
			}
			case 10: {
				bookList.add(new Book(null, "I Have No Mouth & I Must Scream", new Date(), 45 + i,
						new BigDecimal(75.55 + i)));
				break;
			}
			case 11: {
				bookList.add(new Book(null, "No One Belongs Here More Than You", new Date(), 45 + i,
						new BigDecimal(75.55 + i)));
				break;
			}
			case 12: {
				bookList.add(new Book(null, "Difficult Women", new Date(), 45 + i, new BigDecimal(75.55 + i)));
				break;
			}

			}
		}
		repository.saveAll(bookList);
	}

	@Test
	public void testDerivedQuery() throws ParseException {
		
		
		Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse("05/03/2021");
		Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse("05/05/2021");
		List<Book> books = repository.findByPublishDateBetween(date1,  date2);
		 System.out.println(books); assertThat(books.size(),equalTo(12) );
		 
		/*
		 * List<Book> books = repository.findByPublishDateAfter(new Date());
		 * System.out.println(books); assertThat(books.size(),equalTo(0) );
		 */
		
		/*
		 * List<Book> books = repository.findByPublishDateBefore(new Date());
		 * System.out.println(books); assertThat(books.size(),equalTo(12) );
		 */
		
		/*
		 * List<Book> books = repository.findByTitleNot("Difficult Women");
		 * System.out.println(books); assertThat(books.size(),equalTo(11) );
		 */
		 
			/*
			 * List<Book> books =
			 * repository.findByTitleContainingAndPagesGreaterThan("Women", 45);
			 * System.out.println(books); assertThat(books.size(),equalTo(1) );
			 */
		
		/*
		 * List<Book> books = repository.findByTitleContainingOrTitleContaining("Women",
		 * "The"); System.out.println(books); assertThat(books.size(),equalTo(4) );
		 */
		
			/*
			 * List<Book> books = repository.findByPagesBetween(45, 56);
			 * System.out.println(books); assertThat(books.size(),equalTo(11) );
			 */
		
		/*
		 * List<Book> books = repository.findByPagesLessThanEqual(56);
		 * System.out.println(books); assertThat(books.size(),equalTo(11) );
		 */
		
		/*
		 * List<Book> books = repository.findByPagesGreaterThanEqual(56);
		 * System.out.println(books); assertThat(books.size(),equalTo(2) );
		 */
		
		
		
		
		 
		/*
		 * List<Book> books = repository.findByPagesLessThan(56);
		 * System.out.println(books); assertThat(books.size(),equalTo(10) );
		 */
		
			/*
			 * List<Book> books = repository.findByPagesGreaterThan(46);
			 * System.out.println(books); assertThat(books.size(),equalTo(11) );
			 */
		
		/*
		 * List<Book> books = repository.findByPagesEquals(46);
		 * System.out.println(books); assertThat(books.size(),equalTo(1) );
		 */
		
		/*
		 * List<Book> books = repository.findByPagesEquals(46);
		 * System.out.println(books); assertThat(books.size(),equalTo(1) );
		 */

		/*
		  Book book = repository.findByTitle(" Women"); System.out.println(book);
		  assertNotNull(book);
		 */
		
		/*
		  List<Book> books = repository.findByTitleLike("%The%");
		  System.out.println(books); 
		  assertThat(books.size(),equalTo(3) );
		 */
		 

		/*
		 * List<Book> books = repository.findByTitleContaining("The");
		 * System.out.println(books); assertThat(books.size(),equalTo(3) );
		 */
		
		/*
		 * List<Book> books = repository.findByTitleEndingWith("s");
		 * System.out.println(books); assertThat(books.size(),equalTo(4) );
		 */
		
		/*
		 * List<Book> books = repository.findByTitleStartingWith("T");
		 * System.out.println(books); assertThat(books.size(),equalTo(3) );
		 */
		
		  
		/*
		 * List<Book> books = repository.findByTitleIgnoreCase("DIFFICULT WOMEN");
		 * System.out.println(books); assertThat(books.size(),equalTo(1) );
		 */
		  
		
	
		
		/*
		 * for (Book book : repository.findTopByOrderByPagesDesc()) {
		 * System.out.println(book); }
		 */

		
		

	}

	@Test
	public void testReadOnlyRepo() {
		System.out.println(readOnlyBookRepository.findById(1L));
		for (Book book2 : readOnlyBookRepository.findAll()) {
			System.out.println(book2);
		}

		// testing optional type

		Integer value1 = null;
		Integer value2 = new Integer(10);

		// Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);

		// Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);
		System.out.println(sum(a, b));
	}

	private Integer sum(Optional<Integer> a, Optional<Integer> b) {
		// Optional.isPresent - checks the value is present or not

		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());

		// Optional.orElse - returns the value if present otherwise returns
		// the default value passed.
		Integer value1 = a.orElse(new Integer(0));

		// Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		return value1 + value2;
	}

	@Test
	public void testFindOneAll() {
		Optional<Book> book = repository.findById(1L);
		assertEquals("Book-1", book.get().getTitle());
		book.get().setTitle("War and peace");
		repository.save(book.get());
		repository.delete(book.get());
		List<Book> books = repository.findAll();
		assertEquals(10, books.size());
		for (Book book2 : books) {
			System.out.println(book2);
		}

		// List<Book> books1 = repository.findAll(new ArrayList<Long>()
		// {{add(1L);add(3L);add(4L);}});
	}

	@Test
	public void testBokkPersistenceXml() {
		Book book = service.save(new Book(null, "Logan", new Date(), 0, new BigDecimal(85.5)));
		assertNotNull(book.getBookId());
		System.out.println(book);
	}

}
