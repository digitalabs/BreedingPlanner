package com.gui.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import com.io.InputInfoItem;
import com.io.InputInfoMang;
import com.io.InputInfoMangMAS;
import com.overall.BreProcess;
import com.overall.Validate;

public class ModifyCompositeMAS extends Composite {

	private Shell sShell = null;
	private Label label1 = null;
	private GridData widthGridData = null;
	private Group group2 = null;
	private Label label20 = null;
	private Label label23 = null;
	//private Text text9 = null;
	private Spinner spinner2 = null;
	private Spinner spinner1 = null;
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
	private Group group8 = null;
	private Label label6 = null;
	private Label label7 = null;
	//private Text text5 = null;
	private Label label11 = null;
	private Label label12 = null;
	private Label label = null;
	private Group group = null;
	private Label label18 = null;
	private Combo combo17 = null;
	private Label label19 = null;
	private DateTime dateTime1 = null;
	public ModifyCompositeMAS(Composite parent, int style, Shell sShell) {
		super(parent, style);
		this.sShell = sShell;
		initialize();
	}

	private void initialize() {
		widthGridData = new GridData();
		widthGridData.widthHint = 62;
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		gridLayout.marginHeight = 1;
		gridLayout.makeColumnsEqualWidth = true;
		createGroup6();
		GridData gridData1 = new GridData();
//		gridData.verticalAlignment = SWT.CENTER;
		gridData1.horizontalSpan = 3;
		gridData1.horizontalAlignment = SWT.FILL;
		Label filler6 = new Label(this, SWT.NONE);
		Label filler17 = new Label(this, SWT.NONE);
		gridData1.verticalIndent = 5;
		//label1.setLayoutData(gridData1);

		
		createGroup5();
		createGroup8();
	//	label11 = new Label(this, SWT.NONE);
		Label filler5 = new Label(this, SWT.NONE);
	//	label11.setText("Label");
		Label filler16 = new Label(this, SWT.NONE);
		createGroup2();
		createGroup3();
		Label filler4 = new Label(this, SWT.NONE);
		Label filler15 = new Label(this, SWT.NONE);
		createGroup4();
		createGroup();
		label = new Label(this, SWT.NONE);
		label.setText("");
		this.setSize(new Point(642, 538));
		this.setLayout(gridLayout);
		InputInfoMangMAS mang = new InputInfoMangMAS(BreProcess.getXMLPathAndName());
		List<InputInfoItem> inputInfoList = new ArrayList<InputInfoItem>();
		inputInfoList = mang.createList();
		text1.setText(inputInfoList.get(0).getValue());
		text2.setText(inputInfoList.get(1).getValue());
		combo.setText(inputInfoList.get(2).getValue());
		//text5.setText(inputInfoList.get(3).getValue());
		spinner1.setSelection(Integer.parseInt(inputInfoList.get(3).getValue()));
		spinner2.setSelection(Integer.parseInt(inputInfoList.get(4).getValue()));
		//text9.setText(inputInfoList.get(4).getValue());
		//combo12.setText(inputInfoList.get(5).getValue());
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
        if(inputInfoList.get(10).getValue().equals(radioButton2.getText())){
        	radioButton2.setSelection(true);
        }
        else{
        	radioButton3.setSelection(true);
        }
		combo17.setText(inputInfoList.get(11).getValue());

	}

