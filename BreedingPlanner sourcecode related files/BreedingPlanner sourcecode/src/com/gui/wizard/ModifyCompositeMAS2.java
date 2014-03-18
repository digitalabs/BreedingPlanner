package com.gui.wizard;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;

import com.io.InputInfoItem;
import com.io.InputInfoMangMAS;
import com.overall.BreProcess;

public class ModifyCompositeMAS2 extends Composite {

	private Label label = null;
	private Label label1 = null;
	private Label label2 = null;
	private Label label3 = null;
	private Label label4 = null;
	private Label label5 = null;
	private Label label6 = null;
	private Label label7 = null;
	private Label label8 = null;
	private Label label9 = null;
	private Label label10 = null;
	private Label label11 = null;
	private Label label12 = null;
	private Label label15 = null;
	private Button checkBox = null;
	private Button checkBox1 = null;
	private Button checkBox2 = null;
	private Button checkBox3 = null;
	private Button checkBox4 = null;
	private Button checkBox5 = null;
	private Button checkBox6 = null;
	private Button checkBox7 = null;
	private Button checkBox8 = null;
	private Button checkBox9 = null;
	private Button checkBox10 = null;
	private Button checkBox11 = null;
	private Button checkBox12 = null;
	private Button checkBox13 = null;
	private Button checkBox14 = null;
	private Button checkBox15 = null;
	private Button checkBox16 = null;
	private Button checkBox17 = null;
	private Button checkBox18 = null;
	private Button checkBox19 = null;
	private Button checkBox40 = null;
	private Button checkBox41 = null;
	private Button checkBox42 = null;
	private Button checkBox43 = null;
	private Button checkBox44 = null;
	private Button checkBox45 = null;
	private Button checkBox46 = null;
	private Button checkBox47 = null;
	private Button checkBox48 = null;
	private Button checkBox49 = null;
	private Label label16 = null;
	
	private int col=10;
	private int row=4;
	
	private GridData gridData=null;
	private GridLayout gridLayout=null;
	private Label filler3237=null;
	private Label filler3238=null;
	private Label filler3239=null;
	private Label filler3240=null;
	private Label filler3241=null;
	private Label filler3242=null;
	private Label filler3243=null;
	
