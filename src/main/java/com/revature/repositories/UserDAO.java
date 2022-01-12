package com.revature.repositories;


import com.revature.models.User;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO {

    /**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }

    /**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     *
     * Note: The userToBeRegistered will have an id=0, and username and password will not be null.
     * Additional fields may be null.
     */
    public User create(User userToBeRegistered) {
        return userToBeRegistered;
    }
    
    
public List<User> getUser() { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String sql = "SELECT * FROM ers_users;";
			
			//Put the SQL query into a Statement object (The Connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The Statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(sql);
			
			//All the code above makes a call to your database... Now we need to store the data in an ArrayList.
			
			//create an empty ArrayList to be filled with the data from the database
			List<User> UserList = new ArrayList<>();
			
			//while there are results in the resultset...
			while(rs.next()) {
				
				//Use the all args constructor to create a new User object from each returned row from the DB
				User e = new User(
						//we want to use rs.get for each column in the record
						rs.getInt("ers_users_id"),
    	    			rs.getString("ers_username"),
    	    			rs.getString("ers_password"),
    	    			rs.getString("ers_f_name"),
    	    			rs.getString("ers_l_name"),
    	    			rs.getString("user_email"),
    	    			rs.getInt("user_role_id")
						);
				
				//and populate the ArrayList with each new User object
				UserList.add(e); //e is the new User object we created above
		
			}
						
			//when there are no more results in rs, the while loop will break
			//then, return the populated ArrayList of Users
			return UserList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting Users!");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block, so Java won't yell
		//(Since there's no guarantee that the try will run)
		
	}
  //Get by id
    public List<User> getUserById(int id) {

    
    	try(Connection conn = ConnectionFactory.getConnection()) {
    		ResultSet rs = null;
    		String sql = "select * from ers_users where ers_users_id = ?";
    		
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, id);
    		rs = ps.executeQuery();
    		List<User> userList = new ArrayList<>();
    		while(rs.next()) {
    			User u = new User(
    					rs.getInt("ers_users_id"),
    	    			rs.getString("ers_username"),
    	    			rs.getString("ers_password"),
    	    			rs.getString("ers_f_name"),
    	    			rs.getString("ers_l_name"),
    	    			rs.getString("user_email"),
    	    			rs.getInt("user_role_id")
    	    			);
    			userList.add(u);
    		}
    		return userList;
    	}
    	 catch (SQLException e) {
 			System.out.println("Something went wrong with your database!"); 
 			e.printStackTrace();
 		}
 		return null;
}

public void insertUser(User newUser) { //This is INSERT functionality 
	try(Connection conn = ConnectionFactory.getConnection()) {
		//we'll create a SQL statement using parameters to insert a new User
		String sql = "INSERT INTO ers_users (ers_users_id, ers_username,"
				+ "ers_password, ers_f_name, ers_l_name, user_email, user_role_id)" //creating a line break for readability
				    + "VALUES (?, ?, ?); "; //these are parameters!! We have to specify the value of each "?"
		
		PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
		
		//use the PreparedStatement objects' methods to insert values into the query's ?s
		//the values will come from the User object we send in.
		ps.setString(1, newUser.getErs_username()); //1 is the first ?, 2 is the second, etc.
		ps.setString(2, newUser.getErs_password());
		ps.setString(3, newUser.getErs_f_name());
		ps.setString(4, newUser.getErs_l_name());
		ps.setString(5, newUser.getUser_email());
		ps.setInt(6, newUser.getUser_role_id());
		//this executeUpdate() method actually sends and executes the SQL command we built
		ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
		//we use executeQuery() for selects
		
		//send confirmation to the console if successful.
		System.out.println("User " + newUser.getErs_username() + " created. Congratulations!");
	}
	 catch(SQLException e) {
		System.out.println("Failure to Create a User!");
		e.printStackTrace();
	} 
	}

public List<User> getUsersByRole(String title) {
	
	try(Connection conn = ConnectionFactory.getConnection()){
		
		ResultSet rs = null;
		
		String sql = "select * from ers_users inner join ers_user_roles "
				     + "on ers_users.user_role_id = ers_user_roles.ers_user_role_id where ers_user_roles.user_role = ?";
		//we need to join Users to roles in order to access the role_title column and return Users
		//since I want to get Users based on something found in the roles table, we need a join 
		
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, title); //insert the method's argument as the first (and only) variable in the query
		
		rs = ps.executeQuery();	
		
		List<User> UserList = new ArrayList<>();
		
		while(rs.next()) { //while there are results in the result set...
			
			User u = new User( //create a new UserObject from each returned row..
					rs.getInt("ers_users_id"),
	    			rs.getString("ers_username"),
	    			rs.getString("ers_password"),
	    			rs.getString("ers_f_name"),
	    			rs.getString("ers_l_name"),
	    			rs.getString("user_email"),
	    			rs.getInt("user_role_id")
					);
			
			UserList.add(u); //and populate the ArrayList with each created Role Object
		}
		
		return UserList; //Finally, return the populated List of Roles.
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return null;
}

public List<User> getUsers() {
	// TODO Auto-generated method stub
	return null;
}
}



