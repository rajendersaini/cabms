package org.opencab.service;

import java.util.List;

import org.opencab.exception.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericServiceImpl<T>
		implements GenericService<T> {


	@Override
	public T create(T entity) {
		return getRepos().save(entity);
	}

	// TODO add proper exception
	@Override
	public T delete(Long id) throws EntityNotFoundException {
		T t = getRepos().findOne(id);
		if (t == null)
			throw new EntityNotFoundException(t);

		getRepos().delete(t);
		return t;
	}

	@Override
	public List<T> findAll() {
		return getRepos().findAll();
	}

	@Override
	public T update(T entity, Long id) throws EntityNotFoundException {
		T t = getRepos().findOne(id);
		if (t == null)
			throw new EntityNotFoundException(t);
		return getRepos().save(entity);
	}

	@Override
	public T findById(Long id) {
		return getRepos().findOne(id);
	}

	protected abstract JpaRepository<T, Long> getRepos();
}
