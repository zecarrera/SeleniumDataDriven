package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/*
 * Executa todas as acoes na pagina Inicial
 */
public class SimplifiedCalculatorPage {

	/*
	 * Instancia privada do webDriver que vira da suite de teste
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/*
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	static By firstInputLocator = By.id("number1");
	static By secondInputLocator = By.id("number2");
	static By operationLocator = By.id("function");
	static By calculateButtonLocator = By.id("calculate");
	static By answerLocator = By.id("answer");
		
	public SimplifiedCalculatorPage() {
	}

	/**
	 * Enters input of first text field for calculator
	 */
	public static void enterFirstInput(String input1){
		driver.findElement(firstInputLocator).clear();
		driver.findElement(firstInputLocator).sendKeys(input1);
	}	
	
	
	/**
	 * Enters input of second text field for calculator
	 */
	public static void enterSecondInput(String input2){
		driver.findElement(secondInputLocator).clear();
		driver.findElement(secondInputLocator).sendKeys(input2);
	}
	
	/**
	 * Selects operation
	 */
	public static void selectOperation(String operation){
		new Select(driver.findElement(operationLocator)).selectByValue(operation);
	}
	
	
	/**
	 * Submit calculation
	 */
	public static void calculate(){
		driver.findElement(calculateButtonLocator).click();
	}
	
	/**
	 * Checks if answer is the one expected
	 */
	public static void assertCalculationResult(String correctResult){
		wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
		Assert.assertEquals(correctResult, driver.findElement(answerLocator).getText());
	}
	

}