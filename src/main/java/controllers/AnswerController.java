package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Answer;
import repositories.AnswerRepository;
import services.AnswerService;

@Path("answer")
public class AnswerController extends GenericEntityController<AnswerService,AnswerRepository,Answer>{

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Answer createEntity(Answer entity) {
		return service.createAnswer(entity);
	}
	
}
