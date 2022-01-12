package com.revature.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;


import com.revature.models.User;
import com.revature.repositories.UserDAO;

/**MAIN PROJECT
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class UserService {

	/**
	 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */
	public Optional<User> getByUsername(String username) {
		return Optional.empty();
	}
	
	
UserDAO eDAO = new UserDAO(); //so that I can use the methods from the UserDAO
	
	public List<User> getUsers() {
		
		//get the List of Users by calling the DAO method that selects them from the database
		List<User> Users = eDAO.getUsers();
		
		//return the list of Users
		return Users;
	}
	
	public void addUser(User newUser) {
		
		//take in the User object sent from the menu and send it to the UserDAO to be inserted into the database
		
		//call the DAO method that inserts the new User
		eDAO.insertUser(newUser);
	}

	//This is only returning one object so it doesn't necessarily have to be a list...
	public List<User> getUserById(int idInput) {
		
		List<User> User= eDAO.getUserById(idInput);
		
		return User;
	}

	public List<User> getUsersByRole(String roleInput) {
		
		List<User> Users = eDAO.getUsersByRole(roleInput);
		
		return Users;
	}
	
}
