package com.guestbook.client;

import java.util.Date;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class AddPostDialog extends DialogBox {
		private TextBox dayTB;
		private TextBox thingTB,moneytextBox;
		public AddPostDialog(){
			
			DockPanel dockPanel = new DockPanel();
			dockPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			dockPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			setWidget(dockPanel);
			dockPanel.setSize("377px", "311px");
			
			HorizontalPanel horizontalPanel = new HorizontalPanel();
			dockPanel.add(horizontalPanel, DockPanel.NORTH);
			horizontalPanel.setSize("364px", "54px");
			
			Label label = new Label("\u65B0\u589E\u5E33\u672C");
			label.setStyleName("dialog-Title");
			horizontalPanel.add(label);
			horizontalPanel.setCellVerticalAlignment(label, HasVerticalAlignment.ALIGN_MIDDLE);
			horizontalPanel.setCellHorizontalAlignment(label, HasHorizontalAlignment.ALIGN_CENTER);
			
			HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
			horizontalPanel_1.setStyleName("bg");
			horizontalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			horizontalPanel_1.setSpacing(10);
			dockPanel.add(horizontalPanel_1, DockPanel.SOUTH);
			dockPanel.setCellHorizontalAlignment(horizontalPanel_1, HasHorizontalAlignment.ALIGN_CENTER);
			dockPanel.setCellVerticalAlignment(horizontalPanel_1, HasVerticalAlignment.ALIGN_MIDDLE);
			horizontalPanel_1.setSize("364px", "59px");
			
			Button savebtn = new Button("save");
			savebtn.setText("\u5132\u5B58");
			savebtn.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					Date now=new Date();
					String day=dayTB.getText();
					String thing = thingTB.getText();
					String money = moneytextBox.getText();
					Post post = new Post(day,thing,money,now);
					
					int Money =Integer.parseInt(money);
					PostServiceAsync postService = (PostServiceAsync)GWT.create(PostService.class);
					postService.savePost(post, new AsyncCallback<Boolean>() {
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							Window.alert("Error");
						}

						@Override
						public void onSuccess(Boolean result) {
							// TODO Auto-generated method stub
							hide();
							Window.alert(result? "Save":"Failure");
						}
					});
				}
			});
			savebtn.setStyleName("dialog-Title-new");
			horizontalPanel_1.add(savebtn);
			savebtn.setSize("70px", "40px");
			
			Button cancelbtn = new Button("cancel");
			cancelbtn.setText("\u53D6\u6D88");
			cancelbtn.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					hide();
				}
			});
			cancelbtn.setStyleName("dialog-Title-new");
			horizontalPanel_1.add(cancelbtn);
			cancelbtn.setSize("70px", "40px");
			
			FlexTable flexTable = new FlexTable();
			dockPanel.add(flexTable, DockPanel.CENTER);
			flexTable.setSize("364px", "200px");
			
			Label datelab = new Label("\u65E5\u671F");
			datelab.setStyleName("dialog-Title");
			flexTable.setWidget(0, 0, datelab);
			
			dayTB = new TextBox();
			flexTable.setWidget(0, 1, dayTB);
			
			Label thinglab = new Label("\u7269\u54C1\u540D\u7A31");
			thinglab.setStyleName("dialog-Title");
			flexTable.setWidget(1, 0, thinglab);
			
			thingTB = new TextBox();
			thingTB.setText("");
			flexTable.setWidget(1, 1, thingTB);
			
			Label moneylab = new Label("\u91D1\u984D");
			moneylab.setStyleName("dialog-Title");
			flexTable.setWidget(2, 0, moneylab);
			
			moneytextBox = new TextBox();
			flexTable.setWidget(2, 1, moneytextBox);
			
		}
}
