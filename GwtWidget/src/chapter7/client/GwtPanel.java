package chapter7.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GwtPanel implements EntryPoint {

	@Override
	public void onModuleLoad() {
//		testDecoratorPanel();
//		testFlowPanel();
//		testHorizontalPanel();
//		testVerticalPanel();
//		testAbsolutePanel();
//		testTabPanel();
		testScrollPanel();
	}
	
	private void testDecoratorPanel() {
		DecoratorPanel panel = new DecoratorPanel();
		TextBox textBox = new TextBox();
		panel.add(panel);
		// 上中下, 左中右
		RootPanel.get().add(panel);
	}
	
	private void testFlowPanel() {
		FlowPanel panel = new FlowPanel();
		for (int i = 0; i < 10; i++) {
			panel.add(new CheckBox("checkbox"));
		}
		RootPanel.get().add(panel);
	}
	
	private void testHorizontalPanel() {
		HorizontalPanel panel = new HorizontalPanel();
		for (int i = 0; i < 10; i++) {
			panel.add(new CheckBox("checkbox"));
		}
		RootPanel.get().add(panel);
	}
	
	private void testVerticalPanel() {
		VerticalPanel panel = new VerticalPanel();
		for (int i = 0; i < 10; i++) {
			panel.add(new CheckBox("checkbox"));
		}
		RootPanel.get().add(panel);
	}
	
	private void testAbsolutePanel() {
		// 重要理解, 绝对布局面板
		AbsolutePanel panel = new AbsolutePanel();
		panel.setSize("200px", "200px");
		panel.add(new Button("button1"), 10, 10);
		panel.add(new Button("button2"), 30, 30);
		RootPanel.get().add(panel, 100, 100);
	}
	
	private void testTabPanel() {
		TabPanel panel = new TabPanel();
		panel.add(new Label("tab1"), "tab1");
		panel.add(new Label("tab2"), "tab2");
		panel.add(new Label("tab3"), "tab3");
		RootPanel.get().add(panel, 100, 100);
	}
	
	private void testScrollPanel() {
		ScrollPanel panel = new ScrollPanel();
		panel.setSize("100px", "100px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		for(int i = 0; i < 10; i++) {
			verticalPanel.add(new Button("按钮" + i));
		}
		panel.setWidget(verticalPanel);
		RootPanel.get().add(panel);
	}
}
