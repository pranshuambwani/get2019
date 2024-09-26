package zoomanagement;

/**
 * This is a SubClass of Animal, this class Specifies the Category of Animal
 * i.e., Bird
 *
 */
public class Bird extends Animal {
	final AnimalCategory categoryOfAnimal = AnimalCategory.Bird;

	@Override
	public AnimalCategory getCategoryOfAnimal() {
		return categoryOfAnimal;
	}
}

/**
 * This is a SubClass of Bird, this Specifies the Type of Animal i.e., Parrot
 *
 */
class Parrot extends Bird {
	final String animalName;
	final String soundOfAnimal = "Sqauwk";

	Parrot(String animalName, int ageOfAnimal, double weightOfAnimal, int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}
