package com.guestbook.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
		void greetServer(String name, AsyncCallback<String> asyncCallback);

		
}
