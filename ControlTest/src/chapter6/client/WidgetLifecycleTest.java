package chapter6.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class WidgetLifecycleTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Widget widget = new Button("child");
		Panel vPanel = new VerticalPanel();
		Panel hPanel = new HorizontalPanel();
		
		// vPanel (detach --> attach)
		RootPanel.get().add(vPanel);
		// widget (detach --> detach)
		hPanel.add(widget);
		// hpanel, widget (detach --> attach)
		vPanel.add(hPanel);
		// hpanel, widget (attach --> detach)
		vPanel.remove(hPanel);
	}
	
}
