package services;


import java.util.Collection;

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
	
	
	@Transactional
	public UserSubscription updateEntity(long id, UserSubscription entity) throws Exception {
		System.out.println("ENTREI NO SERVICE "+id+" "+entity);
		entity.setId(id);
		return repository.editEntity(entity);
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

	@Transactional
	public boolean getIfUserSubscribed(long sessionId, long userId) {

		return repository.getIfUserSubscribed(sessionId, userId);
	}

	@Transactional
	public UserSubscription getSubscription(long userId, long sessionId) {

		return repository.getSubscription(userId, sessionId);
	}

	@Transactional
	public Collection<UserSubscription> getSubscriptionBySessionId(long sessionId) {

		return repository.getSubscriptionBySessionId( sessionId);
	}


}
