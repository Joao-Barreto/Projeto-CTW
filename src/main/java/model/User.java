package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=User.GET_ALL_USERS, query="SELECT u FROM User u")
@NamedQuery(name=User.GET_ALL_USERS_IDS, query="SELECT u.id FROM User u")
@NamedQuery(name=User.GET_USERS_COUNT, query="SELECT COUNT(u) FROM User u")
@NamedQuery(name = User.GET_USER_BY_EMAIL, query= "SELECT u FROM User u WHERE u.email = :email")
@NamedQuery(name = User.GET_USER_SUBSCRIBED_BY_SESSION_ID, query= "SELECT us.user FROM UserSubscription us WHERE us.trainingSession.id = :sessionId")
@NamedQuery(name = User.SET_IMGURL_BY_USER_ID, query= "UPDATE User user SET user.imgUrl = :imgUrl WHERE user.id = :userId")
@NamedQuery(name = User.GET_IMG_URL_BY_USER_ID, query= "SELECT user.imgUrl FROM User user WHERE user.id = :userId")
@NamedQuery(name = User.GET_USER_PROGRESS, query= "SELECT SUM(us.trainingSession.duration) FROM UserSubscription us WHERE us.user.id = :userId AND us.attended = 'attended'")
public class User extends GenericEntity{

	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_USERS = "User.getAllUsers";
	public static final String GET_ALL_USERS_IDS = "User.getAllUsersIds";
	public static final String GET_USERS_COUNT = "User.getUsersCount";
	public static final String GET_USER_BY_EMAIL = "User.getUserByEmail";
	public static final String GET_USER_SUBSCRIBED_BY_SESSION_ID = "User.getUserSubscribedBySessionId";

	public static final String SET_IMGURL_BY_USER_ID = "User.setImgUrlByUserId";

	public static final String GET_IMG_URL_BY_USER_ID = "User.getImgUrlByUserId";

	public static final String GET_USER_PROGRESS = "User.getUserProgress";

	@Column(unique=true)
	private String email;
	
	private String name;
	private String role;
	private String hashcode;
	private String salt;
	private String imgUrl;
	
	public User() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getHashcode() {
		return hashcode;
	}

	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
