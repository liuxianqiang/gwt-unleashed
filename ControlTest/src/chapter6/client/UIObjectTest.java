package chapter6.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.UIObject;

import static chapter6.client.UIHelper.*;

public class UIObjectTest implements EntryPoint {
	public void onModuleLoad() {
		Button button = new Button("ui object");
		button.setTitle("ui object");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				UIObject obj = (UIObject) event.getSource();
				
//				testSize(obj);
				
//				testStyle(obj);
				
				testOthers(obj);
			}
		});
		RootPanel.get().add(button);
	}
	
	private void testSize(UIObject obj) {
		next("尺寸");
		printSize(obj);
//		obj.setWidth("100px");
//		obj.setHeight("100px");
//		obj.setPixelSize(100, 100);
		obj.setSize("100px", "100px");
		printSize(obj);
	}
	
	private void testStyle(UIObject obj) {
		next("样式");
		obj.addStyleName("normal");
		next();
		obj.removeStyleName("normal");
		obj.addStyleName("highlight");
		next();
		obj.removeStyleName("normal");
		obj.removeStyleName("highlight");
		next();
		obj.addStyleDependentName("normal");
		next();
		obj.removeStyleDependentName("normal");
		obj.addStyleDependentName("highlight");
		next();
		obj.setStyleName("");
		next();
		obj.setStylePrimaryName("main");
		next();
		obj.addStyleDependentName("sub");
		next();
		obj.setStyleDependentName("sub", false);
		next();
		obj.setStyleName("main", false);
		
		printStyle(obj);
	}
	
	private void testOthers(UIObject obj) {
		next("其他");
		printOthers(obj);
		next();
		obj.setTitle("title edit");
		next();
		obj.setVisible(false);
		next();
		printOthers(obj);
		// event ? TODO
		obj.sinkEvents(1);
		obj.unsinkEvents(1);
	}
	
	private void printSize(UIObject obj) {
		log("left: " + obj.getAbsoluteLeft());
		log("top: " + obj.getAbsoluteTop());
		log("width: " + obj.getOffsetWidth());
		log("height: " + obj.getOffsetHeight());
	}
	
	private void printStyle(UIObject obj) {
		log("style: " + obj.getStyleName());
		log("main style: " + obj.getStylePrimaryName());
	}
	
	private void printOthers(UIObject obj) {
		log("element: " + obj.getElement());
		log("title: " + obj.getTitle());
		log("visible: " + obj.isVisible());
	}
}
