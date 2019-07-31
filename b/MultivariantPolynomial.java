package DSAssignment1.b;

import java.util.ArrayList;
import java.util.List;

public class MultivariantPolynomial {
	public List<Integer> term = new ArrayList<Integer>();

	/**
	 * name: MultivariantPolynomial- take expression as input
	 * 
	 * @param array
	 * @param var
	 *            take input with number of variable and expression as Array.
	 */
	public MultivariantPolynomial(Integer var, Integer array[])
			throws AssertionError {
		Integer total = 0;
		for (int loop = 0; loop < array.length; loop = loop + var + 1) {
			for (int loop2 = loop + 1; loop2 <= loop + var; loop2++) {
				if (array[loop2] < 0) {
					throw new AssertionError("Power can't be Negative");
				}
				total = total + array[loop2];
			}

			term.add(total);
			total = 0;
		}
	}

	/**
	 * name: FindDegree- to find the highest number of degree in expression
	 * 
	 * @return degree-Integer
	 */
	public Integer FindDegree() {
		Integer degree = term.get(0);

		for (Integer compare : term) {
			if (compare > degree) {
				degree = compare;
			}
		}
		return degree;
	}

}
