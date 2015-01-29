package entities.intelligence;

import static org.junit.Assert.*;

import org.junit.Test;


public class FillUpDataBaseTest {

	@Test
	public void testGetNumberOfOffenderVariables() {
		FillUpDataBase fudb = new FillUpDataBase();
		int numberOfOffenderVariables;

		for (int i = 0; i < 100000; i++) {
			numberOfOffenderVariables = fudb.getNumberOfOffenderVariables();
			assertTrue(numberOfOffenderVariables > 0 && numberOfOffenderVariables <= 3);
		}
	}



	@Test
	public void testGetRandomOffenderVariable() {
		FillUpDataBase fudb = new FillUpDataBase();
		int randomOffenderVariable;

		for (int i = 0; i < 100000; i++) {
			randomOffenderVariable = fudb.getRandomOffenderVariable();
			assertTrue(randomOffenderVariable > 0 && randomOffenderVariable <= 21);
		}
	}
}
