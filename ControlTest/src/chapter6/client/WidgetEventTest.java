package chapter6.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import static chapter6.client.UIHelper.*;

public class WidgetEventTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		test1();
//		test2();
	}
	
	
	private void test1() {
		MyFlowPanel panel = new MyFlowPanel();
		panel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("捕获了一个冒泡事件!");
			}
		});
		
		Anchor link = new Anchor("百度", false, "http://www.baidu.com");
		link.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!Window.confirm("确定要跳转到百度页面?")) {
					event.preventDefault();
				}
				
				if (Window.confirm("确定要阻止事件冒泡?")) {
					event.stopPropagation();
				}
			}
		});
		
		panel.add(link);
		RootPanel.get().add(panel);
	}
	
	private void test2() {
		TextBox textBox = new TextBox() {
			@Override
			public void onBrowserEvent(Event event) {
				// 事件类型匹配, GWT事件类型用二进制表示
				int type = DOM.eventGetType(event);
				if (((type & Event.KEYEVENTS) != 0) || ((type & Event.MOUSEEVENTS) != 0)) {
					log("on browser event...");
				}
				super.onBrowserEvent(event);
			}
		};
		
		// 注册事件
		textBox.sinkEvents(Event.KEYEVENTS);
		textBox.sinkEvents(Event.MOUSEEVENTS);
		RootPanel.get().add(textBox);
	}
	
	public static class MyFlowPanel extends FlowPanel {

		public MyFlowPanel() {
			super();
			getElement().getStyle().setProperty("border", "black solid 1px");
		}

		public HandlerRegistration addClickHandler(ClickHandler handler) {
			return addDomHandler(handler, ClickEvent.getType());
		}
	}
}
