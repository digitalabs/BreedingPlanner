package com.gui.dialog;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Color;

public class PopulationSizeComposite extends Composite {

	private Label label = null;

	public PopulationSizeComposite(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		setLayout(new FillLayout());
		setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		label = new Label(this, SWT.NONE);
		label.setText("Label");
		label.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/com/img/population_size_table.png")));
	}

}
