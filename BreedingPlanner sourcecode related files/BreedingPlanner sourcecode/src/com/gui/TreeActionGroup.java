package com.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.actions.ActionGroup;

import com.gui.wizard.InputWizard;
import com.gui.wizard.InputWizardMABC;
import com.gui.wizard.InputWizardMAS;
import com.gui.wizard.ModifyWizard;
import com.gui.wizard.ModifyWizardMABC;
import com.gui.wizard.ModifyWizardMAS;
import com.gui.wizard.NewProjectWizard;
import com.gui.MiddleComposite;
import com.io.FileOperator;
import com.overall.BreProcess;
import com.overall.Project;
import com.overall.Validate;
import com.io.InputInfoItem;
import com.io.InputInfoMang;
import com.overall.BreProcess;
import com.gui.WorkBenchComposite;

public class TreeActionGroup extends ActionGroup 
{
	private FileTree fileTree ;
    private TreeViewer tv;  //树浏览器
    private MiddleComposite mc; //中间面板
	private static SashForm sashForm = null;
    private static WorkBenchComposite wbc = null; //右边工作区，可以初始化
    private String processType = null;//项目类项
    private int processIndex;//新建文件的索引号
    private String processName;//项目名称
    private TreeViewer treeViewer = null;// 历树
    private CTabFolder cTabFolder = null;
	private CTabFolder cTabFolder1 = null;
	private Label label1 = null;
	private CTabFolder cTabFolder2 = null;
	private CTabItem cTabItem = null;
	private CTabItem cTabItem1 = null;
	private CTabItem cTabItem2 = null;
    
    
    public static WorkBenchComposite getWbc() {
		return wbc;
	}
    
    public int getProcessIndex() //取得索引号
	{
		return processIndex;
	}

	public String getProcessType() //取得类型并返回
	{
		return processType;
	}
	public String getProcessName()//此段新加，要得到程序的名称
	{
		return processName;
	}

	public TreeActionGroup(TreeViewer treeViewer) //遍历树
	{
        this.tv = treeViewer;
    }

