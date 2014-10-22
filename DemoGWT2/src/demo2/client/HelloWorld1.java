package demo2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class HelloWorld1 extends Widget {
	interface MyUiBinder extends UiBinder<DivElement, HelloWorld1> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField InputElement mybutton;
	 
	public HelloWorld1(String buttonText) {
		setElement(uiBinder.createAndBindUi(this));
		mybutton.setValue(buttonText);
	}
}
