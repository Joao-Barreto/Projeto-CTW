package controllers;

import javax.ws.rs.Path;

import model.Answer;
import repositories.AnswerRepository;
import services.AnswerService;

@Path("answer")
public class AnswerController extends GenericEntityController<AnswerService,AnswerRepository,Answer>{

}
