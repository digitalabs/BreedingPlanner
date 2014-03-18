package com.overall;

import org.eclipse.swt.custom.CTabFolder;

import com.gui.BottomComposite;
import com.gui.BottomCompositeMABC;
import com.gui.BottomCompositeMAS;
import com.gui.MainShell;
import com.gui.RightComposite;
import com.gui.RightCompositeMABC;
import com.gui.RightCompositeMAS;
import com.gui.MiddleComposite;

public class Validate {
	//检测是否为整数
	public static boolean validateInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	//检测是否为MiddleComposite
	public static boolean validateMiddleComposite(CTabFolder cTabFolder){
		try
		{
			MiddleComposite wic = (MiddleComposite)cTabFolder.getItem(0).getControl();
		} catch (Exception e)
		{
			return false;
		}
		return true;
	}
	//检测是否为RightComposite
	public static boolean validateRightComposite(CTabFolder cTabFolder){
		try{
			RightComposite wic = (RightComposite)cTabFolder.getItem(0).getControl();
		} catch (Exception e)
		{
			return false;
		}
		return true;
	}
	//检测是否为RightCompositeMABC
	public static boolean validateRightCompositeMABC(CTabFolder cTabFolder){
		try{
			RightCompositeMABC wic = (RightCompositeMABC)cTabFolder.getItem(0).getControl();
		} catch (Exception e)
		{
			return false;
		}
		return true;
	}
	//检测是否为RightCompositeMAS
	public static boolean validateRightCompositeMAS(CTabFolder cTabFolder){
		try{
			RightCompositeMAS wic = (RightCompositeMAS)cTabFolder.getItem(0).getControl();
		} catch (Exception e)
		{
			return false;
		}
		return true;
	}
	//检测是否为BottomComposite
	public static boolean validateBottomComposite(CTabFolder cTabFolder){
		try{
			BottomComposite bc = (BottomComposite)cTabFolder.getItem(0).getControl();
		} catch (Exception e)
		{
			return false;
		}
		return true;
	}
	//检测是否为BottomCompositeMABC
	public static boolean validateBottomCompositeMABC(CTabFolder cTabFolder){
		try{
			BottomCompositeMABC bc = (BottomCompositeMABC)cTabFolder.getItem(0).getControl();
		} catch (Exception e)
		{
			return false;
		}
		return true;
	}
	//检测是否为BottomCompositeMAS
	public static boolean validateBottomCompositeMAS(CTabFolder cTabFolder){
		try{
			BottomCompositeMAS bc = (BottomCompositeMAS)cTabFolder.getItem(0).getControl();
		} catch (Exception e)
		{
			return false;
		}
		return true;
	}

}
