package com.finallogin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Button;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Finallogin implements EntryPoint {

	public void onModuleLoad() {
		RootPanel rp=RootPanel.get();
		
		Button btnNewButton = new Button("New button");
		rp.add(btnNewButton, 10, 10);
		
	}
}
