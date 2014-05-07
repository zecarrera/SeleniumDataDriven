package br.org.cesar.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.common.Selenium;

public abstract class Utils {	
	
	private static final WebDriver driver;
	private static final WebDriverWait wait;
	
	static{
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}

	public static void isVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void isVisible(String id) {
		isVisible(By.id(id));
	}
	
	public static void isLocated(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void isLocated(String id) {
		isLocated(By.id(id));
	}
	
	public static void isClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void isClickable(String id) {
		isClickable(By.id(id));
	}
	
	/**
	 * Pause for X milliseconds.
	 * 
	 * @param iTimeInMillis
	 */
	@Deprecated
	public static void wait(final int iTimeInMillis) {
		try {
			Thread.sleep(iTimeInMillis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
