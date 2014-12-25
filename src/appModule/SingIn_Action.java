package appModule;

import org.openqa.selenium.WebDriver;

import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.ExcelUtilities;
import utility.Log;

public class SingIn_Action {

	public static void ConstantLogIn(WebDriver driver,String userName,String passWord){
		
		Home_Page.linkToLogIn(driver).click();
		LogIn_Page.inPutUser(driver).sendKeys(userName);
		LogIn_Page.inPutPassword(driver).sendKeys(passWord);
		LogIn_Page.logInButton(driver).click();
		
	}
	
	public static void ExcelLogIn(WebDriver driver2){
		
		String userName2=ExcelUtilities.getCellData(1, 1);
		String passWord2=ExcelUtilities.getCellData(1, 2);
		Log.logInfo("准备点击登录按钮");
		Home_Page.linkToLogIn(driver2).click();
		Log.logInfo("准备输入用户名");
		LogIn_Page.inPutUser(driver2).sendKeys(userName2);
		Log.logInfo("准备输入密码");
		LogIn_Page.inPutPassword(driver2).sendKeys(passWord2);
		Log.logInfo("准备点击登录按钮");
		LogIn_Page.logInButton(driver2).click();
		
	}
	
}