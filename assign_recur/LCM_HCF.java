package assign_recur;

public class LCM_HCF {
	public static int a = 40;
	public static int b = 30;

	/**
	 * Name: gcd Description: finding highest common factor from 2 number
	 * 
	 * @param: a-Integer-Integer as input
	 * @param: b-Integer-Integer as input
	 * @return: gcd-Integer-hcf of two number usage:return Integer
	 **/
	static int gcd(int a, int b) throws AssertionError {
		if (a < 0 || b < 0) {
			throw new AssertionError("A nd B can't be negative");
		}
		if (b == 0)
			return a;
		else {
			return gcd(b, (a % b));
		}
	}

	/**
	 * Name: lcm Description: finding Least Common Multiple from 2 number
	 * 
	 * @param: a-Integer-Integer as input
	 * @param: b-Integer-Integer as input
	 * @return: lcm-Integer-lcm of two number usage:return Integer
	 **/
	public static int i = 1;

	static int lcm(int a, int b) throws AssertionError {
		if (a < 0 || b < 0) {
			throw new AssertionError("A nd B can't be negative.");
		}

		if (a % b == 0) {
			return a;
		} else {
			return lcm(a + (a / i++), b);
		}
	}
}
