package com.example.service;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.example.service.exception.GenericServiceException;

public interface GenericService<T, ID extends Serializable> {
	public default Iterable<T> findAll() {
		return getRepository().findAll();
	}
	
	public default T get(ID id) {
		return (T) getRepository().findById(id);
	}
	
	public default T save(T entity) {
		return getRepository().save(entity);
	}
	
	public default void delete(ID id) {
		if (getRepository().existsById(id)) {
			getRepository().deleteById(id);
		}
		else {
			throw new GenericServiceException("Rating>> 'id' doesn't exists: " + id);
		}
	}
	
	public default void update(T entity) {
		if (getRepository().existsById(getId(entity))) {
			getRepository().save(entity);
		}
		else {
			throw new GenericServiceException("Can't update Rating because it doesn't exist in DB: " + entity);
		}
	}
	
	public ID getId(T entity);
	
	public CrudRepository<T, ID> getRepository();
}
