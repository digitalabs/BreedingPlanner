package com.gui.wizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.gui.Messages;

public class InputWizardPage extends WizardPage 
{    
	//定义私有变量
	private Shell sShell = null;
	private InputComposite ic;
	//方法
	public InputComposite getIc() 
	{
		return ic;
	}
	protected InputWizardPage(String pageName, String title,ImageDescriptor titleImage) 
	{
		super(pageName, title, titleImage);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void createControl(Composite arg0) 
	{		
		sShell = arg0.getShell();
		sShell.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream(Messages.getString("MainShell.2"))));
		ic = new InputComposite(arg0,SWT.NONE,sShell);
		setControl(ic);
	}
}
