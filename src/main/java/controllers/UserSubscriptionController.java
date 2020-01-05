package controllers;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

	@GET
	@Path("session/{sessionId}/instructor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSessioninstructor(@PathParam("sessionId") long sessionId) {
	try {
		UserSubscription instructor = service.getSessionInstructor(sessionId);
		System.out.println(instructor.getUser());
		return Response.ok().entity(instructor.getUser()).build();	
	} catch (Exception e) {
		e.printStackTrace();
	}
		return Response.status(Response.Status.UNAUTHORIZED).entity("No instructor").build();	
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
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserSubscription createEntity(UserSubscription entity) {
		return service.createUserSubscription(entity);
	}
	
	@GET
	@Path("session/{sessionId}/user/{userId}")
	public Response getIfUserSubscribed(@PathParam("sessionId") long sessionId, @PathParam("userId") long userId) {
		try {
			boolean subscribed = service.getIfUserSubscribed(sessionId,userId);
			System.out.println(subscribed);
			return Response.ok().entity(subscribed).build();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.UNAUTHORIZED).entity("No attendees").build();	
	}
	
	@GET
	@Path("user/{userId}/session/{sessionId}")
	public Response getSubscription(@PathParam("userId") long userId, @PathParam("sessionId") long sessionId) {
		System.out.println("ËNTREI");
		try {
			UserSubscription uS = service.getSubscription(userId, sessionId);
			System.out.println(uS);
			return Response.ok().entity(uS).build();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.UNAUTHORIZED).entity("No attendees").build();	
	}
	
	@GET
	@Path("session/{sessionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSubscriptionBySessionId(@PathParam("sessionId") long sessionId) {
		try {
			Collection<UserSubscription> subscribed = service.getSubscriptionBySessionId(sessionId);
			System.out.println(subscribed);
			return Response.ok().entity(subscribed).build();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.UNAUTHORIZED).entity("No attendees").build();	
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEntity(@PathParam("id") long id, UserSubscription entity) {
		System.out.println(id+" "+entity);
		try {
			System.out.println("ENTREI NO TRY "+id+" "+entity);
			UserSubscription edited = service.updateEntity(id,entity);
			return Response.status(Response.Status.ACCEPTED).entity(edited).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	
}
	
