package org.opencab.service;

import java.util.List;

import org.opencab.exception.EntityNotFoundException;

public interface GenericService<T> {
	public T create(T entity);

	public T delete(Long id) throws EntityNotFoundException;

	public List<T> findAll();

	public T update(T Entity, Long id) throws EntityNotFoundException;

	public T findById(Long id);
}
