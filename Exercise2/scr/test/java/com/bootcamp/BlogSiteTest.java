package com.bootcamp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * This testing class uses TDD techniques such as mocking, stubs and faking
 * 
 * @author Yael Salim
 *
 */

public class BlogSiteTest {

	private FakeEntryRepository blogEntriesMock;

	@Before
	public void setUp() throws Exception {
		blogEntriesMock = Mockito.mock(FakeEntryRepository.class);

	}

	@Test
	public void whenANewEntryIsPosted() {
		BlogSite blog = new BlogSite("blog", "bootcamp.com", "yael_salim");

		blog.addBlogEntries("title", "text");
		assertEquals(1, blog.getBlogEntries().size());
	}

	@Test
	public void whenANewEntryIsPostedVerifySavePointUsignAMockObject() {
		BlogSite blog = new BlogSite("blog", "bootcamp.com", "yael_salim");
		blog.setBlogEntries(blogEntriesMock);
		blog.addBlogEntries("title", "text");
		verify(blogEntriesMock).save("title", "text");
	}

	@Test
	public void whenAnEntryIsDeleted() {
		BlogSite blog = new BlogSite("blog", "bootcamp.com", "yael_salim");
		blog.addBlogEntries("title", "text");
		blog.deleteEntry("title");
		assertEquals(0, blog.getBlogEntries().size());
	}

	@Test
	public void whenMostRecentEntriesAreShown() {
		BlogSiteStub blog = new BlogSiteStub("blog", "bootcamp.com", "yael_salim");

		blog.addBlogEntries("title1", "text");
		blog.addBlogEntries("title2", "text");
		blog.addBlogEntries("title3", "text");
		blog.addBlogEntries("title4", "text");
		blog.addBlogEntries("title5", "text");
		blog.addBlogEntries("title6", "text");
		blog.addBlogEntries("title7", "text");
		blog.addBlogEntries("title8", "text");
		blog.addBlogEntries("title9", "text");
		blog.addBlogEntries("title10", "text");

		assertEquals(BlogSiteStub.MAX_ENTRIES, blog.getMostRecentEntries().size());

	}

}
