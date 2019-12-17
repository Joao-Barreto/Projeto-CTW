package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.UserSubscription;
import repositories.UserSubscriptionRepository;
import services.UserSubscriptionService;

@Path("subscription")
public class UserSubscriptionController extends GenericEntityController<UserSubscriptionService,UserSubscriptionRepository,UserSubscription>{

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserSubscription createEntity(UserSubscription entity) {
		return service.createUserSubscription(entity);
	}
	
	@GET
	@Path("session/{sessionId}/trainer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSessionTrainer(@PathParam("sessionId") long sessionId) {
	try {
		UserSubscription trainer = service.getSessionTrainer(sessionId);
		System.out.println(trainer.getUser());
		return Response.ok().entity(trainer.getUser()).build();	
	} catch (Exception e) {
		e.printStackTrace();
	}
		return Response.status(Response.Status.UNAUTHORIZED).entity("No trainer").build();	
	}
	
	@GET
	@Path("session/{sessionId}/user/count")
	public Response getUserSubscriptionsCountBySessionId(@PathParam("sessionId") long sessionId) {
		try {
			Long count = service.getUserSubscriptionsCountBySessionId(sessionId);
			System.out.println(count);
			return Response.ok().entity(count).build();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.UNAUTHORIZED).entity("No attendees").build();	
	}
}
	
