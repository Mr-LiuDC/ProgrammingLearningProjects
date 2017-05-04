package cn.alittler.gradle.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cn.alittler.gradle.Library;

public class LibraryTest {
	@Test
	public void testSomeLibraryMethod() {
		Library classUnderTest = new Library();
		assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
	}
}
