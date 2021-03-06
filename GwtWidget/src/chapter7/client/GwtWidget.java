package chapter7.client;

import static chapter7.client.UIHelper.log;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.event.logical.shared.ShowRangeEvent;
import com.google.gwt.event.logical.shared.ShowRangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

public class GwtWidget implements EntryPoint {

	@Override
	public void onModuleLoad() {
//		testWrap();
//		testAnchor();
//		testButton();
//		testCheckBox();
//		testRadioButton();
//		testDatePicker();
//		testFileUpload();
//		testListBox();
//		testTree();
		testMenuBar();
	}
	
	private void testWrap() {
		Element e = DOM.getElementById("btn");
		e.getStyle().setDisplay(Display.BLOCK);
		
		Button btn = Button.wrap(e); // wrap a element
		btn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("点击按钮");
			}
		});
	}

	private void testAnchor() {
		Anchor a = new Anchor("<font color='red'>链接</font>", true, "http://www.baidu.com", "_self");
		RootPanel.get().add(a);
	}
	
	private void testButton() {
		Button btn = new Button("<font color='red'>按钮</font>", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("点击按钮");
			}
		});
		RootPanel.get().add(btn);
	}
	
	private void testCheckBox() {
		CheckBox cb1 = new CheckBox("鱼");
		CheckBox cb2 = new CheckBox("熊掌");
		cb1.setName("choose");
		cb2.setName("choose");
		
		RootPanel.get().add(cb1);
		RootPanel.get().add(cb2);
	}
	
	private void testRadioButton() {
		RadioButton rb1 = new RadioButton("gender", "男");
		RadioButton rb2 = new RadioButton("gender", "女");
		
		RootPanel.get().add(rb1);
		RootPanel.get().add(rb2);
	}
	
	private void testDatePicker() {
		final DatePicker dp = new DatePicker();
//		dp.setYearAndMonthDropdownVisible(true);
//		dp.setYearArrowsVisible(true);
//		dp.setVisibleYearCount(3);
		final DateTimeFormat dateFormat = DateTimeFormat.getFormat("yyyy-MM-dd");
		dp.setTransientEnabledOnDates(false, dateFormat.parse("2014-11-05"));
		
		dp.addShowRangeHandler(new ShowRangeHandler<Date>() {
			@Override
			public void onShowRange(ShowRangeEvent<Date> event) {
				Date startDate = event.getStart();
				Date endDate = event.getEnd();
				
				log(dp.isDateVisible(startDate));
				log(dp.isDateEnabled(startDate));
				
				log(dp.isDateVisible(endDate));
				log(dp.isDateEnabled(endDate));
				
				log(dateFormat.format(startDate));
				log(dateFormat.format(endDate));
			}
		});
		
		dp.addValueChangeHandler(new ValueChangeHandler<Date>() {
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date selectedDate = event.getValue();
				Window.alert(dateFormat.format(selectedDate));
			}
		});
		RootPanel.get().add(dp);
	}
	
	private void testFileUpload() {
		FormPanel form = new FormPanel();
		form.setAction("http://www.baidu.com/");
		form.setMethod(FormPanel.METHOD_POST);
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		// 提交前触发
		form.addSubmitHandler(new FormPanel.SubmitHandler() {
			@Override
			public void onSubmit(SubmitEvent event) {
				if(!Window.confirm("upload the file ?")) {
					event.cancel();
				}
			}
		});
		// 提交后触发
		form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				Window.alert(event.getResults());
			}
		});
		
		
		{
			VerticalPanel vPanel = new VerticalPanel();
		
			FileUpload fu = new FileUpload();
			fu.setName("file");
			vPanel.add(fu);
		
			Button submit = new SubmitButton("上传");
			vPanel.add(submit);
			
			form.setWidget(vPanel);
		}
		
		RootPanel.get().add(form);
	}
	
	private void testListBox() {
		ListBox listBox = new ListBox(false);
		listBox.addItem("加盟商", "1");
		listBox.addItem("一级渠道", "2");
		listBox.addItem("二级渠道", "3");
		// 无法很方便的设定和取值.
		RootPanel.get().add(listBox);
	}
	
	private void testSuggestBox() {
		MultiWordSuggestOracle suggestOracle = new MultiWordSuggestOracle(); 
		suggestOracle.add("google");
		suggestOracle.add("gooogle");
		suggestOracle.add("goooogle");
		// GWT RPC 实现的SuggestOracle可以参考MultiWordSuggestOracle
		SuggestBox suggestBox = new SuggestBox(suggestOracle);
		RootPanel.get().add(suggestBox);
	}
	
	private void testTree() {
		Tree tree = new Tree();
		tree.setSize("100px", "200px");
		TreeItem parent = tree.addItem(new CheckBox("parent"));
		parent.addItem(new CheckBox("child1"));
		parent.addItem(new CheckBox("child2"));
		parent.addItem(new CheckBox("child3")).addItem(new CheckBox("child31"));
		
		tree.addOpenHandler(new OpenHandler<TreeItem>() {
			@Override
			public void onOpen(OpenEvent<TreeItem> event) {
				TreeItem target = event.getTarget();
				Window.alert(target.getText());
			}
		});
		RootPanel.get().add(tree);
		
	}
	
	private void testMenuBar() {
		MenuBar topMenuBar = new MenuBar();
		
		MenuBar fileMenuBar = new MenuBar(true);
		topMenuBar.addItem("File", fileMenuBar);
		
		fileMenuBar.addItem("Open", new Scheduler.ScheduledCommand() {
			@Override
			public void execute() {
				Window.alert("open file");	
			}
		});
		
		fileMenuBar.addSeparator();
		
		fileMenuBar.addItem("Close", new Scheduler.ScheduledCommand() {
			@Override
			public void execute() {
				Window.alert("close file");	
			}
		});
		
		RootPanel.get().add(topMenuBar);
	}
}
