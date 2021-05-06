package com.kevin.spring.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@NamedQueries({@NamedQuery(name ="Book.QueryOne", query =  "select b from Book b"),
@NamedQuery(name ="Book.QueryOneOther", query = " from Book "),
@NamedQuery(name ="Book.QueryTwo", query = "select b from Book b where b.pages > ?1"),
@NamedQuery(name ="Book.QueryThree", query = "select b from Book b where b.title = :title")})

@EntityListeners(AuditingEntityListener.class)
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	private String title;
	private Date publishDate;
	private int pages;
	private BigDecimal price;
	
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String lastModifiedBy;
	@CreatedDate
	private Date createdDate;
	@LastModifiedDate
	private Date lastModifiedDate;
	
	

}
