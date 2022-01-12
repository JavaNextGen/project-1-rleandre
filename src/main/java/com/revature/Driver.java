package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.AuthController;
import com.revature.controllers.UserController;
import com.revature.models.Menu;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;


public class Driver {
	//DAO 1st, SERVICE 2nd, CONTROLLER 3rd
	
    public static void main(String[] args) {
    	ReimbursementController rc = new ReimbursementController();
    	UserController uc = new UserController();

    	try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} 
    	catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
    	Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
				}
			).start(3004);
    	app.get("/reimbursements", rc.getReimbursementHandler);
		app.post("/reimbursements", rc.insertReimbursementHandler);
		
		
		//i will need to make an app.post for login and i will need to send that to the authcontroller
		//for a login handler
		//this will be responsible for the "login" in the await fetch method in JS
		
		app.get("/users", uc.getUserHandler);
		app.post("/users", uc.insertUserHandler);
    }
}
