package com.gui.dialog;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class TargetComposite2 extends Composite {

	private Label label = null;

	public TargetComposite2(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		setLayout(new FillLayout());
		label = new Label(this, SWT.NONE);
		label.setText("Label");
		label.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/com/img/targetProportion2.png")));
	}

}
