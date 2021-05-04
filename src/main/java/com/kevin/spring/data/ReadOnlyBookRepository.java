package com.kevin.spring.data;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadOnlyBookRepository extends ReadOnlyRepository<Book, Long> {

}
