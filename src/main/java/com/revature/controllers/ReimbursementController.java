package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.*;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {

	ReimbursementService rs = new ReimbursementService(); 
	
	public Handler getReimbursementHandler = ctx -> {
		if(ctx.req.getSession() != null) {	//this is a check to see if your session exists...if the program is running
			List<Reimbursement> allReimbursements = rs.getReimbursements();
			
			Gson gson = new Gson();
			String JSONReimbursements = gson.toJson(allReimbursements);
			ctx.result(JSONReimbursements);
			ctx.status(200);
		}
		
		else {
			ctx.result("Oh no! You failed to get Reimbursements");
			ctx.status(404);
		}
	};
	
	
	public Handler insertReimbursementHandler = (ctx) -> {
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			Reimbursement Reimbursement = gson.fromJson(body, Reimbursement.class);
			
			rs.addReimbursement(Reimbursement);
			
			ctx.result("Reimbursement was successfully added");
			ctx.status(201);//the status code for something successfully added is 201
		}
		else {
			ctx.result("Oh no! You failed to get Reimbursements");
			ctx.status(404);
		}
		
	};
	
}
