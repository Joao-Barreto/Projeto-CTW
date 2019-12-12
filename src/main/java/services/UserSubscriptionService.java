package services;

import javax.enterprise.context.RequestScoped;

import model.UserSubscription;
import repositories.UserSubscriptionRepository;

@RequestScoped
public class UserSubscriptionService extends GenericEntityService<UserSubscriptionRepository, UserSubscription>{

	@Override
	public UserSubscription updateEntity(long id, UserSubscription Entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public UserSubscription createUserSubscription(UserSubscription entity) {
		// TODO Auto-generated method stub
		return repository.createEntity(entity);
	}

}
