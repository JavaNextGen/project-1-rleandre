package com.revature.models;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 * </ul>
 *
 */
public class User extends AbstractUser {

	private int ers_users_id;
	private String	ers_username;
	private String 	ers_password;
	private String	ers_f_name;
	private String	ers_l_name;
	private String	user_email;
	private int	user_role_id;
	
    public User() {
        super();
    }

    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractUser} class.
     * If other fields are needed, please create additional constructors.
     */
    public User(int ers_users_id, String ers_username, String ers_password, 
	String	ers_f_name, String ers_l_name,  String	user_email,  int user_role_id) {
    	this.ers_users_id = ers_users_id;
    	this.ers_username  = ers_username;
    	this.ers_password = ers_password;
    	this.ers_f_name = ers_f_name;
    	this.ers_l_name = ers_l_name;
    	this.user_email = user_email;
    	this.user_role_id = user_role_id;
    }

    public User(String ers_username, String ers_password, 
    		String	ers_f_name, String ers_l_name,  String	user_email,  int user_role_id) {
    	    	this.ers_username  = ers_username;
    	    	this.ers_password = ers_password;
    	    	this.ers_f_name = ers_f_name;
    	    	this.ers_l_name = ers_l_name;
    	    	this.user_email = user_email;
    	    	this.user_role_id = user_role_id;
    	    }
    
	public int getErs_users_id() {
		return ers_users_id;
	}

	public void setErs_users_id(int ers_users_id) {
		this.ers_users_id = ers_users_id;
	}

	public String getErs_username() {
		return ers_username;
	}

	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}

	public String getErs_password() {
		return ers_password;
	}

	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}

	public String getErs_f_name() {
		return ers_f_name;
	}

	public void setErs_f_name(String ers_f_name) {
		this.ers_f_name = ers_f_name;
	}

	public String getErs_l_name() {
		return ers_l_name;
	}

	public void setErs_l_name(String ers_l_name) {
		this.ers_l_name = ers_l_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
}
