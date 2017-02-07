package com.guestbook.client;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Count extends DialogBox {
	TextBox txt;
	String te="";
	int count=0,cc=0;
	Double [] a=new Double[2];
	public Count() {
		
		LayoutPanel layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("CHICHI-new");
		setWidget(layoutPanel);
		layoutPanel.setSize("215px", "317px");
		
		txt = new TextBox();
		layoutPanel.add(txt);
		layoutPanel.setWidgetLeftWidth(txt, 20.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(txt, 18.0, Unit.PX, 54.0, Unit.PX);
		
		Button b0 = new Button("New button");
		b0.setStyleName("CHICHI");
		b0.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te=te+"0";
				txt.setText(te);
			}
		});
		b0.setText("0");
		layoutPanel.add(b0);
		b0.setSize("80px", "40px");
		layoutPanel.setWidgetLeftWidth(b0, 20.0, Unit.PX, 84.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(b0, 262.0, Unit.PX, 40.0, Unit.PX);
		
		Button bs = new Button("New button");
		bs.setStyleName("CHICHI");
		bs.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				a[cc]=Double.parseDouble(txt.getText());
				if(cc==1)
				{
					if(count==1)
						a[0]=a[0]+a[1];
					else if(count==2)
						a[0]=a[0]-a[1];
					else if(count==3)
						a[0]=a[0]*a[1];
					else if(count==4)
						a[0]=a[0]/a[1];
				}
				count=4;
				cc=1;
				te="";
				txt.setText(te);
				
			}
		});
		bs.setText("/");
		layoutPanel.add(bs);
		bs.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(bs, 156.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(bs, 262.0, Unit.PX, 40.0, Unit.PX);
		
		Button c = new Button("New button");
		c.setStyleName("CHICHI");
		c.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te="";
				txt.setText(te);
				count=0;
				cc=0;
				a[0]=(double) 0;
				a[1]=(double) 0;
			}
		});
		c.setText("C");
		layoutPanel.add(c);
		c.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(c, 156.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(c, 78.0, Unit.PX, 40.0, Unit.PX);
		
		Button b7 = new Button("New button");
		b7.setStyleName("CHICHI");
		b7.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te=te+"7";
				txt.setText(te);
			}
		});
		b7.setText("7");
		layoutPanel.add(b7);
		b7.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(b7, 20.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(b7, 124.0, Unit.PX, 40.0, Unit.PX);
		
		Button b8 = new Button("New button");
		b8.setStyleName("CHICHI");
		b8.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te=te+"8";
				txt.setText(te);
			}
		});
		b8.setText("8");
		layoutPanel.add(b8);
		b8.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(b8, 64.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(b8, 124.0, Unit.PX, 40.0, Unit.PX);
		
		Button b9 = new Button("New button");
		b9.setStyleName("CHICHI");
		b9.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te=te+"9";
				txt.setText(te);
			}
		});
		b9.setText("9");
		layoutPanel.add(b9);
		b9.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(b9, 110.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(b9, 124.0, Unit.PX, 40.0, Unit.PX);
		
		Button ba = new Button("New button");
		ba.setStyleName("CHICHI");
		ba.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				a[cc]=Double.parseDouble(txt.getText());
				if(cc==1)
				{
					if(count==1)
						a[0]=a[0]+a[1];
					else if(count==2)
						a[0]=a[0]-a[1];
					else if(count==3)
						a[0]=a[0]*a[1];
					else if(count==4)
						a[0]=a[0]/a[1];
				}
				count=1;
				cc=1;
				te="";
				txt.setText(te);
			}
		});
		ba.setText("+");
		layoutPanel.add(ba);
		ba.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(ba, 156.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(ba, 124.0, Unit.PX, 40.0, Unit.PX);
		
		Button b4 = new Button("New button");
		b4.setStyleName("CHICHI");
		b4.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te=te+"4";
				txt.setText(te);
			}
		});
		b4.setText("4");
		layoutPanel.add(b4);
		b4.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(b4, 20.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(b4, 170.0, Unit.PX, 40.0, Unit.PX);
		
		Button b5 = new Button("New button");
		b5.setStyleName("CHICHI");
		b5.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te=te+"5";
				txt.setText(te);
			}
		});
		b5.setText("5");
		layoutPanel.add(b5);
		b5.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(b5, 64.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(b5, 170.0, Unit.PX, 40.0, Unit.PX);
		
		Button b6 = new Button("New button");
		b6.setStyleName("CHICHI");
		b6.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te=te+"6";
				txt.setText(te);
			}
		});
		b6.setText("6");
		layoutPanel.add(b6);
		b6.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(b6, 110.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(b6, 170.0, Unit.PX, 40.0, Unit.PX);
		
		Button bb = new Button("New button");
		bb.setStyleName("CHICHI");
		bb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				a[cc]=Double.parseDouble(txt.getText());
				if(cc==1)
				{
					if(count==1)
						a[0]=a[0]+a[1];
					else if(count==2)
						a[0]=a[0]-a[1];
					else if(count==3)
						a[0]=a[0]*a[1];
					else if(count==4)
						a[0]=a[0]/a[1];
				}
				count=2;
				cc=1;
				te="";
				txt.setText(te);
			}
		});
		bb.setText("-");
		layoutPanel.add(bb);
		bb.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(bb, 156.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(bb, 170.0, Unit.PX, 40.0, Unit.PX);
		
		Button b1 = new Button("New button");
		b1.setStyleName("CHICHI");
		b1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te=te+"1";
				txt.setText(te);
			}
		});
		b1.setText("1");
		layoutPanel.add(b1);
		b1.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(b1, 20.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(b1, 216.0, Unit.PX, 40.0, Unit.PX);
		
		Button b2 = new Button("New button");
		b2.setStyleName("CHICHI");
		b2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te=te+"2";
				txt.setText(te);
			}
		});
		b2.setText("2");
		layoutPanel.add(b2);
		b2.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(b2, 64.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(b2, 216.0, Unit.PX, 40.0, Unit.PX);
		
		Button b3 = new Button("New button");
		b3.setStyleName("CHICHI");
		b3.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				te=te+"3";
				txt.setText(te);
			}
		});
		b3.setText("3");
		layoutPanel.add(b3);
		b3.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(b3, 110.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(b3, 216.0, Unit.PX, 40.0, Unit.PX);
		
		Button bm = new Button("New button");
		bm.setStyleName("CHICHI");
		bm.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				a[cc]=Double.parseDouble(txt.getText());
				if(cc==1)
				{
					if(count==1)
						a[0]=a[0]+a[1];
					else if(count==2)
						a[0]=a[0]-a[1];
					else if(count==3)
						a[0]=a[0]*a[1];
					else if(count==4)
						a[0]=a[0]/a[1];
				}
				count=3;
				cc=1;
				te="";
				txt.setText(te);
			}
		});
		bm.setText("*");
		layoutPanel.add(bm);
		bm.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(bm, 156.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(bm, 216.0, Unit.PX, 40.0, Unit.PX);
		
		Button benter = new Button("New button");
		benter.setStyleName("CHICHI");
		benter.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				a[cc]=Double.parseDouble(txt.getText());
				if(count==1)
					a[0]=a[0]+a[1];
				else if(count==2)
					a[0]=a[0]-a[1];
				else if(count==3)
					a[0]=a[0]*a[1];
				else if(count==4)
					a[0]=a[0]/a[1];
				count=0;
				cc=0;
				te="";
				txt.setText(a[0]+"");
			}
		});
		benter.setText("=");
		layoutPanel.add(benter);
		benter.setSize("40px", "40px");
		layoutPanel.setWidgetLeftWidth(benter, 110.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(benter, 262.0, Unit.PX, 40.0, Unit.PX);
		
		Button button = new Button("New button");
		button.setStyleName("CHICHI");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		button.setText("x");
		layoutPanel.add(button);
		button.setSize("25px", "25px");
		layoutPanel.setWidgetLeftWidth(button, 125.0, Unit.PX, 40.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(button, 93.0, Unit.PX, 40.0, Unit.PX);
	}
}
