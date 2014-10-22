package demo2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HelloWorld2 extends Composite {
	interface MyUiBinder extends UiBinder<Widget, HelloWorld2> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField Button mybutton;
	
	@UiHandler("mybutton")
	void onClick(DoubleClickEvent e) {
		Window.alert("Hello, AJAX");
	}
	 
	public HelloWorld2(String buttonText) {
		initWidget(uiBinder.createAndBindUi(this));
		mybutton.setText(buttonText);
	}
	
	
}
