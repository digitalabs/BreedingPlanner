package com.gui.wizard;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;

import com.gui.BottomComposite;
import com.gui.MainShell;
import com.gui.RightComposite;
import com.gui.MiddleComposite;
import com.io.InputInfoItem;
import com.io.InputInfoMang;
import com.overall.BreProcess;
import com.overall.Validate;

public class ModifyWizard extends Wizard {
	
	private ModifyComposite mc;
	private ModifyWizardPage mwp;
	private int SEED_HAVE;
	private int SEED_NEED;
	private static String GenoTyping=null;
	private static String PhenoTyping=null;

	//不是重写addPages()
	public void AddPages() {
		// TODO Auto-generated method stub
		mwp = new ModifyWizardPage("page2", "Input Information",
				ImageDescriptor.createFromFile(NewProjectWizardPage.class,
						"/com/img/delicious2.png"));
		this.addPage(mwp);
	}

	@Override
	public boolean needsPreviousAndNextButtons() {
		// TODO Auto-generated method stub
		return false;
	}

	public ModifyWizard() {
		super();
		setWindowTitle("Modify Parameters");
		AddPages();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean performFinish() 
	{
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
		
		if(mc.getCombo3().getText().isEmpty()){
			mwp.setErrorMessage("Generation for genotyping cannot be null.");
			return false;
		}
		if(mc.getCombo6().getText().isEmpty()){
			mwp.setErrorMessage("Generation for phenotyping cannot be null.");
			return false;
		}
		if(mc.getText3().getText().isEmpty()){
			mwp.setErrorMessage("Number of locations cannot be null.");
			return false;
		}
		if(mc.getCombo4().getText().isEmpty()){
			mwp.setErrorMessage("Number replicates in each location cannot be null.");
			return false;
		}
		if(mc.getText4().getText().isEmpty()){
			mwp.setErrorMessage("Plot length cannot be null.");
			return false;
		}
		if(mc.getText6().getText().isEmpty()){
			mwp.setErrorMessage("Number of rows cannot be null.");
			return false;
		}
		if(mc.getText7().getText().isEmpty()){
			mwp.setErrorMessage("Individual plants per plot cannot be null.");
			return false;
		}
		if(mc.getCombo5().getText().isEmpty()){
			mwp.setErrorMessage("Rounds of selfing cannot be null.");
			return false;
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
		*/
		 /*
		 //Length of each season 值的限定，应该是1~12
		 if(Validate.validateInteger(mc.getText9().getText()))
		 {
			 if(Integer.parseInt(mc.getText9().getText())>12||Integer.parseInt(mc.getText9().getText())<1)
					 {
				 mwp.setErrorMessage("Length of each season(months) shoud be more than 1 and less than 12");
					 }
		 }
		 
		//检测正整数
		 if(!Validate.validateInteger(mc.getText9().getText())){
			 mwp.setErrorMessage("Length of each season (months) should be integer.");
				return false;
		 }*/

		 //检测正整数
		if(!Validate.validateInteger(mc.getText3().getText())){
			mwp.setErrorMessage("Number of locations should be integer.");
			return false;
		}

		//检测正整数
		 if(!Validate.validateInteger(mc.getText6().getText())){
			 mwp.setErrorMessage("Number of rows should be integer.");
				return false;
		 }
		 if(!Validate.validateInteger(mc.getText7().getText())){
			 mwp.setErrorMessage("Individual plants per plot should be integer.");
				return false;
		 }
		 //不小于30
		 if(Validate.validateInteger(mc.getText7().getText())){
			 if(Integer.parseInt(mc.getText7().getText()) < 30){
				 mwp.setErrorMessage("Plot size should be more than 30.");
				 return false;
			 }
		 }
		 //检测phenotyping的季数选择
			SEED_HAVE = Integer.parseInt(mc.getSpinner1().getText());
			SEED_NEED = Integer.parseInt(mc.getText3().getText())
			* Integer.parseInt(mc.getCombo4().getText())
			* Integer.parseInt(mc.getText7().getText());
			GenoTyping=mc.getCombo3().getText();
			PhenoTyping=mc.getCombo6().getText();
	        if(GenoTyping.equals("F2")){
	        	if(PhenoTyping.equals("F3")){
	        		if(SEED_HAVE<SEED_NEED){
	   				 mwp.setErrorMessage("Seeds are not enough. Please change the generation for phenotyping");
					 return false;
	         		}
	        	}
	        	else if(PhenoTyping.equals("F4")){
	        		if(SEED_HAVE*SEED_HAVE<SEED_NEED){
	      			mwp.setErrorMessage("Seeds are not enough. Please change the generation for phenotyping");
	   				return false;
	            	}
	        		
	        	}
	        	else{
	        		if(SEED_HAVE*SEED_HAVE*SEED_HAVE<SEED_NEED){
	     			mwp.setErrorMessage("Seeds are not enough. Please change the parameters for Multi-location phenotyping");
	  				return false;
	           		}
	        		
	        	}
	        }
	        else{
	        	if(PhenoTyping.equals("F4")){
	        		if(SEED_HAVE<SEED_NEED){
	   				 mwp.setErrorMessage("Seeds are not enough. Please change the generation for phenotyping");
					 return false;
	         		}
	        	}
	        	else if(PhenoTyping.equals("F5")){
	        		if(SEED_HAVE*SEED_HAVE<SEED_NEED){
	      			mwp.setErrorMessage("Seeds are not enough. Please change the generation for phenotyping");
	   				 return false;
	            	}
	        		
	        	}
	        	else{
	        		if(SEED_HAVE*SEED_HAVE*SEED_HAVE<SEED_NEED){
	     			mwp.setErrorMessage("Seeds are not enough. Please change the parameters for Multi-location phenotyping");
	  				return false;
	           		}
	        		
	        	}
	        	
	        }

		List<InputInfoItem> inputInfoList = new ArrayList<InputInfoItem>();
		for (int i = 0; i < InputInfoMang.getNames().length; i++) {
			InputInfoItem item = new InputInfoItem();
			item.setId(String.valueOf(i));
			item.setName(InputInfoMang.getNames()[i]);
			inputInfoList.add(item);
		}
		inputInfoList.get(0).setValue(mc.getText1().getText());
		inputInfoList.get(1).setValue(mc.getText2().getText());
		inputInfoList.get(2).setValue(mc.getCombo().getText());
		//inputInfoList.get(3).setValue(mc.getText5().getText());
        inputInfoList.get(3).setValue(mc.getSpinner1().getText());		
		inputInfoList.get(4).setValue(mc.getSpinner2().getText());
		//inputInfoList.get(4).setValue(mc.getText9().getText());
		inputInfoList.get(5).setValue(mc.getCombo12().getText());
		inputInfoList.get(6).setValue(mc.getCombo13().getText());
		inputInfoList.get(7).setValue(mc.getCombo14().getText());
		inputInfoList.get(8).setValue(mc.getCombo15().getText());
		inputInfoList.get(9).setValue(mc.getDataTime1().getYear()+"/"+(mc.getDataTime1().getMonth()+1));
		inputInfoList.get(10).setValue(mc.getCombo3().getText());
		inputInfoList.get(11).setValue(mc.getCombo6().getText());
        if(mc.getRadioButton()==0){
        	inputInfoList.get(12).setValue("Greenhouse/offseason");
        }
        else{
        	inputInfoList.get(12).setValue("Field condition");
        }
		inputInfoList.get(13).setValue(mc.getText3().getText());
		inputInfoList.get(14).setValue(mc.getCombo4().getText());
		inputInfoList.get(15).setValue(mc.getText4().getText());
		inputInfoList.get(16).setValue(mc.getText6().getText());
		inputInfoList.get(17).setValue(mc.getText7().getText());
		inputInfoList.get(18).setValue(mc.getCombo5().getText());

		InputInfoMang mang = new InputInfoMang(BreProcess.getXMLPathAndName());
		mang.modifyAll(inputInfoList);
		
		
		//更新DataView
		//为防止CTabItem为初始，暂且使用新建Composite的方式，而不能用getControl()
		CTabItem cTabItem1 = MainShell.getWbc().getcTabFolder().getItem(0);
		cTabItem1.setText(BreProcess.getXMLName());
		MiddleComposite mc = new MiddleComposite(MainShell.getWbc().getcTabFolder(), SWT.NONE, "MARS");
		cTabItem1.setControl(mc);
		MainShell.getWbc().getcTabFolder().setSelection(cTabItem1);
		
		//更新OverView
		CTabItem cTabItem2 = MainShell.getWbc().getcTabFolder1().getItem(0);
		cTabItem2.setText(BreProcess.getPNGName());
		RightComposite rc = new RightComposite(MainShell.getWbc().getcTabFolder1(),SWT.NONE);
		cTabItem2.setControl(rc);
		MainShell.getWbc().getcTabFolder1().setSelection(cTabItem2);
		
		//若存在PlanView则更新
		if(Validate.validateBottomComposite(MainShell.getWbc().getcTabFolder2())){
//			BottomComposite bc = (BottomComposite)MainShell.getWbc().getcTabFolder2().getItem(0).getControl();
//			wic.refreshForTable();
			
			CTabItem cTabItem = MainShell.getWbc().getcTabFolder2().getItem(0);
    		cTabItem.setText("Make a Plan");
			BottomComposite bc = new BottomComposite(MainShell.getWbc().getcTabFolder2(), SWT.NONE);
    		cTabItem.setControl(bc);
    		MainShell.getWbc().getcTabFolder2().setSelection(cTabItem);
		}
		
		return true;
	}

}
