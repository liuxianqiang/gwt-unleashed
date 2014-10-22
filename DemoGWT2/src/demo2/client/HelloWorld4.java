package demo2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HelloWorld4 extends Composite {
	interface MyUiBinder extends UiBinder<Widget, HelloWorld4> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	 
	public HelloWorld4(String buttonText) {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
