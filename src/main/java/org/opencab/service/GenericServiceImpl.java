package org.opencab.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.opencab.db.repository.GenericRepository;
import org.opencab.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {

	private Class<T> type;

	@Resource
	private GenericRepository<T> repos;

	public GenericServiceImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T create(T entity) {
		return repos.save(entity);
	}

	// TODO add proper exception
	@Override
	public T delete(Long id) throws EntityNotFoundException {
		T t = repos.findOne(id);
		if (t == null)
			throw new EntityNotFoundException(t);

		repos.delete(t);
		return t;
	}

	@Override
	public List<T> findAll() {
		return repos.findAll();
	}

	@Override
	public T update(T entity, Long id) throws EntityNotFoundException {
		T t = repos.findOne(id);
		if (t == null)
			throw new EntityNotFoundException(t);
		return repos.save(entity);
	}

	@Override
	public T findById(Long id) {
		return repos.findOne(id);
	}

}
