package com.gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;

import com.gui.dialog.PlanDialog;
import com.gui.dialog.GuidanceDialog;
import com.gui.dialog.FrequencyDialog;
import com.gui.dialog.NotesDialog;
import com.io.InputInfoItem;
import com.io.InputInfoMangMABC;
import com.overall.BreProcess;
import com.sun.java_cup.internal.runtime.Scanner;
import com.io.FileOperator;

public class RightCompositeMABC extends Composite {

	private ScrolledComposite scrolledComposite = null;
	private Canvas canvas = null;
	private InputInfoMangMABC mang = null;
	private List<InputInfoItem> inputInfoList = null;  //  @jve:decl-index=0:
	private static String SPECIES = null;
	private static String CONDITION =null;  //  @jve:decl-index=0:
	private static int Backcrossing;
	private static int Selfing;
	private static List<String> PLAN = null;  //  @jve:decl-index=0:
	private int LENGTHSEASON;
	private int SEASONPERYEAR;
	private int FIRSTSEASON;  
	private int SECONDSEASON;
	private int THIRDSEASON;
//	private static int SEED_NEED;
//	private static int SEED_HAVE;
	private static int STARTYEAR;
	private static int STARTMONTH;
	private static int CURRENTYEAR;
	private static int CURRENTMONTH;
	private static int ENDYEAR;
	private static int ENDMONTH;
	private int QTLTop ;
	private float totalSeason = 0 ;
	private Image image = null;  //  @jve:decl-index=0:
	private Image imageguidance = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/guidance.png"));  //  @jve:decl-index=0:
	private Image imagefrequency = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/frequency.png"));  //  @jve:decl-index=0:
	private Image imagenotes = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/notes.png"));  //  @jve:decl-index=0:
	private Image imagebackcross1 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/backcross1.png"));  //  @jve:decl-index=0:
	private Image imagebackcross2 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/backcross2.png"));  //  @jve:decl-index=0:
	private Image imagebackcross3 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/backcross3.png"));  //  @jve:decl-index=0:
	private Image imageselfing1_1 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/selfing1_1.png"));  //  @jve:decl-index=0:
	private Image imageselfing1_2 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/selfing1_2.png"));  //  @jve:decl-index=0:
	private Image imageselfing1_3 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/selfing1_3.png"));  //  @jve:decl-index=0:
	private Image imageselfing2 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/selfing2.png"));  //  @jve:decl-index=0:
	private Image imagerecurrent = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/recurrent.png"));  //  @jve:decl-index=0:
	private Image imagePlan = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/plan.png"));  //  @jve:decl-index=0:
	private Image imageadditionalBC1F1 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/additionalB1F1.png"));  //  @jve:decl-index=0:
	private Image imageadditionalBC2F1 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/additionalBC2F1.png"));  //  @jve:decl-index=0:
	private Image imageadditionalBC1F2 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/additionalBC1F2.png"));  //  @jve:decl-index=0:
	private Image imageadditionalBC2F2 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/additionalBC2F2.png"));  //  @jve:decl-index=0:
	

	public Canvas getCanvas() {
		return canvas;
	}

