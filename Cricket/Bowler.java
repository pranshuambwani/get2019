package Cricket;

/**
 * Class bowler contains 2 attributes: name and number of balls
 * 
 * @author Pranshu 
 * 
 *
 */
public class Bowler {

	String name;
	int numOfBalls;

	/**
	 * Constructor initializes name and number of balls
	 * 
	 * @param name
	 * @param numOfBalls
	 */
	public Bowler(String name, int numOfBalls) {
		this.name = name;
		this.numOfBalls = numOfBalls;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return number of balls
	 */
	public int getNumOfBalls() {
		return numOfBalls;
	}

	/**
	 * Decrease number of balls by 1
	 */
	public void decreaseNumOfBalls() {
		this.numOfBalls--;

	}
}