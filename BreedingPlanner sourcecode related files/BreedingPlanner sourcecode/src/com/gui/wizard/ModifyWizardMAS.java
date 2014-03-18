package com.gui.wizard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;

import com.gui.BottomCompositeMAS;
import com.gui.MainShell;
import com.gui.RightCompositeMAS;
import com.gui.MiddleComposite;
import com.io.FileOperator;
import com.io.InputInfoItem;
import com.io.InputInfoMangMAS;
import com.overall.BreProcess;
import com.overall.Project;
import com.overall.Validate;

public class ModifyWizardMAS extends Wizard {
	
	private ModifyCompositeMAS mc;
	private ModifyCompositeMAS2 mc2;
	
	private ModifyWizardPageMAS mwp;
	private ModifyWizardPageMAS2 mwp2;
	
	private String processType = "";
	private int processIndex;
	


	//不是重写addPages()
	public void AddPages() {
		// TODO Auto-generated method stub
		mwp = new ModifyWizardPageMAS("page2", "Input Information",
				ImageDescriptor.createFromFile(NewProjectWizardPage.class,
						"/com/img/delicious2.png"));
		
		
		mwp2 = new ModifyWizardPageMAS2("page3", "Input Information",
				ImageDescriptor.createFromFile(NewProjectWizardPage.class,
						"/com/img/delicious2.png"));
		this.addPage(mwp);
		this.addPage(mwp2);
		
		
	}

	@Override
	public boolean needsPreviousAndNextButtons() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

	public ModifyWizardMAS() {
		super();
		setWindowTitle("Modify Parameters");
		AddPages();
		// TODO Auto-generated constructor stub
	}
	public ModifyWizardMAS(String processType3,int processIndex3) {
		super();
		setWindowTitle("Modify Parameters");
		processType=processType3;
		processIndex=processIndex3;
		AddPages();
		
		// TODO Auto-generated constructor stub
	}
	
	
	

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		mc = mwp.getIc();
		

