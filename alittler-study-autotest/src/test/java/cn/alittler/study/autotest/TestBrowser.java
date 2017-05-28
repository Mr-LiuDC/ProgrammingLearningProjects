package cn.alittler.study.autotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBrowser {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./chrome/chromedriver.exe");
		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
	}

	public static void testBrowser(WebDriver driver) throws Exception {
		driver.get("http://www.cnblogs.com/tankxiao");
		Thread.sleep(5000);
		// 浏览器最大化
		driver.manage().window().maximize();

		driver.navigate().to("https://www.baidu.com");
		// 刷新浏览器
		driver.navigate().refresh();
		// 浏览器后退
		driver.navigate().back();
		// 浏览器前进
		driver.navigate().forward();
		// 浏览器退出
		driver.quit();
	}
}
