package com.ts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
		UserBean details=new InsuranceDAO().isUser(uid,pwd);
		out.print("pass");
		if(details.getRole()=="")
		{
		 out.print("Sorry UserName or Password Error!")	;
		 RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("username", details.getUsername());
			if(details.getRole().equals("home"))
			{
				response.sendRedirect("Mainmenu_user.jsp");
			}
			else if(details.getRole().equals("admin"))
			{
				response.sendRedirect("Mainmenu_admin.jsp");
			}
		}
	}

}
