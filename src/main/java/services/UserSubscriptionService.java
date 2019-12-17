package services;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import model.UserSubscription;
import repositories.UserSubscriptionRepository;

@RequestScoped
public class UserSubscriptionService extends GenericEntityService<UserSubscriptionRepository, UserSubscription>{

	@Override
	public UserSubscription updateEntity(long id, UserSubscription Entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public UserSubscription createUserSubscription(UserSubscription entity) {
		return repository.createEntity(entity);
	}

	@Transactional
	public UserSubscription getSessionTrainer(long sessionId) {

		return repository.getSessionTrainer(sessionId);
	}

	@Transactional
	public Long getUserSubscriptionsCountBySessionId(long sessionId) {
		return repository.getUserSubscriptionsCountBySessionId(sessionId);
	}

}