		if(mc.getText1().getText().isEmpty()){
			mwp.setErrorMessage("Country cannot be null.");
			return false;
		}
		if(mc.getText2().getText().isEmpty()){
			mwp.setErrorMessage("Researcher cannot be null.");
			return false;
		}
		if(mc.getCombo().getText().isEmpty()){
			mwp.setErrorMessage("Crop species cannot be null.");
			return false;
		}
		/*
		if(mc.getText5().getText().isEmpty()){
			mwp.setErrorMessage("Expected seeds per plant cannot be null.");
			return false;
		}
		if(mc.getText9().getText().isEmpty()){
			mwp.setErrorMessage("Length of each season (months) cannot be null.");
			return false;
		}
		*/
		if(mc.getCombo12().getText().isEmpty()){
			mwp.setErrorMessage("Seasons per year cannot be null.");
			return false;
		}
		if(mc.getCombo13().getEnabled())
		{
			if(mc.getCombo13().getText().isEmpty()){
				mwp.setErrorMessage("1st season starts in cannot be null.");
				return false;
			}
		}
		if(mc.getCombo14().getEnabled())
		{
			if(mc.getCombo14().getText().isEmpty()){
				mwp.setErrorMessage("2nd season starts in cannot be null.");
				return false;
			}
		}
		if(mc.getCombo15().getEnabled())
		{
			if(mc.getCombo15().getText().isEmpty()){
				mwp.setErrorMessage("3rd season starts in cannot be null.");
				return false;
			}
		}
		if(mc.getCombo17().getEnabled())
		{
			if(mc.getCombo17().getText().isEmpty()){
				mwp.setErrorMessage("Number of unlinked genes to be combined cannot be null.");
				return false;
			}
		}
		
		
		/*
		
		//检测正整数
		 if(!Validate.validateInteger(mc.getText5().getText())){
			 mwp.setErrorMessage("Expected seeds per plant should be integer.");
				return false;
		 }
		 
			//限制不同作物的种子范围，比如“Cowpea"，范围限制在30~300。
		 if(mc.getCombo().getText().endsWith("Cowpea"))
		 {
			 if(Validate.validateInteger(mc.getText5().getText()))
			 {
				 if(Integer.parseInt(mc.getText5().getText()) < 30||Integer.parseInt(mc.getText5().getText())>300)
				 {
					 mwp.setErrorMessage("Expected seeds per Cowpea plant should be more than 30 and less than 300.");
					 mwp2.setErrorMessage("Expected seeds per Cowpea plant should be more than 30 and less than 300.");
					 return false;
				 }
				 
			 }			 
		 }
// 大米预期种子限定范围		 
		 if(mc.getCombo().getText().endsWith("Rice"))
		 {
			 if(Validate.validateInteger(mc.getText5().getText()))
			 {
				 if(Integer.parseInt(mc.getText5().getText()) < 50||Integer.parseInt(mc.getText5().getText())>300)
				 {
					 mwp.setErrorMessage("Expected seeds per Rice plant should be more than 50 and less than 300.");
					 mwp2.setErrorMessage("Expected seeds per Rice plant should be more than 50 and less than 300.");
					 return false;
				 }
				 
			 }			 
		 }
//小麦种子限定范围		 
		 if(mc.getCombo().getText().endsWith("Wheat"))
		 {
			 if(Validate.validateInteger(mc.getText5().getText()))
			 {
				 if(Integer.parseInt(mc.getText5().getText()) < 50||Integer.parseInt(mc.getText5().getText())>250)
				 {
					 mwp.setErrorMessage("Expected seeds per Wheat plant should be more than 50 and less than 250.");
					 mwp2.setErrorMessage("Expected seeds per Wheat plant should be more than 50 and less than 250.");
					 return false;
				 }
				 
			 }			 
		 }
//Maize预期种子限定范围		 
		 if(mc.getCombo().getText().endsWith("Maize"))
		 {
			 if(Validate.validateInteger(mc.getText5().getText()))
			 {
				 if(Integer.parseInt(mc.getText5().getText()) < 50||Integer.parseInt(mc.getText5().getText())>500)
				 {
					 mwp.setErrorMessage("Expected seeds per Maize plant should be more than 50 and less than 500.");
					 mwp2.setErrorMessage("Expected seeds per Maize plant should be more than 50 and less than 500.");
					 return false;
				 }
				 
			 }			 
		 }
//Groundnuts预期种子限定范围		 
		 if(mc.getCombo().getText().endsWith("Groundnuts"))
		 {
			 if(Validate.validateInteger(mc.getText5().getText()))
			 {
				 if(Integer.parseInt(mc.getText5().getText()) < 30||Integer.parseInt(mc.getText5().getText())>200)
				 {
					 mwp.setErrorMessage("Expected seeds per Groundnuts plant should be more than 30 and less than 200.");
					 mwp2.setErrorMessage("Expected seeds per Groundnuts plant should be more than 30 and less than 200.");
					 return false;
				 }
				 
			 }			 
		 }
//Cassava预期种子限定范围		 
		 if(mc.getCombo().getText().endsWith("Cassava"))
		 {
			 if(Validate.validateInteger(mc.getText5().getText()))
			 {
				 if(Integer.parseInt(mc.getText5().getText()) < 30||Integer.parseInt(mc.getText5().getText())>100)
				 {
					 mwp.setErrorMessage("Expected seeds per plant should be more than 30 and less than 100.");
					 mwp2.setErrorMessage("Expected seeds per plant should be more than 30 and less than 100.");
					 return false;
				 }
				 
			 }			 
		 }
		 
		 /*
		 //不小于100
		 if(Validate.validateInteger(mc.getText5().getText())){
			 if(Integer.parseInt(mc.getText5().getText()) < 100){
				 mwp.setErrorMessage("Expected seeds per plant should be more than 100.");
				 return false;
			 }
		 }
		
		 
		//检测正整数
		 if(!Validate.validateInteger(mc.getText9().getText())){
			 mwp.setErrorMessage("Length of each season (months) should be integer.");
			 mwp2.setErrorMessage("Length of each season (months) should be integer.");
				return false;
		 }
*/
			
		
		
			List<InputInfoItem> inputInfoList = new ArrayList<InputInfoItem>();
			for (int i = 0; i < InputInfoMangMAS.getNames().length; i++) {
				InputInfoItem item = new InputInfoItem();
				item.setId(String.valueOf(i));
				item.setName(InputInfoMangMAS.getNames()[i]);
				inputInfoList.add(item);
			}
			inputInfoList.get(0).setValue(mc.getText1().getText());
			inputInfoList.get(1).setValue(mc.getText2().getText());
			inputInfoList.get(2).setValue(mc.getCombo().getText());
			//inputInfoList.get(3).setValue(mc.getText5().getText());
			//inputInfoList.get(4).setValue(mc.getText9().getText());
			inputInfoList.get(3).setValue(mc.getSpinner1().getText());
			inputInfoList.get(4).setValue(mc.getSpinner2().getText());
			inputInfoList.get(5).setValue(mc.getCombo12().getText());
			inputInfoList.get(6).setValue(mc.getCombo13().getText());
			inputInfoList.get(7).setValue(mc.getCombo14().getText());
			inputInfoList.get(8).setValue(mc.getCombo15().getText());
			inputInfoList.get(9).setValue(mc.getDataTime1().getYear()+"/"+(mc.getDataTime1().getMonth()+1));
	        if(mc.getRadioButton()==0){
	        	inputInfoList.get(10).setValue("Greenhouse/offseason");
	        }
	        else{
	        	inputInfoList.get(10).setValue("Field condition");
	        }
			inputInfoList.get(11).setValue(mc.getCombo17().getText());


		
			
			
		
