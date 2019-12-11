package controllers;

import javax.ws.rs.Path;

import model.TrainingSession;
import repositories.TrainingSessionRepository;
import services.TrainingSessionService;

@Path("trainingsession")
public class TrainingSessionController extends GenericEntityController<TrainingSessionService,TrainingSessionRepository,TrainingSession>{

}
