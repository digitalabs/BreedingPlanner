package com.gui.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HomzygousityDialog extends Dialog {

	public HomzygousityDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		// TODO Auto-generated method stub
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new FillLayout());
		composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		HomzygousityComposite psc = new HomzygousityComposite(composite,SWT.None);
		return parent;
	}

	@Override
	protected Point getInitialLocation(Point initialSize) {
		// TODO Auto-generated method stub
		return new Point(300,100);
	}

	@Override
	protected Point getInitialSize() {
		// TODO Auto-generated method stub
		return new Point(750,400);
	}

	@Override
	protected void configureShell(Shell newShell) {
		// TODO Auto-generated method stub
		super.configureShell(newShell);
		newShell.setText("Homzygousity");
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// TODO Auto-generated method stub
		createButton(parent,0,"OK",true);
	}

}
