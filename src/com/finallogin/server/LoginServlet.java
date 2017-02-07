package com.finallogin.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finallogin.client.Man;
import com.finallogin.client.PMF;


public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		System.out.println(userid+" "+password);
		PrintWriter out=resp.getWriter();
		PersistenceManager pm=PMF.get().getPersistenceManager();
		Query query=pm.newQuery("SELECT FROM "+Man.class.getName());
		List<Man> allmembers=(List<Man>) query.execute();
		out.println("<HTML><BODY>");
		boolean inexist=true;
		String URL="http://1-dot-final10211245.appspot.com/";
		for(Man m : allmembers)
		{
			if(m.getUserid().equals(userid))
			{
				inexist=false;
				if(m.getPassword().equals(password))
				{
					out.println("Welcome!");
					out.println("<a href=\""+URL+"\">Change To Main Page</a>");
					break;
				}
				else
				{
					out.println("Password Error!");
					out.println("<a href=\""+("/login.jsp")+"\">Back To Login Page</a>");
					out.println("<a href=\""+("/add.jsp")+"\">Change To Register Page</a>");
					break;
				}
			}	
		}
		if(inexist)
		{
			out.println("This id is not exist!");
			out.println("<a href=\""+("/add.jsp")+"\">Change To Register Page</a>");
		}
		out.println("</BODY></HTML>");
	}

}
