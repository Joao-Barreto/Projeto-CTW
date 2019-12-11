package services;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import model.User;
import repositories.UserRepository;

@RequestScoped
public class UserService extends GenericEntityService<UserRepository, User>{

	@Override
	public User updateEntity(long id, User Entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public User consultEntityByEmailAndPassword(User user) {
		return repository.consultEntityByEmailAndPassword(user);
	}

}
