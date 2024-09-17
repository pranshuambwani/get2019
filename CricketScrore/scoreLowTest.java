package CricketScrore;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class scoreLowTest {
	/**
	 * Positive Test Case
	 */
	@Test
	public void test1() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(13);
		list.add(10);
		list.add(6);
		list.add(22);
		list.add(4);
		scoreLow obj = new scoreLow(list);
		ArrayList<Integer> actualList = obj.bowlerOrder(45);
		int[] actualArray = new int[actualList.size()];
		for (int i = 0; i < actualList.size(); i++) {
			actualArray[i] = actualList.get(i);
		}
		int[] expectedArray = new int[] { 4, 1, 2 };
		assertArrayEquals(expectedArray, actualArray);
	}

	/**
	 * Negative Test Case
	 */
	@Test(expected = AssertionError.class)
	public void test2() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(13);
		list.add(10);
		list.add(6);
		list.add(22);
		list.add(4);
		scoreLow obj = new scoreLow(list);
		ArrayList<Integer> actualList = obj.bowlerOrder(60);
		int[] actualArray = new int[actualList.size()];
		for (int i = 0; i < actualList.size(); i++) {
			actualArray[i] = actualList.get(i);
		}
		int[] expectedArray = new int[] { 4, 1, 2 };
		assertArrayEquals(expectedArray, actualArray);
	}

}