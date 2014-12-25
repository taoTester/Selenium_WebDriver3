package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page {

	public static WebElement inPutUser(WebDriver wd1){
		
		WebElement element1 = wd1.findElement(By.id("log"));
		
		return element1;
	
	}
	
	public static WebElement inPutPassword(WebDriver wd2){
		
		WebElement  element2 = wd2.findElement(By.id("pwd"));
		
		return element2;
		
	}
	
	public static WebElement logInButton(WebDriver wd3){
		
		WebElement element3 = wd3.findElement(By.id("login"));
		
		return element3;
		
	}
}
