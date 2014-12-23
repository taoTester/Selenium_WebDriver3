package com.study1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;




//由于Selenium WebDriver是不能直接对Windows的窗口进行直接操作的，我们在执行一些case的过程中常常会遇到保存文件的case，
//由于Selenium WebDriver的局限性，
//我们并不能直接操作该对话框，我们不能把文件保存到自定义的路径下，但是AutoIt能够帮助我们实现这个功能，
//我们能够借助AutoIt这个工具能够直接操作Windows自带的对话框，
//AutoId的基本流程是：
//1. 利用AutoId Windows Info查找到相关元素
//2. 编写 AutoId的操作脚本
//3. 将相关脚本保存成.exe的文件
//4. 然后通过 Runtime.getRuntime().exec("the location of the .exe")；来执行相关脚本，
//以上步骤就能成功的在Selenium 脚本中通过 AutoId实现对Windows 对话框的操作

public class DownloadFile_AutoIt {
	static WebDriver wd = null;
	public static void main(String[] args) {
	
		String baseURL = "";
		wd = new FirefoxDriver();
	
		wd.get(baseURL);
		((JavascriptExecutor)wd).executeScript("document.getElementById");
	 
		
		

	}

	public WebElement getElementWait(final By by){
		
		WebElement element2 = null;
		boolean flag = new WebDriverWait(wd, 10).until(new ExpectedCondition<Boolean>() {
		
			public Boolean apply(WebDriver w2){
				
				return w2.findElement(by).isDisplayed();
			}
		
		});
		if(flag){
			
			element2=wd.findElement(by);
		}
		
		return element2;	
}
	
}
