package com.gui.wizard;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;

import com.gui.MainShell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;

public class NewProjectComposite extends Composite
{
	//定义私有变量
	private Shell sShell = null;
	private Group group = null;
	private Label label = null;
	private Text text = null;
	private Label label1 = null;
	private Text text1 = null;
	private Button button = null;
       //方法体
	public NewProjectComposite(Composite parent, int style, Shell sShell) 
	{
		super(parent, style);
		this.sShell = sShell ;
		initialize();
	}
    //初始化，空方法
	private void initialize()
	{
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		createGroup();
		this.setLayout(gridLayout);
		setSize(new Point(600,340));
	}
	
	

	public Text getText() 
	{
		return text;
	}
	public Text getText1() {
		return text1;
	}

	/**
	 * This method initializes group	
	 *
	 */
	//createGroup方法
	private void createGroup() 
	{
		GridData gridData = new GridData();
		gridData.horizontalSpan = 2;
		group = new Group(this, SWT.NONE);
		group.setText("");
		group.setLayoutData(gridData);
		group.setLayout(null);
		label = new Label(group, SWT.NONE);
		label.setText("Project Name:");
		label.setBounds(new Rectangle(10, 40, 86, 17));
		text = new Text(group, SWT.BORDER);
		text.setBounds(new Rectangle(100, 37, 218, 25));
		
		label1 = new Label(group, SWT.NONE);
		label1.setText("Location:");
		label1.setBounds(new Rectangle(9, 81, 79, 17));
		text1 = new Text(group, SWT.BORDER);
		text1.setBounds(new Rectangle(100, 73, 218, 25));
		text1.setEnabled(true);
		
		button = new Button(group, SWT.NONE);
		button.setText("Browse");
		button.setBounds(new Rectangle(327, 73, 55, 25));
		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() 
		{
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) 
			{
				//按钮事件,当选中按钮式出现目录页面dd，去选择存放文件的地方
				DirectoryDialog dd = new DirectoryDialog(sShell);
				dd.setFilterPath(text1.getText());//打开的面板要记录选择的路径，传给Text1
				dd.setMessage("Please choose a directory for the project contents");
				dd.open();
				text1.setText(dd.getFilterPath());				
			}
		});
	}

}
