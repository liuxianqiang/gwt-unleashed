package chapter6.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import static chapter6.client.UIHelper.*;

public class GlobalTest implements EntryPoint {
	private long event1;
	private long event2;
	
	@Override
	public void onModuleLoad() {
		testDOM();
//		testGWT();
//		testWindow();
	}
	
	private void testDOM() {
		Button noEventButton = new Button("无法点击的按钮");
		noEventButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("看不到这个消息");
				Window.alert("event1: " + event1 + " event2: " + event2);
			}
		});
		
		Button captureButton = new Button("捕获鼠标的按钮");
		captureButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Button captureButton = (Button) event.getSource();
				Window.alert("都被我捕获了");
				
//				DOM.setCapture(captureButton.getElement());
//				DOM.releaseCapture(captureButton.getElement());
				
				log("CaptureElement: " + DOM.getCaptureElement());
				Window.alert("event1: " + event1 + " event2: " + event2);
			}
		});

		// 全局事件 拦截器, //还是不要用, 拦截的事件太多了.
		Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {
				Object source = event.getSource();
				log("source: " + source);
				log("pre handle 1");
				event1++;
				
				event.cancel();
			}
		});
		
		Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {
				Object source = event.getSource();
				log("source: " + source);
				log("pre handle 2");
				event2++;
				
				event.consume();
			}
		});
		
		DOM.setCapture(captureButton.getElement());
		RootPanel.get().add(noEventButton);
		RootPanel.get().add(captureButton);
		
		// 其他 DOM 操作
	}
	
	private void testGWT() {
		next("GWT");
		log("HostPageBaseURL: " + GWT.getHostPageBaseURL());
		log("ModuleBaseURL: " + GWT.getModuleBaseURL());
		log("ModuleName: " + GWT.getModuleName());
		log("isClient: " + GWT.isClient());
		log("isProdMode: " + GWT.isProdMode());
		log("isScript: " + GWT.isScript());
		log("version: " + GWT.getVersion());
		GWT.log("gwt log"); // TODO 没有效果
		
//		GWT.create(); // 延迟绑定, 参考UIBinder技术
		
		// 捕获异常  TODO 没有效果
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
			@Override
			public void onUncaughtException(Throwable e) {
				log("发现未捕获的异常");
			}
		});
		log("UncaughtExceptionHandler: " + GWT.getUncaughtExceptionHandler());
		next();
		double d = 3 / 0;
	}
	
	private void testWindow() {
		next("Window");
		log("ClientWidth: " + Window.getClientWidth());
		log("ClientHeight: " + Window.getClientHeight());
		log("ScrollLeft: " + Window.getScrollLeft());
		log("ScrollTop: " + Window.getScrollTop());
		
		// 五种提示
		next();
		Window.alert("alert");
		log(Window.confirm("confirm"));
		log(Window.prompt("msg", "init"));
		Window.setStatus("status");
		Window.setTitle("title");
		log("title: " + Window.getTitle());
		
		next();
		Window.open("http://www.baidu.com/", "_blank", "left=150px,top=150px,width=300px,height=300px");
		
		next();
		Window.print();
		
		next();
//		Window.moveBy(dx, dy)
//		Window.moveTo(x, y)
//		
//		Window.resizeBy(width, height)
//		Window.resizeTo(width, height)
		
		Window.enableScrolling(true);
		Window.scrollTo(100, 100);
		
//		Window.addCloseHandler(handler);
//		Window.addWindowClosingListener(listener)
//		Window.addResizeHandler(handler);
//		Window.addWindowScrollHandler(handler);
	}
}
