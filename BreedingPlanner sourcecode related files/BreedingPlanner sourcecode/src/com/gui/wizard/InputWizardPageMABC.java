package com.gui.wizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.gui.Messages;

public class InputWizardPageMABC extends WizardPage {
	private Shell sShell = null;
	private InputCompositeMABC ic;
	
	public InputCompositeMABC getIc() {
		return ic;
	}

	protected InputWizardPageMABC(String pageName, String title,
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
		//this.setTitle("Input Information");
		ic = new InputCompositeMABC(arg0,SWT.NONE,sShell);
		setControl(ic);
	}

}
