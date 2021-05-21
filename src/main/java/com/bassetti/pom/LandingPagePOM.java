package com.bassetti.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPagePOM {
	
	private WebDriver driver;
	
	public LandingPagePOM(WebDriver driver) {
		this.driver = driver;
	}

	/***
	 * 
	 * @param name : "Input Forms>Input Form Submit>My link"
	 */
	public void clickTreeMenuLinks(String name) {
		
		String[] linkNames = name.split(">"); // {"Input Forms", "Input Form Submit"}
		
		for(String lnkName : linkNames) {
			
			WebElement elem = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='"+lnkName+"']"));
			highlighter(elem);
			elem.click();
			
		}
		
	}
	
	public void fillSingleInputField(String msg) {
		WebElement elem = driver.findElement(By.xpath("//input[@id='user-message']"));
		highlighter(elem);
		elem.sendKeys(msg);
	}
	
	public void clickShowMessage() {
		WebElement elem = driver.findElement(By.xpath("//button[text()='Show Message']"));
		highlighter(elem);
		elem.click();
	}
	
	public void highlighter(WebElement elem) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String script = "arguments[0].setAttribute('style','background: yellow; border: 2px solid red;')";
		
		js.executeScript(script, elem);
	}
	
	public void closePopup() {
		driver.findElement(By.id("at-cv-lightbox-close")).click();
	}
}
