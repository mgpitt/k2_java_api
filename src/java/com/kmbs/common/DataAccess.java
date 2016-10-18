/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmbs.common;

import com.kmbs.models.Training;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MPitt
 */
public class DataAccess {
       /**
     * @param args the command line arguments
     * @return 
     */
    public static List<Training> main(String[] args) {
		Connection con = null;
		CallableStatement cstmt = null;
                PreparedStatement pstmt = null;
		ResultSet rs = null;
                List<Training> Trainings=new ArrayList<Training>();
		
		try {
			// Establish the connection. 
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setIntegratedSecurity(false);
			//ds.setServerName("10.10.190.175\\Development");
			ds.setServerName("10.10.190.175");
                        ds.setInstanceName("Development");
			ds.setDatabaseName("KineticData");
                        ds.setUser("sms3");
                        ds.setPassword("Digital#1");
			con = ds.getConnection();
			 
	        	// Execute a stored procedure that returns some data.
            		cstmt = con.prepareCall("{call KineticData.dbo.TrainingReadbackBranch(?)}");
                        String strParam = "BranchNum";
            		cstmt.setInt(strParam, 911);
            		rs = cstmt.executeQuery();
                        //String sqlQuery = "SELECT DateStamp, Comments, NeedsTraining FROM KineticData.dbo.TrainingBranchInfo WHERE BranchNum=?";
                        //pstmt = con.prepareStatement(sqlQuery);
                        //pstmt.setInt(1, 911);
                        //String sqlQuery = "INSERT INTO KineticData.dbo.TrainingBranchInfo ( BranchNum,Comments,NeedsTraining) VALUES (?, ?, ?)";
                        //pstmt = con.prepareStatement(sqlQuery);
                        //pstmt.setInt(1, 111);
                        //pstmt.setString(2, "Still testing");
                        //pstmt.setString(3, "false");
                        //rs = pstmt.executeQuery();

	        	// Iterate through the data in the result set and display it.
                       
	        	while (rs.next()) {
                                Training training = new Training();
                                
                                training.setComment(rs.getString("Comments"));
                                training.setTrain(rs.getString("NeedsTraining"));
                                training.setDate(rs.getDate("DateStamp").toString());
                                
                                Trainings.add(training);
	            		System.out.println("Comments: " + rs.getString("Comments"));
	            		System.out.println("Needs Training: " + rs.getString("NeedsTraining"));
                                System.out.println("Date Stamp: " + rs.getDate("DateStamp").toString());
	            		System.out.println();
	        	}
                        System.out.println(Trainings.toString());
                        System.out.println("Done");
	        }
	        
		// Handle any errors that may have occurred.
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}

	   	finally {
	    		if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (cstmt != null) try { cstmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
	    	}
        // TODO code application logic here
        return Trainings;
    }
}
