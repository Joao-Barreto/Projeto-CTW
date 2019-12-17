package controllers;

import java.text.ParseException;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.TrainingSession;
import model.dto.TrainingSessionDTO;
import repositories.TrainingSessionRepository;
import services.TrainingSessionService;

@Path("trainingsession")
public class TrainingSessionController extends GenericEntityController<TrainingSessionService,TrainingSessionRepository,TrainingSession>{

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingSession createEntity(TrainingSessionDTO entity) throws ParseException {
		return service.createTrainingSession(entity);
	}
	
	@GET
	@Path("today")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<TrainingSession> listAllTodayTrainingSessions(){
		return service.listAllTodayTrainingSessions();
	}
	
	@POST
	@Path("interval")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Collection<TrainingSession> listAllIntervalTrainingSessions(String interval) throws ParseException{
		System.out.println("Interval: " + interval);
		return service.listAllIntervalTrainingSessions(interval);
	}
	
}
