package Cricket;

/**
 * Class contains methods to plan a strategy against Virat Kohli
 * 
 * @author Pranshu
 *
 */
public class BowlingStrategy {

	String[] sequenceOfBowlers;
	Bowler[] listOfBowlers;
	int numOfBowlers;
	int numOfBallsViratWillPlay;

	/**
	 * Constructor initializes instance variables
	 * 
	 * @param numOfBallsViratWillPlay
	 * @param numOfBowlers
	 */
	public BowlingStrategy(int numOfBallsViratWillPlay, int numOfBowlers) {
		sequenceOfBowlers = new String[numOfBallsViratWillPlay];
		listOfBowlers = new Bowler[numOfBowlers];
		this.numOfBallsViratWillPlay = numOfBallsViratWillPlay;
	}

	/**
	 * Adds a bowler to list of bowlers according to number of balls
	 * 
	 * @param name
	 * @param numOfBalls
	 */
	public void addBowler(String name, int numOfBalls) {
		Bowler bowler = new Bowler(name, numOfBalls);
		for (int count = 0; count < numOfBowlers; count++) {
			if (listOfBowlers[count].getNumOfBalls() < numOfBalls) {
				for (int count2 = count; count2 < numOfBowlers; count2++) {
					listOfBowlers[count2 + 1] = listOfBowlers[count2];
				}
				listOfBowlers[count] = bowler;
				numOfBowlers++;
				return;
			}
		}
		listOfBowlers[numOfBowlers] = bowler;
		numOfBowlers++;
	}

	/**
	 * Set sequence according to number of balls left
	 * 
	 * @return sequence of bowlers
	 */
	public String[] getSequence() {
		for (int count = 0; count < numOfBallsViratWillPlay; count++) {
			sequenceOfBowlers[count] = listOfBowlers[0].getName();
			listOfBowlers[0].decreaseNumOfBalls();
			sortByBallsLeft();
		}
		return sequenceOfBowlers;
	}

	/**
	 * Sorts bowlers according to number of balls left in descending order
	 */
	public void sortByBallsLeft() {
		for (int count = 0; count < listOfBowlers.length; count++) {
			for (int count2 = count; count2 < listOfBowlers.length; count2++) {
				if (listOfBowlers[count].getNumOfBalls() < listOfBowlers[count2].getNumOfBalls()) {
					Bowler temp = listOfBowlers[count];
					listOfBowlers[count] = listOfBowlers[count2];
					listOfBowlers[count2] = temp;
				}
			}
		}
	}

}