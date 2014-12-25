package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Utils {
	
	static WebDriver driver = null;
	
	public static void openBrowser(int iTestCaseRow){
		
		String browserType = ExcelUtilities.getCellData(iTestCaseRow, Constant.Col_Browser);
		
		if(browserType.equals("FireFox")){
			
			driver = new FirefoxDriver();
			
			Log.logInfo("准备打开火狐浏览器");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			
		}else if (browserType.equals("IE")) {
			
			driver = new InternetExplorerDriver(); 
			Log.logInfo("准备打开IE浏览器");
			
		}else if (browserType.equals("HTMLUnit")) {
			
			driver = new HtmlUnitDriver();
			Log.logInfo("准备打开无界面浏览器");
			
		}else if (browserType.equals("Chrome")) {
			
			driver = new ChromeDriver();
			Log.logInfo("准备打开火谷歌览器");
			
		}else {
			
			Log.logError("没有找到合适的浏览器");
		}
		
		
	}

}
