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

//import com.gui.dialog.PlanComposite;
import com.gui.dialog.PlanDialog;
import com.gui.dialog.HomzygousityDialog;
import com.gui.dialog.LODDialog;
import com.gui.dialog.PopulationSizeDialog;
import com.io.InputInfoItem;
import com.io.InputInfoMang;
import com.overall.BreProcess;
import com.sun.java_cup.internal.runtime.Scanner;
import com.io.FileOperator;

public class RightComposite extends Composite {

	private ScrolledComposite scrolledComposite = null;
	private Canvas canvas = null;
	private InputInfoMang mang = null;
	private List<InputInfoItem> inputInfoList = null;  //  @jve:decl-index=0:
	private static String SPECIES = null;
	private static String CONDITION =null;  //  @jve:decl-index=0:
	private static String GENOTYPING = null;
	private static String PHENOTYPING = null;
	private static String ROUNDS_SELFING = null;
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
	private static int NLOCATIONS;
	private static int NREPS;
	private static int NROWS;
	private static String PLOTLENGTH=null;
	private static int NPLANTS;
	private static int currentCondition; //0 for common generation; 1 for genotyping generation; 2 for phenotyping generation 
	private int QTLTop ;
	private float totalSeason = 6 ;
	private Image image = null;  //  @jve:decl-index=0:
	private Image image1 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/1.png"));  //  @jve:decl-index=0:
	private Image image2 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/2.png"));  //  @jve:decl-index=0:
	private Image image3 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/3.png"));  //  @jve:decl-index=0:
	private Image image4 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/4.png"));  //  @jve:decl-index=0:
	private Image imageF1F2 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f1_f2.png"));  //  @jve:decl-index=0:
	private Image imageRight = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/right.png"));  //  @jve:decl-index=0:
	private Image imageF2_3 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f2_3.png"));  //  @jve:decl-index=0:
	private Image imageGenotyping = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/genotyping.png"));  //  @jve:decl-index=0:
	private Image imageProgenies = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/progenies.png"));  //  @jve:decl-index=0:
	private Image imagePhenotyping = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/phenotyping.png"));  //  @jve:decl-index=0:
	private Image imagePlus = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/plus.png"));  //  @jve:decl-index=0:
	private Image imageF2_4 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f2_4.png"));  //  @jve:decl-index=0:
	private Image imageF2_5 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f2_5.png"));  //  @jve:decl-index=0:
	private Image imageF3 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f3.png"));  //  @jve:decl-index=0:
	private Image imageF3_4 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f3_4.png"));  //  @jve:decl-index=0:
	private Image imageF3_5 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f3_5.png"));  //  @jve:decl-index=0:
	private Image imageF3_6 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f3_6.png"));  //  @jve:decl-index=0:
	private Image imageF4 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f4.png"));  //  @jve:decl-index=0:
	private Image imageF4_5 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f4_5.png"));  //  @jve:decl-index=0:
	private Image imageF4_6 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f4_6.png"));  //  @jve:decl-index=0:
	private Image imageF5 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f5.png"));  //  @jve:decl-index=0:
	private Image imageF6 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/f6.png"));  //  @jve:decl-index=0:
	private Image imageArrow = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/arrow.png"));  //  @jve:decl-index=0:
	private Image imageMiddle = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/middle.png"));  //  @jve:decl-index=0:
	private Image imageCycle1 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/cycle1.png"));  //  @jve:decl-index=0:
	private Image imageCycle2 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/cycle2.png"));  //  @jve:decl-index=0:
	private Image imageCycle3 = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/cycle3.png"));  //  @jve:decl-index=0:
	private Image imageOtherCycle = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/othercycle.png"));  //  @jve:decl-index=0:
	private Image imageOptiMARS = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/OptiMARS.png"));  //  @jve:decl-index=0:
	private Image imageMultiPhenotyping = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/multi_phenotyping.png"));  //  @jve:decl-index=0:
	private Image imagePlan = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/plan.png"));  //  @jve:decl-index=0:
	private Image imagePopulationSize = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/population_size.png"));  //  @jve:decl-index=0:
	private Image imageLOD = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/lod.png"));  //  @jve:decl-index=0:
	private Image imageHomzygousity = new Image(Display.getCurrent(),getClass().getResourceAsStream("/com/img/homzygousity.png"));  //  @jve:decl-index=0:
	

