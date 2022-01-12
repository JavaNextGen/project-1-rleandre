package com.revature.models;

public class LoginDTO {
	//our login DTO data transfer object models only the username
	//and password for the users
	//so you will need a private string for username and password
	//then i just want two constructors so we can instantiante
	//dont forget getters and setters
	//then we will create two constructors one with no paramters just super keyword
	//and one with the username and password paramter
	
	
	private String username;
	private String password;
	
	public LoginDTO() {
		super();
		}
	
	public LoginDTO(String username, String password) {
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", password=" + password + "]";
	}

}
