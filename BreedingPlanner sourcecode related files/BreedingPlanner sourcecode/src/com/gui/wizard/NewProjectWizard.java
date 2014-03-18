package com.gui.wizard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;

import com.gui.LeftComposite;
import com.gui.MainShell;
import com.gui.WorkBenchComposite;
import com.io.FileOperator;
import com.overall.Project;

public class NewProjectWizard extends Wizard 
{
	
	private NewProjectWizardPage npw;
	private NewProjectComposite npc;
	public String projectName;
	public String selectedDirectory;
	
	@Override
	public boolean needsPreviousAndNextButtons() 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean performFinish() 
	{
		// TODO Auto-generated method stub
		npc = npw.getNpc();
		projectName = npc.getText().getText();
		if(projectName.isEmpty())
		{
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Project Name Error","Project name cannot be null !");
			//this.npw.setErrorMessage("Project name cannot be null");
			return false;
		}
		
		selectedDirectory =  npc.getText1().getText();
		if(selectedDirectory.isEmpty())
		{
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Project Location Error", "Location cannot be null !");
			//this.npw.setErrorMessage("Location cannot be null");
			return false;
		}
		
	//以下为判断工程名为空、工程路径为空的操作	
		File selecteddir = new File(selectedDirectory);		
		File[] selecteddirfile = selecteddir.listFiles();
		ArrayList<String> allfile = new ArrayList<String>();
		for(int t=0;t<selecteddirfile.length;t++)
		{
			String b = selecteddirfile[t].getName();
			allfile.add(b);
		}
		
		if(allfile.contains(projectName))
		{
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Project Name Error", "This Location already contains a folder named"+" "
					+ projectName + "  ,"+"Please rename your project !");
			return false;
		}
				
		
		FileOperator fo = new FileOperator();//打开文件的操作
		fo.newFolder(selectedDirectory + "/" + projectName);
		fo.newFile(selectedDirectory + "/" + projectName + "/" + projectName
				+ ".ibp",selectedDirectory + "\\" + projectName + "\\" + projectName+".ibp");
		
		
		MainShell.getLc().getcTabFolder().getItem(0).setText("Project Explorer：" + projectName);
		Project.setPath(selectedDirectory + "/" + projectName);
//		MainShell.getLc().getFileTree().setProjectPath(selectedDirectory + "/" + projectName);
		MainShell.getLc().getFileTree().getTreeViewer().setInput(new File(Project.getPath()));
		MainShell.getLc().getFileTree().getTreeViewer().refresh();

		return true;
		
	}
	public NewProjectWizard()
	{
		super();
		setWindowTitle("New Project");
		AddPages();
	}
	private void AddPages() 
	{
		// TODO Auto-generated method stub
		npw = new NewProjectWizardPage("page1", "Enter a Project Name",
				ImageDescriptor.createFromFile(NewProjectWizardPage.class,"/com/img/delicious2.png"));
		this.addPage(npw);
		
		
	}

}
