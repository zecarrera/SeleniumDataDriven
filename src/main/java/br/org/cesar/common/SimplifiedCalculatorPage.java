package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/*
 * Classe de P�gina para a aplica��o exemplo (calculadora), disponibilizando as a��es dispon�veis.
 * Aplica��o examplo � disponibilizada pelo livro- Selenium Simplified book
 */
public class SimplifiedCalculatorPage {

	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/*
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	/**
	 * Locators utilizados na p�gina
	 */
	static By firstInputLocator = By.id("number1");
	static By secondInputLocator = By.id("number2");
	static By operationLocator = By.id("function");
	static By calculateButtonLocator = By.id("calculate");
	static By answerLocator = By.id("answer");
		
	public SimplifiedCalculatorPage() {
	}

	/**
	 * Insere o primeiro input para c�lculo
	 */
	public static void enterFirstInput(String input1){
		driver.findElement(firstInputLocator).clear();
		driver.findElement(firstInputLocator).sendKeys(input1);
	}	
	
	
	/**
	 * Insere o segundo input para c�lculo
	 */
	public static void enterSecondInput(String input2){
		driver.findElement(secondInputLocator).clear();
		driver.findElement(secondInputLocator).sendKeys(input2);
	}
	
	/**
	 * Seleciona a opera��o desejada
	 */
	public static void selectOperation(String operation){
		new Select(driver.findElement(operationLocator)).selectByValue(operation);
	}
	
	
	/**
	 * Submete opera��o para c�lculo
	 */
	public static void calculate(){
		driver.findElement(calculateButtonLocator).click();
	}
	
	/**
	 * Verifica se o resultado exibido � o adequado
	 */
	public static void assertCalculationResult(String correctResult){
		wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
		Assert.assertEquals(correctResult, driver.findElement(answerLocator).getText());
	}
	

}