package com.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;

import com.overall.BreProcess;

public class LeftComposite extends Composite 
{
	private CTabFolder cTabFolder = null;
	private CTabItem cTabItem = null;
	private FileTree fileTree = null;
	
	public FileTree getFileTree() 
	{
		return fileTree;
	}
	public LeftComposite(Composite parent, int style) 
	{
		super(parent, style);
		initialize();
	}	
	public CTabFolder getcTabFolder()
	{
		return cTabFolder;
	}
	private void initialize() 
	{
		createCTabFolder();
		setLayout(new FillLayout());
	}
	
	private void createCTabFolder() 
	{
		cTabFolder = new CTabFolder(this, SWT.BORDER);//BREDER改为NOEN，看看效果
		cTabFolder.setSimple(false);		
		createCTabItem();
		cTabFolder.setSelection(cTabItem);
	}	
	public void createCTabItem()
	{
		cTabItem = new CTabItem(cTabFolder,SWT.NONE);//去掉后面的SWT.CLOSE,现改为NONE
		cTabItem.setText("Project Explorer:");
		fileTree = new FileTree(cTabFolder,SWT.SINGLE);
		cTabItem.setControl(fileTree);		
		cTabItem.addDisposeListener(new org.eclipse.swt.events.DisposeListener() 
		{
			public void widgetDisposed(org.eclipse.swt.events.DisposeEvent e)
			{
				if(cTabFolder.getItemCount()==0)
				{
					MainShell.getSashForm().setMaximizedControl(MainShell.getWbc());
				}
			}
		});		
	}
}

	