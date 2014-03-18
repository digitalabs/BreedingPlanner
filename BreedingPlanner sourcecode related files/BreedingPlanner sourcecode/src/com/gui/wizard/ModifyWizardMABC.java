package com.gui.wizard;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;

import com.gui.BottomCompositeMABC;
import com.gui.MainShell;
import com.gui.RightCompositeMABC;
import com.gui.MiddleComposite;
import com.io.InputInfoItem;
import com.io.InputInfoMangMABC;
import com.overall.BreProcess;
import com.overall.Validate;

public class ModifyWizardMABC extends Wizard {
	
	private ModifyCompositeMABC mc;
	private ModifyWizardPageMABC mwp;
	private int SEED_HAVE;
	private static String Backcrossing=null;
	private static String Selfing=null;

	//不是重写addPages()
	public void AddPages() {
		// TODO Auto-generated method stub
		mwp = new ModifyWizardPageMABC("page2", "Input Information",
				ImageDescriptor.createFromFile(NewProjectWizardPage.class,
						"/com/img/delicious2.png"));
		this.addPage(mwp);
	}

	@Override
	public boolean needsPreviousAndNextButtons() {
		// TODO Auto-generated method stub
		return false;
	}

	public ModifyWizardMABC() {
		super();
		setWindowTitle("Modify Parameters");
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
		if(mc.getCombo16().getEnabled())
		{
			if(mc.getCombo16().getText().isEmpty()){
				mwp.setErrorMessage("Backcrossing generations cannot be null.");
				return false;
			}
		}
		if(mc.getCombo17().getEnabled())
		{
			if(mc.getCombo17().getText().isEmpty()){
				mwp.setErrorMessage("Repeated selfing generations cannot be null.");
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
		 
	/*	 //不小于100
		 if(Validate.validateInteger(mc.getText5().getText())){
			 if(Integer.parseInt(mc.getText5().getText()) < 100){
				 mwp.setErrorMessage("Expected seeds per plant should be more than 100.");
				 return false;
			 }
		 }
		
		//检测正整数
		 if(!Validate.validateInteger(mc.getText9().getText())){
			 mwp.setErrorMessage("Length of each season (months) should be integer.");
				return false;
		 }
*/

		List<InputInfoItem> inputInfoList = new ArrayList<InputInfoItem>();
		for (int i = 0; i < InputInfoMangMABC.getNames().length; i++) {
			InputInfoItem item = new InputInfoItem();
			item.setId(String.valueOf(i));
			item.setName(InputInfoMangMABC.getNames()[i]);
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
		inputInfoList.get(11).setValue(mc.getCombo16().getText());
		inputInfoList.get(12).setValue(mc.getCombo17().getText());

		InputInfoMangMABC mang = new InputInfoMangMABC(BreProcess.getXMLPathAndName());
		mang.modifyAll(inputInfoList);
		
		
		//更新DataView
		//为防止CTabItem为初始，暂且使用新建Composite的方式，而不能用getControl()
		CTabItem cTabItem1 = MainShell.getWbc().getcTabFolder().getItem(0);
		cTabItem1.setText(BreProcess.getXMLName());
		MiddleComposite mc = new MiddleComposite(MainShell.getWbc().getcTabFolder(), SWT.NONE, "MABC");
		cTabItem1.setControl(mc);
		MainShell.getWbc().getcTabFolder().setSelection(cTabItem1);
		
		//更新OverView
		CTabItem cTabItem2 = MainShell.getWbc().getcTabFolder1().getItem(0);
		cTabItem2.setText(BreProcess.getPNGName());
		RightCompositeMABC rc = new RightCompositeMABC(MainShell.getWbc().getcTabFolder1(),SWT.NONE);
		cTabItem2.setControl(rc);
		MainShell.getWbc().getcTabFolder1().setSelection(cTabItem2);
		
		//若存在PlanView则更新
		if(Validate.validateBottomCompositeMABC(MainShell.getWbc().getcTabFolder2())){
//			BottomComposite bc = (BottomComposite)MainShell.getWbc().getcTabFolder2().getItem(0).getControl();
//			wic.refreshForTable();
			
			CTabItem cTabItem = MainShell.getWbc().getcTabFolder2().getItem(0);
    		cTabItem.setText("Make a Plan");
			BottomCompositeMABC bc = new BottomCompositeMABC(MainShell.getWbc().getcTabFolder2(), SWT.NONE);
    		cTabItem.setControl(bc);
    		MainShell.getWbc().getcTabFolder2().setSelection(cTabItem);
		}
		
		return true;
	}

}
