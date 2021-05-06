package com.kevin.spring.data;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Transactional
	@Modifying
	@Query("update Book b set b.pages= ?2 where b.title like ?1")
	int setPageCount(String title, int pageCount);
	
	Book findByTitle(String title);
	
	List<Book> findByTitleLike(String title);
	
	List<Book> findByTitleContaining(String title);
	
	List<Book> findByTitleStartingWith(String title);
	
	Page<Book> findByTitleStartingWith(String title, Pageable pageable);
	
	List<Book> findByTitleEndingWith(String title);
	
	//List<Book> findByTitleIgnoreCase(String title);
	
	List<Book> findByPagesEquals(int pageCount);
	
	Page<Book> findByPagesGreaterThan(int pageCount, Pageable  pageable);
	
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
	
	
	List<Book> QueryOne();
	
	
	List<Book> QueryOneOther();
	
	
	List<Book> QueryTwo(int pages);
	
	
	List<Book> QueryThree(@Param("title") String title);

}
