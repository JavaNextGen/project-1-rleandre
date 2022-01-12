package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {

UserService es = new UserService(); 
	
	public Handler getUserHandler = ctx -> {
		if(ctx.req.getSession() != null) {	//this is a check to see if your session exists...if the program is running
			List<User> allUsers = es.getUsers();
			
			Gson gson = new Gson();
			String JSONUsers = gson.toJson(allUsers);
			ctx.result(JSONUsers);
			ctx.status(200);
		}
		
		else {
			ctx.result("Oh no! You failed to get Users");
			ctx.status(404);
		}
	};
	
	public Handler insertUserHandler = (ctx) -> {
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			User User = gson.fromJson(body, User.class);
			
			es.addUser(User);
			
			ctx.result("User was successfully added");
			ctx.status(201);//the status code for something successfully added is 201
		}
		else {
			ctx.result("Oh no! You failed to get Users");
			ctx.status(404);
		}
		
	};
}