    /**
     * 生成菜单Menu，并将Action传入
     */
    public void fillContextMenu(IMenuManager mgr)
    {
        /*
         * 加入两个Action对象到菜单管理器
         */
        MenuManager menuManager = (MenuManager) mgr; //类型转换一下，注意参数是接口
        //删除老菜单
        menuManager.setRemoveAllWhenShown(true);//remove all
        menuManager.addMenuListener(new IMenuListener()//增加菜单管理监听器
        {
			@Override
			public void menuAboutToShow(IMenuManager manager) //menuabouttoshow方法,要显示的内容
			{
				// TODO Auto-generated method stub
				//如果没有工程加入，空白处点击右键，出现新建工程和打开工程选项
				if(Project.getPath() == null)
				{
					manager.add(new NewProjectAction());
					manager.add(new OpenProjectAction());
				}
				//如果左边工程路径不是空，并且没有选中任何一个文件，点击右键会出现，新建MARS MABC MAS的操作				
				if(Project.getPath() != null && !MainShell.getLc().getFileTree().getIsFile())
				{
					manager.add(new MarsAction());
					manager.add(new MabcAction());					
					manager.add(new MasAction());								
				}
				if(MainShell.getLc().getFileTree().getIsFolder())//当点击右键，如果点到的是文件夹，未展开的状态
				{
					Separator separator = new Separator();//增加充当分隔条的菜单项
					manager.add(separator);
					ModifyDataAction dataAction = new ModifyDataAction();//在原来新建的基础上怎加修改参数、和make a plan
					MakeAPlanAction planAction = new MakeAPlanAction();
					dataAction.setEnabled(false);//修改数据不可用
					planAction.setEnabled(false);//制定计划选项不可用
					manager.add(dataAction);
					manager.add(planAction);
					//如果点到是被打开的，即MARS MABC MAS的文件夹，修改数据、制定计划都可用	
					if(MainShell.getLc().getFileTree().getIsExpanded())
					{
						dataAction.setEnabled(true);
						planAction.setEnabled(true);
						MainShell.getLc().getFileTree().setIsExpanded(false);
					}
					manager.add(separator);//跳出分支，无论什么情况都增加分割条菜单项
					manager.add(new RemoveFolderAction());//增加删除选项
					MainShell.getLc().getFileTree().setIsFolder(false);
				}
				//如果鼠标点击是文件，那么全部在菜单管理中加入“Save as” 保存按钮
				if(MainShell.getLc().getFileTree().getIsFile())
				{
					manager.add(new SaveAsAction());
					                                      //如果选到是文件并且扩展名为.png，则增加打印操作
					if(getSelected().getName().endsWith(".png"))
					{
						manager.add(new PrintAction());
						//manager.add(new RemoveFileAction());
						
					}
					MainShell.getLc().getFileTree().setIsFile(false);
				}				
			}
        	
        });
        /*
         * 生成Menu并挂在树Tree上
         */
        Tree tree = tv.getTree();
        Menu menu = menuManager.createContextMenu(tree);
        tree.setMenu(menu);
    }
//以下为对应右键的各项动作  
    private class NewProjectAction extends Action //新建工程对应的类
    {
    	public NewProjectAction() 
    	{
    		setText("New Project");
    	}
    	public void run()
    	{
    		WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new NewProjectWizard());
			wd.setPageSize(300, 300);
			wd.open();//显示为打开
    	}    	
    }    
   
    private class OpenProjectAction extends Action //打开工程按钮对应的类
    {
    	public OpenProjectAction() 
    	{
    		setText("Open Project");
    	}
    	public void run()
    	{
    		FileDialog fd = new FileDialog(Display.getCurrent().getActiveShell(),SWT.OPEN);
			fd.setFilterExtensions(new String[]{"*.ibp"});
			fd.open();
			if(!fd.getFileName().isEmpty())
			{
				MainShell.getLc().getcTabFolder().getItem(0).setText("Project Explorer：" + fd.getFileName().split("\\.")[0]);
				Project.setPath(fd.getFilterPath());//工程路径  ：对话框的获得的路径
				MainShell.getLc().getFileTree().getTreeViewer().setInput(new File(Project.getPath()));
				MainShell.getLc().getFileTree().getTreeViewer().refresh();//刷新一遍树的结构
				MainShell.getLc().getFileTree().initExpand();//初始化打开
			}
    	}
    }
    
