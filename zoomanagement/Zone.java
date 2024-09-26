package zoomanagement;

/**
 * This class creates a New Zone
 *
 */
public class Zone {
	final int maxNoOfCages;
	final AnimalCategory categoryOfAnimal;
	boolean hasCanteen;
	boolean hasPark;

	public Zone(int maxNoOfCages, AnimalCategory categoryOfAnimal, boolean hasCanteen, boolean hasPark) {
		this.maxNoOfCages = maxNoOfCages;
		this.categoryOfAnimal = categoryOfAnimal;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}

	public AnimalCategory getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	public int getMaxNoOfCages() {
		return maxNoOfCages;
	}

	/**
	 * Returns the Total No of Animals in Zone
	 * 
	 * @param zoneNo
	 * @return
	 */
	int getInfo(int zoneNo) {
		int totalNoOfAnimals = 0;
		for (int loop = 0; loop < Zoo.cageList.size(); loop++) {
			if (zoneNo == Zoo.cageList.get(loop).getZoneNo()) {
				totalNoOfAnimals += Zoo.cageList.get(loop).getNoOfAnimals();
			}
		}
		return totalNoOfAnimals;
	}

}