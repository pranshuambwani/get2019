package zoomanagement;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
	private List<Zone> listOfZone = new ArrayList<Zone>();

	public Zone addZone(int limit, boolean canteen, boolean park,
			String zoneType) {
		Zone zone = new Zone(limit, canteen, park, zoneType);
		listOfZone.add(zone);
		return zone;
	}

	/**
	 * check for unique name of animal
	 * 
	 * @param aniObj
	 *            animal to be added to zoo.
	 * @return true if the name is unique, else false
	 */
	public boolean checkUnique(Animal aniObj) {
		for (int loop = 0; loop < listOfZone.size(); loop++) {
			if (listOfZone.get(loop).findName(aniObj.name)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * remove the animal from zoo
	 * 
	 * @param aniObj
	 * @return
	 */
	public boolean mustDie(String name) throws AssertionError{
		for (int loop = 0; loop < listOfZone.size(); loop++) {
			if (listOfZone.get(loop).kill(name)) {
				return true;
			}
		}
		throw new AssertionError("no animal with this name");
	}

	/*
	 * adding the animal to the available zone.
	 */
	public boolean addAnimalToZoo(Animal aniObj) throws AssertionError{
		if (listOfZone.isEmpty()) {
			throw new AssertionError("no zone in the zoo.");
		} else {

			if (checkUnique(aniObj)) {

				/*
				 * iterate through the zones and find the zone matching the
				 * animal category
				 */
				for (int loop = 0; loop < listOfZone.size(); loop++) {
					Zone zoneObj = listOfZone.get(loop);
					String animalCategoryInList = zoneObj.getZoneType();
					String animalCategoryInput = aniObj.getClass()
							.getSuperclass().getSimpleName();
					if (animalCategoryInList.equals(animalCategoryInput)) {
						if (zoneObj.addAnimalToZone(aniObj)) {
							return true;
						}
					}
				}
			} else {

				throw new AssertionError("Name must be unique");
			}
		}
		throw new AssertionError(
				"No Zone for this animal or Cage limit is reached, add new zone.");

	}

	public List getListOfZone() {
		return new ArrayList<Zone>(listOfZone);
	}

}