/*package org.questionBank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;	
import  java.sql.SQLException;


public class TestDatabase {

	public static void main(String[] args) {

		
	
		//Connecting to database;
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/";
		String databaseName = "questionbank";
		String userName = "qbank";
		String password = "qbank12345";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url+databaseName, userName, password);
			
			String sqlQueryForPerson = "Select * from Person";
			
			Statement statement = conn.createStatement();
			ResultSet resultPerson = statement.executeQuery(sqlQueryForPerson);
			
			//testing for Person table
			resultPerson.next();
			System.out.println(resultPerson.getString("id"));
			System.out.println(resultPerson.getString("first_name"));
			System.out.println(resultPerson.getString("last_name"));
			System.out.println(resultPerson.getString("user_name"));
			System.out.println(resultPerson.getString("password"));
			
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			if(conn!=null){
				conn = null;
			}
		}
	}

}
*/