package controllers;

import java.text.ParseException;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.TrainingSession;
import model.dto.TrainingSessionDTO;
import repositories.TrainingSessionRepository;
import services.TrainingSessionService;

@Path("trainingsession")
public class TrainingSessionController extends GenericEntityController<TrainingSessionService,TrainingSessionRepository,TrainingSession>{

	
	@GET
	@Path("today")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<TrainingSession> listAllTodayTrainingSessions(){
		return service.listAllTodayTrainingSessions();
	}
	
	@GET
	@Path("user/{userId}/")
	public Response getSessionsByUserId(@PathParam("userId") long userId) {
		try {
			Collection<TrainingSession> userSessions = service.getSessionsByUserId(userId);
			System.out.println(userSessions);
			return Response.ok().entity(userSessions).build();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.UNAUTHORIZED).entity("No attendees").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingSession createEntity(TrainingSessionDTO entity) throws ParseException {
		TrainingSession returnTS = service.createTrainingSession(entity);
		service.createInstructor(entity.getInstructor(),returnTS.getId());	
		return returnTS;
	}
	
	@POST
	@Path("interval")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Collection<TrainingSession> listAllIntervalTrainingSessions(String interval) throws ParseException{
		System.out.println("Interval: " + interval);
		return service.listAllIntervalTrainingSessions(interval);
	}
	
	
	@GET
	@Path("past/user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<TrainingSession> listAllPastTrainingSessionsSubscribed(@PathParam("userId") long userId) throws ParseException{

		return service.listAllPastTrainingSessionsSubscribed(userId);
	}
	
}

