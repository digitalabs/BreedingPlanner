package com.gui;

import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Filter;
import java.lang.Object;

import javax.swing.*;
import java.awt.*;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;

import com.gui.TreeActionGroup.ModifyDataAction;
import com.gui.wizard.InputComposite;
import com.gui.wizard.InputCompositeMABC;
import com.gui.wizard.InputCompositeMAS;
import com.gui.wizard.InputCompositeMAS2;
import com.gui.wizard.InputWizard;
import com.gui.wizard.InputWizardMABC;
import com.gui.wizard.InputWizardMAS;
import com.gui.wizard.InputWizardPage;
import com.gui.wizard.InputWizardPageMABC;
import com.gui.wizard.InputWizardPageMAS;
import com.gui.wizard.ModifyWizard;
import com.gui.wizard.ModifyWizardMABC;
import com.gui.wizard.ModifyWizardMAS;
import com.gui.wizard.NewProjectWizard;
import com.gui.dialog.*;
import com.overall.Project;
import com.overall.Validate;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import sun.reflect.generics.tree.Tree;

 public class MainShell
{	
	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="-9,0"
	private Menu menuBar = null;
	private Menu submenu = null;
	private Menu submenu2 = null;
	private Menu submenu3 = null;
	private Menu submenu1 = null;
	private static SashForm sashForm = null;
	private static LeftComposite lc = null;
	private static WorkBenchComposite wbc = null;
	private static MenuItem push11 = null;
	private static MenuItem push10 = null;
	private static MenuItem push7 = null;
	private static MenuItem push6 = null;
	private static MenuItem push8 = null;
	private static MenuItem push9 = null;
	private static MenuItem push2 = null;
	private static MenuItem push5 = null;	
	private CTabFolder cTabFolder = null;
    private CTabFolder cTabFolder1 = null;	
	private CTabItem cTabItem = null;
	private CTabItem cTabItem1 = null;
	private CTabFolder cTabFolder2 = null;
	private CTabItem cTabItem2 = null;
	
	public static MenuItem getPush11() {
		return push11;
	}
	public static MenuItem getPush10() {
		return push10;
	}
	public static MenuItem getPush7() {
		return push7;
	}
	public static MenuItem getPush6() {
		return push6;
	}
	public static MenuItem getPush8() {
		return push8;
	}
	public static MenuItem getPush9() {
		return push9;
	}
	public static MenuItem getPush2() 
	{
		return push2;
	}
	
	public static MenuItem getPush5() {
		return push5;
	}	
	public static WorkBenchComposite getWbc() {
		return wbc;
	}

	public static LeftComposite getLc() {
		return lc;
	}

