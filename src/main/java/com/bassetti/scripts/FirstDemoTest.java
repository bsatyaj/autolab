package com.bassetti.scripts;

import org.openqa.selenium.WebDriver;

import com.bassetti.pom.LandingPagePOM;
import com.bassetti.utils.Base;

public class FirstDemoTest {

	public static void main(String[] args) throws Exception {
		
		Base b = new Base();
		WebDriver driver = b.init();

		LandingPagePOM pagePOM = new LandingPagePOM(driver);
		pagePOM.closePopup();
		pagePOM.clickTreeMenuLinks("Input Forms>Simple Form Demo");
		pagePOM.fillSingleInputField("ANONYMOUS");
		pagePOM.clickShowMessage();
		
		
	}

}
