package model.dto;



public class UserDTO extends BaseDTO{

	private String name;
	
	private String email;
	private String role;
	
	private String password;
	
	private int progress;
	
	public UserDTO() {
		super();
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println(this.name);
	}
	public String getName() {
		return name;
	}
	public void setNome(String name) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
