package com.guestbook.server;

import javax.jdo.PersistenceManager;

import com.guestbook.client.GreetingService;
import com.guestbook.client.Post;
import com.guestbook.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
		
	public String greetServer(String limittb) throws IllegalArgumentException {
		int limit=Integer.parseInt(limittb);
		AskServlet aa=new AskServlet();
		int all=aa.all();
		int count=limit-all;
		if(count<=0)
		{
			return count+"　　　(該吃土囉~";
		}
		if(count<500 && count>0)
		{
			return count+"　　　(這個要節制啊!!!" ;
		}
		else
		{
			return count+"　　　(還很多盡量花(? 不...還是存起來好" ;
		}	
	}
}
