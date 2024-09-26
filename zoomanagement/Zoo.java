package zoomanagement;

import java.util.List;
import java.util.ArrayList;

/**
 * This class serves as Implementation class for this Package
 * 
 * @author Pranshu Ambwani
 *
 */
public class Zoo {
	public static List<Zone> zoneList = new ArrayList<>();
	public static List<Cage> cageList = new ArrayList<>();
	public static List<Animal> animalList = new ArrayList<>();

	/**
	 * Adds Zone in Zoo
	 * 
	 * @param maxNoOfCages
	 * @param categoryOfAnimal
	 * @param hasCanteen
	 * @param hasPark
	 * @return
	 */
	boolean addZone(int maxNoOfCages, AnimalCategory categoryOfAnimal, boolean hasCanteen, boolean hasPark) throws AssertionError{
		if (categoryOfAnimal == null) {
			throw new AssertionError("Category Of Animal in Zone Can't be Null");
		}
		Zone newZone = new Zone(maxNoOfCages, categoryOfAnimal, hasCanteen, hasPark);
		zoneList.add(newZone);
		return true;
	}

	/**
	 * Adds Cage in the given Zone if Space is Available
	 * 
	 * @param typeOfAnimal
	 * @param zoneNo
	 * @param maxNoOfAnimals
	 * @return
	 * @throws ZooException
	 */
	boolean addCage(AnimalType typeOfAnimal, int zoneNo, int maxNoOfAnimals) throws AssertionError {
		if (typeOfAnimal == null) {
			throw new AssertionError("Category Of Animal in Cage Can't be Null");
		}
		
		int noOfCages = 0;
		for (int i = 0; i < cageList.size(); i++) {
			if (cageList.get(i).getZoneNo() == zoneNo) {
				noOfCages++;
			}
		}

		Cage newCage = new Cage(0, typeOfAnimal, zoneNo, maxNoOfAnimals);
		cageList.add(newCage);
		return true;
	}

	/**
	 * Adds Animal to given CageNo
	 * 
	 * @param animalName
	 * @param typeOfAnimal
	 * @param ageOfAnimal
	 * @param weightOfAnimal
	 * @param cageNo
	 * @return
	 * @throws ZooException
	 */
	boolean addAnimal(String animalName, AnimalType typeOfAnimal, int ageOfAnimal, double weightOfAnimal, int cageNo)
			throws AssertionError {
		if (animalName.length() == 0 || typeOfAnimal == null) {
			throw new AssertionError("Category Of Animal or Name of Animal Can't be Null or Zero");
		}
		for (int loop = 0; loop < animalList.size(); loop++) {
			if (animalList.get(loop).getAnimalName() == animalName) {
				throw new AssertionError("Animal Name should be Unique");
			}
		}
		/*
		 * Adding Animal in List and increasing NoOfAnimals in Cage
		 */
		int noOfAnimalsInCage = cageList.get(cageNo - 1).getNoOfAnimals();
		switch (typeOfAnimal) {
		case Lion:
			animalList.add(new Lion(animalName, ageOfAnimal, weightOfAnimal, cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;

		case Parrot:
			animalList.add(new Parrot(animalName, ageOfAnimal, weightOfAnimal, cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;

		case Snake:
			animalList.add(new Snake(animalName, ageOfAnimal, weightOfAnimal, cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;
		}
		return true;
	}

	/**
	 * Removes Animal after its Death
	 * 
	 * @param animalName
	 */
	void deathOfAnimal(String animalName) throws AssertionError {
		if (animalName == null || animalName.length() == 0) {
			throw new AssertionError("Name of Animal Can't be Null or Zero");
		}
		int cageNo;
		for (int loop = 0; loop < animalList.size(); loop++) {
			if (animalList.get(loop).getAnimalName().equals(animalName)) {
				cageNo = animalList.get(loop).getCageNo();
				animalList.remove(loop);
			}
		}
		
	}

	
	}
