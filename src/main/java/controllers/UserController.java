package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.User;
import repositories.UserRepository;
import services.UserService;

@Path("user")
public class UserController extends GenericEntityController<UserService,UserRepository,User>{

	
	@POST
	@Path("auth")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public User consultEntityByEmailAndPassword(User user) {
		return service.consultEntityByEmailAndPassword(user);
	}
	
}
