package controllers;

import javax.ws.rs.Path;

import model.UserSubscription;
import repositories.UserSubscriptionRepository;
import services.UserSubscriptionService;

@Path("subscription")
public class UserSubscriptionController extends GenericEntityController<UserSubscriptionService,UserSubscriptionRepository,UserSubscription>{

}
