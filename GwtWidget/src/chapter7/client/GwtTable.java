package chapter7.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class GwtTable implements EntryPoint {

	@Override
	public void onModuleLoad() {
//		testGrid();
		testFlexTable();
	}

	private void testGrid() {
		Grid grid = new Grid(3, 2);
		grid.setBorderWidth(1);
		grid.setCellSpacing(0);
		grid.setCellPadding(0);
		
		grid.setWidget(0, 0, new Label("编号"));
		grid.setWidget(0, 1, new Label("名字"));
		grid.setWidget(1, 0, new Label("1"));
		grid.setWidget(1, 1, new Label("ColinLiu"));
		grid.setWidget(2, 0, new Label("2"));
		grid.setWidget(2, 1, new Label("LiuXianQiang"));
		
		
		RootPanel.get().add(grid);
	}
	
	private void testFlexTable() {
		FlexTable grid = new FlexTable();
		grid.setBorderWidth(1);
		grid.setCellPadding(0);
		grid.setCellSpacing(0);
		
		FlexCellFormatter cellFormatter = (FlexCellFormatter)grid.getCellFormatter();
		cellFormatter.setAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_BOTTOM);
		cellFormatter.setAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_BOTTOM);
		cellFormatter.setColSpan(1, 0, 2);
		cellFormatter.setColSpan(2, 0, 2);
		grid.setWidget(0, 0, new Label("编号"));
		grid.setWidget(0, 1, new Label("名字"));
		grid.setWidget(1, 0, new Label("1 --> Colin Liu"));
		grid.setWidget(2, 0, new Label("2 --> Liu Xian Qiang"));
		RootPanel.get().add(grid);
	}
}