	public Canvas getCanvas() {
		return canvas;
	}

	public RightComposite(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		initData();
		setLayout(new FillLayout());
		createScrolledComposite();
		
	}
	
	private void initData()//初始化数据
	{
		mang = new InputInfoMang(BreProcess.getXMLPathAndName());
		inputInfoList = mang.createList();
		SPECIES = inputInfoList.get(2).getValue();
		LENGTHSEASON = Integer.parseInt(inputInfoList.get(4).getValue());
		SEASONPERYEAR = Integer.parseInt(inputInfoList.get(5).getValue());
		FIRSTSEASON = changeMonth(inputInfoList.get(6).getValue());//第一季
		SECONDSEASON = changeMonth(inputInfoList.get(7).getValue());//第二季
		THIRDSEASON = changeMonth(inputInfoList.get(8).getValue());//第三季
		STARTYEAR = GetYear(inputInfoList.get(9).getValue());     //开始年份
		STARTMONTH = GetMonth(inputInfoList.get(9).getValue());;   //开始月份
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
	private int GetYear(String text) {//得到框中的年份
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
	    scrolledComposite.setMinHeight(1050);//滚动的长度，也就是面板的长度
	    scrolledComposite.setMinWidth(450);//宽度
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
		
		if(GENOTYPING.equals("F2")){
			gc.drawImage(imageRight, 150, 100);
			gc.drawImage(imageGenotyping, 250, 95);
			gc.drawImage(imageProgenies, 150, 145);
			if(PHENOTYPING.equals("F3")){
				gc.drawImage(image1, 0, 20);
				gc.drawImage(imageF2_3, 100, 125);
				gc.drawImage(imagePhenotyping, 250, 145);
				gc.drawImage(imagePlus, 290, 125);
				QTLTop = 200;
				totalSeason = totalSeason + 1;
			}
			if(PHENOTYPING.equals("F4")){
				gc.drawImage(image1, 0, 40);
				gc.drawImage(imageF2_3, 100, 125);
				gc.drawImage(imageF2_4, 100, 170);
				gc.drawImage(imageProgenies, 150, 190);
				gc.drawImage(imagePhenotyping, 250, 190);
				gc.drawImage(imagePlus, 290, 150);
				QTLTop = 245;
				totalSeason = totalSeason + 2;
			}
			if(PHENOTYPING.equals("F5")){
				gc.drawImage(image1, 0, 60);
				gc.drawImage(imageF2_3, 100, 125);
				gc.drawImage(imageF2_4, 100, 170);
				gc.drawImage(imageF2_5, 100, 215);
				gc.drawImage(imageProgenies, 150, 190);
				gc.drawImage(imageProgenies, 150, 235);
				gc.drawImage(imagePhenotyping, 250, 230);
				gc.drawImage(imagePlus, 290, 175);
				QTLTop = 290;
				totalSeason = totalSeason + 3;
			}
		}
		
		if(GENOTYPING.equals("F3")){
			gc.drawImage(imageF3, 100, 125);
			gc.drawImage(imageRight, 150, 145);
			gc.drawImage(imageGenotyping, 250, 140);
			gc.drawImage(imageProgenies, 150, 190);
			if(PHENOTYPING.equals("F4")){
				gc.drawImage(image1, 0, 40);
				gc.drawImage(imageF3_4, 100, 170);
				gc.drawImage(imagePhenotyping, 250, 190);
				gc.drawImage(imagePlus, 290, 170);
				QTLTop = 245;
				totalSeason = totalSeason + 2;
			}
			if(PHENOTYPING.equals("F5")){
				gc.drawImage(image1, 0, 60);
				gc.drawImage(imageF3_4, 100, 170);
				gc.drawImage(imageF3_5, 100, 215);
				gc.drawImage(imageProgenies, 150, 235);
				gc.drawImage(imagePhenotyping, 250, 230);
				gc.drawImage(imagePlus, 290, 195);
				QTLTop = 290;
				totalSeason = totalSeason + 3;
			}
			if(PHENOTYPING.equals("F6")){
				gc.drawImage(image1, 0, 80);
				gc.drawImage(imageF3_4, 100, 170);
				gc.drawImage(imageF3_5, 100, 215);
				gc.drawImage(imageF3_6, 100, 260);
				gc.drawImage(imageProgenies, 150, 235);
				gc.drawImage(imageProgenies, 150, 280);
				gc.drawImage(imagePhenotyping, 250, 280);
				gc.drawImage(imagePlus, 290, 220);
				QTLTop = 335;
				totalSeason = totalSeason + 4;
			}
		}
		
		gc.drawImage(imageF1F2, 47, 22);
		gc.drawImage(image2, 0, QTLTop);
		gc.drawImage(image3, 0, QTLTop+210);
		gc.drawImage(image4, 0, QTLTop+430);
		gc.drawImage(imageArrow, 250, QTLTop-20);
		gc.drawImage(imageMiddle, 30, QTLTop+35);
		gc.drawImage(imageCycle1, 30, QTLTop+300);
		gc.drawImage(imageOptiMARS, 400, QTLTop+300);
		gc.drawImage(imageCycle2, 30, QTLTop+335);
		gc.drawImage(imageGenotyping, 395, QTLTop+340);
		gc.drawImage(imageCycle3, 30, QTLTop+370);
		gc.drawImage(imageGenotyping, 395, QTLTop+380);
		gc.drawImage(imageOtherCycle, 30, QTLTop+410);
		
		gc.drawImage(imagePlan, 360, 27);
		gc.drawImage(imagePopulationSize, 360, 97);
		gc.drawImage(imageLOD, 360, QTLTop+40);
		gc.drawImage(imageHomzygousity, 380, QTLTop+460);//此处要改动，先从360-380，后面460改为100,（实验）
		                                                     //为距顶部距离
		if(ROUNDS_SELFING.equals("1")){
			gc.drawImage(imageMultiPhenotyping, 223, QTLTop+480);
		}
		else if(ROUNDS_SELFING.equals("2")){
			gc.drawImage(imageF3, 285, QTLTop+480);
			gc.drawImage(imageMultiPhenotyping, 223, QTLTop+525);
			totalSeason = totalSeason + 1;
		}
		else if(ROUNDS_SELFING.equals("3")){
			gc.drawImage(imageF3, 285, QTLTop+480);
			gc.drawImage(imageF4, 285, QTLTop+525);
			gc.drawImage(imageMultiPhenotyping, 223, QTLTop+570);
			totalSeason = totalSeason + 2;
		}
		else if(ROUNDS_SELFING.equals("4")){
			gc.drawImage(imageF3, 285, QTLTop+480);
			gc.drawImage(imageF4, 285, QTLTop+525);
			gc.drawImage(imageF5, 285, QTLTop+570);
			gc.drawImage(imageMultiPhenotyping, 223, QTLTop+615);
			totalSeason = totalSeason + 3;
		}
		else{
			gc.drawImage(imageF3, 285, QTLTop+480);
			gc.drawImage(imageF4, 285, QTLTop+525);
			gc.drawImage(imageF5, 285, QTLTop+570);
			gc.drawImage(imageF6, 285, QTLTop+615);
			gc.drawImage(imageMultiPhenotyping, 223, QTLTop+660);
			totalSeason = totalSeason + 4;
		}
		addPlan();
		
		//设置totalSeason
		BreProcess.setTotalSeason(totalSeason);
		
		canvas.addPaintListener(new org.eclipse.swt.events.PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				// TODO Auto-generated method stub
				e.gc.drawImage(image, 0, 0);
			}});
		
