package repositories;

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

	public User consultEntityByEmailAndPassword(User user) {
		return entityManager.createNamedQuery(User.GET_USER_BY_EMAIL_AND_PASSWORD, User.class)
				.setParameter("email", user.getEmail())
				.setParameter("password", user.getPassword())
				.getSingleResult();
	}

}
