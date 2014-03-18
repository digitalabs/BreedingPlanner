package com.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.overall.BreProcess;
import com.overall.Project;
import com.overall.Validate;


public class FileTree extends Tree 
{		
	private FileTree fileTree = this;
	private Boolean isFolder = false;//是文件夹吗
	private Boolean isFile = false;//是文件吗
	private Boolean isExpanded = false;//文件夹是打开的吗
	private TreeViewer treeViewer = null;//树
	private TreeActionGroup actionGroup = null;//把树结构点击右键出发的动作，定义一个新变量
	private File selectedFile = null;	
	private File formerFile = null;//记录上个展开的文件
			
	public void setFormerFile(File formerFile) 
	{
		this.formerFile = formerFile;
	}
	
	public File getFormerFile(){
		return formerFile;
	}
	
	public File getSelectedFile() 
	{
		return selectedFile;
	}

	public TreeActionGroup getActionGroup() 
	{
		return actionGroup;
	}

	public Boolean getIsFolder()
	{
		return isFolder;
	}

	public void setIsFolder(Boolean isFolder)
	{
		this.isFolder = isFolder;
	}

	public Boolean getIsFile()
	{
		return isFile;
	}

	public void setIsFile(Boolean isFile) 
	{
		this.isFile = isFile;
	}

	public Boolean getIsExpanded() 
	{
		return isExpanded;
	}

	public void setIsExpanded(Boolean isExpanded) 
	{
		this.isExpanded = isExpanded;
	}

	public TreeViewer getTreeViewer() 
	{
		return treeViewer;
	}
	
	public void initExpand()
	{
		File file = new File(Project.getPath());
		File files[] = file.listFiles();
		for(int i = 0 ; i < files.length ; i ++)
		{
			treeViewer.setHasChildren(files[i], false);//对文件列表按字母排序
		}
	}
    
