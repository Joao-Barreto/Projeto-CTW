package controllers;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.GenericEntity;
import repositories.GenericEntityRepository;
import services.GenericEntityService;

public abstract class GenericEntityController<T extends GenericEntityService<R, E>, R extends GenericEntityRepository<E>, E extends GenericEntity> {
	

	@Inject
	protected T service;
	
	
	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "O controller está em cima";
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public Long countEntity() {
		return service.countEntity();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<E> listAllEntitys(){
		return service.listAllEntities();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public E consultEntityById(@PathParam("id") long id) {
		
		return service.consultEntityById(id);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteEntity(@PathParam("id") long id) {
		service.deleteEntity(id);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEntity(@PathParam("id") long id, E entity) {
		System.out.println(id+" "+entity);
		try {
			System.out.println("ENTREI NO TRY "+id+" "+entity);
			E edited = service.updateEntity(id,entity);
			return Response.status(Response.Status.ACCEPTED).entity(edited).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
}
