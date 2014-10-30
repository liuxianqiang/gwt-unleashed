package chapter6.client;

import javax.xml.ws.Holder;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import static chapter6.client.UIHelper.*;

public class PanelTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
//		testBasicPanel();
		testTwoParent();
//		testRootPanel();
	}
	
	private void testBasicPanel() {
		DecoratorPanel dPanel = new DecoratorPanel();
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setWidth("200px");
		
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(new Label("左面板"));
		hPanel.add(new Label("右面板"));
		hPanel.setHeight("50px");
		vPanel.add(hPanel);
		
		vPanel.add(new Button("按钮"));
		dPanel.setWidget(vPanel);
		RootPanel.get().add(dPanel);
	}
	
	private void testTwoParent() {
		Label label = new Label("one lable attach to two parent");
		
		HorizontalPanel hPanel1 = new HorizontalPanel();
		hPanel1.add(label);
		hPanel1.getElement().setAttribute("style", "background-color:yellow");
		hPanel1.setSize("200px", "15px");
		HorizontalPanel hPanel2 = new HorizontalPanel();
		hPanel2.getElement().setAttribute("style", "background-color:red");
		hPanel2.setSize("200px", "15px");
		hPanel2.add(label);
		
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.add(hPanel1);
		vPanel.add(hPanel2);
		
		RootPanel.get().add(vPanel);
	}
	
	private void testRootPanel() {
		log(RootPanel.get().getElement());
		log(RootPanel.get("controltest").getElement());
		log(RootPanel.getBodyElement());
	}
}
