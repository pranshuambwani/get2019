package zoomanagement;

/**
 * This class is SuperClass for all Animals in Zoo
 *
 */
public class Animal {
	public String animalName;
	public int ageOfAnimal;
	public double weightOfAnimal;
	public String soundOfAnimal;
	public AnimalCategory categoryOfAnimal;
	public int cageNo;

	public int getAgeOfAnimal() {
		return ageOfAnimal;
	}

	public String getAnimalName() {
		return animalName;
	}

	public AnimalCategory getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	public String getSoundOfAnimal() {
		return soundOfAnimal;
	}

	public double getWeightOfAnimal() {
		return weightOfAnimal;
	}

	public int getCageNo() {
		return cageNo;
	}

	public void setCageNo(int cageNo) {
		this.cageNo = cageNo;
	}
}

enum AnimalCategory {
	Mammal, Reptile, Bird;
}

enum AnimalType {
	Peacook, Parrot, Raven, Lion, Deer, Zebra, Snake, Alligator;
}