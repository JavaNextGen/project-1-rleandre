package com.revature.repositories;
import com.revature.models.User;

public class AuthDAO {
	
	
	
	public User getUserByUnAndPw(String ers_username, String ers_password) {
		
		
		String sql = "SELECT * FROM ers_users WHERE ers_username=? AND ers_password=?";
		
		return null;
	}
}
