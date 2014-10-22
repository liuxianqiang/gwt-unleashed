package demo2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HelloWorld5 extends Composite {
	interface MyUiBinder extends UiBinder<Widget, HelloWorld5> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField Button mybutton;
	
	public HelloWorld5(String buttonText) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiFactory Button makeButtons(String buttonName) {
		System.out.println("--------create a button----------");
		return new Button(buttonName);
	}
	
}
