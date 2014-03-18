package com.gui.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner; 
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyListener;

import com.gui.MainShell;
import com.io.InputInfoItem;
import com.io.InputInfoMang;
import com.overall.BreProcess;
import com.overall.Validate;

public class InputComposite extends Composite {

	private InputWizardPage iwp;
	private DateTime dateTime1=null;
	private Shell sShell = null;
	private Label label1 = null;
	private Combo combo3 = null;
	private Group group1 = null;
	private Label label8 = null;
	private Text text3 = null;
	private Label label9 = null;
	private Combo combo4 = null;
	private Text text4 = null;
	private Combo combo5 = null;
	private Combo combo6 = null;
	private GridData widthGridData = null;
	private Label label14 = null;
	private Label label15 = null;
	private Text text6 = null;
	private Label label16 = null;
	private Text text7 = null;
	private Group group2 = null;
	private Label label20 = null;
	private Label label23 = null;
	//private Text text9 = null;
	private Spinner spinner2 = null;
	private Combo combo1 = null;
	private Label label25 = null;
	private Combo combo9 = null;
	private Label label26 = null;
	private Combo combo10 = null;
	private Label label27 = null;
	private Combo combo11 = null;
	private Group group3 = null;
	private Label label232 = null;
	private Combo combo12 = null;
	private Label label233 = null;
	private Label label234 = null;
	private Label label235 = null;
	private Combo combo13 = null;
	private Combo combo14 = null;
	private Combo combo15 = null;
	private Group group4 = null;
	private Button radioButton2 = null;
	private Button radioButton3 = null;
	private Group group5 = null;
	private Label label10 = null;
	private Label label13 = null;
	private Text text1 = null;
	private Text text2 = null;
	private Combo combo = null;
	private Group group6 = null;
	private Label label2 = null;
	private Text text = null;
	private Button button = null;
	private Group group7 = null;
	private Label label = null;
	private Group group9 = null;
	private Label label4 = null;
	private Label label5 = null;
	private Label label3 = null;
	private Group group8 = null;
	private Label label6 = null;
	private Label label7 = null;
	//private Text text5 = null;
	private Spinner spinner1 = null;
	private Label label11 = null;
	private Label label12 = null;
	private TreeViewer tv;
	
				
	public InputComposite(Composite parent, int style, Shell sShell) 
	{
		super(parent, style);
		this.sShell = sShell;		
		initialize();
		
		if(MainShell.getLc().getFileTree().getIsExpanded())
		{
			this.setSelection(true);			
		}
	}

