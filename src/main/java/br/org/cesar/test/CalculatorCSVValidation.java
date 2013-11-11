package br.org.cesar.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.org.cesar.common.SimplifiedCalculatorPage;
/**
 * The test class has member variables that correspond to input values (numberOfTweets) and expected results (expectedFee). 
 * The @RunWith(Parameterzed.class) annotation gets JUnit to inject your test data into instances of your test class, via the constructor.
 * @author jcan
 *
 */
@RunWith(Parameterized.class)
public class CalculatorCSVValidation extends BaseTestcase{
	/**
	 * Example app is Selenium Simplified book given example
	 * Tests for calculation example
	 */

	private String number1;
	private String function;
	private String number2;
	private String answer;
	
	/**
	 * Class constructor
	 * @param num1
	 * @param function
	 * @param num2
	 * @param answer
	 */
	public CalculatorCSVValidation(String num1, String function, String num2,
			String answer) {
		this.number1 = num1;
		this.function = function;
		this.number2 = num2;
		this.answer = answer;
	}

	/**
	 *  Open home screen and verify page title 
	 */
	@Test
	public void assertCalculation() {
		SimplifiedCalculatorPage.enterFirstInput(this.number1);
		SimplifiedCalculatorPage.enterSecondInput(this.number2);
		SimplifiedCalculatorPage.selectOperation(this.function);
		SimplifiedCalculatorPage.calculate();
		SimplifiedCalculatorPage.assertCalculationResult(this.answer);
	}
	
	/**
	 * Dessa froma todos os testes da classe utilizam o construtor e consequentemente executam o numero de vezes dos itens
	 */
//	@Test
	public void simpleTest(){
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	
	/**
	 * The test data is provided by a method with the @Parameters annotation. 
	 * This method needs to return a collection of arrays, but beyond that you can implement it however you want. 
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	@Parameters
	public static Collection data() throws NumberFormatException, IOException {
		return readTabDelimFile("src\\main\\resources\\calculate2numbers.csv");
//		return readTabDelimFile("src\\main\\resources\\calculate2numbers.tab");
	}

	public static Collection<String[]> readTabDelimFile(String filename)
			throws NumberFormatException, IOException {
		ArrayList<String[]> lines = new ArrayList<String[]>();
		BufferedReader fh = new BufferedReader(new FileReader(filename));
		String s;
		while ((s = fh.readLine()) != null) {
			String f[] = s.split(",");
			lines.add(f);
		}
		fh.close();
		return lines;
	}
}
