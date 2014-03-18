package com.gui.wizard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

import com.gui.MainShell;
import com.gui.RightCompositeMAS;
import com.gui.MiddleComposite;
import com.io.FileOperator;
import com.overall.BreProcess;
import com.overall.Project;
import com.overall.Validate;

public class InputWizardMAS extends Wizard 
{	
	private InputCompositeMAS ic;
	private InputCompositeMAS2 ic2;
	
	private InputWizardPageMAS iwp;
	private InputWizardPageMAS2 iwp2;
	
	private String processType = "";
	private int processIndex;
	
	//不是重写addPages()
	public void AddPages() 
	{
		// TODO Auto-generated method stub
		iwp = new InputWizardPageMAS("page2", "Input Information",
				ImageDescriptor.createFromFile(NewProjectWizardPage.class,
						"/com/img/delicious2.png"));			
		iwp2 = new InputWizardPageMAS2("page3", "Input Information",
				ImageDescriptor.createFromFile(NewProjectWizardPage.class,
						"/com/img/delicious2.png"));
		this.addPage(iwp);
		this.addPage(iwp2);		
	}
    //是否需要前一步、下一步按钮
	@Override	
	public boolean needsPreviousAndNextButtons()
	{
		// TODO Auto-generated method stub		
		return true;
	}		
	public InputWizardMAS()
	{
		super();
		setWindowTitle("New MAS");
		AddPages();
		// TODO Auto-generated constructor stub
	}
	public InputWizardMAS(String processType3,int processIndex3) 
	{
		super();
		setWindowTitle("New MAS");
		processType=processType3;
		processIndex=processIndex3;
		AddPages();		
		// TODO Auto-generated constructor stub
	}	