	private void setSelection(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private File getSelected() 
    {
        IStructuredSelection selection = (IStructuredSelection) tv.getSelection();
        File file = (File) (selection.getFirstElement());
        return file;
    }

	private void initialize() 
	{
		widthGridData = new GridData();
		widthGridData.widthHint = 62;
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.marginHeight = 1;
		gridLayout.makeColumnsEqualWidth = true;
		createGroup6();
		GridData gridData1 = new GridData();
//		gridData.verticalAlignment = SWT.CENTER;
		gridData1.horizontalSpan = 3;
		gridData1.horizontalAlignment = SWT.FILL;
		Label filler6 = new Label(this, SWT.NONE);
		gridData1.verticalIndent = 5;
		//label1.setLayoutData(gridData1);
		
		createGroup5();
		createGroup8();
	//	label11 = new Label(this, SWT.NONE);
		Label filler5 = new Label(this, SWT.NONE);
	//	label11.setText("Label");
		createGroup2();
		createGroup3();
		Label filler4 = new Label(this, SWT.NONE);
		createGroup9();
		createGroup1();
		createGroup7();
		this.setSize(new Point(642, 538));
		this.setLayout(gridLayout);		
	}

	public DateTime getDataTime1()
	{
		return dateTime1;
	}
	public Text getText1() {
		return text1;
	}
	public Text getText2() {
		return text2;
	}
	public Combo getCombo() {
		return combo;
	}
	//public Text getText5() {
	//	return text5;
	//}
	public Spinner getSpinner1()
	{
		return spinner1;
	}
	//public Text getText9() {
	//	return text9;
	//}
	public Spinner getSpinner2(){
		return spinner2;
	}
	public Combo getCombo12() {
		return combo12;
	}
	public Combo getCombo13() {
		return combo13;
	}
	public Combo getCombo14() {
		return combo14;
	}
	public Combo getCombo15() {
		return combo15;
	}
	public Combo getCombo3() {
		return combo3;
	}
	public Combo getCombo6() {
		return combo6;
	}
	
    public int getRadioButton(){
    	if(radioButton2.getSelection()==true){
    		return 0;
    	}
    	else{
    		return 1;
    	}
    }
	public Text getText3() {
		return text3;
	}
	public Combo getCombo4() {
		return combo4;
	}
	public Text getText4() {
		return text4;
	}
	public Text getText6() {
		return text6;
	}
	public Text getText7() {
		return text7;
	}
	public Combo getCombo5() {
		return combo5;
	}

	/**
	 * This method initializes combo3	
	 *
	 */
	private void createCombo3() {
		combo3 = new Combo(group9, SWT.READ_ONLY);
		combo3.add("F2");
		combo3.add("F3");
		combo3.setText("F2");
		combo3.setLayoutData(widthGridData);
		combo3.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				if(combo3.getSelectionIndex()==0){
					combo6.removeAll();
					combo6.add("F3");
					combo6.add("F4");
					combo6.add("F5");
					combo6.setText("F3");
				}
				else if(combo3.getSelectionIndex()==1){
					combo6.removeAll();
					combo6.add("F4");
					combo6.add("F5");
					combo6.add("F6");
					combo6.setText("F4");
					
				}
				else
				{
					combo6.removeAll();
					combo6.add("F3");
					combo6.add("F4");
					combo6.add("F5");
					combo6.setText("F3");
				}
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
	}

	/**
	 * This method initializes group1	
	 *
	 */
	private void createGroup1() {
		GridData gridData36 = new GridData();
		gridData36.widthHint = 190;
		GridData gridData35 = new GridData();
		gridData35.widthHint = 190;
		GridData gridData34 = new GridData();
		gridData34.widthHint = 190;
		GridData gridData33 = new GridData();
		gridData33.widthHint = 190;
		GridData gridData32 = new GridData();
		gridData32.widthHint = 190;
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData2.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData2.widthHint = 300;
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 2;
		gridLayout2.marginHeight = 2;
		group1 = new Group(this, SWT.NONE);
		group1.setText("Multi-location phenotyping");
		group1.setLayoutData(gridData2);
		group1.setLayout(gridLayout2);
		label8 = new Label(group1, SWT.NONE);
		label8.setText("     Number of locations");
		label8.setLayoutData(gridData32);
		text3 = new Text(group1, SWT.BORDER);
		text3.setText("1");
		text3.setLayoutData(widthGridData);
		label9 = new Label(group1, SWT.NONE);
		label9.setText("     Replicates in each location");
		label9.setLayoutData(gridData33);
		createCombo4();
		label14 = new Label(group1, SWT.LEFT);
		label14.setText("     Plot length (m)");
		label14.setLayoutData(gridData34);
		text4 = new Text(group1, SWT.BORDER);
		text4.setText("5");
		text4.setLayoutData(widthGridData);
		label15 = new Label(group1, SWT.NONE);
		label15.setText("     Number of rows");
		label15.setLayoutData(gridData35);
		text6 = new Text(group1, SWT.BORDER);
		text6.setText("10");
		text6.setLayoutData(widthGridData);
		label16 = new Label(group1, SWT.NONE);
		label16.setText("     Individual plants per plot");
		label16.setLayoutData(gridData36);
		text7 = new Text(group1, SWT.BORDER);
		text7.setText("30");
		text7.setLayoutData(widthGridData);
	}

	/**
	 * This method initializes combo4	
	 *
	 */
	private void createCombo4() {
		combo4 = new Combo(group1, SWT.READ_ONLY);
		GridData gridData = new GridData();
		gridData.widthHint = 65;
		combo4.setLayoutData(gridData);
		combo4.add("1");
		combo4.add("2");
		combo4.add("3");
		combo4.add("4");
		combo4.setText("1");
	}

	/**
	 * This method initializes combo5	
	 *
	 */
	private void createCombo5() {
		combo5 = new Combo(group7, SWT.READ_ONLY);
		combo5.add("1");
		combo5.add("2");
		combo5.add("3");
		combo5.add("4");
		combo5.add("5");
		combo5.setText("1");
		combo5.setLayoutData(widthGridData);
	}

	/**
	 * This method initializes combo1	
	 *
	 */
	private void createCombo6() {
		combo6 = new Combo(group9, SWT.READ_ONLY);
		combo6.setEnabled(true);
		combo6.setLayoutData(widthGridData);
		if(combo3.getText()=="F2")
		{
			combo6.removeAll();
			combo6.add("F3");
			combo6.add("F4");
			combo6.add("F5");
			combo6.setText("F3");
		}
		else if(combo3.getText()=="F3")
		{
			combo6.removeAll();
			combo6.add("F4");
			combo6.add("F5");
			combo6.add("F6");
			combo6.setText("F4");
		}
		else
		{
			combo6.removeAll();
			combo6.add("F3");
			combo6.add("F4");
			combo6.add("F5");
			combo6.setText("F3");
		}
	}

	/**
	 * This method initializes group2	
	 *
	 */
	private void createGroup2() {
		GridData gridData19 = new GridData();
		gridData19.widthHint = 190;
		GridData gridData3 = new GridData();
		gridData3.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData3.widthHint = 300;
		GridLayout gridLayout3 = new GridLayout();
		gridLayout3.numColumns = 2;
		gridLayout3.marginHeight = 2;
		group2 = new Group(this, SWT.NONE);
		group2.setText("Greenhouse/offseason");
		group2.setLayoutData(gridData3);
		group2.setLayout(gridLayout3);
		label20 = new Label(group2, SWT.NONE);
		label20.setText("Length of each season (months)");
		label20.setLayoutData(gridData19);
		spinner2 = new Spinner(group2, SWT.BORDER);
		spinner2.setSelection(6);
		spinner2.setMinimum(1);
		spinner2.setMaximum(100);
		spinner2.setLayoutData(widthGridData);
		//text9.setText("6");		
		//text9.setLayoutData(widthGridData);
		
	}

	/**
	 * This method initializes group3	
	 *
	 */
	private void createGroup3() {
		GridData gridData25 = new GridData();
		gridData25.widthHint = 300;
		gridData25.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		GridData gridData24 = new GridData();
		gridData24.widthHint = 190;
		GridLayout gridLayout4 = new GridLayout();
		gridLayout4.numColumns = 2;
		gridLayout4.marginHeight = 2;
		gridLayout4.makeColumnsEqualWidth = false;
		group3 = new Group(this, SWT.NONE);
		group3.setText("Field condition");
		group3.setLayoutData(gridData25);
		group3.setLayout(gridLayout4);
		label232 = new Label(group3, SWT.NONE);
		label232.setText("Seasons per year");
		label232.setLayoutData(gridData24);
		createCombo12();
		label233 = new Label(group3, SWT.NONE);
		label233.setText("    1st season starts in");
		createCombo13();
		label234 = new Label(group3, SWT.NONE);
		label234.setText("    2nd season starts in");
		createCombo14();
		label235 = new Label(group3, SWT.NONE);
		label235.setText("    3rd season starts in");
		createCombo15();
	}

	/**
	 * This method initializes combo12	
	 *
	 */
	private void createCombo12() {
		GridData gridData5 = new GridData();
		gridData5.horizontalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData5.widthHint = 65;
		combo12 = new Combo(group3, SWT.READ_ONLY);
		combo12.setLayoutData(gridData5);
		combo12.add("1");
		combo12.add("2");
		combo12.add("3");
		combo12.setText("1");
		combo12.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				//System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
				
				ChangeCombo12();
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
	}

	/**
	 * This method initializes combo13	
	 *
	 */
	private void createCombo13() {
		GridData gridData6 = new GridData();
		gridData6.horizontalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData6.widthHint = 65;
		combo13 = new Combo(group3, SWT.READ_ONLY);
		combo13.setLayoutData(gridData6);
		combo13.add("Jan");
		combo13.add("Feb");
		combo13.add("Mar");
		combo13.add("Apr");
		combo13.add("May");
		combo13.add("June");
		combo13.add("July");
		combo13.add("Aug");
		combo13.add("Sept");
		combo13.add("Oct");
		combo13.add("Nov");
		combo13.add("Dec");
		combo13.setText("Jan");
		combo13.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e)
			{
				//System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
			    int num13=combo13.getSelectionIndex();
			    int num14=combo14.getSelectionIndex();
			    int num15=combo15.getSelectionIndex();
				
			    if(combo12.getSelectionIndex() == 1)
			    {
			    	if(num13 >=num14)
			    	{
			    		num14 = num13+1;
			    		combo14.select(num14);
			    		combo15.setText("");
			    	}			    	
			    }
			    else if(combo12.getSelectionIndex() == 2)
			    {
			    	if(num13>=num14)
			    	{
			    		num14 = num13+1;
			    		combo14.select(num14);
			    		if(num14>=num15||num13>=num15)
			    		{
			    			num15= num14+1;
			    			combo15.select(num15);
			    		}
			    	}
			    	if(num13>=num15)
			    	{
			    		num15 = num14+1;
			    		combo15.select(num15);
			    	}			    	
			    }
			    else if(combo12.getSelectionIndex()==0)
			    {
			    	combo14.setText("");
			    	combo15.setText("");
			    }			   
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
	}

	/**
	 * This method initializes combo14	
	 *
	 */
	private void createCombo14() {
		GridData gridData7 = new GridData();
		gridData7.horizontalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData7.widthHint = 65;
		combo14 = new Combo(group3, SWT.READ_ONLY);
		combo14.setLayoutData(gridData7);
		combo14.add("Jan");
		combo14.add("Feb");
		combo14.add("Mar");
		combo14.add("Apr");
		combo14.add("May");
		combo14.add("June");
		combo14.add("July");
		combo14.add("Aug");
		combo14.add("Sept");
		combo14.add("Oct");
		combo14.add("Nov");
		combo14.add("Dec");
		combo14.setText("");
		combo14.setEnabled(false);
		if(combo12.getText()=="2"||combo12.getText()=="3")
		{
			combo14.setEnabled(true);		
		}
		
		combo14.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				//System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
				int num13=combo13.getSelectionIndex();
				int num14=combo14.getSelectionIndex();		
				int num15=combo15.getSelectionIndex();				
				
				 if(combo12.getSelectionIndex() == 1)
				    {
				    	if(num13 >=num14)
				    	{
				    		num14 = num13+1;
				    		combo14.select(num14);
				    		combo15.setText("");
				    	}				    	
				    }
				    else if(combo12.getSelectionIndex() == 2)
				    {
				    	if(num14<=num13)
				    	{
				    		num14 = num13+1;
				    		combo14.select(num14);
				    		if(num14>=num15)
				    		{
				    			num15 = num14+1;
				    			combo15.select(num15);
				    		}
				    	}
				    	else if(num14>=num15)
				    	{
				    		num15= num14+1;
				    		combo15.select(num15);
				    	}			    	
				    }
				    else if(combo12.getSelectionIndex()==0)
				    {
				    	combo14.setText("");
				    	combo15.setText("");
				    }
				
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
	}

	/**
	 * This method initializes combo15	
	 *
	 */
	private void createCombo15() {
		GridData gridData8 = new GridData();
		gridData8.horizontalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData8.widthHint = 65;
		combo15 = new Combo(group3, SWT.READ_ONLY);
		combo15.setLayoutData(gridData8);
		combo15.add("Jan");
		combo15.add("Feb");
		combo15.add("Mar");
		combo15.add("Apr");
		combo15.add("May");
		combo15.add("June");
		combo15.add("July");
		combo15.add("Aug");
		combo15.add("Sept");
		combo15.add("Oct");
		combo15.add("Nov");
		combo15.add("Dec");
		combo15.setText("");
		combo15.setEnabled(false);
		if(combo12.getText()=="3")
		{
			combo15.setEnabled(true);
		}
		combo15.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				//System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
				int num14=combo14.getSelectionIndex();
				int num15=combo15.getSelectionIndex();
				int num13 = combo13.getSelectionIndex();
			
				 if(num14>=num15||num13>=num15)
				{
					 num15 = num14+1;					 
					combo15.select(num15);
				}
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		

	}

	/**
	 * This method initializes combo16	
	 *
	 */
	private void createCombo16() {
		
	}

	/**
	 * This method initializes group4	
	 *
	 */
	private void createGroup4() {
		GridData gridData26 = new GridData();
		gridData26.horizontalSpan = 2;
		GridLayout gridLayout5 = new GridLayout();
		gridLayout5.numColumns = 2;
		group4 = new Group(group9, SWT.NONE);
		group4.setText("Early generation growing condition");
		group4.setLayoutData(gridData26);
		group4.setLayout(gridLayout5);
		radioButton2 = new Button(group4, SWT.RADIO);
		radioButton2.setText("Greenhouse/offseason");
		radioButton2.setSelection(true);
		radioButton3 = new Button(group4, SWT.RADIO);
		radioButton3.setText("Field condition");
		
	}

	/**
	 * This method initializes group5	
	 *
	 */
	private void createGroup5() {
		GridData gridData18 = new GridData();
		gridData18.widthHint = 80;
		GridData gridData17 = new GridData();
		gridData17.widthHint = 80;
		GridData gridData16 = new GridData();
		gridData16.widthHint = 190;
		GridData gridData15 = new GridData();
		gridData15.widthHint = 190;
		GridData gridData4 = new GridData();
		gridData4.widthHint = 300;
		gridData4.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		GridLayout gridLayout6 = new GridLayout();
		gridLayout6.numColumns = 2;
		gridLayout6.marginHeight = 2;
		gridLayout6.makeColumnsEqualWidth = false;
		group5 = new Group(this, SWT.NONE);
		group5.setText("Researcher information");
		group5.setLayoutData(gridData4);
		group5.setLayout(gridLayout6);
		label10 = new Label(group5, SWT.NONE);
		label10.setText("Country");
		label10.setLayoutData(gridData15);
		text1 = new Text(group5, SWT.BORDER);
		text1.setLayoutData(gridData17);
		text1.setText("China");
		label13 = new Label(group5, SWT.NONE);
		label13.setText("Researcher's name");
		label13.setLayoutData(gridData16);
		text2 = new Text(group5, SWT.BORDER);
		text2.setLayoutData(gridData18);
		text2.setText("CAAS");
	}

	/**
	 * This method initializes combo	
	 *
	 */
	private void createCombo() 
	{
		GridData gridData21 = new GridData();
		gridData21.widthHint = 65;
		combo = new Combo(group8, SWT.DROP_DOWN);
		combo.setLayoutData(gridData21);
		combo.add("Cowpea");
		combo.add("Rice");
		combo.add("Wheat");
		combo.add("Maize");
		combo.add("Groundnuts");
		combo.add("Cassava");
		combo.add("Input new species");									
		combo.setText("Cowpea");
		
		combo.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent arg0) 
			{
				// TODO Auto-generated method stub
				if(combo.getText().contentEquals("Cowpea"))
				{
					//spinner1.setMaximum(300);
					//spinner1.setMinimum(30);
					spinner1.setSelection(150);
					//text5.setText("150");	
					//text5.setToolTipText("30~300");
				}
				else if(combo.getText().contentEquals("Rice"))
				{
					//spinner1.setMaximum(300);
					//spinner1.setMinimum(50);
					spinner1.setSelection(200);
					//text5.setText("200");
					//text5.setToolTipText("50~300");
				}
				else if(combo.getText().contentEquals("Wheat"))
				{
					//spinner1.setMaximum(250);
					//spinner1.setMinimum(50);
					spinner1.setSelection(150);
					//text5.setToolTipText("50~250");
					//text5.setText("150");
					
				}
				else if(combo.getText().contentEquals("Maize"))
				{
					//spinner1.setMaximum(500);
					//spinner1.setMinimum(50);
					spinner1.setSelection(200);
					//text5.setToolTipText("50~500");
					//text5.setText("200");
				}
				else if(combo.getText().contentEquals("Groundnuts"))
				{
					//spinner1.setMaximum(200);
					//spinner1.setMinimum(30);
					spinner1.setSelection(80);
					//text5.setToolTipText("30~200");
					//text5.setText("80");			
				}
				else if(combo.getText().contentEquals("Cassava"))
				{
					//spinner1.setMaximum(100);
					//spinner1.setMinimum(30);
					spinner1.setSelection(50);
					//text5.setToolTipText("30~100");
					//text5.setText("50");
				}
				else if(combo.getText().contentEquals("Input new species"))
				{
					
					spinner1.setSelection(100);					
				}
			}			
		});
	}
	/**
	 * This method initializes group6	
	 *
	 */
	public void createGroup6() 
	{
		GridData gridData14 = new GridData();
		gridData14.widthHint = 50;
		GridData gridData13 = new GridData();
		gridData13.widthHint = 380;
		GridData gridData12 = new GridData();
		gridData12.widthHint = -1;
		GridData gridData11 = new GridData();
		gridData11.widthHint = 100;
		GridData gridData9 = new GridData();
		gridData9.horizontalSpan = 2;
		gridData9.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData9.widthHint = -1;
		GridLayout gridLayout7 = new GridLayout();
		gridLayout7.numColumns = 4;
		gridLayout7.marginHeight = 2;
		gridLayout7.horizontalSpacing = 3;
		group6 = new Group(this, SWT.NONE);
		group6.setLayout(gridLayout7);
		group6.setLayoutData(gridData9);
		label2 = new Label(group6, SWT.NONE);
		label2.setText("Import file");
		label2.setLayoutData(gridData11);
		text = new Text(group6, SWT.BORDER);
		text.setEditable(false);//新添加，使之能读入，不能写入
		text.setLayoutData(gridData13);
		
		text.addVerifyListener(new org.eclipse.swt.events.VerifyListener() 
		{
			public void verifyText(org.eclipse.swt.events.VerifyEvent e) 
			{
				if(e.text.endsWith(".mars"))//读取mars文件中的数据，赋给各个控件。
				{
					InputInfoMang mang = new InputInfoMang(BreProcess.getXMLPathAndName());
					List<InputInfoItem> inputInfoList = new ArrayList<InputInfoItem>();
					inputInfoList = mang.createList();
					
					String a = inputInfoList.get(0).getValue();
					text1.setText(a);
					//text1.setText(inputInfoList.get(0).getValue());
					text2.setText(inputInfoList.get(1).getValue());
					combo.setText(inputInfoList.get(2).getValue());
			
					
					spinner1.setSelection(Integer.parseInt(inputInfoList.get(3).getValue()));
					//text5.setText(inputInfoList.get(3).getValue());
					spinner2.setSelection(Integer.parseInt(inputInfoList.get(4).getValue()));
					//text9.setText(inputInfoList.get(4).getValue());
					String val=inputInfoList.get(5).getValue();
					combo12.setText(val);
					if(inputInfoList.get(5).getValue()=="1")
					{combo12.select(0);}
					else if(inputInfoList.get(5).getValue()=="2")
					{combo12.select(1);}
					else if(inputInfoList.get(5).getValue()=="3")
					{combo12.select(2);}
					
					ChangeCombo12();
					combo13.setText(inputInfoList.get(6).getValue());
					combo14.setText(inputInfoList.get(7).getValue());
					combo15.setText(inputInfoList.get(8).getValue());
					dateTime1.setYear( GetYear(inputInfoList.get(9).getValue()));
					dateTime1.setMonth(GetMonth(inputInfoList.get(9).getValue()));
					combo3.setText(inputInfoList.get(10).getValue());
					combo6.setText(inputInfoList.get(11).getValue());
					if(inputInfoList.get(12).getValue().equals(radioButton2.getText()))
					{
						radioButton2.setSelection(true);
						radioButton3.setSelection(false);
					}
					else
					{
						radioButton2.setSelection(false);
						radioButton3.setSelection(true);
					}
					text3.setText(inputInfoList.get(13).getValue());
					combo4.setText(inputInfoList.get(14).getValue());
					text4.setText(inputInfoList.get(15).getValue());
					text6.setText(inputInfoList.get(16).getValue());
					text7.setText(inputInfoList.get(17).getValue());
					combo5.setText(inputInfoList.get(18).getValue());
				}
			}
		});
		label11 = new Label(group6, SWT.NONE);
		label11.setText("");
		label11.setLayoutData(gridData14);
		button = new Button(group6, SWT.NONE);
		button.setText("Browse");
		button.setLayoutData(gridData12);
		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) 
			{
				FileDialog fd = new FileDialog(Display.getCurrent().getActiveShell(),SWT.OPEN);
				fd.setFilterExtensions(new String[]{"*.mars"});
				fd.open();
				if(!fd.getFileName().isEmpty()){
					BreProcess.setXMLPathAndName(fd.getFilterPath()+"\\"+fd.getFileName());
					text.setText(BreProcess.getXMLPathAndName());
				}
			}
		});
		
	}

	/**
	 * This method initializes group7	
	 *
	 */
	private void createGroup7() {
		GridData gridData28 = new GridData();
		gridData28.widthHint = 330;
		gridData28.horizontalSpan = 2;
		gridData28.verticalSpan = 3;
		gridData28.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		GridLayout gridLayout8 = new GridLayout();
		gridLayout8.numColumns = 4;//3--6
		gridLayout8.marginHeight = 2;
		group7 = new Group(this, SWT.NONE);
		group7.setLayout(gridLayout8);
		group7.setLayoutData(gridData28);
		label = new Label(group7, SWT.NONE);
		label.setText("Rounds of selfing after inter-mating");
		Label filler3 = new Label(group7, SWT.NONE);
		createCombo5();
	}
	/**
	 * This method initializes group9	
	 *
	 */
	private void createGroup9() {
		GridData gridData37 = new GridData();
		gridData37.widthHint = 120;
		gridData37.horizontalSpan = 2;
		GridData gridData31 = new GridData();
		gridData31.widthHint = 163;
		GridData gridData30 = new GridData();
		gridData30.widthHint = 163;
		GridData gridData29 = new GridData();
		gridData29.widthHint = 163;
		GridData gridData27 = new GridData();
		gridData27.widthHint = 300;//290-300
		gridData27.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		GridLayout gridLayout10 = new GridLayout();
		gridLayout10.numColumns = 3;
		gridLayout10.marginHeight = 4;
		group9 = new Group(this, SWT.NONE);
		group9.setText("Population development");
		group9.setLayoutData(gridData27);
		group9.setLayout(gridLayout10);
		
		label3 = new Label(group9, SWT.NONE);
		label3.setText("Parental generation starts in");
		label3.setLayoutData(gridData29);
		
		dateTime1 = new DateTime(group9, SWT.DATE|SWT.SHORT|SWT.BORDER);
		dateTime1.setLayoutData(gridData37);
		//DateTime dateTime = new DateTime(group7, SWT.DATE | SWT.SHORT);
		//dateTime.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		
		label4 = new Label(group9, SWT.NONE);
		label4.setText("Generation for genotyping");
		label4.setLayoutData(gridData30);
		createCombo3();
		Label filler1 = new Label(group9, SWT.NONE);
		label5 = new Label(group9, SWT.NONE);
		label5.setText("Generation for phenotyping");
		label5.setLayoutData(gridData31);
		createCombo6();
		Label filler = new Label(group9, SWT.NONE);
		createGroup4();
	}

	/**
	 * This method initializes group8	
	 *
	 */
	private void createGroup8() {
		GridData gridData23 = new GridData();
		gridData23.widthHint = 65;
		GridData gridData22 = new GridData();
		gridData22.widthHint = 190;
		GridData gridData20 = new GridData();
		gridData20.widthHint = 190;
		GridData gridData10 = new GridData();
		gridData10.widthHint = 300;
		gridData10.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		GridLayout gridLayout9 = new GridLayout();
		gridLayout9.numColumns = 2;
		gridLayout9.marginHeight = 2;
		group8 = new Group(this, SWT.NONE);
		group8.setText("Species information");
		group8.setLayoutData(gridData10);
		group8.setLayout(gridLayout9);
		label6 = new Label(group8, SWT.NONE);
		label6.setText("Crop species");
		label6.setLayoutData(gridData20);
		createCombo();
		label7 = new Label(group8, SWT.NONE);
		label7.setText("Expected seeds per plant");
		label7.setLayoutData(gridData22);
		//text5.setText("150");	
		//text5.setToolTipText("Expected 30~300"); 
		spinner1 = new Spinner(group8, SWT.BORDER);
		spinner1.setMaximum(1000000);
		spinner1.setMinimum(1);
		spinner1.setLayoutData(gridData23);				
		//spinner1.setMinimum(30);
		//spinner1.setMaximum(300);
		spinner1.setSelection(150);		
		spinner1.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent paramFocusEvent) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void focusLost(FocusEvent paramFocusEvent) {
				// TODO Auto-generated method stub
				if(combo.getText().endsWith("Cowpea"))
				{
					int i;
					i = spinner1.getSelection();
					if(i>300){
						spinner1.setSelection(300);
					}
					if(i < 30){
						spinner1.setSelection(30);
					}						
				}
				if(combo.getText().endsWith("Rice"))
				{
					int i;
					i = spinner1.getSelection();
					if(i>300){
						spinner1.setSelection(300);
					}
					if(i < 50){
						spinner1.setSelection(50);
					}						
				}
				if(combo.getText().endsWith("Wheat"))
				{
					int i;
					i = spinner1.getSelection();
					if(i>250){
						spinner1.setSelection(250);
					}
					if(i < 50){
						spinner1.setSelection(50);
					}						
				}
				if(combo.getText().endsWith("Maize"))
				{
					int i;
					i = spinner1.getSelection();
					if(i>500){
						spinner1.setSelection(500);
					}
					if(i < 50){
						spinner1.setSelection(50);
					}						
				}
				if(combo.getText().endsWith("Groundnuts"))
				{
					int i;
					i = spinner1.getSelection();
					if(i>200){
						spinner1.setSelection(200);
					}
					if(i < 30){
						spinner1.setSelection(30);
					}						
				}
				if(combo.getText().endsWith("Cassava"))
				{
					int i;
					i = spinner1.getSelection();
					if(i>100){
						spinner1.setSelection(100);
					}
					if(i < 30){
						spinner1.setSelection(30);
					}						
				}
				if(combo.getText().endsWith("Add new species"))
				{
					int i;
					i = spinner1.getSelection();
					if(i>1000000){
						spinner1.setSelection(1000000);
					}
					if(i < 1){
						spinner1.setSelection(1);
					}						
				}
			}														
		});			
	}
			

	private int GetYear(String text) {
		String[] texts=text.split("/");
		if(texts.length>=2)
		{
		return Integer.parseInt(texts[0]);
		}
		else
		{
			return 1;
		}
	}
    private int GetMonth(String text) {
    	String[] texts=text.split("/");
    	if(texts.length>=2)
		{
		return (Integer.parseInt(texts[1])-1);
		}
		else
		{
			return 1;
		}
	    
	}
  
    private void ChangeCombo12()
    {
    	if(combo12.getSelectionIndex()==0)
	    {
	    	combo13.setEnabled(true);
	    	//combo14.setText("");
	    	//combo15.setText("");
	    	combo14.removeAll();
	    	combo15.removeAll();
	    	combo14.setEnabled(false);
	    	combo15.setEnabled(false);
	    	
	    	combo13.removeAll();
	    	combo13.add("Jan");
			combo13.add("Feb");
			combo13.add("Mar");
			combo13.add("Apr");
			combo13.add("May");
			combo13.add("June");
			combo13.add("July");
			combo13.add("Aug");
			combo13.add("Sept");
			combo13.add("Oct");
			combo13.add("Nov");
			combo13.add("Dec");
	    	combo13.setText("Jan");
	    	
	    	
	    }
	    else if(combo12.getSelectionIndex()==1)
	    {
	    	combo13.setEnabled(true);
	    	combo14.setEnabled(true);
	    	combo15.removeAll();
	    	combo15.setEnabled(false);
	    	
	    	combo13.removeAll();
	    	combo14.removeAll();
	    	combo13.add("Jan");
			combo13.add("Feb");
			combo13.add("Mar");
			combo13.add("Apr");
			combo13.add("May");
			combo13.add("June");
			combo13.add("July");
			combo13.add("Aug");
			combo13.add("Sept");
			combo13.add("Oct");
			combo13.add("Nov");
			
			combo14.add("Jan");
			combo14.add("Feb");
			combo14.add("Mar");
			combo14.add("Apr");
			combo14.add("May");
			combo14.add("June");
			combo14.add("July");
			combo14.add("Aug");
			combo14.add("Sept");
			combo14.add("Oct");
			combo14.add("Nov");
			combo14.add("Dec");
			
	    	combo13.setText("Jan");
	    	combo14.setText("July");
	    	
	    }
	    else if(combo12.getSelectionIndex()==2)
	    {
	    	combo13.setEnabled(true);
	    	combo14.setEnabled(true);
	    	combo15.setEnabled(true);
	    	
	    	combo13.removeAll();
	    	combo14.removeAll();
	    	combo15.removeAll();
	    	
	    	combo13.add("Jan");
			combo13.add("Feb");
			combo13.add("Mar");
			combo13.add("Apr");
			combo13.add("May");
			combo13.add("June");
			combo13.add("July");
			combo13.add("Aug");
			combo13.add("Sept");
			combo13.add("Oct");

			combo14.add("Jan");
			combo14.add("Feb");
			combo14.add("Mar");
			combo14.add("Apr");
			combo14.add("May");
			combo14.add("June");
			combo14.add("July");
			combo14.add("Aug");
			combo14.add("Sept");
			combo14.add("Oct");
			combo14.add("Nov");
		
			combo15.add("Jan");
			combo15.add("Feb");
			combo15.add("Mar");
			combo15.add("Apr");
			combo15.add("May");
			combo15.add("June");
			combo15.add("July");
			combo15.add("Aug");
			combo15.add("Sept");
			combo15.add("Oct");
			combo15.add("Nov");
			combo15.add("Dec");
						
	    	combo13.setText("Jan");
	    	combo14.setText("May");
	    	combo15.setText("Sept");
	    }
	    else
	    {
	    	    combo13.setEnabled(true);
		    	combo14.setEnabled(true);
		    	combo15.setEnabled(true);
		    	combo13.setText("");
		    	combo14.setText("");
		    	combo15.setText("");
	    }
    }
	
    
    /**
	 * This method initializes combo11	
	 *
	 */
}  
