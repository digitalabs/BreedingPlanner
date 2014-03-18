package com.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.DialogSettings;

public class InputInfoMangMAS {

	private static String[] names = { "country", "researcher", "crop species", "expected seeds per plant", 
		    "length of each season (months)", "seasons per year",
		    "1st season starts in", "2nd season starts in", "3rd season starts in",
			"parental generation starts in", "Growing condition",
			"Number of unlinked genes to be combined",
			"Favorable gene at Locus1", "Favorable gene at Locus2",
			"Favorable gene at Locus3", "Favorable gene at Locus4",
			"Favorable gene at Locus5", "Favorable gene at Locus6",
			"Favorable gene at Locus7", "Favorable gene at Locus8",
			"Favorable gene at Locus9", "Favorable gene at Locus10"};
	private String filePathAndName = null;
	
	public static String[] getNames() {
		return names;
	}

	public InputInfoMangMAS(String filePathAndName) {
		this.filePathAndName = filePathAndName;
	}

	public List<InputInfoItem> createList() {
		List<InputInfoItem> inputInfoList = new ArrayList<InputInfoItem>();
		DialogSettings settings = new DialogSettings("input");
		try {
			settings.load(filePathAndName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < names.length; i++) {
			InputInfoItem item = new InputInfoItem();
			item.setId(String.valueOf(i));
			item.setName(names[i]);
			item.setValue(settings.get(names[i]));
			inputInfoList.add(item);
		}
		return inputInfoList;
	}
	
	public void modifyAll(List<InputInfoItem> inputInfoList){
		DialogSettings settings = new DialogSettings("input");
		try {
			settings.load(filePathAndName);
			for(int i = 0 ; i < names.length ; i ++){
				settings.put(names[i], inputInfoList.get(i).getValue());
			}
			settings.save(filePathAndName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
