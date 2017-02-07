package com.guestbook.client;

import java.util.List;

import com.guestbook.client.GreetingService;
import com.guestbook.client.GreetingServiceAsync;
import com.guestbook.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class Guestbook implements EntryPoint,ClickHandler {
	private DockPanel dockPanel;
	private FlexTable flexTable;
	List<Post> posts;
	int selectRow =-1;
private void readPosts(){
		
		PostServiceAsync postService =(PostServiceAsync)GWT.create(PostService.class);
		postService.getAllPost(new AsyncCallback<List<Post>>() {
			
			@Override
			public void onSuccess(List<Post> result) {
				// TODO Auto-generated method stub
				flexTable.clear();
				posts =result;
				for(int i=0;i<result.size();i++){
					Post p =result.get(i);
					//flexTable.setWidget(i, 0, new Label(p.getId()+""));
					flexTable.setWidget(i, 0, new Label(p.getDay()));
					flexTable.setWidget(i, 1, new Label(p.getThing()));
					flexTable.setWidget(i, 2, new Label(p.getMoney()));
					//flexTable.setWidget(i, 3, new Label(p.getDate()+""));
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void onModuleLoad() {
		RootPanel rp=RootPanel.get();
		
		dockPanel = new DockPanel();
		dockPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		dockPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		rp.add(dockPanel, 0, 0);
		dockPanel.setSize("450px", "300px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		dockPanel.add(horizontalPanel, DockPanel.NORTH);
		horizontalPanel.setSize("449px", "54px");
		
		Button newbtn = new Button("\u65B0\u589E");
		newbtn.setStyleName("dialog-Title-new");
		newbtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				AddPostDialog addDialog = new AddPostDialog();
				addDialog.center();
			}
		});
		horizontalPanel.add(newbtn);
		newbtn.setSize("70px", "30px");
		
		Button updateBtn = new Button("\u4FEE\u6539");
		updateBtn.setStyleName("dialog-Title-new");
		updateBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final DialogBox dialog =new DialogBox();
				final PostEditor editor=new PostEditor();
				editor.setPost(posts.get(selectRow));
				dialog.setWidget(editor);
				Button okbtn=new Button("\u7DE8\u8F2F");
				okbtn.setStyleName("dialog-Title-new");
				Button cancelbtn=new Button("\u53D6\u6D88");
				cancelbtn.setStyleName("dialog-Title-new");
				okbtn.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						Post post =editor.getPost();
						PostServiceAsync postService=(PostServiceAsync)GWT.create(PostService.class);
						postService.updatePost(post, new AsyncCallback<Boolean>() {
							@Override
							public void onSuccess(Boolean result) {
								// TODO Auto-generated method stub
								Window.alert("success");
								dialog.hide();
							}
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								Window.alert("failure");
							}
						});
					}
				});
				cancelbtn.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub	
						dialog.hide();								
					}
				});
				HorizontalPanel hPanel =new HorizontalPanel();
				hPanel.add(okbtn);
				hPanel.add(cancelbtn);
				editor.getDockPanel().add(hPanel, DockPanel.SOUTH);
				dialog.center();
			}
		});
		horizontalPanel.add(updateBtn);
		updateBtn.setSize("70px", "30px");
		
		Button deleteBtn = new Button("\u522A\u9664");
		deleteBtn.setStyleName("dialog-Title-new");
		deleteBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final DialogBox dialog =new DialogBox();
				Button confirmbtn=new Button("\u78BA\u5B9A");
				confirmbtn.setStyleName("dialog-Title-new");
				Button cancelbtn=new Button("\u53D6\u6D88");
				cancelbtn.setStyleName("dialog-Title-new");
				confirmbtn.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						PostServiceAsync postService=(PostServiceAsync)GWT.create(PostService.class);
						postService.deletePost(posts.get(selectRow),new AsyncCallback<Boolean>() {
							@Override
							public void onSuccess(Boolean result) {
								// TODO Auto-generated method stub
								if(result)
									Window.alert("success");
								else
									Window.alert("failure");
								dialog.hide();
							}
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								Window.alert("Error");
								dialog.hide();
							}
						});
					}
				});
				cancelbtn.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub	
						dialog.hide();								
					}
				});
				HorizontalPanel hPanel =new HorizontalPanel();
				hPanel.add(confirmbtn);
				hPanel.add(cancelbtn);
				dialog.setText("Really?");
				dialog.setWidget(hPanel);
				dialog.setSize("200px", "150px");
				dialog.center();
			}
		});
		horizontalPanel.add(deleteBtn);
		deleteBtn.setSize("70px", "30px");
		
		Button button = new Button("\u5269\u9918\u91D1\u984D");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Ask ask = new Ask();
				ask.center();
			}
		});
		button.setStyleName("dialog-Title-new");
		horizontalPanel.add(button);
		button.setSize("80px", "30px");
		
		Button btnc = new Button("\u8A08\u7B97\u6A5F");
		btnc.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Count count=new Count();
				count.center();
			}
		});
		btnc.setStyleName("dialog-Title-new");
		horizontalPanel.add(btnc);
		btnc.setSize("80px", "30px");
		
		flexTable = new FlexTable();
		flexTable.setStyleName("gwt-TextBox");
		flexTable.addClickHandler(this);
		dockPanel.add(flexTable, DockPanel.CENTER);
		dockPanel.setCellVerticalAlignment(flexTable, HasVerticalAlignment.ALIGN_MIDDLE);
		dockPanel.setCellHorizontalAlignment(flexTable, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.setSize("450", "355");
		
		readPosts();
	}	
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			Cell cell =flexTable.getCellForEvent(event);
		    int row =cell.getRowIndex();
		    if(selectRow!=-1){
		    	flexTable.getRowFormatter().removeStyleName(selectRow, "selectedRow");
		    }
		    flexTable.getRowFormatter().addStyleName(row, "selectedRow");
		    selectRow =row;
		    Post p =posts.get(row);
		    
		    Detail detail =new Detail();
		    detail.setPost(p);
		    DialogBox dialog =new DialogBox();
		    dialog.add(detail);
		    dialog.setAutoHideEnabled(true);
		    dialog.center();
	}
		
}