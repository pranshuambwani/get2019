package zoomanagement;

/**
 * This is a SubClass of Animal, this class Specifies the Category of Animal
 * i.e., Reptile
 *
 */
public class Reptile extends Animal {
	final AnimalCategory categoryOfAnimal = AnimalCategory.Reptile;

	@Override
	public AnimalCategory getCategoryOfAnimal() {
		return categoryOfAnimal;
	}
}

/**
 * This is a SubClass of Reptile, this Specifies the Type of Animal i.e., Snake
 *
 */
class Snake extends Reptile {
	final String animalName;
	final String soundOfAnimal = "Hiss";

	Snake(String animalName, int ageOfAnimal, double weightOfAnimal, int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}