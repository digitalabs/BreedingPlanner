package com.gui.wizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.gui.Messages;

public class NewProjectWizardPage extends WizardPage 
{
	private Shell sShell = null;
	private NewProjectComposite npc;//对应面板composition的缩写 
	protected NewProjectWizardPage(String pageName, String title,ImageDescriptor titleImage) 
	{
		super(pageName, title, titleImage);
	}
	

	public NewProjectComposite getNpc()
	{
		return npc;
	}

	public void createControl(Composite arg0)
	{
		// TODO Auto-generated method stub
		sShell = arg0.getShell();
		sShell.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream(Messages.getString("MainShell.2"))));
		npc = new NewProjectComposite(arg0,SWT.NONE,sShell);
		setControl(npc);
	}
}
