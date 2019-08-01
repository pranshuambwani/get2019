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
		for (int loop = 0; loop < array.length; loop++) {

			if (loop % (var + 1) == 0) {
				term.add(total);
				total = 0;
			} else {
				if (array[loop] < 0) {
					throw new AssertionError("Power can't be Negative");
				}
				total = total + array[loop];
			}
			term.add(total);

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
