package zoomanagement;

/**
 * This class creates a New Cage in provided ZoneNo
 *
 */
public class Cage {
	int noOfAnimals;
	final AnimalType typeOfAnimal;
	final int zoneNo;
	final int maxNoOfAnimals;

	public Cage(int noOfAnimals, AnimalType typeOfAnimal, int zoneNo, int maxNoOfAnimals) {
		this.noOfAnimals = noOfAnimals;
		this.typeOfAnimal = typeOfAnimal;
		this.zoneNo = zoneNo;
		this.maxNoOfAnimals = maxNoOfAnimals;
	}

	public void setNoOfAnimals(int noOfAnimals) {
		this.noOfAnimals = noOfAnimals;
	}

	public int getMaxNoOfAnimals() {
		return maxNoOfAnimals;
	}

	public int getNoOfAnimals() {
		return noOfAnimals;
	}

	public AnimalType getTypeOfAnimal() {
		return typeOfAnimal;
	}

	public int getZoneNo() {
		return zoneNo;
	}
}