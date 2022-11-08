package com.cgesgin.managemensystem.core.services;

import java.util.List;

public interface IGenericService<T> {

	public T add(T entity);	
	public List<T> getAll();
	public T getById(int id);
	public T update(int id,T entity);
	public void delete(int id);
	
}
