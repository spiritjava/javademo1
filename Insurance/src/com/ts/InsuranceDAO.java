package com.ts;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class InsuranceDAO {
	public UserBean isUser(String uid,String pwd)
	{
		UserBean details=new UserBean();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurance","root","root");
			String role="";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select role,username from underWriter where uid='"+uid+"' and password='"+pwd+"'");
			while(rs.next())
			{
				details.setRole(rs.getString(1));
				details.setUsername(rs.getString(2));
			}
			rs.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		   return details;
	            
		
	}	
}