	//构造文件 树    继承composite
	public FileTree(Composite parent, int style)
	{
		super(parent, style);
		treeViewer = new TreeViewer(this);
		treeViewer.setLabelProvider(new TreeViewerLableProvider());//设置标签提供器,对应文件夹和文件的图标
		treeViewer.setContentProvider(new TreeViewerContentProvider());//内容提供器
		treeViewer.setInput(Project.getPath() == null ? null : new File(Project.getPath()));//初始化数据
		
		//treeViewer.setSorter(new FileSorter());//设置筛选器
		
		actionGroup = new TreeActionGroup(treeViewer);
		
		actionGroup.fillContextMenu(new MenuManager());//菜单管理器		  
		
        treeViewer.addDoubleClickListener(new IDoubleClickListener()//在树结构中增加双击监听器
		{
			public void doubleClick(DoubleClickEvent e) //双击事件，打开文件
			{				// TODO Auto-generated method stub
				ITreeSelection selection = (ITreeSelection)e.getSelection();
				File file = (File) selection.getFirstElement();	//取得第一个元素			
				if(file.isDirectory())//取得的元素是目录，还没有展开Modify 和make a plan 就不能用
				{					
					MainShell.getPush6().setEnabled(true);
					MainShell.getPush8().setEnabled(true);
					String XMLName = null;
					String PNGName = null;
					if(!file.equals(formerFile))
					{
						File[] subFiles = file.listFiles();
						for (int i = 0; i < subFiles.length; i++) {
							if (subFiles[i].getName().endsWith(".mars")||subFiles[i].getName().endsWith(".mas")||subFiles[i].getName().endsWith(".mabc")) 
							{
								XMLName = subFiles[i].getName();
							}else if(subFiles[i].getName().endsWith(".png"))
							{
								PNGName = subFiles[i].getName();
							}
						}
						//设置参数
						BreProcess.setXMLPathAndName(file.getAbsolutePath() + "\\" + XMLName);						
						//Dataview
						CTabItem cTabItem1 = null;
						if(MainShell.getWbc().getcTabFolder().getItemCount() == 0)
						{
							cTabItem1 = new CTabItem(MainShell.getWbc().getcTabFolder(), SWT.CLOSE);
						}else 
						{
							cTabItem1 = MainShell.getWbc().getcTabFolder().getItem(0);
						}
						cTabItem1.setText(XMLName);
						String processType=null;
						
						if(file.getName().startsWith("MARS"))
						{
							processType="MARS";
						}
						else if(file.getName().startsWith("MABC"))
						{
							processType="MABC";
						}
						else if(file.getName().startsWith("MAS"))
						{
							processType="MAS";
						}
						else
						{							
						}
						//和中间面板显示的内容联系在一起
						MiddleComposite mc = new MiddleComposite(MainShell.getWbc().getcTabFolder(), SWT.NONE, processType);
						cTabItem1.setControl(mc);
						MainShell.getWbc().getcTabFolder().setSelection(cTabItem1);
						
						//Overview
						CTabItem cTabItem2 = null;
						if(MainShell.getWbc().getcTabFolder1().getItemCount() == 0){
							cTabItem2 = new CTabItem(MainShell.getWbc().getcTabFolder1(), SWT.CLOSE);
						}else 
						{
							cTabItem2 = MainShell.getWbc().getcTabFolder1().getItem(0);
						}
						cTabItem2.setText(PNGName);
						if(processType=="MARS")
						{
						RightComposite rc = new RightComposite(MainShell.getWbc().getcTabFolder1(),SWT.NONE);
						cTabItem2.setControl(rc);
						}
						else if(processType=="MABC"){
							RightCompositeMABC rc = new RightCompositeMABC(MainShell.getWbc().getcTabFolder1(),SWT.NONE);
							cTabItem2.setControl(rc);
							}
						else if(processType=="MAS"){
						RightCompositeMAS rc = new RightCompositeMAS(MainShell.getWbc().getcTabFolder1(),SWT.NONE);
						cTabItem2.setControl(rc);
						}
						else{    }
													
//						cTabItem2.setControl(rc);
						MainShell.getWbc().getcTabFolder1().setSelection(cTabItem2);						
						//恢复planview 关于底部面板BottomComposition的一些操作
						if(Validate.validateBottomComposite(MainShell.getWbc().getcTabFolder2()))
						{
							MainShell.getWbc().getcTabFolder2().getItem(0).dispose();
							MainShell.getWbc().createCTabItem2();
							MainShell.getWbc().getcTabFolder2().setSelection(MainShell.getWbc().getcTabFolder2().getItem(0));
						}
						if(Validate.validateBottomCompositeMABC(MainShell.getWbc().getcTabFolder2()))
						{
							MainShell.getWbc().getcTabFolder2().getItem(0).dispose();
							MainShell.getWbc().createCTabItem2();
							MainShell.getWbc().getcTabFolder2().setSelection(MainShell.getWbc().getcTabFolder2().getItem(0));
						}
						if(Validate.validateBottomCompositeMAS(MainShell.getWbc().getcTabFolder2()))
						{
							MainShell.getWbc().getcTabFolder2().getItem(0).dispose();
							MainShell.getWbc().createCTabItem2();
							MainShell.getWbc().getcTabFolder2().setSelection(MainShell.getWbc().getcTabFolder2().getItem(0));
						}												
						//设置treeViewer
						File[] files = file.getParentFile().listFiles();
						for(int i = 0 ; i < files.length ; i ++)
						{
							treeViewer.setExpandedState(files[i], false);
						}
						//initExpand();
						treeViewer.setContentProvider(new OpenTreeViewerContentProvider(file));
						MainShell.getLc().getFileTree().getTreeViewer().setExpandedState(file, true);
						formerFile = file;
					} 
				}
			}});
		
		treeViewer.addPostSelectionChangedListener(new ISelectionChangedListener()
		{
			public void selectionChanged(SelectionChangedEvent e) 
			{
				// TODO Auto-generated method stub
				ITreeSelection selection = (ITreeSelection)e.getSelection();
				File file = (File) selection.getFirstElement();
				
				if(file != null)
				{
					if(file.isDirectory())
					{
						if(treeViewer.getExpandedState(file))
						{
							MainShell.getPush6().setEnabled(true);
							MainShell.getPush8().setEnabled(true);
						}else
						{
							MainShell.getPush6().setEnabled(false);
							MainShell.getPush8().setEnabled(false);
						}
						selectedFile = file;
						File[] files = file.listFiles();
						String XMLName = null;
						for (int i = 0; i < files.length; i++) 
						{
							if (files[i].getName().endsWith(".mars")||files[i].getName().endsWith(".mas")||files[i].getName().endsWith(".mabc")) 
							{
								XMLName = files[i].getName();
							}
						}
						
						//设置参数
						BreProcess.setXMLPathAndName(file.getAbsolutePath() + "\\" + XMLName);
					}else
					{
						MainShell.getPush6().setEnabled(false);
						MainShell.getPush8().setEnabled(false);
					}
				}
			}});
		
		
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{				
				//鼠标右键按下
				if(e.button == 3){
					TreeItem item = fileTree.getItem(new Point(e.x, e.y));
					if (item != null) {
						ITreeSelection selection = (ITreeSelection) treeViewer.getSelection();
						File file = (File) selection.getFirstElement();
						if(file.isDirectory()){
							isFolder = true;
							String XMLName = null;
							File[] files = file.listFiles();
							for (int i = 0; i < files.length; i++) 
							{
								if (files[i].getName().endsWith(".mars")||files[i].getName().endsWith(".mas")||files[i].getName().endsWith(".mabc")) 
								{
									XMLName = files[i].getName();
								}
							}							
							//设置参数
							BreProcess.setXMLPathAndName(file.getAbsolutePath() + "\\" + XMLName);
							
							if(treeViewer.getExpandedState(file))
								isExpanded = true;
						}else {
							isFile = true;
						}
					}
					
				}
				
			}
		});
		
	}


	@Override
    protected void checkSubclass() 
	{    
    }		
	//ContentProvider
	public class TreeViewerContentProvider implements ITreeContentProvider 
	{		
		
		public Object[] getChildren(Object element) 
		{
			return ((File) element).listFiles(new IBPFilter());//是否返回元素要根据后面的IBPFilter，如果是true就返回，false则不返回
		}
	
		public Object[] getElements(Object element) 
		{
			
			return getChildren(element);
			
		}

		public boolean hasChildren(Object element) 
		{
			Object[] obj = getChildren(element);//树中元素要在这里检查一次，

			return obj == null?false : obj.length>0;
		}

		public Object getParent(Object element) 
		{
			return ((File) element).getParentFile();			
		}

		public void dispose() 
		{
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
		{
		}
	}
	
	public class IBPFilter implements FileFilter
	{
		
		public boolean accept(File pathname) 
		{	
			
			
			File projectfile = new File(Project.getPath());
			File[] files = projectfile.listFiles();
			ArrayList<String> allfilepath = new ArrayList<String>();			
			for(int i=0;i<files.length;i++)
			{
				String filename = files[i].getName();						
				if(filename.endsWith(".ibp"))
				{
					File projecttxtfile = new File(Project.getPath()+"/" + filename);
					String projectfilename = filename;
					try
					{
					FileReader reader = new FileReader(projecttxtfile);
					BufferedReader br = new BufferedReader(reader);
					String s1 = null;
					while((s1=br.readLine()) != null)
					{
						allfilepath.add(s1);								
					}
					for(int m=0;m<allfilepath.size();m++)
					{
						allfilepath.remove(projectfilename);
					}
										
					}
					catch(Exception p)
					{
						
					}
				}												
			}
			
			//Collections.sort(allfilepath);	
			String b = pathname.getAbsolutePath();			
			boolean cunzai = false;
			for(int i=0;i<allfilepath.size();i++)
			{				
				String a = allfilepath.get(i);
				if( a.equals(b))
				{
					 cunzai = true;
				}
			}
			
			//return cunzai;
			
			return (!pathname.getAbsolutePath().endsWith(".ibp")&&cunzai);
			
		}
	}

	public class FileSorter extends ViewerSorter 
	{
		public int category(Object element) 
		{
			return ((File) element).isDirectory() ? 0 : 1;
		}
	}

	public class OpenTreeViewerContentProvider implements ITreeContentProvider 
	{
		private File file = null;

		public OpenTreeViewerContentProvider(File file) {
			this.file = file;
		}

		// 子节点
		public Object[] getChildren(Object element) 
		{
			return ((File) element).listFiles(new IBPFilter());
		}
		// 第一级节点
		public Object[] getElements(Object element) 
		{
			return getChildren(element);
		}

		public boolean hasChildren(Object element) 
		{
			return file.equals((File) element);
		}

		public Object getParent(Object element) {
			return ((File) element).getParentFile();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	//LabelProvider,文件图标，
	public class TreeViewerLableProvider implements ILabelProvider 
	{
		public Image getImage(Object element) 
		{
			File file = (File) element;
			if (file.isDirectory())
			{
				return ImageDescriptor.createFromFile(this.getClass(),"/com/img/folder.gif").createImage();
			}
			if(file.getName().endsWith("mars"))
			{
			return ImageDescriptor.createFromFile(this.getClass(),"/com/img/delicious.gif").createImage();
			}
			if(file.getName().endsWith("mabc"))
			{
			return ImageDescriptor.createFromFile(this.getClass(),"/com/img/delicious.gif").createImage();
			}
			if(file.getName().endsWith("mas"))
			{
			return ImageDescriptor.createFromFile(this.getClass(),"/com/img/delicious.gif").createImage();
			}
			if(file.getName().endsWith("png"))
			{
			return ImageDescriptor.createFromFile(this.getClass(),"/com/img/png.gif").createImage();
			}
			if(file.getName().endsWith("txt"))
			{
			return ImageDescriptor.createFromFile(this.getClass(),"/com/img/file.gif").createImage();
			}
			return null;
		}

		public String getText(Object element) 
		{
			return ((File) element).getName();
		}

		public void addListener(ILabelProviderListener listener)
		{

		}

		public void dispose() 
		{

		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {

		}
	}
	
		
	
}
