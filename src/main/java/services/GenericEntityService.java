package services;

import java.util.Collection;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.GenericEntity;
import repositories.GenericEntityRepository;

public abstract class GenericEntityService<T extends GenericEntityRepository<E>, E extends GenericEntity> {

	@Inject
	protected T repository;
	
	@Transactional
	public Collection<E> listAllEntities() {

		return repository.consultEntity();
	}

	@Transactional
	public E consultEntityById(long id) {
		return repository.consultEntity(id);
	}

	@Transactional
	public void deleteEntity(long id) {
		repository.removeEntity(id);
	}

//	public abstract E updateEntity(long id, E Entity) throws Exception;

	@Transactional
	public Long countEntity() {

		return repository.countEntity();
	}
}
