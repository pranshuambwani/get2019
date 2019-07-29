package zoomanagement;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 * This class performs various TestCases for methods in ZooClass
 * 
 * @author Pranshu Ambwani
 *
 */
public class ZooTest {

	@Test
	public void addZoneTest() {
		assertTrue(new Zoo().addZone(10, AnimalCategory.Mammal, true, true));
	}

	@Test
	public void addCageTest() throws AssertionError {
		assertTrue(new Zoo().addCage(AnimalType.Zebra, 1, 5));
	}

	@Test
	public void addAnimalTest() throws AssertionError {
		assertTrue(new Zoo().addAnimal("Parrot-4", AnimalType.Parrot, 2, 8, 3));
	}


	@Test
	public void addCageInFullZone() {
		try {
			new Zoo().addCage(AnimalType.Alligator, 3, 5);
		} catch (AssertionError ae) {
			assertEquals("Zone is Full");
		}
	}

}