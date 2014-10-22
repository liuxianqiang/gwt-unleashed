package demo2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class HelloWorld3 extends Widget {
	interface MyUiBinder extends UiBinder<DivElement, HelloWorld3> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface Style extends CssResource {
		String redbox();
	}
	
	@UiField Style four;
	
	public HelloWorld3(String buttonText) {
		DivElement div = uiBinder.createAndBindUi(this);
		div.setClassName(four.redbox());
		setElement(div);
	}
}
