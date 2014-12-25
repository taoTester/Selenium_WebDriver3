package automationFrameWork;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import appModule.SingIn_Action;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtilities;
import utility.Log;
import pageObjects.LogIn_Page;

public class POM_TC1 {
	
	public WebDriver wDriver=null;
    String baseURL="http://store.demoqa.com";
    
    
//	File screenFile = ((TakesScreenshot)wDriver).getScreenshotAs(OutputType.FILE);
// 	FileUtils.copyFile(screenFile, new File("D:/Junit/logout2.jpg"));

	@Before
	public void setUp(){
		
		wDriver = new FirefoxDriver();
		
	}
	
	@After
	public void tearDown(){
		
		Log.endTestCase("testPOM3");
		wDriver.quit();
		
	}
	
	//Basic Test，only use the project object method 
	@Ignore
	@Test
	public void testPOM() throws Exception{
		
		wDriver.get(baseURL);
		
		Home_Page.linkToLogIn(wDriver).click();
		LogIn_Page.inPutUser(wDriver).sendKeys("taoTester");
		LogIn_Page.inPutPassword(wDriver).sendKeys("g9b4bdxWeZAr");
		LogIn_Page.logInButton(wDriver).click();
		
		wDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Home_Page.logOutHome(wDriver).click();
		System.out.println(wDriver.getTitle());
		Assert.assertEquals("http://store.demoqa.com/products-page/your-account/?login=1",wDriver.getCurrentUrl());
	}
	
	//将数据进行常量的封装，用static final 类型 实现直接调用数据
	@Ignore
	@Test
	public void testPOM2() throws Exception{
		
		wDriver.get(Constant.BASEURL);
		
		SingIn_Action.ConstantLogIn(wDriver,Constant.USERNAME,Constant.PASSWORD);
		
		wDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Home_Page.logOutHome(wDriver).click();
		System.out.println(wDriver.getTitle());
		Assert.assertEquals("http://store.demoqa.com/products-page/your-account/?login=1",wDriver.getCurrentUrl());
		
	}
	
	//将数据存放在Excel中，实现测试数据与Script的分离
	@Test
	public void testPOM3(){
		
		
		Log.logInfo("开始设置Excel路径信息");
		ExcelUtilities.setExcelFile(Constant.EXCELPATH+Constant.EXCELFILE, "test1");
		
		Log.startTestCase("testPOM3");
		wDriver.get(Constant.BASEURL);
		wDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		SingIn_Action.ExcelLogIn(wDriver);
		
		System.out.println("log in successully");

		Home_Page.logOutHome(wDriver);
		
		System.out.println(wDriver.getTitle());
		Assert.assertEquals("http://store.demoqa.com/products-page/your-account/?login=1",wDriver.getCurrentUrl());
		
		ExcelUtilities.setCellData("pass", 1, 3);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
