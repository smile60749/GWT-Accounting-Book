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

public class AddService extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		System.out.println(userid+" "+password);
		PrintWriter out=resp.getWriter();
		Man member =new Man();
		member.setUserid(userid);
		member.setPassword(password);
		PersistenceManager pm= PMF.get().getPersistenceManager();
		out.println("<HTML><BODY>");
		boolean exist=false;
		Query query=pm.newQuery("SELECT FROM "+Man.class.getName());
		List<Man> allmembers=(List<Man>) query.execute();
		for(Man m : allmembers)
		{
			if(m.getUserid().equals(userid))
			{
				exist=true;
				break;
			}
		}			
		if(!exist)
		{
			try
			{
				pm.makePersistent(member);
				out.println("Success!<br>");
				out.println("Please Login Again.<br>");
				out.println("<a href=\""+("/login.jsp")+"\">Change To Login Page</a>");
			}
			catch (Exception e)	{}
		}
		else
		{
			out.println("The id is exist!");
			out.println("<a href=\""+("/add.jsp")+"\">Change To Register Page</a>");
		}
		out.println("</BODY></HTML>");
	}
}