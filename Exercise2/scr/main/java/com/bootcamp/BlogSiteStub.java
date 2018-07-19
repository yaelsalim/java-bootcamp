package com.bootcamp;

import java.util.ArrayList;

/**
 * This is a stub that holds predefined data for testing.
 * 
 * @author Yael Salim
 *
 */

public class BlogSiteStub extends BlogSite {

	private ArrayList<String> mostRecentPosts;

	public BlogSiteStub(String blogName, String blogUrl, String blogOwner) {
		super(blogName, blogUrl, blogOwner);
		mostRecentPosts = new ArrayList<String>();
	}

	@Override
	public void addBlogEntries(String title, String text) {
		mostRecentPosts.add(title);
	}

	@Override
	public ArrayList<String> getMostRecentEntries() {
		return mostRecentPosts;
	}

}
