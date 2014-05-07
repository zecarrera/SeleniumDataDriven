package br.org.cesar.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.org.cesar.common.SimplifiedCalculatorPage;

/**
 * Classe de validação utilizando data driven, onde os dados estão definidos na própria classe.
 * @author jcan
 *
 */
@RunWith(Parameterized.class)
public class CalculatorValidation extends BaseTestcase{
	

	private String number1;
	private String function;
	private String number2;
	private String answer;
	
	/**
	 * Construtor da classe, com os parametros que serão inicializados
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

	/**
	 * Método que define os dados que serão utilizados durante a execução do teste
	 * @return
	 */
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { "1", "plus", "1", "2" },
				{ "2", "times", "2", "4" }, { "5", "divide", "2", "2.5" },
				{ "10", "minus", "4", "6" }});
	}

	/**
	 *  Teste exemplo, que insere os dados de entrada e verifica o resultado exibido, utilizando os dados fornecidos. 
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
	 * Teste abaixo está comentado, ao remover o comentário, podemos observar que todos os testes existentes
	 * utilizam o construtor e consequentemente executam o numero de vezes dos itens parametrizados
	 */
//	@Test
	public void simpleTest(){
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	
}
