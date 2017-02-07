package com.guestbook.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class PostEditor extends Composite {
	private DockPanel dockPanel;
	private TextBox day;
	private TextBox thing;
	private TextBox money;
	private Post post;

	public PostEditor() {
		
		dockPanel = new DockPanel();
		initWidget(dockPanel);
		
		FlexTable flexTable = new FlexTable();
		dockPanel.add(flexTable, DockPanel.CENTER);
		flexTable.setSize("450px", "300px");
		
		Label lblNewLabel = new Label("\u8A18\u5E33\u65E5\u671F\uFF1A");
		lblNewLabel.setStyleName("dialog-Title");
		flexTable.setWidget(0, 0, lblNewLabel);
		
		day = new TextBox();
		flexTable.setWidget(0, 1, day);
		
		Label lblNewLabel_1 = new Label("\u7269\u54C1\u540D\u7A31\uFF1A");
		lblNewLabel_1.setStyleName("dialog-Title");
		flexTable.setWidget(1, 0, lblNewLabel_1);
		
		thing = new TextBox();
		flexTable.setWidget(1, 1, thing);
		
		Label lblNewLabel_2 = new Label("\u91D1\u984D\uFF1A");
		lblNewLabel_2.setStyleName("dialog-Title");
		flexTable.setWidget(2, 0, lblNewLabel_2);
		
		money = new TextBox();
		flexTable.setWidget(2, 1, money);
	}

	public DockPanel getDockPanel() {
		return dockPanel;
	}

	public void setDockPanel(DockPanel dockPanel) {
		this.dockPanel = dockPanel;
	}

	public Post getPost() {
		post.setDay(day.getText());
		post.setThing(thing.getText());
		post.setMoney(money.getText());
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
		day.setText(post.getDay());
		thing.setText(post.getThing());
		money.setText(post.getMoney());
	}

}
