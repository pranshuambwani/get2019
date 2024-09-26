package zoomanagement;

/**
 * This is a SubClass of Animal, this class Specifies the Category of Animal
 * i.e., Mammal
 *
 */
public class Mammal extends Animal {
	final AnimalCategory categoryOfAnimal = AnimalCategory.Mammal;

	@Override
	public AnimalCategory getCategoryOfAnimal() {
		return categoryOfAnimal;
	}
}

/**
 * This is a SubClass of Mammal, this Specifies the Type of Animal i.e., Lion
 *
 */
class Lion extends Mammal {
	final String animalName;;
	final String soundOfAnimal = "Roars";

	Lion(String animalName, int ageOfAnimal, double weightOfAnimal, int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}