package com.bootcamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FileListTest {

	@Test
	public void whenListIsEmptyAtAppStartup() {

		FileList recentFiles = new FileList();

		assertEquals(0, recentFiles.getRecentFiles().size());
	}

	@Test
	public void whenAFileIsOpened() {

		FileList recentFiles = new FileList();

		recentFiles.add("File1");

		assertTrue(recentFiles.getRecentFiles().contains("File1"));
	}

	@Test
	public void whenAFileIsAlreadyOpened() {

		FileList recentFiles = new FileList();

		recentFiles.add("File1");

		recentFiles.add("File2");

		recentFiles.add("File3");

		recentFiles.add("File2");

		assertEquals("[File1, File3, File2]", recentFiles.getRecentFiles().toString());

	}

	@Test
	public void whenListIsFull() {

		FileList recentFiles = new FileList();

		recentFiles.add("File1");
		recentFiles.add("File2");
		recentFiles.add("File3");
		recentFiles.add("File4");
		recentFiles.add("File5");
		recentFiles.add("File6");
		recentFiles.add("File7");
		recentFiles.add("File8");
		recentFiles.add("File9");
		recentFiles.add("File10");
		recentFiles.add("File11");
		recentFiles.add("File12");
		recentFiles.add("File13");
		recentFiles.add("File14");
		recentFiles.add("File15");
		recentFiles.add("File16");

		assertEquals(FileList.MAX_FILES, recentFiles.getRecentFiles().size());

		assertFalse(recentFiles.getRecentFiles().contains("File1"));
	}
}
