package com.bootcamp;

import java.util.ArrayList;

/**
 * This is an in-memory implementation of a repository. Since, it will not
 * access a database, a collection is used to store data.
 * 
 * @author Yael Salim
 *
 */
public class FakeEntryRepository {

	private ArrayList<String> entries;

	public FakeEntryRepository() {
		this.entries = new ArrayList<String>();
	}

	public void save(String title, String text) {
		this.entries.add(title);
	}

	public void delete(String title) {
		this.entries.remove(title);
	}

	public int getEntriesAmount() {
		return entries.size();
	}

	public ArrayList<String> getEntries() {
		return entries;
	}

}
