package br.org.cesar.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.org.cesar.test.CalculatorValidation;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
		CalculatorValidation.class,
	})
public class AllTests {

}
