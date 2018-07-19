package com.bootcamp;

import java.util.ArrayList;

public class FileList {

	public static final int MAX_FILES = 15;

	private ArrayList<String> recentFiles = null;
	
	public FileList(){
		recentFiles = new ArrayList<String>();
	}

	public void add(String txtFile) {

		if (recentFiles.contains(txtFile)) {

			recentFiles.remove(txtFile);

		}
		recentFiles.add(txtFile);

		if (recentFiles.size() > MAX_FILES) {

			recentFiles.remove(0);
		}
	}

	public ArrayList<String> getRecentFiles() {

		return recentFiles;
	}

	public Boolean isRecentFilesEmpty() {

		return recentFiles.isEmpty();
	}


}
