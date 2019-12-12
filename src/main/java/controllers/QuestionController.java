package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Question;
import repositories.QuestionRepository;
import services.QuestionService;

@Path("question")
public class QuestionController extends GenericEntityController<QuestionService,QuestionRepository,Question>{

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Question createQuestion(Question entity) {
		return service.createQuestion(entity);
	}
	
}
