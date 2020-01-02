package controllers;

import java.io.File;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

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
	
	@GET
	@Path("session/{sessionId}/")
	public Response getUserSubscriptionsBySessionId(@PathParam("sessionId") long sessionId) {
		try {
			Collection<User> userSubs = service.getUserSubscribedBySessionId(sessionId);
			System.out.println(userSubs);
			return Response.ok().entity(userSubs).build();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.UNAUTHORIZED).entity("No attendees").build();	
	}
	
	@POST
	@Path("{id}/image-upload")
	@Consumes("multipart/form-data")
	public Response uploadFile2(@PathParam("id") long id,MultipartFormDataInput input) {
		String response = service.saveImage(input);
		return Response.ok(response).build();
	}
	
	@GET
	@Path("image")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getFile() {
	  File file = new File("/Users/alunomanha/Documents/Screen Shot 2019-11-14 at 09.03.51.png");// mudar caminho(ir buscar à BD)
	  return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
	      .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) 
	      .build();
	}
	
}