	public DateTime getDataTime1() {
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
	//public Text getText9() {
	//	return text9;
	//}
	public Spinner getSpinner1(){
		return spinner1;
	}
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
	public Combo getCombo17() {
		return combo17;
	}
	//public Combo getCombo3() {
	//	return combo3;
//	}
//	public Combo getCombo6() {
//		return combo6;
//	}
    public int getRadioButton(){
    	if(radioButton2.getSelection()==true){
    		return 0;
    	}
    	else{
    		return 1;
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
		//text9 = new Text(group2, SWT.BORDER);
		//text9.setText("6");		
		//text9.setLayoutData(widthGridData);
		spinner2 = new Spinner(group2, SWT.BORDER);
		//spinner2.setSelection(6);
		spinner2.setMinimum(1);
		spinner2.setMaximum(100);
		spinner2.setLayoutData(widthGridData);
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
	 * This method initializes group4	
	 *
	 */
	private void createGroup4() {
		GridLayout gridLayout5 = new GridLayout();
		gridLayout5.numColumns = 2;
		group4 = new Group(this, SWT.NONE);
		group4.setText("Growing condition");
		group4.setLayoutData(new GridData());
		group4.setLayout(gridLayout5);
		label19 = new Label(group4, SWT.NONE);
		label19.setText("Parental generation starts in    ");
		createDateTime1();
		radioButton2 = new Button(group4, SWT.RADIO);
		radioButton2.setText("Greenhouse/offseason");
		//radioButton2.setSelection(true);
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
		text1.setEnabled(false);
		text1.setLayoutData(gridData17);
		text1.setText("China");
		label13 = new Label(group5, SWT.NONE);
		label13.setText("Researcher's name");
		label13.setLayoutData(gridData16);
		text2 = new Text(group5, SWT.BORDER);
		text2.setEnabled(false);
		text2.setLayoutData(gridData18);
		text2.setText("CAAS");
	}

	/**
	 * This method initializes combo	
	 *
	 */
	private void createCombo() {
		GridData gridData21 = new GridData();
		gridData21.widthHint = 65;
		combo = new Combo(group8, SWT.READ_ONLY);
		combo.setEnabled(false);
		combo.setLayoutData(gridData21);
		combo.add("Cowpea");
		combo.add("Rice");
		combo.add("Wheat");
		combo.add("Maize");
		combo.add("Groundnuts");
		combo.add("Cassava");
		combo.setText("Cowpea");

	}

	/**
	 * This method initializes group6	
	 *
	 */
	private void createGroup6() {
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
		text.setEnabled(false);
		text.setLayoutData(gridData13);
		text.addVerifyListener(new org.eclipse.swt.events.VerifyListener() {
			public void verifyText(org.eclipse.swt.events.VerifyEvent e) {
				if(e.text.endsWith(".mas")){
					InputInfoMangMAS mang = new InputInfoMangMAS(BreProcess.getXMLPathAndName());
					List<InputInfoItem> inputInfoList = new ArrayList<InputInfoItem>();
					inputInfoList = mang.createList();
					text1.setText(inputInfoList.get(0).getValue());
					text2.setText(inputInfoList.get(1).getValue());
					combo.setText(inputInfoList.get(2).getValue());
					//text5.setText(inputInfoList.get(3).getValue());
					spinner1.setSelection(Integer.parseInt(inputInfoList.get(3).getValue()));
					spinner2.setSelection(Integer.parseInt(inputInfoList.get(4).getValue()));
					//text9.setText(inputInfoList.get(4).getValue());
					//.setText(inputInfoList.get(5).getValue());
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
					if(inputInfoList.get(10).getValue()=="Greenhouse/offseason")
					{
						radioButton2.setSelection(true);
						radioButton3.setSelection(false);
					}
					else
					{
						radioButton2.setSelection(false);
						radioButton3.setSelection(true);
					}
					combo17.setText(inputInfoList.get(11).getValue());
				}
			}
		});
		label11 = new Label(group6, SWT.NONE);
		label11.setText("");
		label11.setLayoutData(gridData14);
		button = new Button(group6, SWT.NONE);
		button.setText("Browse");
		button.setEnabled(false);
		button.setLayoutData(gridData12);
		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				//System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
				FileDialog fd = new FileDialog(Display.getCurrent().getActiveShell(),SWT.OPEN);
				fd.setFilterExtensions(new String[]{"*.mabc"});
				fd.open();
				if(!fd.getFileName().isEmpty()){
					BreProcess.setXMLPathAndName(fd.getFilterPath()+"\\"+fd.getFileName());
					text.setText(BreProcess.getXMLPathAndName());
				}
			}
		});
		
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
		//text5 = new Text(group8, SWT.BORDER);
		//text5.setLayoutData(gridData23);
		//text5.setText("100");
		spinner1 = new Spinner(group8, SWT.BORDER);
		spinner1.setMinimum(1);
		spinner1.setMaximum(1000000);
		spinner1.setLayoutData(gridData23);				
		//spinner1.setMinimum(30);
		//spinner1.setMaximum(300);
		//spinner1.setSelection(150);
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
			}														
		});	
		/*
		spinner1.addModifyListener(new ModifyListener()
		{
			public void modifyText(ModifyEvent arg0) 
			{
				if(combo.getText().endsWith("Cowpea"))
				{
					if(Validate.validateInteger(spinner1.getText()))
					{												
						
						if(Integer.parseInt(spinner1.getText()) >300)
						{
							spinner1.setSelection(300);							
						}			
						
					}	
				}		
				if(combo.getText().endsWith("Rice"))
				{
					if(Validate.validateInteger(spinner1.getText()))
					{												
						
						if(Integer.parseInt(spinner1.getText()) >300)
						{
							spinner1.setSelection(300);							
						}			
						
					}	
				}		
				if(combo.getText().endsWith("Wheat"))
				{
					if(Validate.validateInteger(spinner1.getText()))
					{												
						
						if(Integer.parseInt(spinner1.getText()) >250)
						{
							spinner1.setSelection(250);							
						}			
						
					}	
				}		if(combo.getText().endsWith("Maize"))
				{
					if(Validate.validateInteger(spinner1.getText()))
					{												
						
						if(Integer.parseInt(spinner1.getText()) >500)
						{
							spinner1.setSelection(500);							
						}			
						
					}	
				}		
				if(combo.getText().endsWith("Groundnuts"))
				{
					if(Validate.validateInteger(spinner1.getText()))
					{												
						
						if(Integer.parseInt(spinner1.getText()) >200)
						{
							spinner1.setSelection(200);							
						}			
						
					}	
				}		
				if(combo.getText().endsWith("Cassava"))
				{
					if(Validate.validateInteger(spinner1.getText()))
					{												
						
						if(Integer.parseInt(spinner1.getText()) >100)
						{
							spinner1.setSelection(100);							
						}			
						
					}	
				}		
			}														
		});						*/
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

	/**
	 * This method initializes group	
	 *
	 */
	private void createGroup() {
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 3;
		group = new Group(this, SWT.NONE);
		group.setText("Number of genes");
		group.setLayout(gridLayout1);
		label18 = new Label(group, SWT.NONE);
		label18.setText("Number of unlinked genes \r\n to be combined");
		createCombo17();
	}

	/**
	 * This method initializes combo17	
	 *
	 */
	private void createCombo17() {
		GridData gridData27 = new GridData();
		gridData27.widthHint = 65;
		GridData gridData7 = new GridData();
		gridData7.horizontalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData7.widthHint = 65;
		combo17 = new Combo(group, SWT.READ_ONLY);
		combo17.add("2");
		combo17.add("3");
		combo17.add("4");
		combo17.add("5");
		combo17.add("6");
		combo17.add("7");
		combo17.add("8");
		combo17.add("9");
		combo17.add("10");
		combo17.setText("2");
		combo17.setLayoutData(gridData27);
	}

	/**
	 * This method initializes dateTime1	
	 *
	 */
	private void createDateTime1() {
		dateTime1 = new DateTime(group4, SWT.DATE | SWT.SHORT | SWT.BORDER);
	}
	
	 
	    private void ChangeCombo12()
	    {
	    	if(combo12.getSelectionIndex()==0)
		    {
		    	combo13.setEnabled(true);
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
				//combo13.add("Nov");
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
				//combo14.add("Dec");
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
		
	 
}  //  @jve:decl-index=0:visual-constraint="10,10"
