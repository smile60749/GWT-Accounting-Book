package com.guestbook.client;

	import com.google.gwt.user.client.ui.Composite;
	import com.google.gwt.user.client.ui.FlexTable;
	import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

	public class Detail extends Composite {

		private Label labday;
		private Label labthing;
		private Label labmoney;
		public Detail(){
			
			FlexTable flexTable = new FlexTable();
			initWidget(flexTable);
			
			Label labelday = new Label("\u8A18\u5E33\u65E5\u671F:");
			labelday.setStyleName("dialog-Title");
			flexTable.setWidget(0, 0, labelday);
			
			labday = new Label("");
			flexTable.setWidget(0, 1, labday);
			flexTable.getCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_LEFT);
			
			Label labelthing = new Label("\u7269\u54C1\u540D\u7A31:");
			labelthing.setStyleName("dialog-Title");
			flexTable.setWidget(1, 0, labelthing);
			
			labthing = new Label("");
			flexTable.setWidget(1, 1, labthing);
			
			Label labalmoney = new Label("\u91D1\u984D:");
			labalmoney.setStyleName("dialog-Title");
			flexTable.setWidget(2, 0, labalmoney);
			
			labmoney = new Label("");
			flexTable.setWidget(2, 1, labmoney);
		}
		public void setPost (Post post){
			//lbdate.setText(post.getDate().toString());
			labday.setText(post.getDay());
			labthing.setText(post.getThing());
			labmoney.setText(post.getMoney());
		}
	}
