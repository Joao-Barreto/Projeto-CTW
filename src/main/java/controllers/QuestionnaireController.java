package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Questionnaire;
import repositories.QuestionnaireRepository;
import services.QuestionnaireService;

@Path("questionnaire")
public class QuestionnaireController extends GenericEntityController<QuestionnaireService,QuestionnaireRepository,Questionnaire>{

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Questionnaire createEntity(Questionnaire entity) {
		return service.createQuestionnaire(entity);
	}
}
