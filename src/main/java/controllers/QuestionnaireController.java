package controllers;

import javax.ws.rs.Path;

import model.Question;
import model.Questionnaire;
import repositories.QuestionRepository;
import repositories.QuestionnaireRepository;
import services.QuestionService;
import services.QuestionnaireService;

@Path("question")
public class QuestionnaireController extends GenericEntityController<QuestionnaireService,QuestionnaireRepository,Questionnaire>{

}
