package cn.alittler.study.java.string;

import org.junit.Test;

import cn.alittler.study.java.string.StringUtils;

public class StringUtilsTests {

	// StringUtils stringUtils = new StringUtils();

	@Test
	public void test1() {
		System.out.println(StringUtils.random(8));
		System.out.println(StringUtils.randomNum(8));
		System.out.println(StringUtils.randomStr(8));
		System.out.println(StringUtils.randomString(8));
	}

}
