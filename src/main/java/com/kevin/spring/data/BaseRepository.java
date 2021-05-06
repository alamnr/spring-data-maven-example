package com.kevin.spring.data;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
//public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
public interface BaseRepository<T, ID extends Serializable> {

	T chaterBal(ID id);
}
