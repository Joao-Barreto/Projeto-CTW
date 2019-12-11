package repositories;


import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.GenericEntity;


public abstract class GenericEntityRepository<T extends GenericEntity> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	

	public T createEntity(T entity) {

		return entityManager.merge(entity);
	}

	public Collection<T> consultEntity() {
		return  entityManager.createNamedQuery(getAllEntityQueryName(), getEntityClass()).getResultList();
	}
	
	public T consultEntity(Long entityId) {
		return entityManager.find(getEntityClass(), entityId);
	}
	
	public Collection<Long> getAllIds(){
		return entityManager.createNamedQuery(getAllEntityIdsQueryName(), Long.class).getResultList();
	}

	protected abstract String getAllEntityIdsQueryName();

	protected abstract Class<T> getEntityClass();
	
	protected abstract String getAllEntityQueryName();
	
	protected abstract String getCountQueryName();

	public T editEntity(T editedEntity) {

		return entityManager.merge(editedEntity);
	}

	public void removeEntity(Long entityId) {
		T entity = entityManager.find(getEntityClass(), entityId);
		entityManager.remove(entity);
	}

	public Long countEntity() {

		return entityManager.createNamedQuery(getCountQueryName(), Long.class).getSingleResult();
	}

	
}