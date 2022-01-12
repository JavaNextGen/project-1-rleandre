package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {
	
	
	AuthService as = new AuthService();// THIS OBJECT WILL BE USED IN THE IF STATEMENT BELOW!!!!!!
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		
		
		
		if(as.login(LDTO.getUsername(), LDTO.getPassword()) != null){
			ctx.req.getSession();
			ctx.result("Login was Successful!");
			ctx.status(202);
		}
		
		else {
			ctx.result("Login Failed!");
			ctx.status(401);
		}
	};
	
}
