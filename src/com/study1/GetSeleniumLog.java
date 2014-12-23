package com.study1;


//我们除了可以使用Log4j来实现日志的记录以外，为了更清晰的Debug咱们的程序，我们还可以通过Selenium WebDriver本身的接口来实现相关的操作，
//1. 首先我们实现WebDriverEventListener这个接口（根据实际需求，实现相关的方法），
//2. EventFiringWebDriver eDriver = new EventFiringWebDriver(wDriver);
//3. GetSeleniumLog getSeleniumLog = new GetSeleniumLog();
//4. eDriver.register(getSeleniumLog);
//register这个方法将让你实现WebDriverEventLister这个方法来实现监听WebDriver的事件，
//unresgiter这个方法将解除监听

//输出结果为：
//After Find ByBy.id: su
//After Click On[[FirefoxDriver: firefox on WINDOWS (34ab99f6-79ab-4ac4-ab00-4f7b14c7a582)] -> id: su]
//After Find ByBy.id: kw
//After Change Value of[[FirefoxDriver: firefox on WINDOWS (34ab99f6-79ab-4ac4-ab00-4f7b14c7a582)] -> id: kw]
//Before Execute Scriptdocument.documentElement.scrollTop=10
//After Execute Jave Scriptdocument.documentElement.scrollTop=10

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class GetSeleniumLog implements WebDriverEventListener{
	
	
	public static void main(String[] args) {
		
		WebDriver wDriver = new FirefoxDriver();
		
		String baseURL= "http://www.baidu.com";
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(wDriver);
		GetSeleniumLog getSeleniumLog = new GetSeleniumLog();
		eDriver.register(getSeleniumLog);
		
		eDriver.get(baseURL);
		eDriver.findElement(By.id("su")).click();
		eDriver.findElement(By.id("kw")).sendKeys("test");
		((JavascriptExecutor)eDriver).executeScript("document.documentElement.scrollTop="+10);
		eDriver.quit();

	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		System.out.println("After Change Value of"+ arg0.toString());
		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("After Click On"+arg0.toString());
		
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("After Find By"+arg0.toString());
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("after navigate Back"+arg0.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("after Navigate Forward"+arg0.getTitle());
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		System.out.println("After Execute Jave Script"+arg0);
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		System.out.println("Before Execute Script"+arg0);
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
