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
		// TODO Auto-generated method stub
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

}
