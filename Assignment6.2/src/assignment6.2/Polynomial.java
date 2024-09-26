package assignment6_2;

import java.util.*;

public class Polynomial {
	public List<Terms> lst = new ArrayList<Terms>();

	/*
	 * name: Terms
	 * DEsc: to declare coefficient and exponent
	 */
	public class Terms {

		public Integer coefficient;
		public Integer exponent;
		public Terms(Integer coefficient, Integer exponent) {
			this.coefficient = coefficient;
			this.exponent = exponent;
		}

	}

	public Polynomial(Integer[] data) throws AssertionError {
		if( data.length <1){
			throw new AssertionError("Array is empty");
			}
		for (Integer loop = 0; loop < (data.length - 1); loop = loop + 2) {
			Terms term = new Terms(data[loop], data[loop + 1]);
			this.lst.add(term);
		}
	}

	/*
	 * name: Evaluate
	 * DEsc: to find the value of polynomial equation
	 * @param: value-Float-input value
	 * @return: evaluation-Integer-value of polynomial equation
	 */
	public Integer Evaluate(Float value) throws AssertionError {
		Integer evaluation = 0;
		for (Terms term : this.lst) {
			evaluation = (int) (evaluation + (term.coefficient * (Math.pow(
					value, term.exponent))));
		}
		return evaluation;
	}

	/*
	 * name: getPolynomialDegree
	 * DEsc: to find the highest Degree from polynomial
	 * @param: lst-Array-input polynomial
	 * @return: degree-Integer-highest degree value from polynomial
	 */
	public Integer getPolynomialDegree() throws AssertionError {
		Terms term = lst.get(0);
		Integer degree = term.exponent;
		for (Terms loopterm : lst) {
			if (degree < loopterm.exponent)
				degree = loopterm.exponent;
		}
		return degree;
	}

	/*
	 * name: addPoly
	 * DEsc: to find the sum of two polynomials
	 * @param: s1-Array-input polynomial
	 * @param: s2-Array-input polynomial
	 * @return: sum-Array-sum of 2 input polynomial
	 */
	public Polynomial addPoly(Polynomial s1, Polynomial s2)
			throws AssertionError {
		Integer flag = 0;
		Terms delete = null;
		Polynomial sum = new Polynomial();
		for (Terms t1 : s1.lst) {
			flag = 0;
			for (Terms t2 : s2.lst) {
				if (t1.exponent == t2.exponent) {
					Integer sumofcoeff = t1.coefficient + t2.coefficient;
					Terms term = new Terms(sumofcoeff, t2.exponent);
					sum.lst.add(term);
					flag = 1;
					delete = t2;
				}
			}
			if (flag == 0) {
				sum.lst.add(t1);
			} else {
				s2.lst.remove(delete);
			}
		}
		for (Terms t : s2.lst) {
			sum.lst.add(new Terms(t.coefficient, t.exponent));
		}
		return sum;
	}

	/*
	 * name: mulPoly
	 * DEsc: to find the product of two polynomials
	 * @param: s1-Array-input polynomial
	 * @param: s2-Array-input polynomial
	 * @return: poly-Array-product of 2 input polynomial
	 */
	public Polynomial mulPoly(Polynomial s1, Polynomial s2)
			throws AssertionError {
		Polynomial poly = new Polynomial();
		int coefficient = 0, exponent = 0;
		for (Terms t1 : s1.lst) {
			for (Terms t2 : s2.lst) {

				coefficient = t1.coefficient * t2.coefficient;
				exponent = t1.exponent + t2.exponent;
				Terms tmp = new Terms(coefficient, exponent);
				poly.lst.add(tmp);
			}
		}
		return poly;

	}

	public Polynomial() {

	}

}
