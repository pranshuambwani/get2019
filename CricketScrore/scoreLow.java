package CricketScrore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * This class solves the condition of scoring minimum
 * 
 * @author Vatsal
 *
 */
public class scoreLow {
	static ArrayList<Integer> bowlerBalls = new ArrayList<Integer>();
	static HashMap<Integer, Integer> Bowlers = new HashMap<Integer, Integer>();
	static int size;

	/**
	 * Default Constructors
	 * 
	 * @param balls
	 *            (No.of balls by different bowlers)
	 */
	public scoreLow(ArrayList<Integer> balls) {
		for (int loop = 0; loop < balls.size(); loop++) {
			bowlerBalls.add(balls.get(loop));
			Bowlers.put(balls.get(loop), loop + 1);
		}
		size = bowlerBalls.size();
	}

	/**
	 * This method determines the order of Bowler decided by captain to minimize
	 * score
	 * 
	 * @param maxBalls
	 *            -- Max Balls played by Virat Kohli
	 * @return
	 */
	public ArrayList<Integer> bowlerOrder(int maxBalls) throws AssertionError {
		ArrayList<Integer> listOrder = new ArrayList<Integer>();
		ArrayList<Integer> BowlerBalls = bowlerBalls;
		int sum = 0;
		for (int loop = 0; loop < BowlerBalls.size(); loop++) {
			sum = sum + BowlerBalls.get(loop);
		}
		// If max numbers of balls are short
		if (maxBalls > sum)
			throw new AssertionError("Invalid Input");
			// Concept of Max Heap is used
			while (size > 0) {
				PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
				// Priority Queue is made after every insertion into the order
				// list
				for (int loop = 0; loop < BowlerBalls.size(); loop++) {
					pQueue.add(BowlerBalls.get(loop));
				}
				// Returns the max element
				int top = pQueue.peek();
				// Bowler number is get through map
				int getBowler = Bowlers.get(top);
				// Bowler number added to the list
				listOrder.add(getBowler);
				// Total number of balls left = total balls - balls delivered by
				// a bowler
				if (top < maxBalls) {
					maxBalls = maxBalls - top;
					size--;
					BowlerBalls.remove(getBowler - 1);
				} else
					break;
			}
		return listOrder;
	}
}