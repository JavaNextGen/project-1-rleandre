package com.revature.repositories;



import com.revature.models.Reimbursement;
import com.revature.models.Status;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.util.ConnectionFactory;

public class ReimbursementDAO {

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Reimbursement> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(Status status) {
        return Collections.emptyList();
    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	return null;
    }
    
    //get reimbursment
    public List<Reimbursement> getReimbursement(){
    	try(Connection conn = ConnectionFactory.getConnection()){
    		ResultSet rs = null;
    		
    		String sql = "SELECT * FROM ers_reimbursement;";
    		Statement statement = conn.createStatement();
    		rs = statement.executeQuery(sql);
    		List<Reimbursement> reimbList = new ArrayList<>();
    		while(rs.next()) {
    			Reimbursement reim = new Reimbursement(
    					rs.getInt("reimb_id"),
    	    			rs.getInt("reimb_amount"),
    	    			rs.getString("reimb_submitted"),
    	    			rs.getString("reimb_resolved"),
    	    			rs.getString("reimb_desciption"),
    	    			rs.getInt("reimb_author"),
    	    			rs.getInt("reimb_resolver"),
    	    			rs.getInt("reimb_status_id"),
    	    			rs.getInt("reimb_type_id")
    	    			);
    			reimbList.add(reim);	
    		}
    		return reimbList;
    	}
    	catch (SQLException e) {
			System.out.println("Something went wrong retreiving Reimbursement data!");
			e.printStackTrace();
		}
    	return null;
    }
    
    
    
    //Get by id
    public List<Reimbursement> getReimbursementById(int id) {

    	try(Connection conn = ConnectionFactory.getConnection()) {
    		ResultSet rs = null;
    		String sql = "select * from ers_reimbursement where reimb_id = ?";
    		
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, id);
    		rs = ps.executeQuery();
    		List<Reimbursement> reimbList = new ArrayList<>();
    		while(rs.next()) {
    			Reimbursement reim = new Reimbursement(
    					rs.getInt("reimb_id"),
    	    			rs.getInt("reimb_amount"),
    	    			rs.getString("reimb_desciption"),
    	    			rs.getInt("reimb_author"),
    	    			rs.getInt("reimb_resolver"),
    	    			rs.getInt("reimb_status_id"),
    	    			rs.getInt("reimb_type_id")
    	    			);
    			reimbList.add(reim);
    		}
    		return reimbList;
    	}
    	 catch (SQLException e) {
 			System.out.println("Something went wrong with your database!"); 
 			e.printStackTrace();
 		}
 		return null;
}


public void insertReimbursement(Reimbursement newReimbursement) { //This is INSERT functionality 
	
	try(Connection conn = ConnectionFactory.getConnection()){
		
		//we'll create a SQL statement using parameters to insert a new Employee
		String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_desciption "
				+ "reimb_author, reimb_status_id, reimb_type_id)" //creating a line break for readability
				    + "VALUES (?, ?, ?, ?, ?); "; //these are parameters!! We have to specify the value of each "?"
		
		PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
		
		//use the PreparedStatement objects' methods to insert values into the query's ?s
		//the values will come from the Employee object we send in.
		ps.setInt(1, newReimbursement.getReimb_amount()); //1 is the first ?, 2 is the second, etc.
		ps.setString(2, newReimbursement.getReimb_desciption());
		ps.setInt(3, newReimbursement.getReimb_author());
		ps.setInt(4, newReimbursement.getReimb_status_id());
		ps.setInt(5, newReimbursement.getReimb_type_id());
		//this executeUpdate() method actually sends and executes the SQL command we built
		ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
		//we use executeQuery() for selects
		
		//send confirmation to the console if successful.
		System.out.println("Reimbursement " + newReimbursement.getReimb_amount() + " created. Congratulations!");
		
	} 
	catch(SQLException e) {
		System.out.println("Failure to Create a Reimbursement!");
		e.printStackTrace();
	}
	}
}