	public static SashForm getSashForm() {
		return sashForm;
	}	
	public Image img1 = new Image(Display.getCurrent(),getClass().getResourceAsStream(Messages.getString("MainShell.0")));  //  @jve:decl-index=0: //$NON-NLS-1$	
	/**
	 * This method initializes sashForm	
	 *
	 */
	private void createSashForm() 
	{
		sashForm = new SashForm(sShell, SWT.NONE);
		lc = new LeftComposite(getSashForm(), SWT.NONE);
		wbc = new WorkBenchComposite(sashForm,SWT.NONE);
		sashForm.setWeights(new int[]{1,3});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Before this is run, be sure to set up the launch configuration (Arguments->VM Arguments)
		 * for the correct SWT library path in order to run with the SWT dlls. 
		 * The dlls are located in the SWT plugin jar.  
		 * For example, on Windows the Eclipse SWT 3.1 plugin jar is:
		 *       installation_directory\plugins\org.eclipse.swt.win32_3.1.0.jar
		 */		
		final Display display = Display.getDefault();
		MainShell thisClass = new MainShell();
		thisClass.createSShell();
		thisClass.sShell.open();
						
		while (!thisClass.sShell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	/**
	 * This method initializes sShell
	 */
	private void createSShell() 
	{
		sShell = new Shell();
		sShell.setLayout(new FillLayout());
		sShell.setText(Messages.getString("MainShell.1"));//改动删除MBP //$NON-NLS-1$
		sShell.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream(Messages.getString("MainShell.2")))); //$NON-NLS-1$
		sShell.setBounds(new Rectangle(100, 10, 1200, 730));//面板的初始大小				
		createSashForm();
		menuBar = new Menu(sShell, SWT.BAR);
		MenuItem submenuItem = new MenuItem(menuBar, SWT.CASCADE);
		submenuItem.setText(Messages.getString("MainShell.3")); //$NON-NLS-1$
		MenuItem submenuItem1 = new MenuItem(menuBar, SWT.CASCADE);
		submenuItem1.setText(Messages.getString("MainShell.4")); //$NON-NLS-1$
		MenuItem submenuItem2 = new MenuItem(menuBar, SWT.CASCADE);
		submenuItem2.setText(Messages.getString("MainShell.5")); //$NON-NLS-1$
		MenuItem submenuItem3 = new MenuItem(menuBar, SWT.CASCADE);
		submenuItem3.setText(Messages.getString("MainShell.6")); //$NON-NLS-1$	
				
	//Project 下的选项	
		submenu = new Menu(submenuItem);
		MenuItem push = new MenuItem(submenu, SWT.PUSH);
		push.setText(Messages.getString("MainShell.7")); //$NON-NLS-1$
		push.addSelectionListener(new org.eclipse.swt.events.SelectionListener() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) 
			{				
				WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new NewProjectWizard());
				wd.setPageSize(300, 300);
				wd.open();
				
				if(MainShell.getWbc().getcTabFolder().getItemCount() == 0)
				{
					cTabItem = new CTabItem(MainShell.getWbc().getcTabFolder(), SWT.CLOSE);
				}else 
				{
					cTabItem = MainShell.getWbc().getcTabFolder().getItem(0);
				}
				cTabItem.setText("Parameters");
				String processType=null;
				//MiddleComposite mc = new MiddleComposite(MainShell.getWbc().getcTabFolder(), SWT.NONE, processType);
				cTabItem.setControl(cTabFolder);
				MainShell.getWbc().getcTabFolder().setSelection(cTabItem);
	            
				
				if(MainShell.getWbc().getcTabFolder1().getItemCount() == 0){
					cTabItem1 = new CTabItem(MainShell.getWbc().getcTabFolder1(), SWT.CLOSE);
				}else 
				{
					cTabItem1 = MainShell.getWbc().getcTabFolder1().getItem(0);
				}
				cTabItem1.setText("Breeding scheme");
				cTabItem1.setControl(cTabFolder1);
				MainShell.getWbc().getcTabFolder1().setSelection(cTabItem1);
				
				//新建文件后，清空底部make a plan 框体
	    		if(MainShell.getWbc().getcTabFolder2().getItemCount() == 0){
					cTabItem2 = new CTabItem(MainShell.getWbc().getcTabFolder2(), SWT.CLOSE);
				}else 
				{
					cTabItem2 = MainShell.getWbc().getcTabFolder2().getItem(0);
				}
				cTabItem2.setText("Make a Plan");
				cTabItem2.setControl(cTabFolder2);
				MainShell.getWbc().getcTabFolder2().setSelection(cTabItem2);
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
	//	Open project 这部分，怎么才能让打开的文档显示在软件中？？？
		MenuItem push1 = new MenuItem(submenu, SWT.PUSH);
		push1.setText(Messages.getString("MainShell.8")); //$NON-NLS-1$
		push1.addSelectionListener(new org.eclipse.swt.events.SelectionListener()
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) 
			{
				FileDialog fd = new FileDialog(sShell,SWT.OPEN);
				fd.setFilterExtensions(new String[]{Messages.getString("MainShell.9")}); //$NON-NLS-1$
				fd.open();
				if(!fd.getFileName().isEmpty())//改动添加\n
				{
					lc.getcTabFolder().getItem(0).setText(Messages.getString("MainShell.10") +Messages.getString("MainShell.11")+ fd.getFileName().split(Messages.getString("MainShell.12"))[0]); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					Project.setPath(fd.getFilterPath()) ;
					lc.getFileTree().getTreeViewer().setInput(new File(Project.getPath()));
					lc.getFileTree().getTreeViewer().refresh();
					lc.getFileTree().initExpand();
					
				}
				
				//新添加，在已经有文件打开的情况下，在打开工程要清空当前右边窗体
				if(MainShell.getWbc().getcTabFolder().getItemCount() == 0)
				{
					cTabItem = new CTabItem(MainShell.getWbc().getcTabFolder(), SWT.CLOSE);
				}else 
				{
					cTabItem = MainShell.getWbc().getcTabFolder().getItem(0);
				}
				cTabItem.setText("Parameters");
				String processType=null;
				//MiddleComposite mc = new MiddleComposite(MainShell.getWbc().getcTabFolder(), SWT.NONE, processType);
				cTabItem.setControl(cTabFolder);
				MainShell.getWbc().getcTabFolder().setSelection(cTabItem);
	            
				
				if(MainShell.getWbc().getcTabFolder1().getItemCount() == 0){
					cTabItem1 = new CTabItem(MainShell.getWbc().getcTabFolder1(), SWT.CLOSE);
				}else 
				{
					cTabItem1 = MainShell.getWbc().getcTabFolder1().getItem(0);
				}
				cTabItem1.setText("Breeding scheme");
				cTabItem1.setControl(cTabFolder1);
				MainShell.getWbc().getcTabFolder1().setSelection(cTabItem1);
				
				//新建文件后，清空底部make a plan 框体
	    		if(MainShell.getWbc().getcTabFolder2().getItemCount() == 0){
					cTabItem2 = new CTabItem(MainShell.getWbc().getcTabFolder2(), SWT.CLOSE);
				}else 
				{
					cTabItem2 = MainShell.getWbc().getcTabFolder2().getItem(0);
				}
				cTabItem2.setText("Make a Plan");
				cTabItem2.setControl(cTabFolder2);
				MainShell.getWbc().getcTabFolder2().setSelection(cTabItem2);
				
				
			}
			
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
	//关闭工程
		MenuItem push3 = new MenuItem(submenu, SWT.PUSH);
		push3.setText(Messages.getString("MainShell.13")); //$NON-NLS-1$
		MenuItem separator = new MenuItem(submenu, SWT.SEPARATOR);
		push3.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				lc.getcTabFolder().getItem(0).setText(Messages.getString("MainShell.14")); //$NON-NLS-1$
				lc.getFileTree().getTreeViewer().setInput(null);
				lc.getFileTree().setIsFolder(false);
				lc.getFileTree().setIsFile(false);
				lc.getFileTree().setIsExpanded(false);
				Project.setPath(null);
				
				push11.setEnabled(false);
				push10.setEnabled(false);
				push7.setEnabled(false);
				push6.setEnabled(false);
				push8.setEnabled(false);
				
				if(Validate.validateMiddleComposite(wbc.getcTabFolder())){
					wbc.getcTabFolder().getItem(0).dispose();
					wbc.createCTabItem();
					wbc.getcTabFolder().setSelection(wbc.getcTabFolder().getItem(0));					
				}
				
				if(Validate.validateRightComposite(wbc.getcTabFolder1())){
					wbc.getcTabFolder1().getItem(0).dispose();
					wbc.createCTabItem1();
					wbc.getcTabFolder1().setSelection(wbc.getcTabFolder1().getItem(0));					
				}
				
				if(Validate.validateRightCompositeMABC(wbc.getcTabFolder1())){
					wbc.getcTabFolder1().getItem(0).dispose();
					wbc.createCTabItem1();
					wbc.getcTabFolder1().setSelection(wbc.getcTabFolder1().getItem(0));				
				}
				
				if(Validate.validateRightCompositeMAS(wbc.getcTabFolder1())){
					wbc.getcTabFolder1().getItem(0).dispose();
					wbc.createCTabItem1();
					wbc.getcTabFolder1().setSelection(wbc.getcTabFolder1().getItem(0));
					
				}
				if(Validate.validateBottomComposite(wbc.getcTabFolder2())){
					wbc.getcTabFolder2().getItem(0).dispose();
					wbc.createCTabItem2();
					wbc.getcTabFolder2().setSelection(wbc.getcTabFolder2().getItem(0));
					
				}
				if(Validate.validateBottomCompositeMABC(wbc.getcTabFolder2())){
					wbc.getcTabFolder2().getItem(0).dispose();
					wbc.createCTabItem2();
					wbc.getcTabFolder2().setSelection(wbc.getcTabFolder2().getItem(0));
					
				}
				if(Validate.validateBottomCompositeMAS(wbc.getcTabFolder2())){
					wbc.getcTabFolder2().getItem(0).dispose();
					wbc.createCTabItem2();
					wbc.getcTabFolder2().setSelection(wbc.getcTabFolder2().getItem(0));					
				}
				
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
		//Exit 菜单
		MenuItem push4 = new MenuItem(submenu, SWT.PUSH);
		push4.setText(Messages.getString("MainShell.15")); //$NON-NLS-1$
		push4.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				sShell.dispose();
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		submenuItem.setMenu(submenu);
				
//子菜单Task		
		submenu1 = new Menu(submenuItem1);
		submenu1.addMenuListener(new org.eclipse.swt.events.MenuListener() {
			public void menuShown(org.eclipse.swt.events.MenuEvent e) {
				if(Project.getPath()==null)
				{
					push11.setEnabled(false);
					push10.setEnabled(false);
					push7.setEnabled(false);					
				}
				else
				{
					push11.setEnabled(true);
					push10.setEnabled(true);
					push7.setEnabled(true);
				}				
			}
			public void menuHidden(org.eclipse.swt.events.MenuEvent e) {
			}
		});
		//新建MARS 
		push11 = new MenuItem(submenu1, SWT.PUSH);
		push11.setText(Messages.getString("MainShell.16")); //$NON-NLS-1$
		push11.setEnabled(false);
		push11.addSelectionListener(new org.eclipse.swt.events.SelectionListener()
		{
			
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e)
			{				
				String processType = Messages.getString("MainShell.17"); //$NON-NLS-1$
	    		File file = new File(Project.getPath());
	    		int processIndex = 1;	    			    		
	    		File[] files = file.listFiles();
	    		
	    		boolean isE=true;
	    		while(isE)
	    		{
	    			boolean isE1=false;
	    			for(int i = 0;i<files.length;i++)
	    			{
	    				String na=processType+Integer.toString(processIndex);
	    				String name1=files[i].getName();
	    			    if(name1.equals(na))//如果里面有同名的文件，isE1 = true;
	    			    {
	    			       isE1=true;		
	    			    }
	    			}
	    			if(isE1)
	    			{
	    				isE=true;
	    				processIndex++;
	    			}
	    			else
	    			{
	    				isE=false;
	    			}
	    		}
	    		
	    		WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new InputWizard(processType,processIndex));
	    		wd.setPageSize(650, 550);
	    		wd.open();
	    		
	    		File subfile = new File(Project.getPath() + Messages.getString("MainShell.18") + processType + processIndex); //$NON-NLS-1$	    	
	    		String name =  processType + processIndex;
	    		MainShell.getLc().getFileTree().getTreeViewer().add(Project.getPath(), subfile);	    		
	    		MainShell.getLc().getFileTree().getTreeViewer().refresh();
	    			    			    		
			    for(int i = 0 ; i < files.length ; i ++)
			      {
				MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(files[i], false);
			      }
			    MainShell.getLc().getFileTree().initExpand();
	    		MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(subfile, true);
	    		MainShell.getLc().getFileTree().setFormerFile(subfile);
	    			    		
	    		TreeItem[] ti =  MainShell.getLc().getFileTree().getTreeViewer().getTree().getItems();
	    		for(TreeItem t:ti)
	    		{
	    			if(name.equals(t.getText()))
	    			{
	    				MainShell.getLc().getFileTree().setSelection(t);
	    				break;
	    			}
	    		}
	    		
	    		//新建文件后，清空底部make a plan 框体
	    		if(MainShell.getWbc().getcTabFolder2().getItemCount() == 0){
					cTabItem2 = new CTabItem(MainShell.getWbc().getcTabFolder2(), SWT.CLOSE);
				}else 
				{
					cTabItem2 = MainShell.getWbc().getcTabFolder2().getItem(0);
				}
				cTabItem2.setText("Make a Plan");
				cTabItem2.setControl(cTabFolder2);
				MainShell.getWbc().getcTabFolder2().setSelection(cTabItem2);
				
	    		
	    		
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) 
			{
			}

		});
		
		//新建MABC
		push10 = new MenuItem(submenu1, SWT.PUSH);
		push10.setText(Messages.getString("MainShell.19")); //$NON-NLS-1$
		push10.setEnabled(false);
		push10.addSelectionListener(new org.eclipse.swt.events.SelectionListener() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e)
			{
				String processType = Messages.getString("MainShell.20"); //$NON-NLS-1$
	    		File file = new File(Project.getPath());
	    		int processIndex = 1;//索引号
	    		File[] files = file.listFiles();
	    		boolean isE=true;
	    		while(isE)
	    		{
	    			boolean isE1=false;
	    			for(int i = 0;i<files.length;i++){
	    				String na=processType+Integer.toString(processIndex);
	    				String name1=files[i].getName();
	    			    if(name1.equals(na))
	    			    {
	    			       isE1=true;		
	    			    }
	    			}
	    			if(isE1)
	    			{
	    				isE=true;
	    				processIndex++;
	    			}
	    			else
	    			{
	    				isE=false;
	    			}
	    		}
	    		
	    		WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new InputWizardMABC(processType,processIndex));
	    		wd.setPageSize(650, 550);
	    		wd.open();
	    		
	    		File subfile = new File(Project.getPath() + Messages.getString("MainShell.21") + processType + processIndex); //$NON-NLS-1$
	    			    		
	    		String name =  processType + processIndex;
	    		MainShell.getLc().getFileTree().getTreeViewer().refresh();
	    		//MainShell.getLc().getFileTree().initExpand();
				for(int i = 0 ; i < files.length ; i ++)
				{
				MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(files[i], false);
				}
				MainShell.getLc().getFileTree().initExpand();
	    		MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(subfile, true);
	    		MainShell.getLc().getFileTree().setFormerFile(subfile);	    		 
	    		TreeItem[] ti =  MainShell.getLc().getFileTree().getTreeViewer().getTree().getItems();
	    		for(TreeItem t:ti)
	    		{
	    			if(name.equals(t.getText())){
	    				MainShell.getLc().getFileTree().setSelection(t);
	    				break;
	    			}
	    		}	
	    		
	    		//新建文件后，清空底部make a plan 框体
	    		if(MainShell.getWbc().getcTabFolder2().getItemCount() == 0){
					cTabItem2 = new CTabItem(MainShell.getWbc().getcTabFolder2(), SWT.CLOSE);
				}else 
				{
					cTabItem2 = MainShell.getWbc().getcTabFolder2().getItem(0);
				}
				cTabItem2.setText("Make a Plan");
				cTabItem2.setControl(cTabFolder2);
				MainShell.getWbc().getcTabFolder2().setSelection(cTabItem2);
				
			}
			
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
        //新建MAS
		push7 = new MenuItem(submenu1, SWT.PUSH);
		push7.setText(Messages.getString("MainShell.22")); //$NON-NLS-1$
		push7.setEnabled(false);
		push7.addSelectionListener(new org.eclipse.swt.events.SelectionListener() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e)
			{
				String processType = Messages.getString("MainShell.23"); //$NON-NLS-1$
	    		File file = new File(Project.getPath());
	    		int processIndex = 1;
	    		File[] files = file.listFiles();
	    		boolean isE=true;
	    		while(isE)
	    		{
	    			boolean isE1=false;
	    			for(int i = 0;i<files.length;i++){
	    				String na=processType+Integer.toString(processIndex);
	    				String name1=files[i].getName();
	    			    if(name1.equals(na))
	    			    {
	    			       isE1=true;		
	    			    }
	    			}
	    			if(isE1)
	    			{
	    				isE=true;
	    				processIndex++;
	    			}
	    			else
	    			{
	    				isE=false;
	    			}
	    		}
	    		WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new InputWizardMAS(processType,processIndex));
	    		wd.setPageSize(650, 550);
	    		wd.open();
	    		
	    		File subfile = new File(Project.getPath() + Messages.getString("MainShell.24") + processType + processIndex); //$NON-NLS-1$	    		
	    		String name =  processType + processIndex;
	    		MainShell.getLc().getFileTree().getTreeViewer().refresh();
	    		//MainShell.getLc().getFileTree().initExpand();
				for(int i = 0 ; i < files.length ; i ++)
				{
					MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(files[i], false);
			    }
				MainShell.getLc().getFileTree().initExpand();
	    		MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(subfile, true);
	    		MainShell.getLc().getFileTree().setFormerFile(subfile);
	    		TreeItem[] ti =  MainShell.getLc().getFileTree().getTreeViewer().getTree().getItems();
	    		for(TreeItem t:ti)
	    		{
	    			if(name.equals(t.getText()))
	    			{
	    				MainShell.getLc().getFileTree().setSelection(t);
	    				break;
	    			}
	    		}
	    		
	    		//新建文件后，清空底部make a plan 框体
	    		if(MainShell.getWbc().getcTabFolder2().getItemCount() == 0){
					cTabItem2 = new CTabItem(MainShell.getWbc().getcTabFolder2(), SWT.CLOSE);
				}else 
				{
					cTabItem2 = MainShell.getWbc().getcTabFolder2().getItem(0);
				}
				cTabItem2.setText("Make a Plan");
				cTabItem2.setControl(cTabFolder2);
				MainShell.getWbc().getcTabFolder2().setSelection(cTabItem2);
	    		
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
		MenuItem separator1 = new MenuItem(submenu1, SWT.SEPARATOR);
		//修改参数
		
		push6 = new MenuItem(submenu1, SWT.PUSH);
		push6.setText(Messages.getString("MainShell.25")); //$NON-NLS-1$
		push6.setEnabled(false);
		push6.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				TreeItem[] ti = MainShell.getLc().getFileTree().getTreeViewer().getTree().getItems();
				///TreeItem t = MainShell.getLc().getFileTree()..getSelection();
				File file = MainShell.getLc().getFileTree().getFormerFile();
				if(file.getName().startsWith(Messages.getString("MainShell.26")))	    			
	    		{ 
	    			WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new ModifyWizard());
		    		wd.setPageSize(630, 500);
		    		wd.open();					
	    		}	    		
	    		else if(file.getName().startsWith(Messages.getString("MainShell.27"))) //$NON-NLS-1$
	    		{
					WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new ModifyWizardMABC());
		    		wd.setPageSize(630, 500);
		    		wd.open();
	    		}
	    		else if(file.getName().startsWith(Messages.getString("MainShell.28"))){ //$NON-NLS-1$
					WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new ModifyWizardMAS());
		    		wd.setPageSize(630, 500);
		    		wd.open();
	    		}
	    		else{
	    			
	    		}

			}

			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) 
			{
			}
		});
				
		push8 = new MenuItem(submenu1, SWT.PUSH);
		push8.setText(Messages.getString("MainShell.29")); //$NON-NLS-1$
		push8.setEnabled(false);
		push8.addSelectionListener(new org.eclipse.swt.events.SelectionListener() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) 
			{
				File file = lc.getFileTree().getSelectedFile();
				CTabItem cTabItem = MainShell.getWbc().getcTabFolder2().getItem(0);
	    		cTabItem.setText(Messages.getString("MainShell.30")); //$NON-NLS-1$
				if(file.getName().startsWith(Messages.getString("MainShell.31"))){ //$NON-NLS-1$
					BottomComposite bc = new BottomComposite(wbc.getcTabFolder2(),SWT.NONE);
		    		cTabItem.setControl(bc);
		    		wbc.getcTabFolder2().setSelection(cTabItem);
	    		}
				else if(file.getName().startsWith(Messages.getString("MainShell.32"))) //$NON-NLS-1$
				{
					BottomCompositeMABC bc = new BottomCompositeMABC(wbc.getcTabFolder2(),SWT.NONE);
		    		cTabItem.setControl(bc);
		    		wbc.getcTabFolder2().setSelection(cTabItem);
	    		}
				else if(file.getName().startsWith(Messages.getString("MainShell.33"))) //$NON-NLS-1$
				{
					BottomCompositeMAS bc = new BottomCompositeMAS(wbc.getcTabFolder2(),SWT.NONE);
		    		cTabItem.setControl(bc);
		    		wbc.getcTabFolder2().setSelection(cTabItem);
	    		}
				else{
					
				}
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		submenuItem1.setMenu(submenu1);
		
		submenu2 = new Menu(submenuItem2);
		push9 = new MenuItem(submenu2, SWT.PUSH);
		push9.setText(Messages.getString("MainShell.34")); //$NON-NLS-1$
		push9.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				sashForm.setMaximizedControl(null);
				
				if(lc.getcTabFolder().getItemCount() == 0){
					lc.createCTabItem();
					lc.getcTabFolder().setSelection(lc.getcTabFolder().getItem(0));
					if(Project.getPath() != null){
						MainShell.getLc().getcTabFolder().getItem(0).setText(Messages.getString("MainShell.35") + new File(Project.getPath()).getName()); //$NON-NLS-1$
					}
				}
				
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		

		submenuItem2.setMenu(submenu2);
		
		submenu3 = new Menu(submenuItem3);
		push2 = new MenuItem(submenu3, SWT.PUSH);
		push2.setText(Messages.getString("MainShell.36")); //$NON-NLS-1$
		
		MenuItem push12 = new MenuItem(submenu3, SWT.PUSH);
		push12.setText(Messages.getString("MainShell.37")); //$NON-NLS-1$
		push12.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		}); 
		
		MenuItem push13 = new MenuItem(submenu3, SWT.PUSH);
		push13.setText(Messages.getString("MainShell.38")); //$NON-NLS-1$
		push13.addSelectionListener(new org.eclipse.swt.events.SelectionListener() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) 
			{
				//System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
				String jarPath=Messages.getString("MainShell.39"); //$NON-NLS-1$
				String jarPathF=Messages.getString("MainShell.40"); //$NON-NLS-1$
				String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
                  try
                  {
                     path = java.net.URLDecoder.decode(path, Messages.getString("MainShell.41")); //$NON-NLS-1$
                  }
                  catch (java.io.UnsupportedEncodingException ee)
                  {
                     ee.printStackTrace();
                  }
                  java.io.File jarFile = new java.io.File(path);
                  java.io.File parent = jarFile.getParentFile();
                  if (parent != null)
                  {
                     jarPath = parent.getAbsolutePath();
                  }
                  try
                  {
                	  jarPathF=java.net.URLDecoder.decode(jarPath, Messages.getString("MainShell.42")); //$NON-NLS-1$
                  }
                  catch (java.io.UnsupportedEncodingException ee)
                  {
                      ee.printStackTrace();
                  }
				
                  
                  
 				String filepath=jarPathF +Messages.getString("MainShell.43"); //$NON-NLS-1$
				File aaa=new File(filepath);
				if(!aaa.exists()) 
				{
					MessageDialog.openInformation(sShell, Messages.getString("MainShell.44"), Messages.getString("MainShell.45")); //$NON-NLS-1$ //$NON-NLS-2$
					return;
					}
			    String commandStr=Messages.getString("MainShell.46")+Messages.getString("MainShell.47") +filepath.replace(Messages.getString("MainShell.48"), Messages.getString("MainShell.49"));     //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			    try {
			    	//MessageDialog.openInformation(sShell, "Tutorial",commandFile);
			    	Runtime.getRuntime().exec(commandStr);    
			    	} catch(IOException ea) {            
			    		ea.printStackTrace(); 
			    		//MessageDialog.openInformation(sShell, "Tutorial",ea.getMessage());			    		
			    		}			    	
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
		push12.addSelectionListener(new org.eclipse.swt.events.SelectionListener() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				//System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
				String jarPath=Messages.getString("MainShell.50"); //$NON-NLS-1$
				String jarPathF=Messages.getString("MainShell.51"); //$NON-NLS-1$
				String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
                  try
                  {
                     path = java.net.URLDecoder.decode(path, Messages.getString("MainShell.52")); //$NON-NLS-1$
                  }
                  catch (java.io.UnsupportedEncodingException ee)
                  {
                     ee.printStackTrace();
                  }
                  java.io.File jarFile = new java.io.File(path);
                  java.io.File parent = jarFile.getParentFile();
                  if (parent != null)
                  {
                     jarPath = parent.getAbsolutePath();
                  }
                  try
                  {
                	  jarPathF=java.net.URLDecoder.decode(jarPath, Messages.getString("MainShell.53")); //$NON-NLS-1$
                  }
                  catch (java.io.UnsupportedEncodingException ee)
                  {
                      ee.printStackTrace();
                  }
				
                  
                  
 				String filepath=jarPathF +Messages.getString("MainShell.54"); //$NON-NLS-1$
				File aaa=new File(filepath);
				if(!aaa.exists()) 
				{
					MessageDialog.openInformation(sShell, Messages.getString("MainShell.55"), Messages.getString("MainShell.56")); //$NON-NLS-1$ //$NON-NLS-2$
					return;
					}
			    String commandStr=Messages.getString("MainShell.57")+Messages.getString("MainShell.58") +filepath.replace(Messages.getString("MainShell.59"), Messages.getString("MainShell.60"));     //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			    try {
			    	//MessageDialog.openInformation(sShell, "Tutorial",commandFile);
			    	Runtime.getRuntime().exec(commandStr);    
			    	} catch(IOException ea) {            
			    		ea.printStackTrace(); 
			    		//MessageDialog.openInformation(sShell, "Tutorial",ea.getMessage());
			    		
			    		}
			    	
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});

		push2.addSelectionListener(new org.eclipse.swt.events.SelectionListener() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) 
			{
				//System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
				String jarPath=Messages.getString("MainShell.61"); //$NON-NLS-1$
				String jarPathF=Messages.getString("MainShell.62"); //$NON-NLS-1$
				String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
                  try
                  {
                     path = java.net.URLDecoder.decode(path, Messages.getString("MainShell.63")); //$NON-NLS-1$
                  }
                  catch (java.io.UnsupportedEncodingException ee)
                  {
                     ee.printStackTrace();
                  }
                  java.io.File jarFile = new java.io.File(path);
                  java.io.File parent = jarFile.getParentFile();
                  if (parent != null)
                  {
                     jarPath = parent.getAbsolutePath();
                  }
                  try
                  {
                	  jarPathF=java.net.URLDecoder.decode(jarPath, Messages.getString("MainShell.64")); //$NON-NLS-1$
                  }
                  catch (java.io.UnsupportedEncodingException ee)
                  {
                      ee.printStackTrace();
                  }
				
                  
                  
 				String filepath=jarPathF +Messages.getString("MainShell.65"); //$NON-NLS-1$
				File aaa=new File(filepath);
				if(!aaa.exists()) 
				{
					MessageDialog.openInformation(sShell, Messages.getString("MainShell.66"), Messages.getString("MainShell.67")); //$NON-NLS-1$ //$NON-NLS-2$
					return;
					}
			    String commandStr=Messages.getString("MainShell.68")+Messages.getString("MainShell.69") +filepath.replace(Messages.getString("MainShell.70"), Messages.getString("MainShell.71"));     //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			    try {
			    	//MessageDialog.openInformation(sShell, "Tutorial",commandFile);
			    	Runtime.getRuntime().exec(commandStr);    
			    	} catch(IOException ea) {            
			    		ea.printStackTrace(); 
			    		//MessageDialog.openInformation(sShell, "Tutorial",ea.getMessage());
			    		
			    		}
			    	
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
	  
		MenuItem push14 = new MenuItem(submenu3,SWT.PUSH);
	    push14.setText("Manual");	  
		push14.addSelectionListener(new org.eclipse.swt.events.SelectionListener() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) 
			{
				//System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
				String jarPath=Messages.getString("MainShell.39"); //$NON-NLS-1$
				String jarPathF=Messages.getString("MainShell.40"); //$NON-NLS-1$
				String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
                  try
                  {
                     path = java.net.URLDecoder.decode(path, Messages.getString("MainShell.41")); //$NON-NLS-1$
                  }
                  catch (java.io.UnsupportedEncodingException ee)
                  {
                     ee.printStackTrace();
                  }
                  java.io.File jarFile = new java.io.File(path);
                  java.io.File parent = jarFile.getParentFile();
                  if (parent != null)
                  {
                     jarPath = parent.getAbsolutePath();
                  }
                  try
                  {
                	  jarPathF=java.net.URLDecoder.decode(jarPath, Messages.getString("MainShell.42")); //$NON-NLS-1$
                  }
                  catch (java.io.UnsupportedEncodingException ee)
                  {
                      ee.printStackTrace();
                  }
                  
 				String filepath=jarPathF +Messages.getString("MainShell.93"); //$NON-NLS-1$
				File aaa=new File(filepath);
				if(!aaa.exists()) 
				{
					MessageDialog.openInformation(sShell, Messages.getString("MainShell.44"), Messages.getString("MainShell.45")); //$NON-NLS-1$ //$NON-NLS-2$
					return;
					}
			    String commandStr=Messages.getString("MainShell.46")+Messages.getString("MainShell.47") +filepath.replace(Messages.getString("MainShell.48"), Messages.getString("MainShell.49"));     //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			    try {
			    	//MessageDialog.openInformation(sShell, "Tutorial",commandFile);
			    	Runtime.getRuntime().exec(commandStr);    
			    	} catch(IOException ea) {            
			    		ea.printStackTrace(); 
			    		//MessageDialog.openInformation(sShell, "Tutorial",ea.getMessage());			    		
			    		}			    	
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
	
		push5 = new MenuItem(submenu3, SWT.PUSH);
		push5.setText(Messages.getString("MainShell.72"));//增加MBP //$NON-NLS-1$
		push5.addSelectionListener(new org.eclipse.swt.events.SelectionListener() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) 
			{
				MessageDialog.openInformation(sShell, Messages.getString("MainShell.73"), //$NON-NLS-1$
						Messages.getString("MainShell.74") + Messages.getString("MainShell.75") //$NON-NLS-1$ //$NON-NLS-2$
								+ Messages.getString("MainShell.76")+Messages.getString("MainShell.77")  //$NON-NLS-1$ //$NON-NLS-2$
								+Messages.getString("MainShell.78")+Messages.getString("MainShell.79") //$NON-NLS-1$ //$NON-NLS-2$
								+Messages.getString("MainShell.80")+Messages.getString("MainShell.81")+Messages.getString("MainShell.82")+Messages.getString("MainShell.83")+Messages.getString("MainShell.84")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			}
			
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		submenuItem3.setMenu(submenu3);
		
		sShell.setMenuBar(menuBar);
	}

}
