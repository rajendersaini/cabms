package org.opencab.service;

import java.util.List;

import org.opencab.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericServiceImpl<T> implements GenericService<T> {

	private final static Logger logger = LoggerFactory
			.getLogger(GenericServiceImpl.class);

	@Override
	public T create(T entity) {
		if (entity == null)
			throw new IllegalArgumentException(
					"Null object passed for creation");
		logger.debug("Saving entity - " + entity.getClass());
		return getRepos().save(entity);
	}

	// TODO add proper exception
	@Override
	public T delete(Long id) throws EntityNotFoundException {
		logger.debug("finding entity with id " + id);
		T t = getRepos().findOne(id);
		if (t == null)
			throw new EntityNotFoundException();
		logger.debug("Found entity, now deleting entity with id " + id);
		getRepos().delete(t);
		logger.debug("Deleted entity successfully");
		return t;
	}

	@Override
	public List<T> findAll() {
		return getRepos().findAll();
	}

	@Override
	public T update(T entity, Long id) throws EntityNotFoundException {

		logger.debug("Updating entity with id " + id);
		T t = getRepos().findOne(id);
		if (t == null)
			throw new EntityNotFoundException(t);
		return getRepos().save(entity);
	}

	@Override
	public T findById(Long id) {
		logger.debug("Finding entity with id " + id);
		return getRepos().findOne(id);
	}

	protected abstract JpaRepository<T, Long> getRepos();
}
