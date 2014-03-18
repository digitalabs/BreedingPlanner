BreedingPlanner
-------------------------
This file is about the function of the BreedingPlanner, how to compile the sourcecode of the software, make a EXE file of BreedingPlanner through Eclipse, and build a project.

Function introduction
----------
The BreedingPlanner provide a user-friendly interface for creating£¬modifing and deleting breeding plan.
  1.  In the software, you can build a New Project firstly, then you can creat different breeding plan for different plants in the project.
  2.  After you creat a breeding plan, you also can modify the parameter or delete the plan.

Compile the sourcecode
---------------
The BreedingPlanner sourcecode and the referenced file have been packaged together.
If you want to compile the sourcecode, you should do the several steps as bellow:
  1.  Make sure you computer has a Java RunEnvironment. If not, you should download Java JDK and install it to your computer, then configure the environment variables of java.
  2.  Download Eclipse, open Eclipse and Import the BreedingPlanner sourcecode through "File-->Import-->import the Existing Projects into        Workspace".
  3.  Now£¬You can have a run of the program, but if you want see the interface directly, you should modify the referenced files path. Right click the       BreedingPlanner Project, choose the "Properties", then configure the "Java Build Path", modify the referenced file path to corresponding files(in       the package).  
       (1)  SWT(Standard Widget Toolkit) files, modify the path to the corresponding files in the package.
       (2)  "Referenced Libraries", you should modify the path of the referenced jar file "org.eclipse.ui.workbench_3.6.2.M20110210-1200.jar"to it`s path.

Run the software
----------
Run "MainShell.java", you will see the interface of BreedingPlanner, you can creat a New Project and make different breeding plan to test the software.

Debug the software
--------------
If you find there are some problems in the run of BreedingPlanner, you can exit it and have a Debug:
   1.  In the Eclipse,debug "MainShell.java", or press the button F11, to test some part of the code, or test the function of the software.
 
Make installation files
-----------
  1.  "File-->Export", Export all resources required to run an application into a JAR file on the local file system. 
  2.  Select a 'Java Application' launch configuration to use to create a runnable JAR.
  3.  Use exe4j to produce windows executables to start up BreedingPlanner Java applications(corresponding exe4j file in the package).
  4.  Use Inno Setup Compiler to produce a EXE file(corresponding Inno Setup file in the package), named "BreedingPlanner.exe".
   
Install BreedingPlanner
-------------------
BreedingPlanner is standalone application, only support window system, you can install it to your computer directly.
But before you run it, you also should make sure you computer has a Java RunEnvironment.

Make a Breeding plank
-------------------------
Creat breeding plan is very easy in the software:
  1.  "Project-->New Project", to build a new breeding project.
  2.  "Task-->New MARS/MABC/MAS" to creat a new breeding plan under the new project.
       In the interface of BreedingPlanner, you will see the parameters and the Breeding scheme of the correspond breeding plan.
  3.  "Task-->Modify parameters" to modify the parameters of the breeding plan.
  4.  "Task-->Make a Plan" to make a  stage plan.