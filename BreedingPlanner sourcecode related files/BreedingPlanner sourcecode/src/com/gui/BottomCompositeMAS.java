package com.gui;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import com.gui.dialog.PlanDialog;
import com.io.InputInfoItem;
import com.io.InputInfoMangMAS;
import com.overall.BreProcess;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.graphics.Point;

public class BottomCompositeMAS extends Composite {

	private static List<String> PLAN = null;  //  @jve:decl-index=0:
	private DateTime dateTime1=null;
	private Group group = null;
	private Combo combo = null;
	private Button button = null;
	private GridData comboGridData = new GridData();  //  @jve:decl-index=0:
	private List<InputInfoItem> inputInfoList = null;  //  @jve:decl-index=0:
	private static String CONDITION =null;  //  @jve:decl-index=0:
	private static int NumGenes;
	private int LENGTHSEASON;
	private int SEASONPERYEAR;
	private int FIRSTSEASON;  
	private int SECONDSEASON;
	private int THIRDSEASON;
	private float totalSeason ;
	private float pastSeason ;
	private float leftSeason;
	private float leftYear;
	private float leftYearAbout ;
	private int year ;
	private int month ;

	private static int STARTYEAR;
	private static int STARTMONTH;
	private static int CURRENTYEAR;
	private static int CURRENTMONTH;
	private static int ENDYEAR;
	private static int ENDMONTH;

	private Group group2 = null;
	private Label label = null;
	private Text text1 = null;
	private Label label1 = null;
	private Button button1 = null;
	public BottomCompositeMAS(Composite parent, int style) {
		super(parent, style);
		initialize();
	}
	
	private void computeStage() {
		String XMLPathAndName = BreProcess.getXMLPathAndName();
		InputInfoMangMAS mang = new InputInfoMangMAS(XMLPathAndName);
		inputInfoList = mang.createList();
		SEASONPERYEAR = Integer.parseInt(inputInfoList.get(5).getValue());
		LENGTHSEASON = Integer.parseInt(inputInfoList.get(4).getValue());
		SEASONPERYEAR = Integer.parseInt(inputInfoList.get(5).getValue());
		FIRSTSEASON = changeMonth(inputInfoList.get(6).getValue());
		SECONDSEASON = changeMonth(inputInfoList.get(7).getValue());
		THIRDSEASON = changeMonth(inputInfoList.get(8).getValue());
		CONDITION = inputInfoList.get(10).getValue();
		NumGenes=Integer.parseInt(inputInfoList.get(11).getValue());
		
	}
	
	private void addPlan(){
		PLAN=new LinkedList<String>();
	//	STARTYEAR=dateTime1.getYear();
	//	STARTMONTH=dateTime1.getMonth();
        ENDYEAR=STARTYEAR;
        ENDMONTH=STARTMONTH;
        
		//1.1
		if(pastSeason==0){
			
			CURRENTYEAR=STARTYEAR;
			CURRENTMONTH=STARTMONTH;
			CalculatingYM();
			PLAN.add(addPlanText("Parental generation")+" make a few hybrid seeds by hand pollination;");
			PLAN.add("");
		}
       //1.2
		if(pastSeason<=1){
	       	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
	 		CalculatingYM();
	 		PLAN.add(addPlanText("F1")+" harvest 100-300 selfed seeds in bulk;");
			PLAN.add("");
 		}
		//1.3
		if(pastSeason<=2){
	       	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
	 		CalculatingYM();
	 		if(NumGenes>=5){
		 		PLAN.add(addPlanText("F2")+" genotype F2 individuals with chosen markers; apply enhancement selection;" +
		 				" harvest equal selfed seeds from each selected plants;");
	 		}
	 		else{
	 	 		PLAN.add(addPlanText("F2")+" genotype F2 individuals with chosen markers;" +
	 	 				" harvest equal selfed seeds from each selected plants;");
	 		}
			PLAN.add("");
		}
		//1.4
		if(pastSeason<=3){
	       	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
	 		CalculatingYM();
	 		PLAN.add(addPlanText("F3")+" single seed descent (SSD) applys in F3;");
			PLAN.add("");
		}
		//1.5
		if(pastSeason<=4){
	       	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
	 		CalculatingYM();
	 		PLAN.add(addPlanText("F4")+" single seed descent (SSD) applys in F4;");
			PLAN.add("");
		}
		//1.6
		if(pastSeason<=5){
	       	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
	 		CalculatingYM();
			PLAN.add(addPlanText("F5")+" single seed descent (SSD) applys in F5;");
			PLAN.add("");
		}
		//1.7
		if(pastSeason<=6){
	       	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
	 		CalculatingYM();
	 		if(NumGenes>=5){
	 			PLAN.add(addPlanText("F6")+" genotype each family with chosen markers; " +
	 					"select the target genotype in F6 families;");
	 		}
	 		else{
				PLAN.add(addPlanText("F6")+" genotype each family with chosen markers;");
	 		}
			PLAN.add("");
		}

       	//summary
       	int totalMonth;
       	if(ENDMONTH<STARTMONTH){
       		totalMonth=ENDMONTH+12-STARTMONTH+(ENDYEAR-1-STARTYEAR)*12;
       	}
       	else{
       		totalMonth=ENDMONTH-STARTMONTH+(ENDYEAR-STARTYEAR)*12;
       	}
       	PLAN.add("The MAS scheme takes "+(totalMonth/12)+" years and "+(totalMonth%12)+" months.");
 	}
	

