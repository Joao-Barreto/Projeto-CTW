package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import model.User;
import model.dto.EmailDTO;
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
	
	@GET
	@Path("{userId}/progress/")
	public Response getUserProgress(@PathParam("userId") long userId) {
		try {
			long progress = service.getUserProgress(userId);
			return Response.ok().entity(progress).build();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.UNAUTHORIZED).entity("No attendees").build();	
	}
	
	@PUT
	@Path("{id}/image-upload")
	@Consumes("multipart/form-data")
	public Response uploadFile2(@PathParam("id") long id,MultipartFormDataInput input) {
		String response = service.saveImage(id,input);
		return Response.ok(response).build();
	}
	
	@GET
	@Path("{id}/image")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getFile(@PathParam("id") long id) {
		File file =	service.getUserImg(id);
		return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
	      .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) 
	      .build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEntity(@PathParam("id") long id, UserDTO entity) {
		System.out.println(id+" "+entity);
		try {
			System.out.println("ENTREI NO TRY "+id+" "+entity);
			UserDTO edited = service.updateEntity(id,entity);
			return Response.status(Response.Status.ACCEPTED).entity(edited).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	@POST
	@Path("sendGrid/{instructorEmail}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String sendGrid(@PathParam("instructorEmail") String instructorEmail, EmailDTO conteudo) throws IOException {
		System.out.println(conteudo);
		try {
			System.out.println(System.getProperty("SGKey"));
			service.sendMessage(conteudo,instructorEmail);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "Email is OK!";
	}
	
}
