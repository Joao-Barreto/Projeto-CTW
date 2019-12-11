package model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=User.GET_ALL_USERS, query="SELECT u FROM User u")
@NamedQuery(name=User.GET_ALL_USERS_IDS, query="SELECT u.id FROM User u")
@NamedQuery(name=User.GET_USERS_COUNT, query="SELECT COUNT(u) FROM User u")
public class User extends GenericEntity{

	private static final long serialVersionUID = 1L;
	

	public static final String GET_ALL_USERS = "Answer.getAllUsers";
	public static final String GET_ALL_USERS_IDS = "Answer.getAllUsersIds";
	public static final String GET_USERS_COUNT = "Answer.getUsersCount";
	
	private String nome;
	private String email;
	private String password;
	private String role;
	
	public User() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
