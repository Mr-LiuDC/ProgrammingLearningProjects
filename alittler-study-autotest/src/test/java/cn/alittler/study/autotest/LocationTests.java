package cn.alittler.study.autotest;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocationTests {
	
	/**
	 * 根据标签查找
	 */
	@Test
	public void test1() {
		System.setProperty("webdriver.gecko.driver", "./gecko/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");
		//driver.findElement(By.id("kw")).sendKeys("谷歌");
		//driver.findElement(By.name("wd")).sendKeys("刘德财");
		//driver.findElement(By.className("s_ipt")).sendKeys("Java开发");
		//driver.findElement(By.linkText("新闻")).click();
		driver.findElement(By.partialLinkText("新")).click();
		
		// 设置超时时间。
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// 为了看清效果等待几秒钟。
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	/**
	 * 根据Xpath查找
	 */
	
	@Test
	public void test2() {
		System.setProperty("webdriver.gecko.driver", "./gecko/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.imooc.com/search");
		driver.findElement(By.xpath(".//*[@id='main']/div/div[1]/div/input")).sendKeys("Java入门");
		driver.findElement(By.xpath(".//*[@id='main']/div/div[1]/div/span")).click();
		
		// 设置超时时间。
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// 为了看清效果等待几秒钟。
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}@Test
	public void test3() {
		System.setProperty("webdriver.gecko.driver", "./gecko/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.imooc.com/");
		driver.findElement(By.xpath(".//*[@id='nav']/div[3]/div[2]/input[1]")).sendKeys("Java入门");
		driver.findElement(By.xpath(".//*[@id='nav']/div[3]/div[3]/i")).click();
		
		// 设置超时时间。
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// 为了看清效果等待几秒钟。
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Test
	public void test4() {
		System.setProperty("webdriver.gecko.driver", "./gecko/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("Java开发");
		
		// 设置超时时间。
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// 为了看清效果等待几秒钟。
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
