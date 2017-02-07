package com.guestbook.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.client.Post;
import com.guestbook.server.PMF;


public class AskServlet extends HttpServlet {
	int total=0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		PersistenceManager pm=PMF.get().getPersistenceManager();
		Query query=pm.newQuery("SELECT FROM "+Post.class.getName());
		List<Post> allmoney=(List<Post>) query.execute();
		
		for(Post m : allmoney)
		{
			int	sum=Integer.parseInt(m.getMoney());			
			total=total+sum;
			
		}
		out.println(total);
	}

	public int all() {
		PersistenceManager pm=PMF.get().getPersistenceManager();
		Query query=pm.newQuery("SELECT FROM "+Post.class.getName());
		List<Post> allmoney=(List<Post>) query.execute();
		
		for(Post m : allmoney)
		{
			int	sum=Integer.parseInt(m.getMoney());			
			total=total+sum;
		}
		return total;
		// TODO Auto-generated method stub
	}


}
