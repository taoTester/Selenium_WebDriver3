package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  class Home_Page {
	

	
	public static WebElement linkToLogIn(WebDriver wd1){
		
		WebElement element = wd1.findElement(By.className("account_icon"));
		
		return element;
		
	}
	
	public static WebElement logOutHome(WebDriver wd2){
		
		WebElement element2 = wd2.findElement(By.id("account_logout"));
		
		return element2;
		
	}

}
