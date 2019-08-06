package OrganicChemistry;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrganicChemistryTest {
	@Test
	public void checkForCorrectInputs() {
		String formula = "C(OH)";
		Integer expected = 29;
		assertEquals(expected, OrganicChemistry.caluclateMass(formula));
	}

	@Test
	public void checkForEmptyInputTest() {
		String formula = "";
		String expected = "String is empty";
		try {
			OrganicChemistry.caluclateMass(formula);
		} catch (Throwable ex) {
			assertEquals(expected, ex.getMessage());
		}
	}

	@Test
	public void checkForNullInputTest() {
		String formula = "";
		String expected = "String is empty";
		try {
			OrganicChemistry.caluclateMass(formula);
		} catch (Throwable ex) {
			assertEquals(expected, ex.getMessage());
		}
	}
}