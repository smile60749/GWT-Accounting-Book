package com.guestbook.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("post")
public interface PostService extends RemoteService {	
		public boolean savePost(Post post) throws IllegalArgumentException;
		List<Post>getAllPost();
		public boolean updatePost(Post post);
		public boolean deletePost(Post post);
}
