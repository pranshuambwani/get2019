package DSAssignment1.b;

import org.junit.Assert;
import org.junit.Test;

public class MPTest {

	@Test
	public void FindDegreePositive() {
		MultivariantPolynomial poly = new MultivariantPolynomial(new Integer (3),new Integer[] {
				1, 2, 1, 1, -6, 3, 12, 2, 3, 12, 12, 1 });
		Assert.assertEquals((int) 25, (int) poly.FindDegree());
	}

	@Test
	public void FindDegreeNegative() {
		MultivariantPolynomial poly = new MultivariantPolynomial(new Integer (2),new Integer[] {
				1, 2, 1, -6, 3, 12, 3, 12, 12 });
		Assert.assertNotEquals((int) 23, (int) poly.FindDegree());
	}

}
