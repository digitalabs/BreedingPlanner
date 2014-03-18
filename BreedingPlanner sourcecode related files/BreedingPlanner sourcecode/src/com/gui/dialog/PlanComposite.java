package com.gui.dialog;

import java.awt.Color;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;

public class PlanComposite extends Composite 
{

	private static final org.eclipse.swt.graphics.Color Color = null;
	private Text textArea = null;

	public void SetPlanText(List<String> planText1)
	{
		String text="";
		for(int i=0;i<planText1.size();i++)
		{
			text=text+planText1.get(i)+"\r\n";
		}
		textArea.setText(text);
	}
	
	public PlanComposite(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		GridData gridData = new GridData();
		gridData.heightHint = 300;
		gridData.horizontalSpan = 2;
		gridData.widthHint = 400;
		textArea = new Text(this, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL |SWT.H_SCROLL| SWT.READ_ONLY);
		textArea.setLayoutData(gridData);
		//textArea.setBackground(Color.getRGB());
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		this.setLayout(gridLayout);
		setSize(new Point(500, 400));
		
	}

}  
