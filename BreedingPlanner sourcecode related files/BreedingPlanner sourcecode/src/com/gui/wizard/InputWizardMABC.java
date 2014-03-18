package com.gui.wizard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;

import com.gui.MainShell;
import com.gui.RightCompositeMABC;
import com.gui.MiddleComposite;
import com.io.FileOperator;
import com.overall.BreProcess;
import com.overall.Project;
import com.overall.Validate;

public class InputWizardMABC extends Wizard {
	
	private InputCompositeMABC ic;
	private InputWizardPageMABC iwp;
	private int SEED_HAVE;
	private static String Backcrossing=null;
	private static String Selfing=null;
	
	private String processType = "";
	private int processIndex;
	
//	private String XMLName = null;
//	private String PNGName = null;
//	private String XMLPathAndName = null;

	//不是重写addPages()
	public void AddPages() 
	{
		// TODO Auto-generated method stub
		iwp = new InputWizardPageMABC("page2", "Input Information",
				ImageDescriptor.createFromFile(NewProjectWizardPage.class,
						"/com/img/delicious2.png"));
		this.addPage(iwp);
	}

	@Override
	public boolean needsPreviousAndNextButtons() {
		// TODO Auto-generated method stub
		return false;
	}

	public InputWizardMABC() {
		super();
		setWindowTitle("New MABC");
		AddPages();
		// TODO Auto-generated constructor stub
	}
	public InputWizardMABC(String processType2,int processIndex2) {
		super();
		setWindowTitle("New MABC");
		processType=processType2;
		processIndex=processIndex2;
		AddPages();
		// TODO Auto-generated constructor stub
	}
	


	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		ic = iwp.getIc();
		

		if(ic.getText1().getText().isEmpty()){
			iwp.setErrorMessage("Country cannot be null.");
			return false;
		}
		if(ic.getText2().getText().isEmpty()){
			iwp.setErrorMessage("Researcher cannot be null.");
			return false;
		}
		if(ic.getCombo().getText().isEmpty()){
			iwp.setErrorMessage("Crop species cannot be null.");
			return false;
		}
		/*
		if(ic.getText5().getText().isEmpty()){
			iwp.setErrorMessage("Expected seeds per plant cannot be null.");
			return false;
		}
		if(ic.getText9().getText().isEmpty()){
			iwp.setErrorMessage("Length of each season (months) cannot be null.");
			return false;
		}*/
		if(ic.getCombo12().getText().isEmpty()){
			iwp.setErrorMessage("Seasons per year cannot be null.");
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
		if(ic.getCombo16().getEnabled())
		{
			if(ic.getCombo16().getText().isEmpty()){
				iwp.setErrorMessage("Backcrossing generations cannot be null.");
				return false;
			}
		}
		if(ic.getCombo17().getEnabled())
		{
			if(ic.getCombo17().getText().isEmpty()){
				iwp.setErrorMessage("Repeated selfing generations cannot be null.");
				return false;
			}
		}		 
		
		//processType = MainShell.getLc().getFileTree().getActionGroup().getProcessType();
		//processIndex = String.valueOf(MainShell.getLc().getFileTree().getActionGroup().getProcessIndex());
		
		//设置参数
//		BreProcess.setXMLName();
//		BreProcess.setPNGName(
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
		settings.put("expected seeds per plant", ic.getSpinner1().getText());
		//settings.put("length of each season (months)", ic.getText9().getText());
		settings.put("length of each season (months)", ic.getSpinner2().getText());
		settings.put("seasons per year", ic.getCombo12().getText());
		settings.put("1st season starts in", ic.getCombo13().getText());
		settings.put("2nd season starts in", ic.getCombo14().getText());
		settings.put("3rd season starts in", ic.getCombo15().getText());
        settings.put("parental generation starts in", ic.getDataTime1().getYear()+"/"+(ic.getDataTime1().getMonth()+1));
		
        if(ic.getRadioButton()==0){
        	settings.put("Growing condition", "Greenhouse/offseason");
        }
        else{
        	settings.put("Growing condition", "Field condition");
       	
        }
		settings.put("Backcrossing generations", ic.getCombo16().getText());
		settings.put("Repeated selfing generations", ic.getCombo17().getText());
		
	
		try {
			settings.save(BreProcess.getXMLPathAndName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//show dataview
//		if(Validate.validateWICComposite(MainShell.getWbc().getcTabFolder())){
//			WorkBenchInputComposite wic = (WorkBenchInputComposite)MainShell.getWbc().getcTabFolder().getItem(0).getControl();
//			wic.refreshForTable();
//		}else{
//		}
		CTabItem cTabItem1 = MainShell.getWbc().getcTabFolder().getItem(0);
		cTabItem1.setText(XMLName);
		MiddleComposite mc = new MiddleComposite(MainShell.getWbc().getcTabFolder(), SWT.NONE, "MABC");
		//mc.setProcessType("MABC");
		cTabItem1.setControl(mc);
		MainShell.getWbc().getcTabFolder().setSelection(cTabItem1);
		
		//show overview
		CTabItem cTabItem2 = MainShell.getWbc().getcTabFolder1().getItem(0);
		cTabItem2.setText(PNGName);
		RightCompositeMABC rc = new RightCompositeMABC(MainShell.getWbc().getcTabFolder1(),SWT.NONE);
		cTabItem2.setControl(rc);
		MainShell.getWbc().getcTabFolder1().setSelection(cTabItem2);
		
		//恢复planview
		if(Validate.validateBottomCompositeMABC(MainShell.getWbc().getcTabFolder2())){
			MainShell.getWbc().getcTabFolder2().getItem(0).dispose();
			MainShell.getWbc().createCTabItem2();
			MainShell.getWbc().getcTabFolder2().setSelection(MainShell.getWbc().getcTabFolder2().getItem(0));
		}
		
		//设置filetree
//		MainShell.getLc().getFileTree().getTreeViewer().setSelection(new TreeSelection(new TreePath(Project.path)));
		
		File file = new File(Project.getPath());		    			    		
		File[] files = file.listFiles();		
		File subfile = new File(Project.getPath()+"/" + processType + processIndex2);
		File marsfile = new File(subfile.getAbsolutePath() +  "/" + ic.getCombo().getText() + ".mabc");
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
