package com.guestbook.client;

import com.guestbook.client.GreetingService;
import com.guestbook.client.GreetingServiceAsync;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Ask extends DialogBox {
	//private Post post;
	private TextBox limittb;
	public Ask() {
		//String limit=limittb.getText();
		DockPanel dockPanel = new DockPanel();
		dockPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		dockPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setWidget(dockPanel);
		dockPanel.setSize("377px", "311px");
		
		FlexTable flexTable = new FlexTable();
		dockPanel.add(flexTable, DockPanel.CENTER);
		flexTable.setSize("370px", "304px");
		
		Label lblNewLabel = new Label("\u8ACB\u8F38\u5165\u9322\u9322\u7684\u4E0A\u9650\uFF1A");
		lblNewLabel.setStyleName("dialog-Title");
		flexTable.setWidget(0, 0, lblNewLabel);
		
		limittb = new TextBox();
		flexTable.setWidget(0, 1, limittb);
		
		Label lblNewLabel_2 = new Label("\u5269\u9918\u7684\u9322\u9322\uFF1A");
		lblNewLabel_2.setStyleName("dialog-Title");
		flexTable.setWidget(2, 0, lblNewLabel_2);
		
		final Label lblast = new Label("");
		lblast.setStyleName("gwt-TextBox");
		flexTable.setWidget(2, 1, lblast);
		
		DockPanel dockPanel_1 = new DockPanel();
		dockPanel.add(dockPanel_1, DockPanel.SOUTH);
		
		Button countbtn = new Button("\u8A08\u7B97");
		countbtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				GreetingServiceAsync greetingService1 =
						(GreetingServiceAsync) GWT.create(GreetingService.class);
				greetingService1.greetServer(limittb.getText(), new AsyncCallback<String>() 
						{
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						lblast.setText(""+result);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("error!");
					}
						});
			}
		});
		dockPanel_1.add(countbtn, DockPanel.CENTER);
		countbtn.setStyleName("dialog-Title-new");
		countbtn.setSize("55px", "33px");
		
		Button leavebtn = new Button("\u96E2\u958B");
		leavebtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		leavebtn.setStyleName("dialog-Title-new");
		dockPanel_1.add(leavebtn, DockPanel.EAST);
		leavebtn.setSize("55px", "33px");		
	}

}
