package br.org.cesar.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.org.cesar.common.SimplifiedCalculatorPage;

@RunWith(Parameterized.class)
public class CalculatorValidation extends BaseTestcase{
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
	public CalculatorValidation(String num1, String function, String num2,
			String answer) {
		this.number1 = num1;
		this.function = function;
		this.number2 = num2;
		this.answer = answer;
	}

	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { "1", "plus", "1", "2" },
				{ "2", "times", "2", "4" }, { "5", "divide", "2", "2.5" },
				{ "10", "minus", "4", "6" }});
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
	
	
}
