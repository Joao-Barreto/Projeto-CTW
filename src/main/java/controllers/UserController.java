package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.User;
import model.dto.UserDTO;
import repositories.UserRepository;
import services.UserService;

@Path("user")
public class UserController extends GenericEntityController<UserService,UserRepository,User>{

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEntity(UserDTO user) {
		try{
			service.createEntity(user);
			return Response.ok().entity("Success").build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.UNAUTHORIZED).entity("Create Failed").build();	
	}
	
	@POST
	@Path("auth")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response login(UserDTO user) {
		try {
			User userLoged = service.checkIfUserValid(user, user.getPassword());
			
			return Response.ok().entity(userLoged).build();	
		} catch (Exception e) {
			e.printStackTrace();
		}
			return Response.status(Response.Status.UNAUTHORIZED).entity("Login failed").build();	
		}
	
}
