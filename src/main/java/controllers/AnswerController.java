package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEntity(@PathParam("id") long id, Answer entity) {
		System.out.println(id+" "+entity);
		try {
			System.out.println("ENTREI NO TRY "+id+" "+entity);
			Answer edited = service.updateEntity(id,entity);
			return Response.status(Response.Status.ACCEPTED).entity(edited).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
}
