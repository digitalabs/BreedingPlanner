package com.gui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import java.lang.Object;
import java.util.List;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import java.lang.String;
import org.eclipse.jface.viewers.ILabelProviderListener;

import com.io.InputInfoItem;
import com.io.InputInfoMang;
import com.io.InputInfoMangMABC;
import com.io.InputInfoMangMAS;
import com.overall.BreProcess;


public class MiddleComposite extends Composite {
    
	private String processType = null;  //  @jve:decl-index=0:
	private Table table = null;
	private TableViewer tableViewer = null;
	private List<InputInfoItem> inputInfoList = null;  //  @jve:decl-index=0:
	
	
	public TableViewer getTableViewer() 
	{
		return tableViewer;
	}
	public MiddleComposite(Composite parent, int style, String processType1) 
	{
		super(parent, style);
		processType=processType1;
		initialize();
	}	
	private void initData(){
		if(processType=="MARS")
		{
        InputInfoMang mang = new InputInfoMang(BreProcess.getXMLPathAndName());
		inputInfoList = mang.createList();
		}
		else if(processType=="MABC")
		{
			InputInfoMangMABC mang = new InputInfoMangMABC(BreProcess.getXMLPathAndName());
			inputInfoList = mang.createList();
		}
		else if(processType=="MAS")
		{
        InputInfoMangMAS mang = new InputInfoMangMAS(BreProcess.getXMLPathAndName());
		inputInfoList = mang.createList();
		}
		else
		{
			
		}
	}
	public void refreshForTable(){
		initData();
		tableViewer.refresh();
	}
	private void initialize() 
	{
		initData();		
		tableViewer = new TableViewer(this,SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(60);//参数改为80-40
		tableColumn.setText("ID");
		TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);
		tableColumn1.setWidth(220);
		tableColumn1.setText("Name");
		TableColumn tableColumn2 = new TableColumn(table, SWT.NONE);
		tableColumn2.setWidth(100);//参数改为80-100,初始值
		tableColumn2.setText("Value");
		this.setLayout(new FillLayout());
		this.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		
	    tableViewer.setLabelProvider(new ITableLabelProvider(){
			public Image getColumnImage(Object arg0, int arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			public String getColumnText(Object arg0, int arg1) {
				// TODO Auto-generated method stub
				InputInfoItem item = (InputInfoItem) arg0;
				if( arg1 == 0 ){
					return item.getId();
				}
				if( arg1 == 1 ){
					return item.getName();
				}
				if( arg1 == 2 ){
					return item.getValue();
				}
				return null;

			}

			public void addListener(ILabelProviderListener arg0) {
			}

			public void dispose() {
			}

			public boolean isLabelProperty(Object arg0, String arg1) {
				// TODO Auto-generated method stub
				return false;

			}

			public void removeListener(ILabelProviderListener arg0) {
			}
		});

		tableViewer.setContentProvider(new IStructuredContentProvider() {

			public Object[] getElements(Object arg0) {
				// TODO Auto-generated method stub
				return inputInfoList.toArray();
			}

			public void dispose() {
			}

			public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
			}
		});
		
		tableViewer.setInput(inputInfoList);
		
	}

} // @jve:decl-index=0:visual-constraint="10,10"
