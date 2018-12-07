package com.qa.mohan.anita.sakilaDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class JDBC {
	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila"; 
	static final String user = "root";
	static final String pass = "password";
	Connection conn =null;
	Statement stmt = null;
	public void accessDB() {
		
		try {
			conn = DriverManager.getConnection(DB_URL, user, pass);
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	
		
	}
	public void closeDB() {
		try {
			if (stmt != null)
				stmt.close();
		}
			catch (SQLException se) {
				se.printStackTrace();
			}
		try {
			if (conn !=null)
				conn.close();
		}
			catch(SQLException se) {
				se.printStackTrace();
			}
		
	}
	
	public Optional<ResultSet> getTables() {
		accessDB();
		Optional<ResultSet> rs = Optional.empty();
		String sql = "SHOW tables;";
		try {
		    stmt = conn.createStatement();
			rs = Optional.of(stmt.executeQuery(sql));
			if(rs.isPresent()) {
				ResultSet rs1 = rs.get();
				while (rs1.next()) {
					String tableName = rs1.getString("TABLE_NAME");
					System.out.println(tableName);
				}
			}
			
		}
		
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			
			closeDB();
		}
	
		return rs;
	}
	public Optional<ResultSet> getActorTable(){
		accessDB();
		Optional<ResultSet> rs = Optional.empty();
		String sql = "SELECT first_name, last_name FROM actor;";
		try {
			stmt = conn.createStatement();
			rs = Optional.of(stmt.executeQuery(sql));
			if(rs.isPresent()) {
				ResultSet rs1 = rs.get();
				while(rs1.next()) {
					String firstName = rs1.getString("first_name");
					String lastName = rs1.getString("last_name");
					System.out.println(firstName +" " + lastName);
				}
					
				}
			}
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			closeDB();
		}
		return rs;
		}
		
					

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		
		
		
		
}
	
	


