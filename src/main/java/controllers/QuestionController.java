package controllers;

import javax.ws.rs.Path;

import model.Question;
import repositories.QuestionRepository;
import services.QuestionService;

@Path("question")
public class QuestionController extends GenericEntityController<QuestionService,QuestionRepository,Question>{

}
