package cn.alittler.study.java.string;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * StringUtils 字符串工具类
 * 
 * @description:
 * @date: Created on 2017年5月24日
 * @author: Mr.LiuDC
 * @email: 1911939348@qq.com
 */
public class StringUtils {

	/**
	 * 利用a-z A-Z 0-9生成随机字符串。
	 * 
	 * @param length
	 * @return
	 */
	public static String randomString(int length) {
		String str = "qazwsxedcrfvtgbyhnujmikolpQAZWSXEDCRFVTGBYHNUJMIKOLP1234567890";
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(62);
			buffer.append(str.charAt(num));
		}
		return buffer.toString();
	}

	/**
	 * 利用 ThreadLocalRandom 生成随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String random(int length) {
		StringBuilder builder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			builder.append(ThreadLocalRandom.current().nextInt(33, 128));
		}
		return builder.toString();
	}

	/**
	 * 利用common-lang3 RandomStringUtils 生成随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String randomStr(int length) {
		return RandomStringUtils.random(length).toString();
	}

	/**
	 * 利用common-lang3 RandomStringUtils 生成随机数字字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String randomNum(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

}
