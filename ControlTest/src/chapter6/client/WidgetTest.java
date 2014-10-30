package chapter6.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class WidgetTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Widget widget = new Button("button");
		widget.setTitle("button widget");
		RootPanel.get().add(widget);
		
		testEvent(widget);
		testLifeCycle(widget);
	}

	private void testEvent(Widget widget) {
		// TODO 比较抽象, 先放一放.
	}
	
	private void testLifeCycle(Widget widget) {
		// TODO 比较抽象, 先放一放.
	}
}