		canvas.addMouseListener(new org.eclipse.swt.events.MouseListener() {
			public void mouseUp(org.eclipse.swt.events.MouseEvent e)//鼠标监听事件，点击鼠标出来相应的说明 
			{
				
				if(e.x >= 360 && e.x <= 490 && e.y >= 27 && e.y <= 59){
					PlanDialog pd = new PlanDialog(Display.getCurrent().getActiveShell());
					pd.SetPlanText(PLAN);
					pd.open();
				}
				if(e.x >= 360 && e.x <= 492 && e.y >= 97 && e.y <= 121){
					PopulationSizeDialog psd = new PopulationSizeDialog(Display.getCurrent().getActiveShell());
					psd.open();
				}
				if(e.x >= 360 && e.x <= 484 && e.y >= QTLTop+40 && e.y <= QTLTop+64){
					LODDialog ld = new LODDialog(Display.getCurrent().getActiveShell());
					ld.open();
				}
				//Homzygousity，像素调整
				if(e.x >= 380 && e.x <= 531 && e.y >= QTLTop+450 && e.y <= QTLTop+482){
					HomzygousityDialog hd = new HomzygousityDialog(Display.getCurrent().getActiveShell());
					hd.open();
				}
			}
			public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
			}
			public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
			}
		});
		canvas.addMouseMoveListener(new org.eclipse.swt.events.MouseMoveListener() {
			public void mouseMove(org.eclipse.swt.events.MouseEvent e) {
				if(e.x >= 360 && e.x <= 490 && e.y >= 27 && e.y <= 59 || 
						e.x >= 360 && e.x <= 453 && e.y >= 97 && e.y <= 121 ||
						e.x >= 360 && e.x <= 453 && e.y >= QTLTop+40 && e.y <= QTLTop+64 ||
						e.x >= 380 && e.x <= 531 && e.y >= QTLTop+450 && e.y <= QTLTop+482)//像素范围调整
				{
					Cursor cursor = new Cursor(Display.getCurrent(),SWT.CURSOR_HAND);
					canvas.setCursor(cursor);
				}else{
					canvas.setCursor(getCursor());
				}
			}
		});
	}
	
	private void addPlan()
	{
		PLAN=new LinkedList<String>();
		PLAN.add("1 Population development stage");
		//1.1
		CURRENTYEAR=STARTYEAR;
		CURRENTMONTH=STARTMONTH;
		CalculatingYM();
		currentCondition=0;
		PLAN.add(addPlanText("Parental generation"));
		
       //1.2
       	CURRENTMONTH=(ENDMONTH + 1);
       	CURRENTYEAR=ENDYEAR;
       	if(CURRENTMONTH == 13)
       	{
       		CURRENTMONTH  = 1;
	        CURRENTYEAR = CURRENTYEAR + 1;
       	}
 		CalculatingYM();
		currentCondition=0;
 		PLAN.add(addPlanText("F1"));
		//1.3	
       	CURRENTMONTH=(ENDMONTH+1);
       	CURRENTYEAR=ENDYEAR;
       	if(CURRENTMONTH == 13)
       	{
       		CURRENTMONTH  = 1;
	        CURRENTYEAR = CURRENTYEAR + 1;
       	}
		CalculatingYM();
		if(GENOTYPING.equals("F2"))
		{
			currentCondition=1;
		}
		else{
			currentCondition=0;
		}
		PLAN.add(addPlanText("F2"));
		//1.4
       	CURRENTMONTH=(ENDMONTH+1);
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
		//1.5
       	CURRENTMONTH=(ENDMONTH+1);
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
		//1.6
       	CURRENTMONTH=(ENDMONTH+1);
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
		
        //1.7
       	CURRENTMONTH=(ENDMONTH+1);
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
        //end stage 1
		PLAN.add("");
        //2
		PLAN.add("2 QTL analysis and selection stage");
		//2.1
       	CURRENTMONTH=ENDMONTH+1;
       	CURRENTYEAR=ENDYEAR;
		ENDMONTH=CURRENTMONTH+1;
		if(ENDMONTH > 12){
			ENDYEAR = CURRENTYEAR + 1;
			ENDMONTH = ENDMONTH -12;
			}
		PLAN.add("Genotypic and phenotypic data collection starts in "+CURRENTYEAR+"/"+CURRENTMONTH+ "; ends in "+ENDYEAR+"/"+ENDMONTH+";");
		//2.2
       	CURRENTMONTH=ENDMONTH;
       	CURRENTYEAR=ENDYEAR;
		ENDMONTH=CURRENTMONTH+1;
		if(ENDMONTH > 12){
			ENDYEAR = CURRENTYEAR + 1;
			ENDMONTH = ENDMONTH -12;
			}
		PLAN.add("QTL analysis starts in "+CURRENTYEAR+"/"+CURRENTMONTH+ "; ends in "+ENDYEAR+"/"+ENDMONTH+";");
		//2.3
       	CURRENTMONTH=ENDMONTH;
       	CURRENTYEAR=ENDYEAR;
		ENDMONTH=CURRENTMONTH+1;
		if(ENDMONTH > 12){
			ENDYEAR = CURRENTYEAR + 1;
			ENDMONTH = ENDMONTH -12;
			}
		PLAN.add("Selecting parental lines for inter-mating starts in "+CURRENTYEAR+"/"+CURRENTMONTH+ "; ends in "+ENDYEAR+"/"+ENDMONTH+";" + " you may use OptiMARS to select the parental lines for interacting;");
		PLAN.add("");
		
		//3.1
		PLAN.add("3 Recombination stage");
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
		//3.2
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
		//3.3
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

		//4.1
		PLAN.add("4 Final line development stage");
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
        //4.2
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
		//4.3
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
		//4.4
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
		//4.5
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
       //4.6
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
	
	//保存图像
	public void saveImage(){
		Image savedImage = new Image(Display.getCurrent(), 520, 1050);
		GC gc = new GC(savedImage);
		gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		gc.fillRectangle(savedImage.getBounds());
		
		if(GENOTYPING.equals("F2")){
			gc.drawImage(imageRight, 150, 100);
			gc.drawImage(imageGenotyping, 250, 95);
			gc.drawImage(imageProgenies, 150, 145);
			if(PHENOTYPING.equals("F3")){
				gc.drawImage(image1, 0, 20);
				gc.drawImage(imageF2_3, 100, 125);
				gc.drawImage(imagePhenotyping, 250, 145);
				gc.drawImage(imagePlus, 290, 125);
				QTLTop = 200;
			}
			if(PHENOTYPING.equals("F4")){
				gc.drawImage(image1, 0, 40);
				gc.drawImage(imageF2_3, 100, 125);
				gc.drawImage(imageF2_4, 100, 170);
				gc.drawImage(imageProgenies, 150, 190);
				gc.drawImage(imagePhenotyping, 250, 190);
				gc.drawImage(imagePlus, 290, 150);
				QTLTop = 245;
			}
			if(PHENOTYPING.equals("F5")){
				gc.drawImage(image1, 0, 60);
				gc.drawImage(imageF2_3, 100, 125);
				gc.drawImage(imageF2_4, 100, 170);
				gc.drawImage(imageF2_5, 100, 215);
				gc.drawImage(imageProgenies, 150, 190);
				gc.drawImage(imageProgenies, 150, 235);
				gc.drawImage(imagePhenotyping, 250, 230);
				gc.drawImage(imagePlus, 290, 175);
				QTLTop = 290;
			}
		}
		
		if(GENOTYPING.equals("F3")){
			gc.drawImage(imageF3, 100, 125);
			gc.drawImage(imageRight, 150, 145);
			gc.drawImage(imageGenotyping, 250, 140);
			gc.drawImage(imageProgenies, 150, 190);
			if(PHENOTYPING.equals("F4")){
				gc.drawImage(image1, 0, 40);
				gc.drawImage(imageF3_4, 100, 170);
				gc.drawImage(imagePhenotyping, 250, 190);
				gc.drawImage(imagePlus, 290, 170);
				QTLTop = 245;
			}
			if(PHENOTYPING.equals("F5")){
				gc.drawImage(image1, 0, 60);
				gc.drawImage(imageF3_4, 100, 170);
				gc.drawImage(imageF3_5, 100, 215);
				gc.drawImage(imageProgenies, 150, 235);
				gc.drawImage(imagePhenotyping, 250, 230);
				gc.drawImage(imagePlus, 290, 195);
				QTLTop = 290;
			}
			if(PHENOTYPING.equals("F6")){
				gc.drawImage(image1, 0, 80);
				gc.drawImage(imageF3_4, 100, 170);
				gc.drawImage(imageF3_5, 100, 215);
				gc.drawImage(imageF3_6, 100, 260);
				gc.drawImage(imageProgenies, 150, 235);
				gc.drawImage(imageProgenies, 150, 280);
				gc.drawImage(imagePhenotyping, 250, 280);
				gc.drawImage(imagePlus, 290, 220);
				QTLTop = 335;
			}
		}
		
		gc.drawImage(imageF1F2, 47, 22);
		gc.drawImage(image2, 0, QTLTop);
		gc.drawImage(image3, 0, QTLTop+210);
		gc.drawImage(image4, 0, QTLTop+430);
		gc.drawImage(imageArrow, 250, QTLTop-20);
		gc.drawImage(imageMiddle, 30, QTLTop+35);
		gc.drawImage(imageCycle1, 30, QTLTop+300);
		gc.drawImage(imageOptiMARS, 400, QTLTop+300);
		gc.drawImage(imageCycle2, 30, QTLTop+335);
		gc.drawImage(imageGenotyping, 395, QTLTop+340);
		gc.drawImage(imageCycle3, 30, QTLTop+370);
		gc.drawImage(imageGenotyping, 395, QTLTop+380);
		gc.drawImage(imageOtherCycle, 30, QTLTop+410);
		
		if(ROUNDS_SELFING.equals("1")){
			gc.drawImage(imageMultiPhenotyping, 223, QTLTop+480);
		}
		else if(ROUNDS_SELFING.equals("2")){
			gc.drawImage(imageF3, 285, QTLTop+480);
			gc.drawImage(imageMultiPhenotyping, 223, QTLTop+525);
		}
		else if(ROUNDS_SELFING.equals("3")){
			gc.drawImage(imageF3, 285, QTLTop+480);
			gc.drawImage(imageF4, 285, QTLTop+525);
			gc.drawImage(imageMultiPhenotyping, 223, QTLTop+570);
		}
		else if(ROUNDS_SELFING.equals("4")){
			gc.drawImage(imageF3, 285, QTLTop+480);
			gc.drawImage(imageF4, 285, QTLTop+525);
			gc.drawImage(imageF5, 285, QTLTop+570);
			gc.drawImage(imageMultiPhenotyping, 223, QTLTop+615);
			
		}
		else {
			gc.drawImage(imageF3, 285, QTLTop+480);
			gc.drawImage(imageF4, 285, QTLTop+525);
			gc.drawImage(imageF5, 285, QTLTop+570);
			gc.drawImage(imageF6, 285, QTLTop+615);
			gc.drawImage(imageMultiPhenotyping, 223, QTLTop+660);
			
		}
		ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[]{savedImage.getImageData()};
		loader.save(BreProcess.getPath() + "\\" +BreProcess.getPNGName(), SWT.IMAGE_PNG);
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
	
}