	public RightCompositeMABC(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		initData();
		setLayout(new FillLayout());
		createScrolledComposite();
		
	}
	private void initData(){
		mang = new InputInfoMangMABC(BreProcess.getXMLPathAndName());
		inputInfoList = mang.createList();
		SPECIES = inputInfoList.get(2).getValue();
		LENGTHSEASON = Integer.parseInt(inputInfoList.get(4).getValue());
		SEASONPERYEAR = Integer.parseInt(inputInfoList.get(5).getValue());
		FIRSTSEASON = changeMonth(inputInfoList.get(6).getValue());
		SECONDSEASON = changeMonth(inputInfoList.get(7).getValue());
		THIRDSEASON = changeMonth(inputInfoList.get(8).getValue());
		STARTYEAR = GetYear(inputInfoList.get(9).getValue());
		STARTMONTH = GetMonth(inputInfoList.get(9).getValue());;
		CONDITION = inputInfoList.get(10).getValue();
		Backcrossing= Integer.parseInt(inputInfoList.get(11).getValue());
		Selfing= Integer.parseInt(inputInfoList.get(12).getValue());
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
		return Integer.parseInt(texts[1]);
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

	private void createScrolledComposite(){
		scrolledComposite = new ScrolledComposite(this, SWT.V_SCROLL|SWT.H_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
	    scrolledComposite.setMinHeight(800);
	    scrolledComposite.setMinWidth(500);//参数修改成450——500
	    createCanvas();
	    scrolledComposite.setVisible(true);
	    scrolledComposite.setContent(canvas);
	    
	    saveImage();
	    FileOperator saveplan=new FileOperator();
	    String fileContent=new String();
	    for(int i=0;i<PLAN.size();i++)
	    {
	    	fileContent=fileContent+PLAN.get(i)+"\r\n";
	    }
	    saveplan.newFile(BreProcess.getPath() + "\\" +BreProcess.getTXTName(), fileContent);
	}

	/**
	 * This method initializes canvas	
	 *
	 */
	private void createCanvas() {
		canvas = new Canvas(scrolledComposite, SWT.NONE);
		
//		image = new Image(Display.getCurrent(), canvas.getSize().x,canvas.getSize().y);
		image = new Image(Display.getCurrent(), 600, 1050);
		GC gc = new GC(image);
		gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		gc.fillRectangle(image.getBounds());
		
    	gc.drawImage(imageguidance, 50, 10);//改动有110-50
    	gc.drawImage(imagefrequency, 174, 10);
    	gc.drawImage(imagenotes, 310, 10);

    	if(Backcrossing==1){
	    	gc.drawImage(imagebackcross1, 10, 50);
			gc.drawImage(imageselfing1_1, 135, 250);
	    	gc.drawImage(imageadditionalBC1F2, 235, 245);
			if(Selfing>=2){
				gc.drawImage(imageselfing2, 123, 300);
			}
			if(Selfing==3){
				gc.drawImage(imageselfing2, 123, 360);
			}
		}
	    else if(Backcrossing==2){
	    	gc.drawImage(imagebackcross1, 10, 50);
    		gc.drawImage(imagerecurrent, 10, 215);
         	gc.drawImage(imagebackcross2, 125, 245);
	    	gc.drawImage(imageadditionalBC1F1, 235, 245);
			gc.drawImage(imageselfing1_2, 135, 375);
	    	gc.drawImage(imageadditionalBC2F2, 235, 370);
			if(Selfing>=2){
				gc.drawImage(imageselfing2, 123, 425);
			}
			if(Selfing==3){
				gc.drawImage(imageselfing2, 123, 485);
			}
      }	
	    else if(Backcrossing==3){
	    	gc.drawImage(imagebackcross1, 10, 50);
    		gc.drawImage(imagerecurrent, 10, 215);
        	gc.drawImage(imagebackcross2, 125, 245);
	    	gc.drawImage(imageadditionalBC1F1, 235, 245);
    		gc.drawImage(imagerecurrent, 10, 345);
        	gc.drawImage(imagebackcross3, 125, 375);
	    	gc.drawImage(imageadditionalBC2F1, 235, 370);
 			gc.drawImage(imageselfing1_3, 135, 500);
			if(Selfing>=2){
			gc.drawImage(imageselfing2, 123, 550);
			}
			if(Selfing==3){
				gc.drawImage(imageselfing2, 123, 610);
			}
		}
		
		gc.drawImage(imagePlan, 406, 10);
		addPlan();
		
		//设置totalSeason
		totalSeason=2+Backcrossing+Selfing;
		BreProcess.setTotalSeason(totalSeason);
		
		canvas.addPaintListener(new org.eclipse.swt.events.PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				// TODO Auto-generated method stub
				e.gc.drawImage(image, 0, 0);
			}});
		
		canvas.addMouseListener(new org.eclipse.swt.events.MouseListener() {
			public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
				
				if(e.x >= 406 && e.x <= 536 && e.y >= 10 && e.y <= 52){
					PlanDialog pd = new PlanDialog(Display.getCurrent().getActiveShell());
					pd.SetPlanText(PLAN);
					pd.open();
				}
				
				if(e.x >= 50 && e.x <= 164 && e.y >= 10 && e.y <= 47){
					GuidanceDialog gd = new GuidanceDialog(Display.getCurrent().getActiveShell());
					gd.open();
				}
				if(e.x >= 174 && e.x <= 300 && e.y >= 10 && e.y <= 51){
					FrequencyDialog fd = new FrequencyDialog(Display.getCurrent().getActiveShell());
					fd.open();
				}
				if(e.x >= 310 && e.x <= 406 && e.y >= 10 && e.y <= 52){
					NotesDialog nd = new NotesDialog(Display.getCurrent().getActiveShell());
					nd.open();
				}
			}
			public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
			}
			public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
			}
		});
		canvas.addMouseMoveListener(new org.eclipse.swt.events.MouseMoveListener() {
			public void mouseMove(org.eclipse.swt.events.MouseEvent e) {
				if(e.x >= 406 && e.x <= 530 && e.y >= 10 && e.y <= 52 || 
						e.x >= 50 && e.x <= 164 && e.y >= 10 && e.y <= 47 ||
						e.x >= 174 && e.x <= 300 && e.y >= 10 && e.y <= 51 ||
						e.x >= 310 && e.x <= 406 && e.y >= 10 && e.y <= 52){
					Cursor cursor = new Cursor(Display.getCurrent(),SWT.CURSOR_HAND);
					canvas.setCursor(cursor);
				}else{
					canvas.setCursor(getCursor());
				}
			}
		});
	}
	
	private void addPlan(){
		PLAN=new LinkedList<String>();
		//1.1
		CURRENTYEAR=STARTYEAR;
		CURRENTMONTH=STARTMONTH;
		CalculatingYM();
		PLAN.add(addPlanText("Parental generation")+" make a few hybrid seeds by hand pollination;");
		PLAN.add("");
       //1.2
       	CURRENTMONTH=ENDMONTH+1;
       	CURRENTYEAR=ENDYEAR;
       	if(CURRENTMONTH == 13)
       	{
       		CURRENTMONTH  = 1;
	        CURRENTYEAR = CURRENTYEAR + 1;
       	}
 		CalculatingYM();
 		PLAN.add(addPlanText("F1")+" make 100-300 backcross seeds by hand pollination;");
		PLAN.add("");
		//1.3
      	if(Backcrossing>=2){
           	CURRENTMONTH=ENDMONTH+1;
           	CURRENTYEAR=ENDYEAR;
           	if(CURRENTMONTH == 13)
           	{
           		CURRENTMONTH  = 1;
    	        CURRENTYEAR = CURRENTYEAR + 1;
           	}
    		CalculatingYM();
			PLAN.add(addPlanText("BC1F1")+" genotype them with chosen markers; select best BC1F1 based on: " +
					" (1) close recombination on one side of target locus (between two flanking markers);" +
					" (2) highest recovery of recurrent background at non-carrier chromosomes; \r\n"  +
					"make 100-300 backcross seeds by hand pollination between the best BC1F1 and the recurrent parent;");
			PLAN.add("");
      	}
      	else if(Backcrossing==1){
           	CURRENTMONTH=ENDMONTH+1;
           	CURRENTYEAR=ENDYEAR;
           	if(CURRENTMONTH == 13)
           	{
           		CURRENTMONTH  = 1;
    	        CURRENTYEAR = CURRENTYEAR + 1;
           	}
    		CalculatingYM();
			PLAN.add(addPlanText("BC1F1")+" genotype them with chosen markers; select best BC1F1 based on: " +
					" (1) close recombination on one side of target locus (between two flanking markers);" +
					" (2) highest recovery of recurrent background at non-carrier chromosomes; \r\n"  +
					"selfing the best BC1F1 to generate BC1F2 seeds;");
			PLAN.add("");
      	}
      	else{
      		
      	}
		//1.4
       	if(Backcrossing==3){
			CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
			CalculatingYM();
			PLAN.add(addPlanText("BC2F1")+" genotype them with chosen markers; select best BC2F1 based on: " +
					" (1) close recombination on one side of target locus (between two flanking markers);" +
					" (2) highest recovery of recurrent background at non-carrier chromosomes; \r\n"  +
					"make 100-300 backcross seeds by hand pollination between the best BC2F1 and the recurrent parent;");
			PLAN.add("");
		}
       	else if(Backcrossing==2){
			CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
			CalculatingYM();
			PLAN.add(addPlanText("BC2F1")+" genotype them with chosen markers; select best BC2F1 based on: " +
					" (1) close recombination on one side of target locus (between two flanking markers);" +
					" (2) highest recovery of recurrent background at non-carrier chromosomes; \r\n"  +
					"selfing the best BC2F1 to generate BC2F2 seeds;");
			PLAN.add("");
		}
       	else{
			CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
			CalculatingYM();
           	PLAN.add(addPlanText("BC1F2")+" genotype them with target markers; select best BC1F2 based on: " +
    				" (1) homozygosity at introgrogressed locus;" +
    				" (2) phenotypic selection may be needed when the target genes and markers are not completely linked;");
    		PLAN.add("");
       	}
		//1.5
       	if(Backcrossing==3){
    		CURRENTMONTH=ENDMONTH+1;
           	CURRENTYEAR=ENDYEAR;
           	if(CURRENTMONTH == 13)
           	{
           		CURRENTMONTH  = 1;
    	        CURRENTYEAR = CURRENTYEAR + 1;
           	}
			CalculatingYM();
    		PLAN.add(addPlanText("BC3F1")+" genotype them with chosen markers; select best BC3F1 based on: " +
					" close recombination on one side of target locus (between two flanking markers); \r\n" +
					"selfing the best BC3F1 to generate BC3F2 seeds;");
			PLAN.add("");
    	}
       	else if(Backcrossing==2){
    		CURRENTMONTH=ENDMONTH+1;
           	CURRENTYEAR=ENDYEAR;
           	if(CURRENTMONTH == 13)
           	{
           		CURRENTMONTH  = 1;
    	        CURRENTYEAR = CURRENTYEAR + 1;
           	}
			CalculatingYM();
           	PLAN.add(addPlanText("BC2F2")+" genotype them with target markers; select best BC2F2 based on: " +
    				" (1) homozygosity at introgrogressed locus;" +
    				" (2) phenotypic selection may be needed when the target genes and markers are not completely linked;");
    		PLAN.add("");
       	}
       	else if(Backcrossing==1){
       		if(Selfing>=2){
           		CURRENTMONTH=ENDMONTH+1;
	           	CURRENTYEAR=ENDYEAR;
	           	if(CURRENTMONTH == 13)
	           	{
	           		CURRENTMONTH  = 1;
	    	        CURRENTYEAR = CURRENTYEAR + 1;
	           	}
	    		CalculatingYM();
               	PLAN.add(addPlanText("BC1F3"));
    			PLAN.add("");
       		}
       	}
		//1.6
        if(Backcrossing==3){
           	CURRENTMONTH=ENDMONTH+1;
           	CURRENTYEAR=ENDYEAR;
           	if(CURRENTMONTH == 13)
           	{
           		CURRENTMONTH  = 1;
    	        CURRENTYEAR = CURRENTYEAR + 1;
           	}
    		CalculatingYM();
	       	PLAN.add(addPlanText("BC3F2")+" genotype them with target markers; select best BC3F2 based on: " +
					" (1) homozygosity at introgrogressed locus;" +
					" (2) phenotypic selection may be needed when the target genes and markers are not completely linked;");
			PLAN.add("");
       	}
        else if(Backcrossing==2){
           	if(Selfing >=2){
           		CURRENTMONTH=ENDMONTH+1;
	           	CURRENTYEAR=ENDYEAR;
	           	if(CURRENTMONTH == 13)
	           	{
	           		CURRENTMONTH  = 1;
	    	        CURRENTYEAR = CURRENTYEAR + 1;
	           	}
	    		CalculatingYM();
		       	PLAN.add(addPlanText("BC2F3")+" genotype them with target markers; select best BC2F3 based on: " +
						" (1) homozygosity at introgrogressed locus;" +
						" (2) phenotypic selection may be needed when the target genes and markers are not completely linked;");
				PLAN.add("");
			}
       	}
        else if (Backcrossing==1){
       		if(Selfing==3){
           		CURRENTMONTH=ENDMONTH+1;
	           	CURRENTYEAR=ENDYEAR;
	           	if(CURRENTMONTH == 13)
	           	{
	           		CURRENTMONTH  = 1;
	    	        CURRENTYEAR = CURRENTYEAR + 1;
	           	}
	    		CalculatingYM();
               	PLAN.add(addPlanText("BC1F4"));
    			PLAN.add("");
       		}       		
       	}
		//1.7
        if(Backcrossing==3){
           	if(Selfing>=2){
           		CURRENTMONTH=ENDMONTH+1;
	           	CURRENTYEAR=ENDYEAR;
	           	if(CURRENTMONTH == 13)
	           	{
	           		CURRENTMONTH  = 1;
	    	        CURRENTYEAR = CURRENTYEAR + 1;
	           	}
	    		CalculatingYM();
		       	PLAN.add(addPlanText("BC3F3"));
				PLAN.add("");
           	}
       	}
        else if(Backcrossing==2){
           	if(Selfing ==3){
           		CURRENTMONTH=ENDMONTH+1;
	           	CURRENTYEAR=ENDYEAR;
	           	if(CURRENTMONTH == 13)
	           	{
	           		CURRENTMONTH  = 1;
	    	        CURRENTYEAR = CURRENTYEAR + 1;
	           	}
	    		CalculatingYM();
		       	PLAN.add(addPlanText("BC2F4"));
				PLAN.add("");
			}
       	}
        else {

        }       		
		//1.8
       	if(Backcrossing==3 && Selfing==3){
	       	CURRENTMONTH=ENDMONTH+1;
	       	CURRENTYEAR=ENDYEAR;
	       	if(CURRENTMONTH == 13)
	       	{
	       		CURRENTMONTH  = 1;
		        CURRENTYEAR = CURRENTYEAR + 1;
	       	}
			CalculatingYM();
           	PLAN.add(addPlanText("BC3F4"));
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
       	PLAN.add("The MABC scheme takes "+(totalMonth/12)+" years and "+(totalMonth%12)+" months.");
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
	
        	
	
	//保存图像
	public void saveImage(){
		Image savedImage = new Image(Display.getCurrent(), 600, 800);//后一个参数1000——800
		GC gc = new GC(savedImage);
		gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		gc.fillRectangle(savedImage.getBounds());
		
    	if(Backcrossing==1){
	    	gc.drawImage(imagebackcross1, 10, 50);
			gc.drawImage(imageselfing1_1, 135, 250);
	    	gc.drawImage(imageadditionalBC1F2, 235, 245);
			if(Selfing>=2){
				gc.drawImage(imageselfing2, 123, 300);
			}
			if(Selfing==3){
				gc.drawImage(imageselfing2, 123, 360);
			}
		}
	    else if(Backcrossing==2){
	    	gc.drawImage(imagebackcross1, 10, 50);
    		gc.drawImage(imagerecurrent, 10, 215);
         	gc.drawImage(imagebackcross2, 125, 245);
	    	gc.drawImage(imageadditionalBC1F1, 235, 245);
			gc.drawImage(imageselfing1_2, 135, 375);
	    	gc.drawImage(imageadditionalBC2F2, 235, 370);
			if(Selfing>=2){
				gc.drawImage(imageselfing2, 123, 425);
			}
			if(Selfing==3){
				gc.drawImage(imageselfing2, 123, 485);
			}
      }	
	    else if(Backcrossing==3){
	    	gc.drawImage(imagebackcross1, 10, 50);
    		gc.drawImage(imagerecurrent, 10, 215);
        	gc.drawImage(imagebackcross2, 125, 245);
	    	gc.drawImage(imageadditionalBC1F1, 235, 245);
    		gc.drawImage(imagerecurrent, 10, 345);
        	gc.drawImage(imagebackcross3, 125, 375);
	    	gc.drawImage(imageadditionalBC2F1, 235, 370);
 			gc.drawImage(imageselfing1_3, 135, 500);
			if(Selfing>=2){
			gc.drawImage(imageselfing2, 123, 550);
			}
			if(Selfing==3){
				gc.drawImage(imageselfing2, 123, 610);
			}
		}
		
	    
	    ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[]{savedImage.getImageData()};
		loader.save(BreProcess.getPath() + "\\" +BreProcess.getPNGName(), SWT.IMAGE_PNG);
	}

	
	
	private String addPlanText(String headText) 
	{
		String text=headText+" starts in " + CURRENTYEAR + "/" + CURRENTMONTH + ";" 
		 + " ends in " + ENDYEAR + "/" + ENDMONTH + ";";
			text=text+" grows in " + CONDITION + ";";
		return text;
	}
	
}
