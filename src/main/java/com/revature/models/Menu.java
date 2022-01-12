package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

//This Menu Class will have a displayMenu() method that displays the menu to the user and lets them interact with it
//The menu will make use of the Scanner class to take user inputs in order to travel through the menu options.
public class Menu {
	
	static UserService es = new UserService(); //we need this object to use methods from UserService
	
	//All of the menu display options and control flow are contained within this method
	public static void displayMenu() {
		
		boolean displayMenu = true; //we're going to use this to toggle whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //Scanner object to parse (take) user input
		
		//give the user a pretty greeting :)
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println("Welcome to The Krusty Krab User Management System");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		
		
		//display the menu as long as the displayMenu boolean == true
		//this is going to hold and display all my menu options until displayMenu == false
		while(displayMenu) { 
			
			//menu options
			System.out.println("hi -> get greeted");
			System.out.println("Users -> show all Users");
			System.out.println("UsersById -> get Users with a certain ID");
			System.out.println("UsersByTitle -> get Users of a certain title");
			System.out.println("add -> add a new User");
			System.out.println("exit -> exit the application");
			
			
			//parse user input after they choose a menu option, and put it into a String variable
			String input = scan.nextLine();
			
			//switch statement that takes the user input and executes the appropriate code
			//BEN MAY ADD MORE COMMENTS HERE ONCE WE DO DATABASE CONNECTIVITY
			switch(input) {
			
			case "hi": {
				System.out.println("Hello there.");
				break; //we need a break in each case block, or else all the other cases will still run
			}
			
			case "Users" :{
				
				//get the List of Users from the repository layer
				List<User> Users = es.getUsers();
				
				//enhanced for loop to print out the Users one by one
				for (User e : Users) {
					System.out.println(e);
				}
			}
		
		
	}
	
}
	}
}
