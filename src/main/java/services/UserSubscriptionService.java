package services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import model.UserSubscription;
import repositories.UserSubscriptionRepository;

@RequestScoped
public class UserSubscriptionService extends GenericEntityService<UserSubscriptionRepository, UserSubscription>{

	@Inject
	UserService userService;
	
	@Inject
	TrainingSessionService trainingSessionService;
	
	
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
	public UserSubscription getSessionInstructor(long sessionId) {

		return repository.getSessionInstructor(sessionId);
	}

	@Transactional
	public Long getUserSubscriptionsCountBySessionId(long sessionId) {
		return repository.getUserSubscriptionsCountBySessionId(sessionId);
	}
	
	public void setSessionInstructor(long instructor, long session) {
		UserSubscription userSubscription = new UserSubscription();
		userSubscription.setUser(userService.consultEntityById(instructor));
		userSubscription.setTrainingSession(trainingSessionService.consultEntityById(session));
		userSubscription.setSubType("instructor");
		repository.createEntity(userSubscription);
	}


}
