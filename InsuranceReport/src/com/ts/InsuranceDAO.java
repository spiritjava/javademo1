package com.ts;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class InsuranceDAO {
	public String isUser(String uid,String pwd)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurance","root","root");
			String role="";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select role from underWriter where uid='"+uid+"' and pwd='"+pwd+"'");
			while(rs.next())
				role=rs.getString(0);
			rs.close();
			con.close();
			return role;
		}
		catch(Exception e)
		{
			
		}
		return pwd;
	}

	
}
