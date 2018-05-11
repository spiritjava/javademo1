package com.ts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/First")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FirstServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		String role=new InsuranceDAO().isUser(uid,pwd);
		if(role=="")
		{
		 out.print("Sorry UserName or Password Error!")	;
		 RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		}
		else
		{
			if(role.equals("user"))
			{
				response.sendRedirect("Mainmenu_user.jsp");
			}
			else if(role.equals("admin"))
			{
				response.sendRedirect("Mainmenu_admin.jsp");
			}
		}
	}

}
