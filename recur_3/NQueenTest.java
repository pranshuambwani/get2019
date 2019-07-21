package recur_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest {

	/**
	 * Testcase1 for NQueen
	 */
	@Test
	public void test1() {
		int size = 4;
		boolean[][] board = new boolean[size][size];
		boolean result = NQueen.queenPlaced(board, 0, size);
		assertTrue(result);
	}

	/**
	 * Testcase2 for NQueen
	 */
	@Test
	public void test2() {
		int size = 3;
		boolean[][] board = new boolean[size][size];
		boolean result = NQueen.queenPlaced(board, 0, size);
		assertFalse(result);
	}

	/**
	 * Testcase3 for NQueen
	 */
	@Test
	public void test3() {
		int size = 2;
		boolean[][] board = new boolean[size][size];
		boolean result = NQueen.queenPlaced(board, 0, size);
		assertFalse(result);
	}

	/**
	 * Testcase4 for NQueen
	 */
	@Test
	public void test4() {
		int size = 1;
		boolean[][] board = new boolean[size][size];
		boolean result = NQueen.queenPlaced(board, 0, size);
		assertTrue(result);
	}

	/**
	 * Assertion Error Handling in NQueen
	 */
	@Test(expected = AssertionError.class)
	public void whenAssertionErrorThrownNQueen() {
		int size = 0;
		boolean[][] board = new boolean[size][size];
		NQueen.queenPlaced(board, 0, size);
	}
}
