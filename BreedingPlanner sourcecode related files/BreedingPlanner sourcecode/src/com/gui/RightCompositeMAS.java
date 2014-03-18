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

import com.gui.dialog.EnhancementDialog;
import com.gui.dialog.PlanDialog;
import com.gui.dialog.TargetDialog;
import com.gui.dialog.TargetDialog2;
import com.io.InputInfoItem;
import com.io.InputInfoMangMAS;
import com.overall.BreProcess;
import com.sun.java_cup.internal.runtime.Scanner;
import com.io.FileOperator;

public class RightCompositeMAS extends Composite {

	private ScrolledComposite scrolledComposite = null;
	private Canvas canvas = null;
	private InputInfoMangMAS mang = null;
	private List<InputInfoItem> inputInfoList = null;  //  @jve:decl-index=0:
	private static String SPECIES = null;
	private static String CONDITION =null;  //  @jve:decl-index=0:
	private static int NumGenes;
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
	private Image imageMAS = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/MAS.png"));  //  @jve:decl-index=0:
	private Image imagePlan = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/plan.png"));  //  @jve:decl-index=0:
	private Image imageTarget = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/target.png"));  //  @jve:decl-index=0:
	private Image imageEnhancement = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/enhancement.png"));  //  @jve:decl-index=0:
	private Image imageSelection = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/selection.png"));  //  @jve:decl-index=0:
	

	public Canvas getCanvas() {
		return canvas;
	}

	public RightCompositeMAS(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		initData();
		setLayout(new FillLayout());
		createScrolledComposite();
		
	}
	
	private void initData(){
		mang = new InputInfoMangMAS(BreProcess.getXMLPathAndName());
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
		NumGenes= Integer.parseInt(inputInfoList.get(11).getValue());
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
	    scrolledComposite.setMinHeight(600);//高度调到800
	    scrolledComposite.setMinWidth(450);
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
		
       	gc.drawImage(imageMAS, 47, 22);
      	gc.drawImage(imageSelection, 80, 300);

      	gc.drawImage(imageTarget, 170, 100);//定位200-170
       	gc.drawImage(imageEnhancement, 320, 100);
       	gc.drawImage(imageTarget, 320, 260);
 
		
		gc.drawImage(imagePlan, 250, 10);
		addPlan();
		
		//设置totalSeason
		totalSeason=7;
		BreProcess.setTotalSeason(totalSeason);
		
		canvas.addPaintListener(new org.eclipse.swt.events.PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				// TODO Auto-generated method stub
				e.gc.drawImage(image, 0, 0);
			}});
		
		canvas.addMouseListener(new org.eclipse.swt.events.MouseListener() {
			public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
				
				if(e.x >= 250 && e.x <= 380 && e.y >= 10 && e.y <= 52){
					PlanDialog pd = new PlanDialog(Display.getCurrent().getActiveShell());
					pd.SetPlanText(PLAN);
					pd.open();
				}
				
				if(e.x >= 170 && e.x <= 305 && e.y >= 100 && e.y <= 124){//改动200-150
					TargetDialog td = new TargetDialog(Display.getCurrent().getActiveShell());
					td.open();
				}
				if(e.x >= 320 && e.x <= 505 && e.y >= 100 && e.y <= 124){
					EnhancementDialog ed = new EnhancementDialog(Display.getCurrent().getActiveShell());
					ed.open();
				}
				if(e.x >= 320 && e.x <= 455 && e.y >= 260 && e.y <= 284){
					TargetDialog2 td2 = new TargetDialog2(Display.getCurrent().getActiveShell());
					td2.open();
				}

			}
			public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
			}
			public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
			}
		});
		canvas.addMouseMoveListener(new org.eclipse.swt.events.MouseMoveListener() {
			public void mouseMove(org.eclipse.swt.events.MouseEvent e) {
				if(e.x >= 250 && e.x <= 380 && e.y >= 10 && e.y <= 52 || 
						e.x >= 150 && e.x <= 290 && e.y >= 100 && e.y <= 140 ||//改动200-150
						e.x >= 320 && e.x <= 505 && e.y >= 100 && e.y <= 124 ||
						e.x >= 320 && e.x <= 455 && e.y >= 260 && e.y <= 284){
					Cursor cursor = new Cursor(Display.getCurrent(),SWT.CURSOR_HAND);
					canvas.setCursor(cursor);
				}else
				{
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
 		PLAN.add(addPlanText("F1")+" harvest 100-300 selfed seeds in bulk;");
		PLAN.add("");
		//1.3
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
		//1.4
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
		//1.5
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
		//1.6
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
		//1.7
       	CURRENTMONTH=ENDMONTH+1;
       	CURRENTYEAR=ENDYEAR;
       	if(CURRENTMONTH == 13)
       	{
       		CURRENTMONTH = 1;
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
	
        	
	
	//保存图像
	public void saveImage(){
		Image savedImage = new Image(Display.getCurrent(), 600, 600);//输出调到600
		GC gc = new GC(savedImage);
		gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		gc.fillRectangle(savedImage.getBounds());
       	gc.drawImage(imageMAS, 47, 22);
     	gc.drawImage(imageSelection, 80, 300);
		
		
	    
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
