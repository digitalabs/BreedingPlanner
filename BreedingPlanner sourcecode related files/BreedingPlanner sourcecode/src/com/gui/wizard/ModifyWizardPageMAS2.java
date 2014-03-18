package com.gui.wizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.gui.Messages;


public class ModifyWizardPageMAS2 extends WizardPage {

	private ModifyCompositeMAS2 mc2;
	private Shell sShell = null;
	private int col=10;
	private int row=4;

	
	public ModifyCompositeMAS2 getIc() {
		return mc2;
	}

	protected ModifyWizardPageMAS2(String pageName, String title,
			ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createControl(Composite arg0) {
		// TODO Auto-generated method stub
		sShell = arg0.getShell();
		sShell.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream(Messages.getString("MainShell.2"))));
		  mc2 = new ModifyCompositeMAS2(arg0,SWT.NONE);
		  setControl(mc2);
		  
		
	}
	@Override
	public boolean isControlCreated()
	{
		return true;
	}
	 @Override
	    public boolean isPageComplete() {
		 
		 ModifyWizardPageMAS wizardPage1=(ModifyWizardPageMAS)this.getPreviousPage();
		  Combo Combo17=wizardPage1.getIc().getCombo17();
		  col=Integer.parseInt(Combo17.getText());   
		  row=2;   
		  ModifyCompositeMAS2 aa=(ModifyCompositeMAS2)this.getControl();
		  aa.changeEnabled(col, row);
		  
		 return true;
		 		
	    }

	
	
}