//新建MARS工程     
    private class MarsAction extends Action 
    {
		public MarsAction()
		{
    		setText("New MARS");
    	}		
    	public void run()
    	{
    		processType = "MARS";    		
    		File file = new File(Project.getPath());
    		processIndex = 1;//索引号
    		File[] files = file.listFiles();     		
    		boolean isE=true;
    		while(isE)
    		{
    			boolean isE1=false;
    			for(int i = 0;i<files.length;i++)
    			{
    				String na=processType+Integer.toString(processIndex);
    				String name1=files[i].getName();
    			    if(name1.equals(na))
    			    {
    			       isE1=true;		
    			    }
    			}
    			if(isE1)
    			{
    				isE=true;
    				processIndex++;
    			}
    			else
    			{
    				isE=false;
    			}
    		}    		
    		WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new InputWizard(processType,processIndex));
    		wd.setPageSize(650, 550);
    		wd.open();    		
    		
    		File subfile = new File(Project.getPath() + "/" + processType + processIndex);
    	    		
    		String name =  processType + processIndex;
    		MainShell.getLc().getFileTree().getTreeViewer().refresh();//左侧树的刷新、初始化
    		
    		for(int i = 0 ; i < files.length ; i ++){
				MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(files[i], false);
		}
    		MainShell.getLc().getFileTree().initExpand();			  //保证新建项目后，其他的关闭，新建的打开    		
    		MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(subfile, true);//把新建的项目设为打开状态
    		//MainShell.getLc().getFileTree().getTreeViewer().setSelection(null);
    		MainShell.getLc().getFileTree().setFormerFile(subfile); 
    		TreeItem[] ti =  MainShell.getLc().getFileTree().getTreeViewer().getTree().getItems();
    		for(TreeItem t:ti)
    		{
    			if(name.equals(t.getText()))
    			{
    				MainShell.getLc().getFileTree().setSelection(t);
    				break;
    			}
    		}
    		
    		//新建文件后，清空底部make a plan 框体
    		if(MainShell.getWbc().getcTabFolder2().getItemCount() == 0){
				cTabItem2 = new CTabItem(MainShell.getWbc().getcTabFolder2(), SWT.CLOSE);
			}else 
			{
				cTabItem2 = MainShell.getWbc().getcTabFolder2().getItem(0);
			}
			cTabItem2.setText("Make a Plan");
			cTabItem2.setControl(cTabFolder2);
			MainShell.getWbc().getcTabFolder2().setSelection(cTabItem2);
			
    	}
    }
    
    //新建MABC的操作
    private class MabcAction extends Action 
    {
    	public MabcAction() {
    		setText("New MABC");
    		//this.setEnabled(false);
    	}
    	
    	public void run()
    	{
    		processType = "MABC";
    		File file = new File(Project.getPath());
    		processIndex = 1;//索引号
    		File[] files = file.listFiles();
    		boolean isE=true;
    		while(isE)
    		{
    			boolean isE1=false;
    			for(int i = 0;i<files.length;i++){
    				String na=processType+Integer.toString(processIndex);
    				String name1=files[i].getName();
    			    if(name1.equals(na))
    			    {
    			       isE1=true;		
    			    }
    			}
    			if(isE1)
    			{
    				isE=true;
    				processIndex++;
    			}
    			else
    			{
    				isE=false;
    			}
    		}
    		WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new InputWizardMABC(processType,processIndex));
    		wd.setPageSize(650, 550);
    		wd.open();
    		
    		File subfile = new File(Project.getPath() + "/" + processType + processIndex);  
    	
    		String name =  processType + processIndex;
    		MainShell.getLc().getFileTree().getTreeViewer().refresh();
    		//subfile = getSelected();
    		for(int i = 0 ; i < files.length ; i ++){
				MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(files[i], false);
		}
    		MainShell.getLc().getFileTree().initExpand();
    		MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(subfile, true);
    		MainShell.getLc().getFileTree().setFormerFile(subfile);
    		TreeItem[] ti =  MainShell.getLc().getFileTree().getTreeViewer().getTree().getItems();
    		for(TreeItem t:ti){
    			if(name.equals(t.getText())){
    				MainShell.getLc().getFileTree().setSelection(t);
    				break;
    			}
    		}
    		//新建文件后，清空底部make a plan 框体
    		if(MainShell.getWbc().getcTabFolder2().getItemCount() == 0){
				cTabItem2 = new CTabItem(MainShell.getWbc().getcTabFolder2(), SWT.CLOSE);
			}
    		else 
			{
				cTabItem2 = MainShell.getWbc().getcTabFolder2().getItem(0);
			}
			cTabItem2.setText("Make a Plan");
			cTabItem2.setControl(cTabFolder2);
			MainShell.getWbc().getcTabFolder2().setSelection(cTabItem2);
    	}
    }
    
    //新建mas的工程
    private class MasAction extends Action 
    {
    	public MasAction(
    			){
    		setText("New MAS");
    		//this.setEnabled(false);
    	}    	
    	public void run()
    	{
    		processType = "MAS";
    		File file = new File(Project.getPath());
    		processIndex = 1;//索引号改为1
    		File[] files = file.listFiles();
    		boolean isE=true;
    		while(isE)
    		{
    			boolean isE1=false;
    			for(int i = 0;i<files.length;i++){
    				String na=processType+Integer.toString(processIndex);
    				String name1=files[i].getName();
    			    if(name1.equals(na))
    			    {
    			       isE1=true;		
    			    }
    			}
    			if(isE1)
    			{
    				isE=true;
    				processIndex++;
    			}
    			else
    			{
    				isE=false;
    			}
    		}
    		WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new InputWizardMAS(processType,processIndex));
    		wd.setPageSize(650, 550);
    		wd.open();
    		
    		File subfile = new File(Project.getPath() + "/" + processType + processIndex);
    		
    		String name =  processType + processIndex;
    		MainShell.getLc().getFileTree().getTreeViewer().refresh();
    		for(int i = 0 ; i < files.length ; i ++){
				MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(files[i], false);
		}
    		MainShell.getLc().getFileTree().initExpand();
    		MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(subfile, true);
    		MainShell.getLc().getFileTree().setFormerFile(subfile);
    	    //subfile = getSelected();
    		TreeItem[] ti =  MainShell.getLc().getFileTree().getTreeViewer().getTree().getItems();
    		for(TreeItem t:ti){
    			if(name.equals(t.getText())){
    				MainShell.getLc().getFileTree().setSelection(t);
    				break;
    			}
    		}
    		//新建文件后，清空底部make a plan 框体
    		if(MainShell.getWbc().getcTabFolder2().getItemCount() == 0){
				cTabItem2 = new CTabItem(MainShell.getWbc().getcTabFolder2(), SWT.CLOSE);
			}else 
			{
				cTabItem2 = MainShell.getWbc().getcTabFolder2().getItem(0);
			}
			cTabItem2.setText("Make a Plan");
			cTabItem2.setControl(cTabFolder2);
			MainShell.getWbc().getcTabFolder2().setSelection(cTabItem2);
    	}
    }
    
    /**
     * 删除文件夹
     */
    
    private class RemoveFolderAction extends Action 
    {
        public RemoveFolderAction() 
        {
            setText("Delete");
        }      
        public void run() 
        {      //删除后刷新左侧树     
        	MainShell.getPush6().setEnabled(false);
        	MainShell.getPush8().setEnabled(false);
            File file = getSelected();
            FileOperator fo = new FileOperator();
            fo.delFolder(file.getAbsolutePath()); //删除操作                   
            tv.refresh();  
            
            
            
            //删除后，删除ibp文件中的相关记录
            File projectfile = new File(Project.getPath());
            File[] files =projectfile.listFiles();
            for(int i = 0;i<files.length;i++)
    		{
    			String filename = files[i].getName(); 
    			if(filename.endsWith(".ibp"))
    			{
    				File projecttxtfile = new File(Project.getPath() + "/" + filename); 
    				try
    				{
    				FileReader reader = new FileReader(projecttxtfile);
    				BufferedReader br = new BufferedReader(reader);
    				String s1 = null;
    				ArrayList<String> allfilepath = new ArrayList<String>();
    				while((s1 = br.readLine())!= null)
    				{
    					allfilepath.add(s1);    					
    				}
    				int fileposition =0;
    				for(int t=0;t<allfilepath.size();t++)
    				{
    					String a= allfilepath.get(t);
    					if(a.equals(file.getAbsolutePath()))
    					{
    						fileposition = t;
    						allfilepath.remove(fileposition);
    				        allfilepath.remove(fileposition);
    				        allfilepath.remove(fileposition);
    				        allfilepath.remove(fileposition);
    					}   					    					
    				}    				    				    				
    				//Collections.sort(allfilepath);
    				br.close(); 
    				   					
    			    FileWriter t = new FileWriter(projecttxtfile);
    			     t.write("");
    			     t.close();
    			     
    			     FileOutputStream f = new FileOutputStream(projecttxtfile);
    			     for(int j=0;j<allfilepath.size();j++)
    			     {
	    	    		f.write(allfilepath.get(j).getBytes());
	    	    		f.write("\r\n".toString().getBytes());
    			     }
	    	    		f.close();
    				}    	    		    	    		
    	    		catch(Exception p)
    	    		{   	    					
    	    		}
    			}	    			
    		}        
            //刷新右侧和底部窗口
            if(MainShell.getWbc().getcTabFolder().getItemCount() == 0)
			{
				cTabItem = new CTabItem(MainShell.getWbc().getcTabFolder(), SWT.CLOSE);
			}else 
			{
				cTabItem = MainShell.getWbc().getcTabFolder().getItem(0);
			}
			cTabItem.setText("Parameters");
			String processType=null;
			//MiddleComposite mc = new MiddleComposite(MainShell.getWbc().getcTabFolder(), SWT.NONE, processType);
			cTabItem.setControl(cTabFolder);
			MainShell.getWbc().getcTabFolder().setSelection(cTabItem);
            
			
			if(MainShell.getWbc().getcTabFolder1().getItemCount() == 0){
				cTabItem1 = new CTabItem(MainShell.getWbc().getcTabFolder1(), SWT.CLOSE);
			}else 
			{
				cTabItem1 = MainShell.getWbc().getcTabFolder1().getItem(0);
			}
			cTabItem1.setText("Breeding scheme");
			cTabItem1.setControl(cTabFolder1);
			MainShell.getWbc().getcTabFolder1().setSelection(cTabItem1);	
			
			if(MainShell.getWbc().getcTabFolder2().getItemCount() == 0){
				cTabItem2 = new CTabItem(MainShell.getWbc().getcTabFolder2(), SWT.CLOSE);
			}else 
			{
				cTabItem2 = MainShell.getWbc().getcTabFolder2().getItem(0);
			}
			cTabItem2.setText("Make a Plan");
			cTabItem2.setControl(cTabFolder2);
			MainShell.getWbc().getcTabFolder2().setSelection(cTabItem2);
        }                       
    }   
    
   
    //更新输入信息
    public class ModifyDataAction extends Action
    {
    	public ModifyDataAction()
    	{
    		setText("Modify Parameters");
    	}
    	public void run()
    	{
    		File file = getSelected();    	//被选中才能修改参数	    		    
            if(file.getName().startsWith("MARS")){
	    		WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new ModifyWizard());
	    		wd.setPageSize(650, 550);
	    		wd.open();
    		}
            else if(file.getName().startsWith("MABC")){
	    		WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new ModifyWizardMABC());
	    		wd.setPageSize(650, 550);
	    		wd.open();
    		}
            else if(file.getName().startsWith("MAS")){
	    		WizardDialog wd = new WizardDialog(Display.getCurrent().getActiveShell(), new ModifyWizardMAS());
	    		wd.setPageSize(650, 550);
	    		wd.open();
    		}
            else{
            	
            }
    		
    	}
    }
    
    private class MakeAPlanAction extends Action 
    {
    	public MakeAPlanAction() 
    	{
    		setText("Make a Plan");
    	}
    	public void run(){
    		File file = getSelected();
    //被选中，才能制定计划		
    		CTabItem cTabItem = MainShell.getWbc().getcTabFolder2().getItem(0);
    		cTabItem.setText("Make a Plan");
			if(file.getName().startsWith("MARS")){
	    		BottomComposite bc = new BottomComposite(MainShell.getWbc().getcTabFolder2(), SWT.NONE);						
	    		cTabItem.setControl(bc);
	    		MainShell.getWbc().getcTabFolder2().setSelection(cTabItem);
			}
			else if(file.getName().startsWith("MABC")){
	    		BottomCompositeMABC bc = new BottomCompositeMABC(MainShell.getWbc().getcTabFolder2(), SWT.NONE);						
	    		cTabItem.setControl(bc);
	    		MainShell.getWbc().getcTabFolder2().setSelection(cTabItem);
			}
			else if(file.getName().startsWith("MAS")){
	    		BottomCompositeMAS bc = new BottomCompositeMAS(MainShell.getWbc().getcTabFolder2(), SWT.NONE);						
	    		cTabItem.setControl(bc);
	    		MainShell.getWbc().getcTabFolder2().setSelection(cTabItem);
			}
			else{				
			}
    	}
    }
    //保存按钮的方法
    private class SaveAsAction extends Action 
    {
    	public SaveAsAction() 
    	{
    		setText("Save As");
    	}
    	public void run()
    	{
    		
    		File file = getSelected();
    		    		
    		FileDialog fd = new FileDialog(Display.getDefault().getActiveShell(),SWT.SAVE);
    		    		
    		if(file.getName().endsWith(".mars"))
    		{
    			fd.setFilterExtensions(new String[]{"*.mars"});
    		}
    		else if(file.getName().endsWith(".mabc"))
    		{
    			fd.setFilterExtensions(new String[]{"*.mabc"});
    		}    		
    		if(file.getName().endsWith(".mas"))
    		{
    			fd.setFilterExtensions(new String[]{"*.mas"});
    		}
    		else if(file.getName().endsWith(".png"))
    		{
    			fd.setFilterExtensions(new String[]{"*.png"});
    		}
    		else if(file.getName().endsWith(".txt"))
    		{
    			fd.setFilterExtensions(new String[]{"*.txt"});
    		}
    		
    		fd.setFilterPath(System.getProperty("user.home"));
    		fd.setFileName(file.getName());
    		fd.open();
    	    	    		
 		   if(!fd.getFileName().isEmpty())
    		{
    			
    			//if(fd.getFilterPath().equals(Project.getPath()))
    			//{
    				//MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error Message", "This is your Project folder," +
    				//		"please choose another folder to save the file !");    
    				
    			//}
    			//else
    			//{
    				FileOperator fo = new FileOperator();
    			    fo.copyFile(file.getAbsolutePath(), fd.getFilterPath()+"/"+fd.getFileName());
    			//}
    			
    		}
    	}
    }
    
    private class PrintAction extends Action {
    	public PrintAction() {
    		setText("Print");
    	}
    	public void run(){
    		File file = getSelected();
    		// Load the image
    		ImageLoader loader = new ImageLoader();
    		ImageData[] imageData = loader.load(file.getAbsolutePath());
    		// Show the Choose Printer dialog
    		PrintDialog pd = new PrintDialog(Display.getCurrent().getActiveShell());
    		PrinterData data = pd.open();
			if (data != null) {
				Printer printer = new Printer(data);
				try {
					if (imageData.length > 0) {
						// Calculate the scale factor between the screen
						// resolution and printer
						// resolution in order to correctly size the image for
						// the printer
						Point screenDPI = Display.getCurrent().getDPI();
						Point printerDPI = printer.getDPI();
						int scaleFactor = printerDPI.x / screenDPI.x;
						// Determine the bounds of the entire area of the
						// printer
						Rectangle trim = printer.computeTrim(0, 0, 0, 0);
						// Start the print job
						if (printer.startJob(file.getAbsolutePath())) {
							if (printer.startPage()) {
								GC gc = new GC(printer);
								Image printerImage = new Image(printer,
										imageData[0]);
								// Draw the image
								gc.drawImage(printerImage, 0, 0,
										imageData[0].width,
										imageData[0].height, -trim.x, -trim.y,
										scaleFactor * imageData[0].width,
										scaleFactor * imageData[0].height);
								// Clean up
								printerImage.dispose();
								gc.dispose();
								printer.endPage();
							}
						}			
						printer.endJob();
						printer.dispose();

					}
				} catch (Exception e) {
					MessageBox messageBox = new MessageBox(Display.getCurrent()
							.getActiveShell(), SWT.ICON_ERROR);
					messageBox.setMessage("Error printing test image");
					messageBox.open();
				}
			}
    	}
    }


    
    private File getSelected() 
    {
        IStructuredSelection selection = (IStructuredSelection) tv.getSelection();
        File file = (File) (selection.getFirstElement());
        return file;
    }
   

}