		mc2 = mwp2.getIc();//填写验证信息验证page2
		//检测有利基因选择
        //检测行
		int countSelected=0;
		if(mc2.getCheckBox().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox1().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox2().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox3().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox4().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox5().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox6().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox7().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox8().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox9().getSelection()){
			countSelected=countSelected+1;
		}
		/*
		if(countSelected>=Integer.parseInt(mc.getCombo17().getText())){
			mwp2.setErrorMessage("Parent1 cannot be the same as target.");
			return false;
		}
		if(countSelected==0){
			mwp2.setErrorMessage("Parent1 cannot contain no favorable genes.");
			return false;
		}
		*/
		
		countSelected=0;
		if(mc2.getCheckBox10().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox11().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox12().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox13().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox14().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox15().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox16().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox17().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox18().getSelection()){
			countSelected=countSelected+1;
		}
		if(mc2.getCheckBox19().getSelection()){
			countSelected=countSelected+1;
		}
		/*
		if(countSelected>=Integer.parseInt(mc.getCombo17().getText())){
			mwp2.setErrorMessage("Parent2 cannot be the same as target.");
			return false;
		}
		if(countSelected==0){
			mwp2.setErrorMessage("Parent2 cannot contain no favorable genes.");
			return false;
		}
		*/
		//检测列
		if(Integer.parseInt(mc.getCombo17().getText())>=1){
		    countSelected=0;
			if(mc2.getCheckBox().getSelection()){
				countSelected=countSelected+1;
			}
			if(mc2.getCheckBox10().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				mwp2.setErrorMessage("Number of favorable gene at Locus1 cannot be two.");
				return false;
			}
			if(countSelected==0){
				mwp2.setErrorMessage("Number of favorable gene at Locus1 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(mc.getCombo17().getText())>=2){
		    countSelected=0;
			if(mc2.getCheckBox1().getSelection()){
				countSelected=countSelected+1;
			}
			if(mc2.getCheckBox11().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				mwp2.setErrorMessage("Number of favorable gene at Locus2 cannot be two.");
				return false;
			}
			if(countSelected==0){
				mwp2.setErrorMessage("Number of favorable gene at Locus2 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(mc.getCombo17().getText())>=3){
			countSelected=0;
			if(mc2.getCheckBox2().getSelection()){
				countSelected=countSelected+1;
			}
			if(mc2.getCheckBox12().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				mwp2.setErrorMessage("Number of favorable gene at Locus3 cannot be two.");
				return false;
			}
			if(countSelected==0){
				mwp2.setErrorMessage("Number of favorable gene at Locus3 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(mc.getCombo17().getText())>=4){
		    countSelected=0;
			if(mc2.getCheckBox3().getSelection()){
				countSelected=countSelected+1;
			}
			if(mc2.getCheckBox13().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				mwp2.setErrorMessage("Number of favorable gene at Locus4 cannot be two.");
				return false;
			}
			if(countSelected==0){
				mwp2.setErrorMessage("Number of favorable gene at Locus4 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(mc.getCombo17().getText())>=5){
		    countSelected=0;
			if(mc2.getCheckBox4().getSelection()){
				countSelected=countSelected+1;
			}
			if(mc2.getCheckBox14().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				mwp2.setErrorMessage("Number of favorable gene at Locus5 cannot be two.");
				return false;
			}
			if(countSelected==0){
				mwp2.setErrorMessage("Number of favorable gene at Locus5 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(mc.getCombo17().getText())>=6){
		    countSelected=0;
			if(mc2.getCheckBox5().getSelection()){
				countSelected=countSelected+1;
			}
			if(mc2.getCheckBox15().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				mwp2.setErrorMessage("Number of favorable gene at Locus6 cannot be two.");
				return false;
			}
			if(countSelected==0){
				mwp2.setErrorMessage("Number of favorable gene at Locus6 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(mc.getCombo17().getText())>=7){
		    countSelected=0;
			if(mc2.getCheckBox6().getSelection()){
				countSelected=countSelected+1;
			}
			if(mc2.getCheckBox16().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				mwp2.setErrorMessage("Number of favorable gene at Locus7 cannot be two.");
				return false;
			}
			if(countSelected==0){
				mwp2.setErrorMessage("Number of favorable gene at Locus7 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(mc.getCombo17().getText())>=8){
		    countSelected=0;
			if(mc2.getCheckBox7().getSelection()){
				countSelected=countSelected+1;
			}
			if(mc2.getCheckBox17().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				mwp2.setErrorMessage("Number of favorable gene at Locus8 cannot be two.");
				return false;
			}
			if(countSelected==0){
				mwp2.setErrorMessage("Number of favorable gene at Locus8 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(mc.getCombo17().getText())>=9){
		    countSelected=0;
			if(mc2.getCheckBox8().getSelection()){
				countSelected=countSelected+1;
			}
			if(mc2.getCheckBox18().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				mwp2.setErrorMessage("Number of favorable gene at Locus9 cannot be two.");
				return false;
			}
			if(countSelected==0){
				mwp2.setErrorMessage("Number of favorable gene at Locus9 cannot be zero.");
				return false;
			}
		}
		if(Integer.parseInt(mc.getCombo17().getText())>=10){
		    countSelected=0;
			if(mc2.getCheckBox9().getSelection()){
				countSelected=countSelected+1;
			}
			if(mc2.getCheckBox19().getSelection()){
				countSelected=countSelected+1;
			}
			if(countSelected>=2){
				mwp2.setErrorMessage("Number of favorable gene at Locus10 cannot be two.");
				return false;
			}
			if(countSelected==0){
				mwp2.setErrorMessage("Number of favorable gene at Locus10 cannot be zero.");
				return false;
			}
		}

		
		
		
		String Parent="";
		if(mc2.getCheckBox().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(mc2.getCheckBox10().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		inputInfoList.get(12).setValue(Parent);

		Parent="";
		if(mc2.getCheckBox1().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(mc2.getCheckBox11().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		inputInfoList.get(13).setValue(Parent);
		Parent="";
		if(mc2.getCheckBox2().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(mc2.getCheckBox12().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		inputInfoList.get(14).setValue(Parent);
		Parent="";
		if(mc2.getCheckBox3().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(mc2.getCheckBox13().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		inputInfoList.get(15).setValue(Parent);
		Parent="";
		if(mc2.getCheckBox4().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(mc2.getCheckBox14().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		inputInfoList.get(16).setValue(Parent);
		Parent="";
		if(mc2.getCheckBox5().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(mc2.getCheckBox15().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		inputInfoList.get(17).setValue(Parent);
		Parent="";
		if(mc2.getCheckBox6().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(mc2.getCheckBox16().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		inputInfoList.get(18).setValue(Parent);
		Parent="";
		if(mc2.getCheckBox7().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(mc2.getCheckBox17().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		inputInfoList.get(19).setValue(Parent);
		Parent="";
		if(mc2.getCheckBox8().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(mc2.getCheckBox18().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		inputInfoList.get(20).setValue(Parent);
		Parent="";
		if(mc2.getCheckBox9().getSelection()){
			Parent=Parent+"Parent1 ";
		}
		if(mc2.getCheckBox19().getSelection()){
			Parent=Parent+"Parent2 ";
		}
		inputInfoList.get(21).setValue(Parent);
		
		
		InputInfoMangMAS mang = new InputInfoMangMAS(BreProcess.getXMLPathAndName());
		mang.modifyAll(inputInfoList);
		
		
		//更新DataView
		//为防止CTabItem为初始，暂且使用新建Composite的方式，而不能用getControl()
		CTabItem cTabItem1 = MainShell.getWbc().getcTabFolder().getItem(0);
		cTabItem1.setText(BreProcess.getXMLName());
		MiddleComposite mc = new MiddleComposite(MainShell.getWbc().getcTabFolder(), SWT.NONE, "MAS");
		cTabItem1.setControl(mc);
		MainShell.getWbc().getcTabFolder().setSelection(cTabItem1);
		
		//更新OverView
		CTabItem cTabItem2 = MainShell.getWbc().getcTabFolder1().getItem(0);
		cTabItem2.setText(BreProcess.getPNGName());
		RightCompositeMAS rc = new RightCompositeMAS(MainShell.getWbc().getcTabFolder1(),SWT.NONE);
		cTabItem2.setControl(rc);
		MainShell.getWbc().getcTabFolder1().setSelection(cTabItem2);
		
		//若存在PlanView则更新
		if(Validate.validateBottomCompositeMAS(MainShell.getWbc().getcTabFolder2())){
//			BottomComposite bc = (BottomComposite)MainShell.getWbc().getcTabFolder2().getItem(0).getControl();
//			wic.refreshForTable();
			
			CTabItem cTabItem = MainShell.getWbc().getcTabFolder2().getItem(0);
    		cTabItem.setText("Make a Plan");
			BottomCompositeMAS bc = new BottomCompositeMAS(MainShell.getWbc().getcTabFolder2(), SWT.NONE);
    		cTabItem.setControl(bc);
    		MainShell.getWbc().getcTabFolder2().setSelection(cTabItem);
		}
		
		return true;
	}

	
	
}
