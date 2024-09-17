package assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SparseMatrix {

	public final Integer ROW = 0;
	public final Integer COL = 1;
	public final Integer VAL = 2;
	public final Integer[][] sparseMatrix;

	public SparseMatrix(Integer[][] sparseMatrix) {
		this.sparseMatrix = CreateSparseMatrix(sparseMatrix);
	}

	/**
	 * Create sparse matrix
	 * 
	 * @param matrix
	 *            2-d array
	 * @return sparse matrix
	 */
	private Integer[][] CreateSparseMatrix(Integer[][] matrix) {
		// TODO Auto-generated method stub
		Integer rows = matrix.length;
		Integer cols = matrix[0].length;
		Integer countNonZero = 0;
		Integer sparseMatrix[][];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (matrix[row][col] != 0)
					countNonZero++;
			}
		}
		sparseMatrix = new Integer[countNonZero][3];
		Integer loop = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (matrix[row][col] != 0) {
					sparseMatrix[loop][ROW] = row;
					sparseMatrix[loop][COL] = col;
					sparseMatrix[loop][VAL] = matrix[row][col];
					loop++;
				}

			}
		}
		return sparseMatrix;
	}

	/**
	 * Transpose the Matrix
	 * 
	 * @return 2-d array transpose of matrix
	 */
	public Integer[][] TransposeMatrix() {
		Integer rows = this.sparseMatrix.length;
		Integer cols = 3;
		Integer transposeMatrix[][] = new Integer[rows][cols];
		for (int row = 0; row < rows; row++) {
			transposeMatrix[row][ROW] = this.sparseMatrix[row][COL];
			transposeMatrix[row][COL] = this.sparseMatrix[row][ROW];
			transposeMatrix[row][VAL] = this.sparseMatrix[row][VAL];
		}
		return transposeMatrix;
	}

	/**
	 * Check matrix is symmetric or not
	 * 
	 * @return if matrix is symmetric return true else false
	 */
	public boolean SymmetricalMatrix() {
		Integer[][] transpose = this.TransposeMatrix();
		Integer rows = this.sparseMatrix.length;
		Integer cols = this.sparseMatrix[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (transpose[row][col] != this.sparseMatrix[row][col])
					return false;
			}
		}
		return true;
	}

	/**
	 * Add two sparse matrix
	 * 
	 * @param mat1
	 *            first matrix
	 * @param mat2
	 *            second matrix
	 * @return addition of first and second matrix
	 */
	public Integer[][] AddMatrix(Integer[][] mat1, Integer[][] mat2) {
		List<Integer[]> lst1 = new ArrayList<Integer[]>();
		lst1 = Arrays.asList(mat1);
		List<Integer[]> lst2 = new ArrayList<Integer[]>();
		lst2 = Arrays.asList(mat2);
		List<Integer[]> additionList = new ArrayList<Integer[]>();
		Integer flag = 0;
		for (Integer firstmat[] : lst1) {
			flag = 0;
			for (Integer secondmat[] : lst2) {
				if (firstmat[ROW] == secondmat[ROW]
						&& firstmat[COL] == secondmat[COL]) {
					additionList.add(new Integer[] { firstmat[ROW],
							firstmat[COL], firstmat[VAL] + secondmat[VAL] });
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				additionList.add(new Integer[] { firstmat[ROW], firstmat[COL],
						firstmat[VAL] });
			}
		}
		for (Integer secondmat[] : lst2) {
			flag = 0;
			for (Integer firstmat[] : lst1) {
				if (firstmat[ROW] == secondmat[ROW]
						&& firstmat[COL] == secondmat[COL]) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				additionList.add(new Integer[] { secondmat[ROW],
						secondmat[COL], secondmat[VAL] });
			}
		}
		Integer result[][] = new Integer[additionList.size()][3];
		int loop = 0;
		for (Integer obj[] : additionList) {
			result[loop][ROW] = obj[ROW];
			result[loop][COL] = obj[COL];
			result[loop][VAL] = obj[VAL];
			loop++;
		}
		// sortbyColumn(result);
		return result;
	}

	/**
	 * Multiply two sparse matrix
	 * 
	 * @param mat1
	 *            first matrix
	 * @param mat2
	 *            second matrix
	 * @return Multiplication of first and second matrix
	 */
	public Integer[][] MultiplyTwoMatrix(Integer[][] mat1, Integer[][] mat2) {
		List<Integer[]> rcv = new ArrayList<Integer[]>();
		for (int row = 0; row < mat1.length; row++) {
			for (int col = 0; col < mat2.length; col++) {
				int sumValue = 0;
				if (mat1[row][COL] == mat2[col][ROW]) {
					sumValue = mat1[row][VAL] * mat2[col][VAL];
					if (row > 0 && rcv.size() > 0) {
						int oldRow = rcv.get(rcv.size() - 1)[ROW];
						int oldCol = rcv.get(rcv.size() - 1)[COL];
						if (mat1[row][ROW] == oldRow
								&& mat2[col][COL] == oldCol) {
							int oldValue = rcv.get(rcv.size() - 1)[VAL];
							sumValue += oldValue;
							rcv.remove(rcv.size() - 1);
							rcv.add(new Integer[] { mat1[row][ROW],
									mat2[col][COL], sumValue });
						} else {
							rcv.add(new Integer[] { mat1[row][ROW],
									mat2[col][COL], sumValue });
						}
					} else {
						rcv.add(new Integer[] { mat1[row][ROW], mat2[col][COL],
								sumValue });
					}
				}

			}
		}
		Integer result[][] = new Integer[rcv.size()][3];
		rcv.toArray(result);
		return result;
	}

}
