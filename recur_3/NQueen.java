package recur_3;


public class NQueen {
	/**
	 * This Method returns if is safe to place the queen on a particular position
	 * @param Board-on which queen is to be placed
	 * @param row-- row index
	 * @param col-- column index
	 * @param size-- Dimensions of the board
	 * @return If queen can be(true) placed at a spot or not(false)
	 */
	static boolean isSafe(boolean[][] board, int row, int col, int size) {
		if (size == 0)
			throw new AssertionError("Invalid Size");
		boolean safe = true;
		try {
			// Checking Column
			for (int loop= 0; loop < size; loop++) {
				if (board[loop][col] == true)
					safe = false;
			}
			int sum_index = row + col;
			// Checking Right Diagonal
			for (int loop= 0; loop < row; loop++) {
				for (int loop2 = 0; loop2 < size; loop2++) {
					// Diagonal Condition
					if ((loop + loop2 == sum_index) && (board[loop][loop2] == true))
						safe = false;
				}
			}
			int diff_index = row - col;
			// Checking Left Diagonal
			for (int loop= 0; loop< row; loop++) {
				for (int loop2 = 0; loop2 < size; loop2++) {
					// Diagonal Condition
					if ((loop - loop2 == diff_index) && (board[loop][loop2] == true))
						safe = false;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Entering or Accessing Invalid Values");
		}
		// Returning the possibility
		return safe;
	}

	/**
	 * This method place the queen using the isSafe Function written above and
	 * Backtracking Approach
	 * @param Board-on which queen is to be placed
	 * @param row-- row index
	 * @param size-- Dimensions of the board
	 * @return Queens can be placed or not in the given board of set dimensions
	 */
	public static boolean queenPlaced(boolean[][] board, int row, int size) {
		if (size==0)
			throw new AssertionError("Invalid Size");
		// Base Case or Break Condition
		if (row >= size)
			return true;
		boolean QueenisPlaced = false;
		try {
			for (int loop = 0; loop < size; loop++) {
				// If safe place the queen
				if (isSafe(board, row, loop, size)) {
					board[row][loop] = true;
					// Go for next row
					QueenisPlaced = queenPlaced(board, row + 1, size);
				}
				if (QueenisPlaced)
					break;
				// If not safe mark element 0
				else
					board[row][loop] = false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Entering or Accessing Invalid Values");
		}
		return QueenisPlaced;
	}
}
