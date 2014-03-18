package com.gui.wizard;
//新建MARS的代码
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.*;

import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;

import com.gui.MainShell;
import com.gui.Messages;
import com.gui.RightComposite;
import com.gui.MiddleComposite;
import com.io.FileOperator;
import com.overall.BreProcess;
import com.overall.Project;
import com.overall.Validate;

public class InputWizard extends Wizard 
{
	//定义私有变量
	private InputComposite ic;
	private InputWizardPage iwp;
	private int SEED_HAVE;
	private int SEED_NEED;
	private static String GenoTyping=null;
	private static String PhenoTyping=null;	
	private String processType = "";//暂时空置
	private int processIndex;
	org.eclipse.swt.graphics.Color foregroundcolor;
	Display display;
	    	
	//不是重写addPages()
	public void AddPages() //定义Addpage方法，每一次打开时都会出现的页面，
	{
		// TODO Auto-generated method stub,新生成页面
		iwp = new InputWizardPage("page2", "Input Information",
				ImageDescriptor.createFromFile(NewProjectWizardPage.class,
						"/com/img/delicious2.png"));
		this.addPage(iwp);
	}
	@Override
	public boolean needsPreviousAndNextButtons() 
	{
		// TODO Auto-generated method stub
		return false;
	}
//方法重载，变量不同
	public InputWizard() 
	{
		super();//继承父类
		setWindowTitle("New MARS");//框架的标题
		AddPages();//调用AddPage方法
		// TODO Auto-generated constructor stub
	}
	public InputWizard(String processType1,int processIndex1) 
	{
		super();
		setWindowTitle("New MARS");		
		processType = processType1;
		processIndex = processIndex1;
		AddPages();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean performFinish() 
	{
		// TODO Auto-generated method stub
		ic = iwp.getIc();
		
		if(ic.getText1().getText().isEmpty())
		{
			iwp.setErrorMessage("Country cannot be null.");
			return false;
		}
		if(ic.getText2().getText().isEmpty())
		{
			iwp.setErrorMessage("Researcher cannot be null.");
			return false;
		}
		if(ic.getCombo().getText().isEmpty())
		{
			iwp.setErrorMessage("Crop species cannot be null.");
			return false;
		}

		if(ic.getCombo12().getText().isEmpty())
		{
			iwp.setErrorMessage("Seasons per year cannot be null.");
			return false;
		}
		if(ic.getCombo13().getEnabled())
		{
			if(ic.getCombo13().getText().isEmpty())
			{
				iwp.setErrorMessage("1st season starts in cannot be null.");
				return false;
			}
		}
		if(ic.getCombo14().getEnabled())
		{
			if(ic.getCombo14().getText().isEmpty())
			{
				iwp.setErrorMessage("2nd season starts in cannot be null.");
				return false;
			}
		}
		if(ic.getCombo15().getEnabled())
		{
			if(ic.getCombo15().getText().isEmpty())
			{
				iwp.setErrorMessage("3rd season starts in cannot be null.");
				return false;
			}
		}
		if(ic.getCombo3().getText().isEmpty())
		{
			iwp.setErrorMessage("Generation for genotyping cannot be null.");
			return false;
		}
		if(ic.getCombo6().getText().isEmpty())
		{
			iwp.setErrorMessage("Generation for phenotyping cannot be null.");
			return false;
		}
		if(ic.getText3().getText().isEmpty())
		{
			iwp.setErrorMessage("Number of locations cannot be null.");
			return false;
		}
		if(ic.getCombo4().getText().isEmpty())
		{
			iwp.setErrorMessage("Number replicates in each location cannot be null.");
			return false;
		}
		if(ic.getText4().getText().isEmpty())
		{
			iwp.setErrorMessage("Plot length cannot be null.");
			return false;
		}
		if(ic.getText6().getText().isEmpty())
		{
			iwp.setErrorMessage("Number of rows cannot be null.");
			return false;
		}
		if(ic.getText7().getText().isEmpty())
		{
			iwp.setErrorMessage("Individual plants per plot cannot be null.");
			return false;
		}
		if(ic.getCombo5().getText().isEmpty())
		{
			iwp.setErrorMessage("Rounds of selfing cannot be null.");
			return false;
		}
		 //检测正整数
		if(!Validate.validateInteger(ic.getText3().getText())){
			iwp.setErrorMessage("Number of locations should be integer.");
			return false;
		}

		//检测正整数
		 if(!Validate.validateInteger(ic.getText6().getText())){
			 iwp.setErrorMessage("Number of rows should be integer.");
				return false;
		 }
		 if(!Validate.validateInteger(ic.getText7().getText())){
			 iwp.setErrorMessage("Individual plants per plot should be integer.");
				return false;
		 }
		 //株数不可小于30
		 if(Validate.validateInteger(ic.getText7().getText()))
		 {
			 if(Integer.parseInt(ic.getText7().getText()) < 30)
			 {
				 iwp.setErrorMessage("Plot size should be more than 30.");
				 return false;
			 }
		 }
		 //检测phenotyping的季数选择
	
		SEED_HAVE = Integer.parseInt(ic.getSpinner1().getText());
		SEED_NEED = Integer.parseInt(ic.getText3().getText())
		* Integer.parseInt(ic.getCombo4().getText())
		* Integer.parseInt(ic.getText7().getText());
		GenoTyping=ic.getCombo3().getText();
		PhenoTyping=ic.getCombo6().getText();
        if(GenoTyping.equals("F2"))
        {
        	if(PhenoTyping.equals("F3"))
        	{
        		if(SEED_HAVE<SEED_NEED)
        		{
   				 iwp.setErrorMessage("Seeds are not enough. Please change the generation for phenotyping");
				 return false;
         		}
        	}
        	else if(PhenoTyping.equals("F4"))
        	{
        		if(SEED_HAVE*SEED_HAVE<SEED_NEED)
        		{
      			iwp.setErrorMessage("Seeds are not enough. Please change the generation for phenotyping");
   				return false;
            	}
        		
        	}
        	else
        	{
        		if(SEED_HAVE*SEED_HAVE*SEED_HAVE<SEED_NEED)
        		{
     			iwp.setErrorMessage("Seeds are not enough. Please change the parameters for Multi-location phenotyping");
  				return false;
           		}
        		
        	}
        }
        else
        {
        	if(PhenoTyping.equals("F4"))
        	{
        		if(SEED_HAVE<SEED_NEED)
        		{
   				 iwp.setErrorMessage("Seeds are not enough. Please change the generation for phenotyping");
				 return false;
         		}
        	}
        	else if(PhenoTyping.equals("F5"))
        	{
        		if(SEED_HAVE*SEED_HAVE<SEED_NEED)
        		{
      			iwp.setErrorMessage("Seeds are not enough. Please change the generation for phenotyping");
   				 return false;
            	}
        		
        	}
        	else
        	{
        		if(SEED_HAVE*SEED_HAVE*SEED_HAVE<SEED_NEED)
        		{
     			iwp.setErrorMessage("Seeds are not enough. Please change the parameters for Multi-location phenotyping");
  				return false;
           		}
        		
        	}
        	
        }
		 
		
        String processIndex1=Integer.toString(processIndex);        
		String XMLName = ic.getCombo().getText() + "." + processType.toLowerCase();//此处的xlm是根据，combo的内容来改写的
		String PNGName = ic.getCombo().getText() + ".png";
		BreProcess.setXMLPathAndName(Project.getPath() + "\\" + processType + processIndex1 + "\\" + XMLName);		
		FileOperator fo = new FileOperator();
		fo.newFolder(Project.getPath() + "/" + processType + processIndex1);		
		DialogSettings settings = new DialogSettings("input");
		settings.put("country", ic.getText1().getText());
		settings.put("researcher", ic.getText2().getText());
		settings.put("crop species", ic.getCombo().getText());
		settings.put("expected seeds per plant", ic.getSpinner1().getText());
		//settings.put("expected seeds per plant", ic.getText5().getText());
		settings.put("length of each season (months)", ic.getSpinner2().getText());
		settings.put("seasons per year", ic.getCombo12().getText());
		settings.put("1st season starts in", ic.getCombo13().getText());
		settings.put("2nd season starts in", ic.getCombo14().getText());
		settings.put("3rd season starts in", ic.getCombo15().getText());
        settings.put("parental generation starts in", ic.getDataTime1().getYear()+"/"+(ic.getDataTime1().getMonth()+1));
		settings.put("generation for genotyping", ic.getCombo3().getText());
		settings.put("generation for phenotyping", ic.getCombo6().getText());
        if(ic.getRadioButton()==0)
        {
        	settings.put("Early generation growing condition", "Greenhouse/offseason");
        }
        else
        {
        	settings.put("Early generation growing condition", "Field condition");
       	
        }
		settings.put("number of locations", ic.getText3().getText());
		settings.put("replicates in each location", ic.getCombo4().getText());
		settings.put("plot length (m)", ic.getText4().getText());
		settings.put("number of rows", ic.getText6().getText());
		settings.put("individual plants per plot", ic.getText7().getText());
		settings.put("rounds of selfing", ic.getCombo5().getText());
		try 
		{
			settings.save(BreProcess.getXMLPathAndName());
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		CTabItem cTabItem1 = MainShell.getWbc().getcTabFolder().getItem(0);
		cTabItem1.setText(XMLName);
		MiddleComposite mc = new MiddleComposite(MainShell.getWbc().getcTabFolder(), SWT.NONE, "MARS");
		//mc.setProcessType("MARS");
		
		cTabItem1.setControl(mc);
		MainShell.getWbc().getcTabFolder().setSelection(cTabItem1);
		
		//show overview
		CTabItem cTabItem2 = MainShell.getWbc().getcTabFolder1().getItem(0);
		cTabItem2.setText(PNGName);
		RightComposite rc = new RightComposite(MainShell.getWbc().getcTabFolder1(),SWT.NONE);
		cTabItem2.setControl(rc);
		MainShell.getWbc().getcTabFolder1().setSelection(cTabItem2);
		
		//恢复planview
		if(Validate.validateBottomComposite(MainShell.getWbc().getcTabFolder2()))
		{
			MainShell.getWbc().getcTabFolder2().getItem(0).dispose();
			MainShell.getWbc().createCTabItem2();
			MainShell.getWbc().getcTabFolder2().setSelection(MainShell.getWbc().getcTabFolder2().getItem(0));
		}
					
		//String processType = Messages.getString("MainShell.17"); //$NON-NLS-1$
		
		File file = new File(Project.getPath());		    			    		
		File[] files = file.listFiles();		
		File subfile = new File(Project.getPath()+"/" + processType + processIndex1);
		File marsfile = new File(subfile.getAbsolutePath() +  "/" + ic.getCombo().getText() + ".mars");
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
