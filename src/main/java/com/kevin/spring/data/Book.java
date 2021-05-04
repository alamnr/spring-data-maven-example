package com.kevin.spring.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({@NamedQuery(name ="Book.QueryOne", query =  "select b from Book b"),
@NamedQuery(name ="Book.QueryOneOther", query = " from Book "),
@NamedQuery(name ="Book.QueryTwo", query = "select b from Book b where b.pages > ?1"),
@NamedQuery(name ="Book.QueryThree", query = "select b from Book b where b.title = :title")})

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	private String title;
	private Date publishDate;
	private int pages;
	private BigDecimal price;
	

}
