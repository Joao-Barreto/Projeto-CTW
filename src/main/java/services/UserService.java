package services;

import javax.enterprise.context.RequestScoped;

import model.User;
import repositories.UserRepository;

@RequestScoped
public class UserService extends GenericEntityService<UserRepository, User>{

	@Override
	public User updateEntity(long id, User Entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
