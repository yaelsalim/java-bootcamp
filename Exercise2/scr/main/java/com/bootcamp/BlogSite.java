package com.bootcamp;

import java.util.ArrayList;

/**
 * This class represents a blog site.
 * 
 * @author Yael Salim
 *
 */
public class BlogSite {

	public static final int MAX_ENTRIES = 10;
	private String blogName;
	private String blogUrl;
	private String blogOwner;
	private FakeEntryRepository blogEntries;

	public BlogSite(String blogName, String blogUrl, String blogOwner) {

		this.blogName = blogName;
		this.blogUrl = blogUrl;
		this.blogOwner = blogOwner;
		this.blogEntries = new FakeEntryRepository();

	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogUrl() {
		return blogUrl;
	}

	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}

	public void setBlogEntries(FakeEntryRepository blogEntries) {
		this.blogEntries = blogEntries;
	}

	public ArrayList<String> getBlogEntries() {
		return blogEntries.getEntries();
	}

	public String getBlogOwner() {
		return blogOwner;
	}

	public void setBlogOwner(String blogOwner) {
		this.blogOwner = blogOwner;
	}

	public void addBlogEntries(String title, String text) {
		blogEntries.save(title, text);
	}

	public void deleteEntry(String title) {
		blogEntries.delete(title);
	}

	public ArrayList<String> getMostRecentEntries() {

		if (blogEntries.getEntriesAmount() <= MAX_ENTRIES) {
			return blogEntries.getEntries();
		} else {
			ArrayList<String> recentEntries = new ArrayList<String>();
			recentEntries.addAll(blogEntries.getEntries().subList(blogEntries.getEntries().size() - MAX_ENTRIES,
					blogEntries.getEntries().size()));
			return recentEntries;
		}
	}
}