	private void CalculatingYM()
	{
		if(CONDITION.equals("Greenhouse/offseason"))
		{
			ENDMONTH=CURRENTMONTH + (LENGTHSEASON-1);
			ENDYEAR=(int) (CURRENTYEAR  + Math.floor(ENDMONTH/12));
			if(ENDMONTH > 12)
			{
			 ENDMONTH = ENDMONTH%12;	
			 if(ENDMONTH == 0)
			 {
				 ENDMONTH = 12;
			 }
			}
		}
		else
		{
            if(SEASONPERYEAR == 1)
            {
				if(CURRENTMONTH <= FIRSTSEASON)
				{
					CURRENTMONTH=FIRSTSEASON;
					ENDMONTH=(FIRSTSEASON-1);
					if(ENDMONTH == 0)
					{
					ENDMONTH = 12;
					ENDYEAR = CURRENTYEAR;
					}
					else
					{
					ENDYEAR=CURRENTYEAR+1;	
					}			
				}
				else
				{
					CURRENTMONTH=FIRSTSEASON;
					CURRENTYEAR=CURRENTYEAR+1;
					ENDMONTH=(FIRSTSEASON-1);
					if(ENDMONTH == 0)
					{
					ENDMONTH = 12;
					ENDYEAR = CURRENTYEAR;
					}
					else
					{
					ENDYEAR=CURRENTYEAR+1;	
					}
				}
			}
            else if(SEASONPERYEAR == 2)
            {
				if(CURRENTMONTH <= FIRSTSEASON)
				{
					CURRENTMONTH=FIRSTSEASON;
					ENDMONTH=(SECONDSEASON-1);	
					ENDYEAR=CURRENTYEAR;
				}
				else if(CURRENTMONTH <= SECONDSEASON & CURRENTMONTH > FIRSTSEASON)
				{
					CURRENTMONTH=SECONDSEASON;
					ENDMONTH=(FIRSTSEASON-1);
					if(ENDMONTH == 0)
					{
						ENDMONTH = 12;
						ENDYEAR = CURRENTYEAR;
					}
					else
					{
						ENDYEAR=CURRENTYEAR+1;
					}
				}
				else
				{
					CURRENTMONTH=FIRSTSEASON;
					CURRENTYEAR=CURRENTYEAR+1;
					ENDMONTH=(SECONDSEASON-1);
					ENDYEAR=CURRENTYEAR;
				}            	
            }
            else if(SEASONPERYEAR == 3)
            {
				if(CURRENTMONTH <= FIRSTSEASON)
				{
					CURRENTMONTH=FIRSTSEASON;
					ENDMONTH=(SECONDSEASON-1);
					ENDYEAR=CURRENTYEAR;

				}
				else if(CURRENTMONTH <= SECONDSEASON & CURRENTMONTH > FIRSTSEASON)
				{
					CURRENTMONTH=SECONDSEASON;
					ENDMONTH=(THIRDSEASON-1);
					ENDYEAR=CURRENTYEAR;

				}
				else if(CURRENTMONTH <= THIRDSEASON & CURRENTMONTH > SECONDSEASON)
				{
					CURRENTMONTH=THIRDSEASON;
					ENDMONTH=(FIRSTSEASON-1);
					if(ENDMONTH == 0)
					{
						ENDMONTH = 12;
						ENDYEAR = CURRENTYEAR;
					}
					else
					{
						ENDYEAR=CURRENTYEAR+1;
					}
				}
				else
				{
					CURRENTMONTH=FIRSTSEASON;
					CURRENTYEAR=CURRENTYEAR+1;
					ENDMONTH=(SECONDSEASON-1);
					ENDYEAR=CURRENTYEAR;
				}
            	
            } 
		}
	}
	
	
	private String addPlanText(String headText) 
	{
		String text=headText+" starts in " + CURRENTYEAR + "/" + CURRENTMONTH + ";" 
		 + " ends in " + ENDYEAR + "/" + ENDMONTH + ";";
		text=text+" grows in " + CONDITION + ";";
		
		return text;
	}

