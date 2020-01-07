package repositories;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import model.User;

@ApplicationScoped
public class UserRepository extends GenericEntityRepository<User>{

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}
	
	@Override
	protected String getAllEntityQueryName() {
		return User.GET_ALL_USERS;
	}
	
	@Override
	protected String getAllEntityIdsQueryName() {
		// TODO Auto-generated method stub
		return User.GET_ALL_USERS_IDS;
	}

	@Override
	protected String getCountQueryName() {
		// TODO Auto-generated method stub
		return User.GET_USERS_COUNT;
	}

	public User findUserByEmail(String email) {
		return entityManager.createNamedQuery(User.GET_USER_BY_EMAIL, User.class)
				.setParameter("email", email)
				.getSingleResult();
	}

	public Collection<User> getUserSubscribedBySessionId(long sessionId) {

		return entityManager.createNamedQuery(User.GET_USER_SUBSCRIBED_BY_SESSION_ID, User.class)
				.setParameter("sessionId", sessionId)
				.getResultList();
	}

	public void updateImage(long id, String fileName) {
		entityManager.createNamedQuery(User.SET_IMGURL_BY_USER_ID, User.class) 
		.setParameter("userId", id)
		.setParameter("imgUrl", fileName)
		.executeUpdate();
		
	}
	
	public User editEntity(User editedEntity) {
		System.out.println("ENTREI NO REPOSITORY"+editedEntity.toString());
		return entityManager.merge(editedEntity);
	}

	public String getImgUrl(long id) {
		
		return entityManager.createNamedQuery(User.GET_IMG_URL_BY_USER_ID, String.class)
				.setParameter("userId",id)
				.getSingleResult();
	}

	public long getUserProgress(long userId) {
		return entityManager.createNamedQuery(User.GET_USER_PROGRESS, long.class)
				.setParameter("userId",userId)
				.getSingleResult();
	}

}