	public boolean performFinish()
	{
		// TODO Auto-generated method stub
		ic = iwp.getIc();
		ic2= iwp2.getIc();

		if(ic.getText1().getText().isEmpty()){
			iwp.setErrorMessage("Country cannot be null.");
			iwp2.setErrorMessage("Country cannot be null.");
			return false;
		}
		if(ic.getText2().getText().isEmpty()){
			iwp.setErrorMessage("Researcher cannot be null.");
			iwp2.setErrorMessage("Researcher cannot be null.");
			return false;
		}
		if(ic.getCombo().getText().isEmpty()){
			iwp.setErrorMessage("Crop species cannot be null.");
			return false;
		}

		if(ic.getCombo12().getText().isEmpty()){
			iwp.setErrorMessage("Seasons per year cannot be null.");
			iwp2.setErrorMessage("Seasons per year cannot be null.");
			return false;
		}
		if(ic.getCombo13().getEnabled())
		{
			if(ic.getCombo13().getText().isEmpty()){
				iwp.setErrorMessage("1st season starts in cannot be null.");
				return false;
			}
		}
		if(ic.getCombo14().getEnabled())
		{
			if(ic.getCombo14().getText().isEmpty()){
				iwp.setErrorMessage("2nd season starts in cannot be null.");
				return false;
			}
		}
		if(ic.getCombo15().getEnabled())
		{
			if(ic.getCombo15().getText().isEmpty()){
				iwp.setErrorMessage("3rd season starts in cannot be null.");
				return false;
			}
		}
		if(ic.getCombo17().getEnabled())
		{
			if(ic.getCombo17().getText().isEmpty()){
				iwp.setErrorMessage("Number of unlinked genes to be combined cannot be null.");
				return false;
			}
		}	
	
			 
		//检测有利基因选择,MAS第二个页面的靶基因选择
		 
        //检测行
		 //检测第一行，是否包含所有的靶基因
		int countSelected=0;
		if(ic2.getCheckBox().getSelection())
		{
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox1().getSelection())
		{
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox2().getSelection())
		{
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox3().getSelection())
		{
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox4().getSelection())
		{
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox5().getSelection())
		{
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox6().getSelection())
		{
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox7().getSelection())
		{
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox8().getSelection())
		{
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox9().getSelection())
		{
			countSelected=countSelected+1;
		}
		//检测第二行是否包含所有的靶基因
		countSelected=0;
		if(ic2.getCheckBox10().getSelection()){
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox11().getSelection()){
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox12().getSelection()){
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox13().getSelection()){
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox14().getSelection()){
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox15().getSelection()){
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox16().getSelection()){
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox17().getSelection()){
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox18().getSelection()){
			countSelected=countSelected+1;
		}
		if(ic2.getCheckBox19().getSelection()){
			countSelected=countSelected+1;
		}
		/*
		if(countSelected>=Integer.parseInt(ic.getCombo17().getText())){
			iwp2.setErrorMessage("Parent2 cannot be the same as target.");
			return false;
		}
		
		if(countSelected==0){
			iwp2.setErrorMessage("Parent2 cannot contain no favorable genes.");
			return false;
		}
		*/
		//检测列
		//上下对应的列分为一组
		if(Integer.parseInt(ic.getCombo17().getText())>=1)
		{
		    countSelected=0;
			if(ic2.getCheckBox().getSelection())
			{
				countSelected=countSelected+1;
			}
			if(ic2.getCheckBox10().getSelection())
			{
				countSelected=countSelected+1;
			}
			if(countSelected>=2)
			{
				iwp2.setErrorMessage("Number of favorable gene at Locus1 cannot be two.");
				return false;
			}
			if(countSelected==0)
			{
				iwp2.setErrorMessage("Number of favorable gene at Locus1 cannot be zero.");
				return false;
			}
		}
		
		if(Integer.parseInt(ic.getCombo17().getText())>=2){
		    countSelected=0;
			if(ic2.getCheckBox1().getSelection()){
				countSelected=countSelected+1;
			}
			if(ic2.getCheckBox11().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				iwp2.setErrorMessage("Number of favorable gene at Locus2 cannot be two.");
				return false;
			}
			if(countSelected==0){
				iwp2.setErrorMessage("Number of favorable gene at Locus2 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(ic.getCombo17().getText())>=3){
			countSelected=0;
			if(ic2.getCheckBox2().getSelection()){
				countSelected=countSelected+1;
			}
			if(ic2.getCheckBox12().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				iwp2.setErrorMessage("Number of favorable gene at Locus3 cannot be two.");
				return false;
			}
			if(countSelected==0){
				iwp2.setErrorMessage("Number of favorable gene at Locus3 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(ic.getCombo17().getText())>=4){
		    countSelected=0;
			if(ic2.getCheckBox3().getSelection()){
				countSelected=countSelected+1;
			}
			if(ic2.getCheckBox13().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				iwp2.setErrorMessage("Number of favorable gene at Locus4 cannot be two.");
				return false;
			}
			if(countSelected==0){
				iwp2.setErrorMessage("Number of favorable gene at Locus4 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(ic.getCombo17().getText())>=5){
		    countSelected=0;
			if(ic2.getCheckBox4().getSelection()){
				countSelected=countSelected+1;
			}
			if(ic2.getCheckBox14().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				iwp2.setErrorMessage("Number of favorable genes at Locus5 cannot be two.");
				return false;
			}
			if(countSelected==0){
				iwp2.setErrorMessage("Number of favorable gene at Locus5 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(ic.getCombo17().getText())>=6){
		    countSelected=0;
			if(ic2.getCheckBox5().getSelection()){
				countSelected=countSelected+1;
			}
			if(ic2.getCheckBox15().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				iwp2.setErrorMessage("Number of favorable gene at Locus6 cannot be two.");
				return false;
			}
			if(countSelected==0){
				iwp2.setErrorMessage("Number of favorable gene at Locus6 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(ic.getCombo17().getText())>=7){
		    countSelected=0;
			if(ic2.getCheckBox6().getSelection()){
				countSelected=countSelected+1;
			}
			if(ic2.getCheckBox16().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				iwp2.setErrorMessage("Number of favorable gene at Locus7 cannot be two.");
				return false;
			}
			if(countSelected==0){
				iwp2.setErrorMessage("Number of favorable gene at Locus7 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(ic.getCombo17().getText())>=8){
		    countSelected=0;
			if(ic2.getCheckBox7().getSelection()){
				countSelected=countSelected+1;
			}
			if(ic2.getCheckBox17().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				iwp2.setErrorMessage("Number of favorable gene at Locus8 cannot be two.");
				return false;
			}
			if(countSelected==0){
				iwp2.setErrorMessage("Number of favorable gene at Locus8 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(ic.getCombo17().getText())>=9){
		    countSelected=0;
			if(ic2.getCheckBox8().getSelection()){
				countSelected=countSelected+1;
			}
			if(ic2.getCheckBox18().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				iwp2.setErrorMessage("Number of favorable gene at Locus9 cannot be two.");
				return false;
			}
			if(countSelected==0){
				iwp2.setErrorMessage("Number of favorable gene at Locus9 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(ic.getCombo17().getText())>=10){
		    countSelected=0;
			if(ic2.getCheckBox9().getSelection()){
				countSelected=countSelected+1;
			}
			if(ic2.getCheckBox19().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				iwp2.setErrorMessage("Number of favorable gene at Locus10 cannot be two.");
				return false;
			}
			if(countSelected==0){
				iwp2.setErrorMessage("Number of favorable gene at Locus10 cannot be zero.");
				return false;
			}
		}
				
        String processIndex2=Integer.toString(processIndex);
		String XMLName = ic.getCombo().getText() + "." + processType.toLowerCase();
		String PNGName = ic.getCombo().getText() + ".png";
		BreProcess.setXMLPathAndName(Project.getPath() + "\\" + processType + processIndex2 + "\\" + XMLName);
		
		FileOperator fo = new FileOperator();
		fo.newFolder(Project.getPath() + "/" + processType + processIndex2);
		
		DialogSettings settings = new DialogSettings("input");
		settings.put("country", ic.getText1().getText());
		settings.put("researcher", ic.getText2().getText());
		settings.put("crop species", ic.getCombo().getText());
		//settings.put("expected seeds per plant", ic.getText5().getText());
		//settings.put("length of each season (months)", ic.getText9().getText());
		settings.put("expected seeds per plant", ic.getSpinner1().getText());
		settings.put("length of each season (months)", ic.getSpinner2().getText());
		settings.put("seasons per year", ic.getCombo12().getText());
		settings.put("1st season starts in", ic.getCombo13().getText());
		settings.put("2nd season starts in", ic.getCombo14().getText());
		settings.put("3rd season starts in", ic.getCombo15().getText());
        settings.put("parental generation starts in", ic.getDataTime1().getYear()+"/"+(ic.getDataTime1().getMonth()+1));
		
        
        if(ic.getRadioButton2().getSelection()){
        	settings.put("Growing condition", ic.getRadioButton2().getText());
        }
        else{
        	settings.put("Growing condition", ic.getRadioButton3().getText());
       	
        }
		settings.put("Number of unlinked genes to be combined", ic.getCombo17().getText());
										
		ic2 = iwp2.getIc();//填写验证信息验证page2
		String Parent="";
		if(ic2.getCheckBox().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(ic2.getCheckBox10().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		settings.put("Favorable gene at Locus1", Parent);

		Parent="";
		if(ic2.getCheckBox1().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(ic2.getCheckBox11().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		settings.put("Favorable gene at Locus2", Parent);
		Parent="";
		if(ic2.getCheckBox2().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(ic2.getCheckBox12().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		settings.put("Favorable gene at Locus3", Parent);
		Parent="";
		if(ic2.getCheckBox3().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(ic2.getCheckBox13().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		settings.put("Favorable gene at Locus4", Parent);
		Parent="";
		if(ic2.getCheckBox4().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(ic2.getCheckBox14().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		settings.put("Favorable gene at Locus5", Parent);
		Parent="";
		if(ic2.getCheckBox5().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(ic2.getCheckBox15().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		settings.put("Favorable gene at Locus6", Parent);
		Parent="";
		if(ic2.getCheckBox6().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(ic2.getCheckBox16().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		settings.put("Favorable gene at Locus7", Parent);
		Parent="";
		if(ic2.getCheckBox7().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(ic2.getCheckBox17().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		settings.put("Favorable gene at Locus8", Parent);
		Parent="";
		if(ic2.getCheckBox8().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(ic2.getCheckBox18().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		settings.put("Favorable gene at Locus9", Parent);
		Parent="";
		if(ic2.getCheckBox9().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(ic2.getCheckBox19().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		settings.put("Favorable gene at Locus10", Parent);
		
		
		try {
			settings.save(BreProcess.getXMLPathAndName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CTabItem cTabItem1 = MainShell.getWbc().getcTabFolder().getItem(0);
		cTabItem1.setText(XMLName);
		MiddleComposite mc = new MiddleComposite(MainShell.getWbc().getcTabFolder(), SWT.NONE, "MAS");
		cTabItem1.setControl(mc);
		MainShell.getWbc().getcTabFolder().setSelection(cTabItem1);
		
		//show overview
		CTabItem cTabItem2 = MainShell.getWbc().getcTabFolder1().getItem(0);
		cTabItem2.setText(PNGName);
		RightCompositeMAS rc = new RightCompositeMAS(MainShell.getWbc().getcTabFolder1(),SWT.NONE);
		cTabItem2.setControl(rc);
		MainShell.getWbc().getcTabFolder1().setSelection(cTabItem2);
		
		//恢复planview
		if(Validate.validateBottomCompositeMAS(MainShell.getWbc().getcTabFolder2())){
			MainShell.getWbc().getcTabFolder2().getItem(0).dispose();
			MainShell.getWbc().createCTabItem2();
			MainShell.getWbc().getcTabFolder2().setSelection(MainShell.getWbc().getcTabFolder2().getItem(0));
		}
				
		
		File file = new File(Project.getPath());		    			    		
		File[] files = file.listFiles();		
		File subfile = new File(Project.getPath()+"/" + processType + processIndex);
		File marsfile = new File(subfile.getAbsolutePath() +  "/" + ic.getCombo().getText() + ".mas");
		File pngfile = new File(subfile.getAbsolutePath() +"/" + ic.getCombo().getText() + ".png");
		File txtfile = new File(subfile.getAbsolutePath() + "/" + ic.getCombo().getText() + ".txt");
		for(int i = 0;i<files.length;i++)
		{
			String filename = files[i].getName(); 
			if(filename.endsWith(".ibp"))
			{
				File projectfile = new File(Project.getPath() + "/" + filename);
				try
	    		{
			    
	    		FileOutputStream f = new FileOutputStream(projectfile,true);
	    		f.write(subfile.getAbsolutePath().getBytes());
	    		f.write("\r\n".toString().getBytes());
	    		f.write(marsfile.getAbsolutePath().getBytes());
	    		f.write("\r\n".toString().getBytes());	 
	    		f.write(pngfile.getAbsolutePath().getBytes());
	    		f.write("\r\n".toString().getBytes());
	    		f.write(txtfile.getAbsolutePath().getBytes());
	    		f.write("\r\n".toString().getBytes());
	    		f.close();
	    		}
	    		catch(Exception p)
	    		{	    	    			
	    		}
			}	    			
		}
		
		
				return true;
	}

	
	
}
