package com.gui.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import java.util.LinkedList;
import java.util.List;

public class PlanDialog extends Dialog 
{	
	private static List<String> planText=null;
	private Button Button1;
	public void SetPlanText(List<String> planText1)
	{
		planText=planText1;
	}
	
	public PlanDialog(Shell parentShell) 
	{
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Control createDialogArea(Composite parent) 
	{
		// TODO Auto-generated method stub
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new FillLayout());
		composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		PlanComposite pc = new PlanComposite(composite,SWT.None);
		//pc.SetLableText(planText);
		pc.SetPlanText(planText);
		
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
		return new Point(500,400);
	}

	@Override
	protected void configureShell(Shell newShell) {
		// TODO Auto-generated method stub
		super.configureShell(newShell);
		newShell.setText("Breeding Documentation");
		newShell.setImage(new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/delicious.ico")));
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// TODO Auto-generated method stub
		//createButton(parent,0,"save as",true);		
		createButton(parent,0,"OK",true);		
		//Button1 = new Button(parent,10);
	}

}
