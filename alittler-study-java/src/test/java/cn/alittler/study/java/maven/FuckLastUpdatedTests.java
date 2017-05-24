package cn.alittler.study.java.maven;

import java.util.Map;

import org.junit.Test;

public class FuckLastUpdatedTests {
	
	@Test
	public void test1() {
		String repositoryPath = "C:\\Users\\liude\\.m2\\repository";
		Map<Object, Object> results = FuckLastUpdated.findLastUpdated(repositoryPath );
		System.out.println(results);
		System.out.println(results.size());
	}

}
