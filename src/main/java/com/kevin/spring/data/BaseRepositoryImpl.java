package com.kevin.spring.data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;


public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T,ID> 
implements BaseRepository<T, ID>{

	private JpaEntityInformation<T, ?> entityInformation;
	private EntityManager entityManager ;
	
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
	}


	@SuppressWarnings("unchecked")
	@Override
	public T chaterBal(ID id) {
		Query query = this.entityManager.createQuery(" select b from " + this.entityInformation.getEntityName() 
														+ "  b where b." +this.entityInformation.getIdAttribute().getName()+" = :id");
		query.setParameter("id", id);
		//return (List<T>)query.getResultList();
		return (T) query.getSingleResult();
	}


}