	private void initialize() {
		computeStage();
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		comboGridData.widthHint = 300;
		createGroup2();
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		this.setLayout(gridLayout);
		createGroup();
		this.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		this.setSize(new Point(847, 199));
		Label filler22 = new Label(this, SWT.NONE);
		button = new Button(this, SWT.NONE);
		button.setText("Make a Plan");
		button.setLayoutData(gridData2);
		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				if(!combo.getText().isEmpty()){
					
					pastSeason=7;
					if(combo.getText().contains("0.")||combo.getText().contains("1.")){
							pastSeason = 0;
					}
					if(combo.getText().contains("2.")){
						pastSeason = 1;
					}
					if(combo.getText().contains("3.")){
						pastSeason = 2;
					}
					if(combo.getText().contains("4.")){
						pastSeason = 3;
					}
					if(combo.getText().contains("5.")){
						pastSeason = 4;
					}
					if(combo.getText().contains("6.")){
						pastSeason = 5;
					}
					if(combo.getText().contains("7.")){
						pastSeason = 6;
					}
//					System.out.println(pastSeason);
		    		STARTYEAR = dateTime1.getYear();
		    		STARTMONTH = dateTime1.getMonth()+1;

		            
					addPlan();
					PlanDialog pd = new PlanDialog(Display.getCurrent().getActiveShell());
					pd.SetPlanText(PLAN);
					pd.open();
					
				}
				
			}
			
		
		});
	}

	/**
	 * This method initializes group	
	 *
	 */
	private void createGroup() {
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 2;
		gridLayout2.marginHeight = 5;
		group = new Group(this, SWT.NONE);
		group.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		group.setLayout(gridLayout2);
		group.setText("Select current status");
		
		GridData groupGridData = new GridData();
		groupGridData.widthHint = 350;
		groupGridData.heightHint = 50;
		group.setLayoutData(groupGridData);
		
		createCombo();
	
		
	}

	/**
	 * This method initializes combo	
	 *
	 */
	private void createCombo() {
		combo = new Combo(group, SWT.NONE);
		combo.setLayoutData(comboGridData);
		combo.add("0. Select parental lines and prepare for planting");
		combo.add("1. Parental lines is growing");
		combo.add("2. F1 generation is growing");
		combo.add("3. F2 generation is growing");
		combo.add("4. F3 generation is growing");
		combo.add("5. F4 generation is growing");
		combo.add("6. F5 generation is growing");
		combo.add("7. F6 generation is growing");
		
		combo.setText("0. Select parental lines and prepare for planting");
	}

	/**
	 * This method initializes group2	
	 *
	 */
	private void createGroup2() {
		GridData gridData1 = new GridData();
		gridData1.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		GridData gridData = new GridData();
		gridData.widthHint = 120;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 3;
		group2 = new Group(this, SWT.NONE);
		group2.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		group2.setLayout(gridLayout1);
		group2.setLayoutData(gridData1);
		label = new Label(group2, SWT.NONE);
		label.setText("Current status starts in");
		label.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		label1 = new Label(group2, SWT.NONE);
		label1.setText("     ");
		label1.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		dateTime1 = new DateTime(group2, SWT.DATE | SWT.SHORT | SWT.BORDER);
		dateTime1.setBackground(new Color(Display.getCurrent(), 240, 240, 240));
		dateTime1.setLayoutData(gridData);
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

	private int changeMonth(String month){
		if(month.equals("Jan")){
			return 1;
		}
		else if(month.equals("Feb")){
			return 2;
		}
		else if(month.equals("Mar")){
			return 3;
		}
		else if(month.equals("Apr")){
			return 4;
		}
		else if(month.equals("May")){
			return 5;
		}
		else if(month.equals("June")){
			return 6;
		}
		else if(month.equals("July")){
			return 7;
		}
		else if(month.equals("Aug")){
			return 8;
		}
		else if(month.equals("Sept")){
			return 9;
		}
		else if(month.equals("Oct")){
			return 10;
		}
		else if(month.equals("Nov")){
			return 11;
		}
		else if(month.equals("Dec")){
			return 12;
		}
		else{
			return 0;
		}
	}

}  //  @jve:decl-index=0:visual-constraint="-34,181"
