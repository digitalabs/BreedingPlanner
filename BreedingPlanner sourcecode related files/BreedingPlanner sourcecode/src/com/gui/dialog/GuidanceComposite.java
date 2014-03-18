package com.gui.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class GuidanceComposite extends Composite {

	private Label label = null;

	public GuidanceComposite(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		setLayout(new FillLayout());
		label = new Label(this, SWT.NONE);
		label.setText("Label");
		label.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/com/img/guidanceInfo.png")));
	}

}
