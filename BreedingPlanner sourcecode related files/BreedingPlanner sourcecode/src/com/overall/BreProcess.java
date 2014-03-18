package com.overall;

import java.io.File;

//Breeding Process(MARS/MAS/MABC)
public class BreProcess 
{
	private static float totalSeason = 0 ;
	private static String XMLPathAndName = null;
	private static String XMLName = null;
	private static String PNGName = null;
	private static String path = null;
	
	public static float getTotalSeason() {
		return totalSeason;
	}
	public static void setTotalSeason(float totalSeason) 
	{
		BreProcess.totalSeason = totalSeason;
	}
	public static String getXMLPathAndName() 
	{
		return XMLPathAndName;
	}
	public static void setXMLPathAndName(String xMLPathAndName) {
		XMLPathAndName = xMLPathAndName;
	}
	
	public static String getXMLName() {
		File file = new File(XMLPathAndName);
		return file.getName();
	}
	public static String getPNGName() {
		return getXMLName().split("\\.")[0] + ".png";
	}
	public static String getTXTName() {
		return getXMLName().split("\\.")[0] + ".txt";
	}
	
	public static String getPath() 
	{
		File file = new File(XMLPathAndName);
		return file.getParentFile().getAbsolutePath();
	}
	

}
