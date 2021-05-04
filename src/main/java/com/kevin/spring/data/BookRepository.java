package com.kevin.spring.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findByTitle(String title);
	
	List<Book> findByTitleLike(String title);
	
	List<Book> findByTitleContaining(String title);
	
	List<Book> findByTitleStartingWith(String title);
	
	List<Book> findByTitleEndingWith(String title);
	
	//List<Book> findByTitleIgnoreCase(String title);
	
	List<Book> findByPagesEquals(int pageCount);
	
	List<Book> findByPagesGreaterThan(int pageCount);
	
	List<Book> findByPagesLessThan(int pageCount);
	
	List<Book> findByPagesGreaterThanEqual(int pageCount);
	
	List<Book> findByPagesLessThanEqual(int pageCount);
	
	List<Book> findByPagesBetween(int min, int max);
	
	List<Book> findByTitleContainingOrTitleContaining( String title, String title1);
	
	List<Book> findByTitleContainingAndPagesGreaterThan( String title, int pages);
	
	List<Book> findByTitleNot(String title);
	
	List<Book> findByPublishDateAfter(Date date);
	
	List<Book> findByPublishDateBefore(Date date);
	
	List<Book> findByPublishDateBetween(Date date1 , Date date2);
	
	//List<Book> findByTitleContainingOrderByTitleAsc(String title);
	//List<Book> findByTitleContainingOrderByTitleDesc(String title);
	
	//List<Book> findTop5ByOrderByPriceDesc();
	
	@Query("select b from Book b")
	List<Book> QueryOne();
	
	@Query(" from Book ")
	List<Book> QueryOneOther();
	
	@Query("select b from Book b where b.pages > ?1")
	List<Book> QueryTwo(int pages);
	
	@Query("select b from Book b where b.title = :title")
	List<Book> QueryThree(@Param("title") String title);

}
