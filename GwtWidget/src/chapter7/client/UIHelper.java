package chapter7.client;

import com.google.gwt.user.client.Window;

public class UIHelper {
	public static boolean next() {
		return next("next ?");
	}
	
	public static boolean next(String message) {
		return Window.confirm(message);
	}
	
	public static native void log(Object obj) /*-{
		console.log(obj);
	}-*/;
}