	public ModifyCompositeMAS2(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	public ModifyCompositeMAS2(Composite parent, int style, int col1, int row1) {
		super(parent, style);
		col=col1;
		row=row1;
		initialize();
	}
	
	

	private void initialize() {
		
		gridData = new GridData();
		gridData.horizontalSpan = 4;
		gridLayout = new GridLayout();
		gridLayout.numColumns = 11;
		label16 = new Label(this, SWT.NONE);
		label16.setText("Source of favorable genes");
		label16.setLayoutData(gridData);
		filler3237 = new Label(this, SWT.NONE);
		filler3238 = new Label(this, SWT.NONE);
		filler3239 = new Label(this, SWT.NONE);
		filler3240 = new Label(this, SWT.NONE);
		filler3241 = new Label(this, SWT.NONE);
		filler3242 = new Label(this, SWT.NONE);
		filler3243 = new Label(this, SWT.NONE);
		label = new Label(this, SWT.NONE);
		label.setText("Locus");
		label1 = new Label(this, SWT.NONE);
		label1.setText("Locus1");
		label2 = new Label(this, SWT.NONE);
		label2.setText("Locus2");
		label3 = new Label(this, SWT.NONE);
		label3.setText("Locus3");
		label4 = new Label(this, SWT.NONE);
		label4.setText("Locus4");
		label5 = new Label(this, SWT.NONE);
		label5.setText("Locus5");
		label6 = new Label(this, SWT.NONE);
		label6.setText("Locus6");
		label7 = new Label(this, SWT.NONE);
		label7.setText("Locus7");
		label8 = new Label(this, SWT.NONE);
		label8.setText("Locus8");
		label9 = new Label(this, SWT.NONE);
		label9.setText("Locus9");
		label10 = new Label(this, SWT.NONE);
		label10.setText("Locus10");
		label11 = new Label(this, SWT.NONE);
		label11.setText("Parent1");
		checkBox = new Button(this, SWT.CHECK);
		checkBox1 = new Button(this, SWT.CHECK);
		checkBox2 = new Button(this, SWT.CHECK);
		checkBox3 = new Button(this, SWT.CHECK);
		checkBox4 = new Button(this, SWT.CHECK);
		checkBox5 = new Button(this, SWT.CHECK);
		checkBox6 = new Button(this, SWT.CHECK);
		checkBox7 = new Button(this, SWT.CHECK);
		checkBox8 = new Button(this, SWT.CHECK);
		checkBox9 = new Button(this, SWT.CHECK);
		label12 = new Label(this, SWT.NONE);
		label12.setText("Parent2");
		checkBox10 = new Button(this, SWT.CHECK);
		checkBox11 = new Button(this, SWT.CHECK);
		checkBox12 = new Button(this, SWT.CHECK);
		checkBox13 = new Button(this, SWT.CHECK);
		checkBox14 = new Button(this, SWT.CHECK);
		checkBox15 = new Button(this, SWT.CHECK);
		checkBox16 = new Button(this, SWT.CHECK);
		checkBox17 = new Button(this, SWT.CHECK);
		checkBox18 = new Button(this, SWT.CHECK);
		checkBox19 = new Button(this, SWT.CHECK);
		label15 = new Label(this, SWT.NONE);
		label15.setText("Target");
		checkBox40 = new Button(this, SWT.CHECK);
		checkBox41 = new Button(this, SWT.CHECK);
		checkBox42 = new Button(this, SWT.CHECK);
		checkBox43 = new Button(this, SWT.CHECK);
		checkBox44 = new Button(this, SWT.CHECK);
		checkBox45 = new Button(this, SWT.CHECK);
		checkBox46 = new Button(this, SWT.CHECK);
		checkBox47 = new Button(this, SWT.CHECK);
		checkBox48 = new Button(this, SWT.CHECK);
		checkBox40.setSelection(true);
		checkBox40.setEnabled(false);
		checkBox41.setSelection(true);
		checkBox41.setEnabled(false);
		checkBox42.setSelection(true);
		checkBox42.setEnabled(false);
		checkBox43.setSelection(true);
		checkBox43.setEnabled(false);
		checkBox44.setSelection(true);
		checkBox44.setEnabled(false);
		checkBox45.setSelection(true);
		checkBox45.setEnabled(false);
		checkBox46.setSelection(true);
		checkBox46.setEnabled(false);
		checkBox47.setSelection(true);
		checkBox47.setEnabled(false);
		checkBox48.setSelection(true);
		checkBox48.setEnabled(false);
		checkBox49 = new Button(this, SWT.CHECK);
		checkBox49.setSelection(true);
		checkBox49.setEnabled(false);
		this.setLayout(gridLayout);
		this.setSize(new Point(515, 177));
		
		InputInfoMangMAS mang = new InputInfoMangMAS(BreProcess.getXMLPathAndName());
		List<InputInfoItem> inputInfoList = new ArrayList<InputInfoItem>();
		inputInfoList = mang.createList();
		if(inputInfoList.get(12).getValue().contains("Parent1")){
			checkBox.setSelection(true);	
		}
		if(inputInfoList.get(12).getValue().contains("Parent2")){
			checkBox10.setSelection(true);	
		}
		if(inputInfoList.get(13).getValue().contains("Parent1")){
			checkBox1.setSelection(true);	
		}
		if(inputInfoList.get(13).getValue().contains("Parent2")){
			checkBox11.setSelection(true);	
		}
		if(inputInfoList.get(14).getValue().contains("Parent1")){
			checkBox2.setSelection(true);	
		}
		if(inputInfoList.get(14).getValue().contains("Parent2")){
			checkBox12.setSelection(true);	
		}
		if(inputInfoList.get(15).getValue().contains("Parent1")){
			checkBox3.setSelection(true);	
		}
		if(inputInfoList.get(15).getValue().contains("Parent2")){
			checkBox13.setSelection(true);	
		}
		if(inputInfoList.get(16).getValue().contains("Parent1")){
			checkBox4.setSelection(true);	
		}
		if(inputInfoList.get(16).getValue().contains("Parent2")){
			checkBox14.setSelection(true);	
		}
		if(inputInfoList.get(17).getValue().contains("Parent1")){
			checkBox5.setSelection(true);	
		}
		if(inputInfoList.get(17).getValue().contains("Parent2")){
			checkBox15.setSelection(true);	
		}
		if(inputInfoList.get(18).getValue().contains("Parent1")){
			checkBox6.setSelection(true);	
		}
		if(inputInfoList.get(18).getValue().contains("Parent2")){
			checkBox16.setSelection(true);	
		}
		if(inputInfoList.get(19).getValue().contains("Parent1")){
			checkBox7.setSelection(true);	
		}
		if(inputInfoList.get(19).getValue().contains("Parent2")){
			checkBox17.setSelection(true);	
		}
		if(inputInfoList.get(20).getValue().contains("Parent1")){
			checkBox8.setSelection(true);	
		}
		if(inputInfoList.get(20).getValue().contains("Parent2")){
			checkBox18.setSelection(true);	
		}
		if(inputInfoList.get(21).getValue().contains("Parent1")){
			checkBox9.setSelection(true);	
		}
		if(inputInfoList.get(21).getValue().contains("Parent2")){
			checkBox19.setSelection(true);	
		}

	
	
	
	}
	
	public void changeEnabled(int col1, int row1)
	{
		col=col1;
		row=row1;
		
		setUnable(checkBox, 0);
		setUnable(checkBox1, 1);
		setUnable(checkBox2, 2);
		setUnable(checkBox3, 3);
		setUnable(checkBox4, 4);
		setUnable(checkBox5, 5);
		setUnable(checkBox6, 6);
		setUnable(checkBox7, 7);
		setUnable(checkBox8, 8);
		setUnable(checkBox9, 9);
		setUnable(checkBox10, 10);
		setUnable(checkBox11, 11);
		setUnable(checkBox12, 12);
		setUnable(checkBox13, 13);
		setUnable(checkBox14, 14);
		setUnable(checkBox15, 15);
		setUnable(checkBox16, 16);
		setUnable(checkBox17, 17);
		setUnable(checkBox18, 18);
		setUnable(checkBox19, 19);
	}

	private void setUnable(Button box, int number){
		
		box.setEnabled(true);
		int col2;
		int row2;
		row2=number/10+1;
		col2=number-(row2-1)*10+1;
		if(col2>col || row2>row){
			box.setEnabled(false);
			box.setSelection(false);
		}	
	}

	public Button getCheckBox() {
		return checkBox;
	}
	public Button getCheckBox1() {
		return checkBox1;
	}
	public Button getCheckBox2() {
		return checkBox2;
	}
	public Button getCheckBox3() {
		return checkBox3;
	}
	public Button getCheckBox4() {
		return checkBox4;
	}
	public Button getCheckBox5() {
		return checkBox5;
	}
	public Button getCheckBox6() {
		return checkBox6;
	}
	public Button getCheckBox7() {
		return checkBox7;
	}
	public Button getCheckBox8() {
		return checkBox8;
	}
	public Button getCheckBox9() {
		return checkBox9;
	}
	public Button getCheckBox10() {
		return checkBox10;
	}
	public Button getCheckBox11() {
		return checkBox11;
	}
	public Button getCheckBox12() {
		return checkBox12;
	}
	public Button getCheckBox13() {
		return checkBox13;
	}
	public Button getCheckBox14() {
		return checkBox14;
	}
	public Button getCheckBox15() {
		return checkBox15;
	}
	public Button getCheckBox16() {
		return checkBox16;
	}
	public Button getCheckBox17() {
		return checkBox17;
	}
	public Button getCheckBox18() {
		return checkBox18;
	}
	public Button getCheckBox19() {
		return checkBox19;
	}

	
}  //  @jve:decl-index=0:visual-constraint="10,10"
