package controllers;

import javax.ws.rs.Path;

import model.Questionnaire;
import repositories.QuestionnaireRepository;
import services.QuestionnaireService;

@Path("questionnaire")
public class QuestionnaireController extends GenericEntityController<QuestionnaireService,QuestionnaireRepository,Questionnaire>{

}
