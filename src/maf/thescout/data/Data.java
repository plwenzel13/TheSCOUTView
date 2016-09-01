package maf.thescout.data;

import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Properties;
import maf.thescout.thescoutview.Juliette;

public class Data {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/SCOUT";

	   //  Database credentials
	   static final String USER = "username";
	   static final String PASS = "password";

	   
	public static void main (String[] args){
//	public static List<Juliette> getJuliettesDatabase (){
		List<Juliette> databaseJuliettes = loadJuliettesFromDatabase();
		
		System.out.println(databaseJuliettes.size());
		
		return;

		}// end main

	private static List<Juliette> loadJuliettesFromDatabase() {
				List<Juliette> s_juliettes = new ArrayList<Juliette>();
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				try {
					// STEP 2. Register JDBC driver	
					Class.forName("com.mysql.jdbc.Driver");
		
					// STEP 3. Open a connection
				    //System.out.println("Connecting to a selected database...");
					String connectionUrl = "jdbc:mysql://localhost:3306/SCOUT";
					String connectionUser = "root";
					String connectionPassword = "1414";
					conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				    //System.out.println("Connected database successfully...");
				    
					// STEP 4. Execute a query
				    //System.out.println("Creating statement...");
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM MEMBERS");
					
					// STEP 5. Extract data from result set
					while (rs.next()) {
						// retrive by column name
						String firstName = rs.getString("firstName");
						String lastName = rs.getString("lastName");
						int grade = rs.getInt("grade");
						String gsLevel = rs.getString("gsLevel");
						
						int troopNumber = rs.getInt("troopNumber");
						
						// display values
						System.out.println("First Name: " + firstName);
						System.out.println("Last Name: " + lastName);
						System.out.println("Grade: " + grade);
						System.out.println("Girl Scout Level: " + gsLevel);
						System.out.println("Troop Number: " + troopNumber);
						
						s_juliettes.add(new Juliette(firstName, lastName, grade, gsLevel, troopNumber));
					}
					rs.close();
					
				} catch (SQLException se){
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e) {
					// Handle errors for Class.forName
					e.printStackTrace();
				} finally {
					// Finally block used to close resources
					try{
				         if(stmt!=null) conn.close();
				    }catch(SQLException se){
				    	se.printStackTrace();
				    }// do nothing
				    try{
				         if(conn!=null) conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }//end try
				   //System.out.println("Goodbye!");
//				return;
				return s_juliettes;
	}
		

	public static List<Juliette> getJuliettesDatabase (){
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		@SuppressWarnings("resource")
		java.net.URLClassLoader ucl =  ((java.net.URLClassLoader)cl);
		for (URL url : ucl.getURLs()){
			System.out.println(url.getFile());
		}
		
		List<Juliette> s_juliettes;
		s_juliettes = loadJuliettesFromDatabase();
		s_juliettes = getHardCodedJuliettes();	
		return s_juliettes;
	}

	private static List<Juliette> getHardCodedJuliettes() {
		System.out.println("Evil compiler!!! These are the hard-coded scouts!!!");
			
		
		List<Juliette> s_juliettes = new ArrayList<Juliette>();
//
		s_juliettes.add(new Juliette("Bill", "Dance", 5, "Junior", 1096));
		s_juliettes.add(new Juliette("Bob", "Royal",7, "Cadette", 1111));
		s_juliettes.add(new Juliette("Gary", "Taylor",2, "Brownie", 345));
		s_juliettes.add(new Juliette("Jeff", "Wallace",1, "Daisy", 2345));
		s_juliettes.add(new Juliette("Joe", "Macho",9, "Senior", 22233));
		return s_juliettes;
	}
}
