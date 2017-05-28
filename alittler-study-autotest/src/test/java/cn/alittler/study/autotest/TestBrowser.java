package cn.alittler.study.autotest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBrowser {

	@Test
	public void testChromeDriver() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
	}

	@Test
	public void testFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "./gecko/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com");
	}
	
	@Test
	public void test() throws Exception {
		System.setProperty("webdriver.gecko.driver", "./gecko/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./chrome/chromedriver.exe");
		testBrowser(new ChromeDriver());
		testBrowser(new FirefoxDriver());
	}

	public static void testBrowser(WebDriver driver) throws Exception {
		driver.get("http://www.cnblogs.com/tankxiao");
		Thread.sleep(500);
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
