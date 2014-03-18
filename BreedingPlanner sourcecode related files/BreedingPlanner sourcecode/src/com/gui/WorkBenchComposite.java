package com.gui;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class WorkBenchComposite extends Composite {

	private SashForm sashForm = null;
	private Composite composite = null;
	private Composite composite1 = null;
	private SashForm sashForm1 = null;
	private CTabFolder cTabFolder = null;
	private CTabFolder cTabFolder1 = null;
	private Label label1 = null;
	private CTabFolder cTabFolder2 = null;
	private CTabItem cTabItem = null;
	private CTabItem cTabItem1 = null;
	private CTabItem cTabItem2 = null;
	private Table table = null;
	private TableViewer tableViewer = null;
	
	public CTabFolder getcTabFolder2() {
		return cTabFolder2;
	}

	public CTabFolder getcTabFolder() {
		return cTabFolder;
	}

	public CTabFolder getcTabFolder1() {
		return cTabFolder1;
	}

	public SashForm getSashForm() {
		return sashForm;
	}

	public SashForm getSashForm1() {
		return sashForm1;
	}

	public WorkBenchComposite(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		setLayout(new FillLayout());
		createSashForm();
		
	}

	/**
	 * This method initializes sashForm	
	 *
	 */
	private void createSashForm() {
		sashForm = new SashForm(this, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);
		createComposite();
		createComposite1();
		sashForm.setWeights(new int[]{3,1});//此处改动为4：:1
	}

	/**
	 * This method initializes composite	
	 *
	 */
	private void createComposite() {
		composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new FillLayout());
		composite.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		createSashForm1();
	}

	/**
	 * This method initializes composite1	
	 *
	 */
	private void createComposite1()
	{
		composite1 = new Composite(sashForm, SWT.NONE);//添加min
		composite1.setLayout(new FillLayout());		
		composite1.setVisible(true);
		composite1.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		createCTabFolder2();
	}

	/**
	 * This method initializes sashForm1	
	 *
	 */
	private void createSashForm1() {
		sashForm1 = new SashForm(composite, SWT.NONE);
		createCTabFolder();
		createCTabFolder1();
		sashForm1.setWeights(new int[]{4,6});//参数后一个由5改为6
	}	
	/**
	 * This method initializes cTabFolder	
	 *
	 */
	private void createCTabFolder() {
		cTabFolder = new CTabFolder(sashForm1, SWT.BORDER);
		cTabFolder.setSimple(false);
		createCTabItem();
		cTabFolder.setSelection(cTabItem);
		
	}
	public void createCTabItem() 
	{
		cTabItem = new CTabItem(cTabFolder,SWT.NONE);
		cTabItem.setText("Parameters");
		Composite composite0 = new Composite(cTabFolder,SWT.NONE);
		cTabItem.setControl(composite0);		
	}

	/**
	 * This method initializes cTabFolder1	
	 *
	 */
	private void createCTabFolder1() 
	{
		cTabFolder1 = new CTabFolder(sashForm1, SWT.BORDER|SWT.NONE);//此处先去掉	SWT.NONE
		cTabFolder1.setSimple(false);
		createCTabItem1();
		cTabFolder1.setSelection(cTabItem1);
	}	
	public void createCTabItem1() 
	{
		cTabItem1 = new CTabItem(cTabFolder1,SWT.NONE);
		cTabItem1.setText("Breeding scheme");
		Composite composite0 = new Composite(cTabFolder1,SWT.NONE);
		cTabItem1.setControl(composite0);
	}
	/**
	 * This method initializes cTabFolder2	
	 *
	 */
	private void createCTabFolder2()
	{
		cTabFolder2 = new CTabFolder(composite1, SWT.BORDER);//此处添加SWT.MIN
		cTabFolder2.setSimple(false);//光滑过渡的框体
		cTabFolder2.setVisible(true);
		createCTabItem2();
		cTabFolder2.setSelection(cTabItem2);	
	}
	public void createCTabItem2() {
		cTabItem2 = new CTabItem(cTabFolder2,SWT.NONE);//NONE改为MIN,没成功
		cTabItem2.setText("Make a Plan");
		Composite composite0 = new Composite(cTabFolder2,SWT.NONE);//NONE改为MIN
		cTabItem2.setControl(composite0);
	}
}
