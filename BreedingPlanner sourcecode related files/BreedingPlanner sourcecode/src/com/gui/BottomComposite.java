package com.gui;

import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
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
//import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import com.gui.dialog.PlanDialog;
import com.io.InputInfoItem;
import com.io.InputInfoMang;
import com.overall.BreProcess;

//import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.graphics.Point;

public class BottomComposite extends Composite {

	private static List<String> PLAN = null;  //  @jve:decl-index=0:
	private DateTime dateTime1=null;
	private Group group = null;
	private Combo combo = null;
	private Combo combo1 = null;
	private Button button = null;
	private GridData comboGridData = new GridData();  //  @jve:decl-index=0:
	private List<InputInfoItem> inputInfoList = null;  //  @jve:decl-index=0:
	private static String CONDITION =null;  //  @jve:decl-index=0:
	private static String GENOTYPING = null;
	private static String PHENOTYPING = null;
	private static String ROUNDS_SELFING = null;
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
	private int stage1;
	private int stage4;
	private int calculatingStage;

	private static int STARTYEAR;
	private static int STARTMONTH;
	private static int CURRENTYEAR;
	private static int CURRENTMONTH;
	private static int ENDYEAR;
	private static int ENDMONTH;
	private static int NLOCATIONS;
	private static int NREPS;
	private static int NROWS;
	private static String PLOTLENGTH=null;
	private static int NPLANTS;
	private static int currentCondition; //0 for common generation; 1 for genotyping generation; 2 for phenotyping generation 

	private Group group2 = null;
	private Label label = null;
	private Text text1 = null;
	private Label label1 = null;
	private Button button1 = null;
	public BottomComposite(Composite parent, int style) 
	{
		super(parent, style);
		initialize();
	}
	
