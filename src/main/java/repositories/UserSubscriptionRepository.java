package repositories;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import model.UserSubscription;

@ApplicationScoped
public class UserSubscriptionRepository extends GenericEntityRepository<UserSubscription>{

	@Override
	protected Class<UserSubscription> getEntityClass() {
		return UserSubscription.class;
	}
	
	@Override
	protected String getAllEntityQueryName() {
		return UserSubscription.GET_ALL_USERSUBSCRIPTIONS;
	}
	
	@Override
	protected String getAllEntityIdsQueryName() {
		return UserSubscription.GET_ALL_USERSUBSCRIPTIONS_IDS;
	}

	@Override
	protected String getCountQueryName() {
		return UserSubscription.GET_USERSUBSCRIPTIONS_COUNT;
	}

	public UserSubscription getSessionInstructor(long sessionId) {

		return entityManager.createNamedQuery(UserSubscription.GET_SESSION_INSTRUCTOR, UserSubscription.class)
				.setParameter("sessionId", sessionId)
				.getSingleResult();
	}

	public Long getUserSubscriptionsCountBySessionId(long sessionId) {

		return entityManager.createNamedQuery(UserSubscription.GET_USERSCRIPTIONS_COUNT_BY_SESSION_ID, Long.class)
				.setParameter("sessionId", sessionId)
				.getSingleResult();
	}

	public boolean getIfUserSubscribed(long sessionId, long userId) {
		boolean subscribed = false;
		Long result = entityManager.createNamedQuery(UserSubscription.GET_IF_USER_SUBSCRIBED, Long.class)
				.setParameter("sessionId", sessionId)
				.setParameter("userId", userId)
				.getSingleResult();
		if (result != 0) {
			subscribed = true;
		};
		
		return subscribed ;
	}

	
	public UserSubscription getSubscription(long userId, long sessionId) {

		return entityManager.createNamedQuery(UserSubscription.GET_SUBSCRIPTION, UserSubscription.class)
				.setParameter("userId", userId)
				.setParameter("sessionId", sessionId)
				.getSingleResult();
	}

	public Collection<UserSubscription> getSubscriptionBySessionId(long sessionId) {
		return entityManager.createNamedQuery(UserSubscription.GET_SUBSCRIPTION_BY_SESSION_ID, UserSubscription.class)
				.setParameter("sessionId", sessionId)
				.getResultList();
	}

}
