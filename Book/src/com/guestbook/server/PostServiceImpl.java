package com.guestbook.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.guestbook.client.Post;
import com.guestbook.client.PostService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.guestbook.server.PMF;
@SuppressWarnings("serial")
public class PostServiceImpl extends RemoteServiceServlet implements
		PostService {

	@Override
	public boolean savePost(Post post) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		boolean saved= false;
		try {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			pm.makePersistent(post);	
			saved = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		PersistenceManager pm=PMF.get().getPersistenceManager();
		Query query =pm.newQuery("SELECT FROM "+Post.class.getName());
		List<Post> results=(List<Post>) query.execute();
		List<Post> posts =new ArrayList<Post>();
		for(Post p : results){
			posts.add(pm.detachCopy(p));
		}
		pm.close();
		return posts;
	}

	@Override
	public boolean updatePost(Post post) {
		// TODO Auto-generated method stub
		boolean updated =false;
		PersistenceManager pm=PMF.get().getPersistenceManager();
		Post p=(Post)pm.getObjectById(Post.class,post.getId());
		try{
			p.setDay(post.getDay());
			p.setThing(post.getThing());
			p.setMoney(post.getMoney());
			p.setDate(post.getDate());
			updated=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pm.close();
		}
		
		return updated;
	}

	@Override
	public boolean deletePost(Post post) {
		// TODO Auto-generated method stub
		boolean deleted =false;
		PersistenceManager pm=PMF.get().getPersistenceManager();
		try{
			Post p =(Post)pm.getObjectById(Post.class, post.getId());
			pm.deletePersistent(p);
			deleted =true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pm.close();
		}
		return deleted;
	
	}

}