	private void computeStage() 
	{
		String XMLPathAndName = BreProcess.getXMLPathAndName();
		InputInfoMang mang = new InputInfoMang(XMLPathAndName);
		inputInfoList = mang.createList();
		PHENOTYPING = inputInfoList.get(11).getValue();
		ROUNDS_SELFING = inputInfoList.get(18).getValue();
		SEASONPERYEAR = Integer.parseInt(inputInfoList.get(5).getValue());
		stage1 = Integer.parseInt(PHENOTYPING.substring(1))+1;
		stage4 = Integer.parseInt(ROUNDS_SELFING);
		calculatingStage=0;
		LENGTHSEASON = Integer.parseInt(inputInfoList.get(4).getValue());
		SEASONPERYEAR = Integer.parseInt(inputInfoList.get(5).getValue());
		FIRSTSEASON = changeMonth(inputInfoList.get(6).getValue());
		SECONDSEASON = changeMonth(inputInfoList.get(7).getValue());
		THIRDSEASON = changeMonth(inputInfoList.get(8).getValue());
		GENOTYPING = inputInfoList.get(10).getValue();
		PHENOTYPING = inputInfoList.get(11).getValue();
		CONDITION = inputInfoList.get(12).getValue();
		NLOCATIONS= Integer.parseInt(inputInfoList.get(13).getValue());
		NREPS= Integer.parseInt(inputInfoList.get(14).getValue());
		PLOTLENGTH= inputInfoList.get(15).getValue();
		NROWS= Integer.parseInt(inputInfoList.get(16).getValue());
		NPLANTS= Integer.parseInt(inputInfoList.get(17).getValue());
		ROUNDS_SELFING = inputInfoList.get(18).getValue();
		
	}
	private void addPlan()
	{
		PLAN=new LinkedList<String>();
	//	STARTYEAR=dateTime1.getYear();
	//	STARTMONTH=dateTime1.getMonth();
        ENDYEAR=STARTYEAR;
        ENDMONTH=STARTMONTH;
        
		if(pastSeason<stage1){
			PLAN.add("1 Population development stage");
		}
		//1.1
		if(pastSeason==0)
		{
			
			CURRENTYEAR=STARTYEAR;
			CURRENTMONTH=STARTMONTH;
			CalculatingYM();
			currentCondition=0;
			PLAN.add(addPlanText("Parental generation"));
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
			currentCondition=0;
	 		PLAN.add(addPlanText("F1"));
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
			if(GENOTYPING.equals("F2")){
				currentCondition=1;
			}
			else{
				currentCondition=0;
			}
			PLAN.add(addPlanText("F2"));
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
			if(PHENOTYPING.equals("F3")){
				currentCondition=2;
				CalculatingYMField();
				PLAN.add(addPlanText("F2:3"));
			}
			else {
				if(GENOTYPING.equals("F3")){
					currentCondition=1;
				}
				else{
					currentCondition=0;
				}
				CalculatingYM();
				PLAN.add(addPlanText("F3"));
			}
		}
		//1.5
		if(pastSeason<=Math.min(4,stage1)){
	      	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
			if(PHENOTYPING.equals("F4")){
				currentCondition=2;
				CalculatingYMField();
				if(GENOTYPING.equals("F2")){
					PLAN.add(addPlanText("F2:4"));
				}
				else{
					PLAN.add(addPlanText("F3:4"));
				}
			}
			else if(PHENOTYPING.equals("F5")||PHENOTYPING.equals("F6")){
				currentCondition=0;
				CalculatingYM();
				PLAN.add(addPlanText("F4"));
			}
			else{
				//end stage 1
			}
		}
		//1.6
		if(pastSeason<=Math.min(5,stage1)){

			CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
			if(PHENOTYPING.equals("F5")){
				currentCondition=2;
				CalculatingYMField();
				if(GENOTYPING.equals("F2")){
					PLAN.add(addPlanText("F2:5"));
				}
				else{
					PLAN.add(addPlanText("F3:5"));
				}
			}
			else if(PHENOTYPING.equals("F6")){
				currentCondition=0;
				CalculatingYM();
				PLAN.add(addPlanText("F5"));	
				}
			else{
				//end stage 1
			}
		}		
        //1.7
		if(pastSeason<=Math.min(6,stage1)){
	       	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
			if(PHENOTYPING.equals("F6")){
				currentCondition=2;
				CalculatingYMField();
				PLAN.add(addPlanText("F3:6"));
			}
			else{
				//end stage 1
			}
		}
		//end stage 1
		if(pastSeason<stage1){
			PLAN.add("");
		}
        //2
		if(pastSeason<=stage1 && calculatingStage<=3){
			PLAN.add("2 QTL analysis and selection stage");
		}
		
		//2.1
		if(pastSeason<=stage1 && calculatingStage<=1){
			CURRENTMONTH=ENDMONTH;
	       	CURRENTYEAR=ENDYEAR;
			ENDMONTH=CURRENTMONTH+1;
			if(ENDMONTH > 12){
				ENDYEAR = CURRENTYEAR + 1;
				ENDMONTH = ENDMONTH -12;
				}
			PLAN.add("Genotypic and phenotypic data collection starts in "+CURRENTYEAR+"/"+CURRENTMONTH+ "; ends in "+ENDYEAR+"/"+ENDMONTH+";");
		}
		//2.2
		if(pastSeason<=stage1 && calculatingStage<=2){
	       	CURRENTMONTH=ENDMONTH;
	       	CURRENTYEAR=ENDYEAR;
			ENDMONTH=CURRENTMONTH+1;
			if(ENDMONTH > 12){
				ENDYEAR = CURRENTYEAR + 1;
				ENDMONTH = ENDMONTH -12;
				}
			PLAN.add("QTL analysis starts in "+CURRENTYEAR+"/"+CURRENTMONTH+ "; ends in "+ENDYEAR+"/"+ENDMONTH+";");
		}
		//2.3
		if(pastSeason<=stage1 && calculatingStage<=3){
	       	CURRENTMONTH=ENDMONTH;
	       	CURRENTYEAR=ENDYEAR;
			ENDMONTH=CURRENTMONTH+1;
			if(ENDMONTH > 12){
				ENDYEAR = CURRENTYEAR + 1;
				ENDMONTH = ENDMONTH -12;
				}
			PLAN.add("Selecting parental lines for inter-mating starts in "+CURRENTYEAR+"/"+CURRENTMONTH+ "; ends in "+ENDYEAR+"/"+ENDMONTH+";" + " you may use OptiMARS to select the parental lines for interacting;");
			PLAN.add("");
		}		
		//3.1
		if(pastSeason<=stage1+2){
			PLAN.add("3 Recombination stage");
		}
		if(pastSeason<=stage1){
	       	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
			CalculatingYM();
			currentCondition=0;
			PLAN.add("Grow the reserved seeds from selected individual plants;");
			PLAN.add(addPlanText("Two-way inter-mating (or single cross)")+" you need to do genotyping and use marker information to select individuals for four-way inter-mating;");
		}
		//3.2
       	if(pastSeason<=stage1+1){
			CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
			CalculatingYM();
			currentCondition=0;
			PLAN.add(addPlanText("Four-way inter-mating (or double cross)")+" you need to do genotyping and use marker information to select individuals for eight-way inter-mating;");
       	}
	    //3.3
       	if(pastSeason<=stage1+2){
       	CURRENTMONTH=ENDMONTH+1;
       	CURRENTYEAR=ENDYEAR;
       	if(CURRENTMONTH == 13)
       	{
       		CURRENTMONTH  = 1;
	        CURRENTYEAR = CURRENTYEAR + 1;
       	}
		CalculatingYM();
		currentCondition=0;
		PLAN.add(addPlanText("Eight-way inter-mating (or double double cross)")+" you need to do genotyping and use marker information to select individuals for pure line development;");
		PLAN.add("");
       	}
		//4.1
        if(pastSeason<=stage1+3+stage4){
			PLAN.add("4 Final line development stage");
        }
       	if(pastSeason<=stage1+3){
	       	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
			CalculatingYM();
			currentCondition=0;
			PLAN.add(addPlanText("First self pollination of individuals selected from the final inter-mating"));
       	}
       	//4.2
       	if(pastSeason<=stage1+3+1){
			if(Integer.parseInt(ROUNDS_SELFING) >= 2){
		       	CURRENTMONTH=ENDMONTH+1;
		       	CURRENTYEAR=ENDYEAR;
		       	if(CURRENTMONTH == 13)
		       	{
		       		CURRENTMONTH  = 1;
			        CURRENTYEAR = CURRENTYEAR + 1;
		       	}
				CalculatingYM();
				currentCondition=0;
				PLAN.add(addPlanText("Second self pollination"));
			}
       	}
       	//4.3
       	if(pastSeason<=stage1+3+2 ){
			if(Integer.parseInt(ROUNDS_SELFING) >= 3){
		       	CURRENTMONTH=ENDMONTH+1;
		       	CURRENTYEAR=ENDYEAR;
		       	if(CURRENTMONTH == 13)
		       	{
		       		CURRENTMONTH  = 1;
			        CURRENTYEAR = CURRENTYEAR + 1;
		       	}
				CalculatingYM();
				currentCondition=0;
				PLAN.add(addPlanText("Third self pollination"));
			}
       	}
       	//4.4
       	if(pastSeason<=stage1+3+3 ){
			if(Integer.parseInt(ROUNDS_SELFING) >= 4){
		       	CURRENTMONTH=ENDMONTH+1;
		       	CURRENTYEAR=ENDYEAR;
		       	if(CURRENTMONTH == 13)
		       	{
		       		CURRENTMONTH  = 1;
			        CURRENTYEAR = CURRENTYEAR + 1;
		       	}
				CalculatingYM();
				currentCondition=0;
				PLAN.add(addPlanText("Fourth self pollination"));
			}
       	}
       	//4.5
       	if(pastSeason<=stage1+3+4 ){
			if(Integer.parseInt(ROUNDS_SELFING) == 5){
		       	CURRENTMONTH=ENDMONTH+1;
		       	CURRENTYEAR=ENDYEAR;
		       	if(CURRENTMONTH == 13)
		       	{
		       		CURRENTMONTH  = 1;
			        CURRENTYEAR = CURRENTYEAR + 1;
		       	}
				CalculatingYM();
				currentCondition=0;
				PLAN.add(addPlanText("Fifth self pollination"));
			}
       	}
       	//4.6
       	if(pastSeason<=stage1+3+stage4 ){
	      	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
	       	CalculatingYMField();
			currentCondition=2;
	       	PLAN.add(addPlanText("Multilocation phenotyping"));
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
       	PLAN.add("The MARS scheme takes "+(totalMonth/12)+" years and "+(totalMonth%12)+" months.");
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
	

	private void CalculatingYMField(){
        if(SEASONPERYEAR == 1){
			if(CURRENTMONTH <= FIRSTSEASON){
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
			else{
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
			if(CURRENTMONTH <= FIRSTSEASON){
				CURRENTMONTH=FIRSTSEASON;
				ENDMONTH=(SECONDSEASON-1);
				ENDYEAR=CURRENTYEAR;
			}
			else if(CURRENTMONTH <= SECONDSEASON & CURRENTMONTH > FIRSTSEASON){
				CURRENTMONTH=SECONDSEASON;
				ENDMONTH=FIRSTSEASON-1;
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
			else{
				CURRENTMONTH=FIRSTSEASON;
				CURRENTYEAR=CURRENTYEAR+1;
				ENDMONTH=SECONDSEASON-1;
				ENDYEAR=CURRENTYEAR;
			}
        	
        }
        else{
			if(CURRENTMONTH <= FIRSTSEASON){
				CURRENTMONTH=FIRSTSEASON;
				ENDMONTH=SECONDSEASON-1;
				ENDYEAR=CURRENTYEAR;

			}
			else if(CURRENTMONTH <= SECONDSEASON & CURRENTMONTH > FIRSTSEASON){
				CURRENTMONTH=SECONDSEASON;
				ENDMONTH=(THIRDSEASON-1);
				if(ENDMONTH == 0)
				{
					ENDMONTH = 12;
					ENDYEAR = CURRENTYEAR - 1;
				}
				else
				{
				ENDYEAR=CURRENTYEAR;}

			}
			else if(CURRENTMONTH <= THIRDSEASON & CURRENTMONTH > SECONDSEASON){
				CURRENTMONTH=THIRDSEASON;
				ENDMONTH=FIRSTSEASON-1;
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
			else{
				CURRENTMONTH=FIRSTSEASON;
				CURRENTYEAR=CURRENTYEAR+1;
				ENDMONTH=SECONDSEASON-1;
				ENDYEAR=CURRENTYEAR;
			}
        	
        } 
	}	
	
	
	private String addPlanText(String headText) 
	{
		String text=headText+" starts in " + CURRENTYEAR + "/" + CURRENTMONTH + ";" 
		 + " ends in " + ENDYEAR + "/" + ENDMONTH + ";";
		if(currentCondition==0){//common generation
			text=text+" grows in " + CONDITION + ";";
		}
		else if(currentCondition==1){//genotyping generation
			text=text+" grows in " + CONDITION + ";";
			text=text+ " extracts DNA from individual plants for genotyping;";
			text=text+" seeds from individual plants need to be reserved separately for recombination stage;";
		}
		else{//phenotyping generation
			text=text+" grows in " + "Field " + ";";
			text=text+" in "+ NLOCATIONS + " locations with " + NREPS + " replications;";
			text=text+" plot length: "+ PLOTLENGTH + "m; number of rows: " + NROWS +";";
		}
		
		return text;
	}

	private void initialize() 
	{
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
				if(!combo.getText().isEmpty()&&!combo1.getText().isEmpty()){
					
					if(combo.getText().equals("1 Population development stage")){
						if(combo1.getText().contains("1.0")||combo1.getText().contains("1.1")){
							pastSeason = 0;
						}
						for(int i = 2; i <= stage1; i++){
							if(combo1.getText().contains("1." + i)){
								pastSeason = i - 1;
							}
							
						}
					}
					if(combo.getText().equals("2 QTL analysis and selection stage")){
						pastSeason = stage1;
						if(combo1.getText().contains("2.1")){
							calculatingStage = 1;
						}
						if(combo1.getText().contains("2.2")){
							calculatingStage = 2;
						}
						if(combo1.getText().contains("2.3")){
							calculatingStage = 3;
						}
					}
					if(combo.getText().equals("3 Recombination stage")){
						calculatingStage=4;
						if(combo1.getText().contains("3.1")){
							pastSeason = stage1;
						}
						if(combo1.getText().contains("3.2")){
							pastSeason = stage1 + 1;
						}
						if(combo1.getText().contains("3.3")){
							pastSeason = stage1 + 2;
						}
					}
					if(combo.getText().equals("4 Final line development stage")){
						calculatingStage=4;
						for(int i = 0; i <= stage4; i++){
							if(combo1.getText().contains("4." + i)){
								pastSeason = stage1 + 3 + i-1 ;
							}
							
						}
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
		group = new Group(this, SWT.NONE);
		group.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		group.setLayout(gridLayout2);
		group.setText("Select current status");
		
		GridData groupGridData = new GridData();
		groupGridData.widthHint = 400;
		groupGridData.heightHint = 80;
		group.setLayoutData(groupGridData);
		
		createCombo();
		Label filler1 = new Label(group, SWT.NONE);
		createCombo1();
		Label filler = new Label(group, SWT.NONE);
	
		
	}

	/**
	 * This method initializes combo	
	 *
	 */
	private void createCombo() {
		combo = new Combo(group, SWT.NONE);
		combo.setLayoutData(comboGridData);
		combo.add("1 Population development stage");
		combo.add("2 QTL analysis and selection stage");
		combo.add("3 Recombination stage");
		combo.add("4 Final line development stage");
		combo.setText("1 Population development stage");
		combo.addVerifyListener(new org.eclipse.swt.events.VerifyListener() {
			public void verifyText(org.eclipse.swt.events.VerifyEvent e) {
				if(e.text.equals("1 Population development stage")){
					combo1.removeAll();
					combo1.add("1.0 Select parental lines and prepare for planting");
					combo1.add("1.1 Parental lines is growing");
					combo1.add("1.2 F1 generation is growing");
					combo1.add("1.3 F2 generation is growing");
					for(int i = 3; i <= stage1-1; i++){
						combo1.add("1." + (i+1) +" F" + i + " generation is growing");
						
					}
					combo1.setText("1.0 Select parental lines and prepare for planting");
				}
				if(e.text.equals("2 QTL analysis and selection stage")){
					combo1.removeAll();
					combo1.add("2.1 Genotypic and phenotypic data collection");
					combo1.add("2.2 QTL analysis");
					combo1.add("2.3 Selecting parental lines for inter-mating");
					combo1.setText("2.1 Genotypic and phenotypic data collection");
				}
				if(e.text.equals("3 Recombination stage")){
					combo1.removeAll();
					combo1.add("3.1 Two-way inter-mating (or single cross)");
					combo1.add("3.2 Four-way inter-mating (or double cross)");
					combo1.add("3.3 Eight-way inter-mating (or double double cross)");
					combo1.setText("3.1 Two-way (or single) inter-mating");
				}
				if(e.text.equals("4 Final line development stage")){
					combo1.removeAll();
					combo1.add("4.0 Completion of inter-mating");
					//String[] times = {"once", "twice", "three times", "four times", "five times"};
					for(int i = 1; i <= stage4; i++){
						combo1.add("4." + i +" Self pollination "  + " (F" + (i+1) + ") is growing");
						
					}
					combo1.setText("4.0 Completion of inter-mating");
				}
			}
		});
	}

	/**
	 * This method initializes combo1	
	 *
	 */
	private void createCombo1() {
		combo1 = new Combo(group, SWT.NONE);
		combo1.setLayoutData(comboGridData);
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
