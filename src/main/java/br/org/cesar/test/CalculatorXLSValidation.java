package br.org.cesar.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.org.cesar.common.SimplifiedCalculatorPage;
import br.org.cesar.util.SpreadsheetData;

@RunWith(Parameterized.class)
public class CalculatorXLSValidation extends BaseTestcase{
	/**
	 * Example app is Selenium Simplified book given example
	 * Tests for calculation example
	 */

	private Double number1;
	private String function;
	private Double number2;
	private Double answer;
	
	/**
	 * Class constructor
	 * @param num1
	 * @param function
	 * @param num2
	 * @param answer
	 */
	public CalculatorXLSValidation(Double num1, String function, Double num2,
			Double answer) {
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
		SimplifiedCalculatorPage.enterFirstInput(String.valueOf(this.number1.intValue()));
		SimplifiedCalculatorPage.enterSecondInput(String.valueOf(this.number2.intValue()));
		SimplifiedCalculatorPage.selectOperation(this.function);
		SimplifiedCalculatorPage.calculate();
		
		SimplifiedCalculatorPage.assertCalculationResult(String.valueOf(this.answer.intValue()));
	}
	
	@Parameters
    public static Collection spreadsheetData() throws IOException {
        InputStream spreadsheet = new FileInputStream("src\\main\\resources\\calculate2numbers.xls");
        return new SpreadsheetData(spreadsheet).getData();
    }
}
