package br.org.cesar.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;


import br.org.cesar.common.SimplifiedCalculatorPage;
import br.org.cesar.common.Property;
import br.org.cesar.common.Selenium;

public class BaseTestcase {
	protected static SimplifiedCalculatorPage homePage;
	protected static WebDriver driver;
	
	
	
	@BeforeClass
	public static void beforeClass() throws Exception {		
		driver = Selenium.getDriver();
		driver.navigate().to(Property.SITE_ADDRESS);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		driver.quit();
	}
}
