package demo2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HelloWorld6 extends Composite {
	interface MyUiBinder extends UiBinder<Widget, HelloWorld6> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField(provided = true) Button mybutton;
	
	public HelloWorld6(String buttonText) {
		this.mybutton = new Button(buttonText);
		initWidget(uiBinder.createAndBindUi(this));
	}
}
