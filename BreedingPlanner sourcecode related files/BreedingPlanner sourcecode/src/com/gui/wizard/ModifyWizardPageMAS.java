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

public class ModifyWizardPageMAS extends WizardPage {
	private Shell sShell = null;
	private ModifyCompositeMAS mc;
	
	public ModifyCompositeMAS getIc() {
		return mc;
	}
	
	

	protected ModifyWizardPageMAS(String pageName, String title,
			ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		// TODO Auto-generated constructor stub
	}

	/*protected InputWizardPage(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
	}*/

	@Override
	public void createControl(Composite arg0) {
		// TODO Auto-generated method stub
		sShell = arg0.getShell();
		sShell.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream(Messages.getString("MainShell.2"))));
		mc = new ModifyCompositeMAS(arg0,SWT.NONE,sShell);
		setControl(mc);
		
		//this.setPageComplete(false);

	}
	
	
}
