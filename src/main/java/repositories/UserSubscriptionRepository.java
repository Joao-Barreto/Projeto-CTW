package repositories;

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

}
