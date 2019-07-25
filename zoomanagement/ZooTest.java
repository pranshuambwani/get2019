package zoomanagement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class ZooTest {

	@Test
	public void zoneCreationTest() {
		Zoo zoo1 = new Zoo();
		zoo1.addZone(4, true, false, "Mammal");
		int expected = 1;
		assertEquals(expected, zoo1.getListOfZone().size());
	}

	@Test
	public void addNewAnimalTest() {
		Zoo zoo1 = new Zoo();
		zoo1.addZone(4, true, false, "Mammal");
		boolean expected = true;
		Animal lionObj = new Lion("Simba", 4, 100f);
		assertEquals(expected, zoo1.addAnimalToZoo(lionObj));
	}

	// adding two lions to a single cage
	@Test
	public void addNewAnimalToExistingCageTest() {
		Zoo zoo1 = new Zoo();
		zoo1.addZone(4, true, false, "Mammal");
		boolean expected = true;
		Animal lionObj = new Lion("Simba", 4, 100f);
		zoo1.addAnimalToZoo(lionObj);
		Animal lionObj1 = new Lion("Simba2", 4, 100f);
		assertEquals(expected, zoo1.addAnimalToZoo(lionObj1));
	}

	// adding 5 lions to the zoo
	@Test
	public void addNewAnimalsToExistingCageTest() {
		Zoo zoo1 = new Zoo();
		zoo1.addZone(3, true, false, "Mammal");
		boolean expected = true;
		Animal lionObj = new Lion("Simba", 4, 100f);
		Animal lionObj2 = new Lion("Simba2", 4, 100f);
		Animal lionObj3 = new Lion("Simba3", 4, 100f);
		Animal lionObj4 = new Lion("Simba4", 4, 100f);
		Animal lionObj5 = new Lion("Simba5", 4, 100f);
		zoo1.addAnimalToZoo(lionObj);
		zoo1.addAnimalToZoo(lionObj2);
		zoo1.addAnimalToZoo(lionObj3);
		zoo1.addAnimalToZoo(lionObj4);

		assertEquals(expected, zoo1.addAnimalToZoo(lionObj5));
	}

	// creating a new Zone for bird then adding Pigeon into it
	@Test
	public void addBird() {
		Zoo zoo1 = new Zoo();
		zoo1.addZone(1, false, true, "Birds");
		zoo1.addZone(3, false, true, "Mammal");
		zoo1.addZone(4, false, true, "Birds");
		List<Animal> lionList = new ArrayList<Animal>();
		StringBuilder nameLion = new StringBuilder("Simba");
		StringBuilder namePigeons = new StringBuilder("Kabootar");
		List<Animal> birdList = new ArrayList<Animal>();
		for (int loop = 0; loop < 5; loop++) {

			lionList.add(new Lion(nameLion.append(loop).toString(), loop, loop + 10f));
			birdList.add(new Pigeons(namePigeons.append(loop).toString(), loop, .25f));
			zoo1.addAnimalToZoo(lionList.get(loop));
			zoo1.addAnimalToZoo(birdList.get(loop));

		}
	}

	// there is no zone for lion and trying to add lion to zoo
	@Test(expected = AssertionError.class)
	public void addAnimalW_OZone() {
		Zoo zoo1 = new Zoo();
		int limitOfCage = 2;
		zoo1.addZone(limitOfCage, false, true, "Birds");
		Animal lionObj = new Lion("Pet", 2, 100f);
		zoo1.addAnimalToZoo(lionObj);
	}

	// cage limit reached
	@Test(expected = AssertionError.class)
	public void addMoreAnimals() {
		Zoo zoo1 = new Zoo();
		int limitOfCage = 3;
		zoo1.addZone(limitOfCage, true, true, "Mammal");
		List<Animal> lionList = new ArrayList<Animal>();
		for (int loop = 0; loop < 7; loop++) {
			lionList.add(new Lion("Simba", loop, loop + 10f));
			zoo1.addAnimalToZoo(lionList.get(loop));
		}

	}

	@Test
	public void killAnimal() {
		Zoo z1 = new Zoo();
		z1.addZone(3, true, true, "Reptile");
		Animal snakeObj = new Snake("Kaa", 12, 20f);
		z1.addAnimalToZoo(snakeObj);
		assertEquals(true, z1.mustDie("Kaa"));
	}

	// trying to kill an animal who is not in zoo
	@Test(expected = AssertionError.class)
	public void killRandom() {
		Zoo z1 = new Zoo();
		z1.addZone(3, true, true, "Reptile");
		Animal snakeObj = new Snake("hiss", 12, 20f);
		z1.addAnimalToZoo(snakeObj);
		assertEquals(true, z1.mustDie("Kaal"));
	}

	// adding kaa again after killing
	@Test
	public void addAgain() {
		Zoo z1 = new Zoo();
		z1.addZone(1, true, true, "Reptile");
		Animal snakeObj = new Snake("Kaa", 12, 20f);
		Animal snakeObj2 = new Snake("hiss Hiss", 12, 20f);
		Animal snakeObj3 = new Snake("Nag", 12, 20f);
		z1.addAnimalToZoo(snakeObj);
		z1.addAnimalToZoo(snakeObj2);
		z1.mustDie("Kaa");
		z1.addAnimalToZoo(snakeObj3);
		z1.addZone(2, false, false, "Reptile");
		z1.addAnimalToZoo(snakeObj);
	}

	@Test(expected = AssertionError.class)
	public void nullNameLion() {
		Animal lionObj = new Lion(null, 4, 4.5f);
	}

	@Test(expected = AssertionError.class)
	public void nullNamePigeon() {
		Animal pigeonsObj = new Pigeons(null, 4, 4.5f);
	}

	@Test(expected = AssertionError.class)
	public void nullNameSnake() {
		Animal snakeObj = new Snake(null, 4, 4.5f);
	}

}