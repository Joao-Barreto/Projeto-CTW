package controllers;

import javax.ws.rs.Path;

import model.User;
import repositories.UserRepository;
import services.UserService;

@Path("user")
public class UserController extends GenericEntityController<UserService,UserRepository,User>{

}
