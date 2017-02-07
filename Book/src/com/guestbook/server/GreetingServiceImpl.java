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
			return count+"�@�@�@(�ӦY�g�o~";
		}
		if(count<500 && count>0)
		{
			return count+"�@�@�@(�o�ӭn�`���!!!" ;
		}
		else
		{
			return count+"�@�@�@(�٫ܦh�ɶq��(? ��...�٬O�s�_�Ӧn" ;
		}	
	}
}
