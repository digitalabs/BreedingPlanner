package com.gui.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.gui.Messages;
import com.io.InputInfoItem;


public class InputWizardPageMAS2 extends WizardPage {
	
	private InputCompositeMAS2 ic2;
	private Shell sShell = null;
	
	private int col=10;
	private int row=4;
	
	public InputCompositeMAS2 getIc() {
		return ic2;
	}

	protected InputWizardPageMAS2(String pageName, String title,
			ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createControl(Composite arg0) {
		// TODO Auto-generated method stub
		sShell = arg0.getShell();
		sShell.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream(Messages.getString("MainShell.2"))));
		  ic2 = new InputCompositeMAS2(arg0,SWT.NONE);
		  setControl(ic2);
		
	}
	@Override
	public boolean isControlCreated()
	{
		return true;
	}
	 @Override
	 public boolean isPageComplete() {
		 
	    InputWizardPageMAS wizardPage1=(InputWizardPageMAS)this.getPreviousPage();
		Combo Combo17=wizardPage1.getIc().getCombo17();
		col=Integer.parseInt(Combo17.getText());   
		row=2; 
		List<InputInfoItem> inputInfoList=wizardPage1.getIc().getInputInfoItems();
		  
		InputCompositeMAS2 aa=(InputCompositeMAS2)this.getControl();
		
		if(inputInfoList!=null)
		{
			aa.changeData(inputInfoList);
		}
		aa.changeEnabled(col, row);
		  
	     return true;
		 		
	 }

	
	
}
