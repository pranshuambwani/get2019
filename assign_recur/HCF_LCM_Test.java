package assign_recur;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import assign_recur2.Search;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HCF_LCM_Test {

	public int a;
	public int b;
	public int expectedResult;
	public int negativeresult;

	public HCF_LCM_Test(int a, int b, int expectedResult, int negativeresult) {
		this.a = a;
		this.b = b;
		this.expectedResult = expectedResult;
		this.negativeresult = negativeresult;

	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 34, 24, 408, 2 },
				{ 4, 2, 4, 2 },

		});
	}

	@Test
	public void Test_LCM() {
		Assert.assertEquals(expectedResult, LCM_HCF.lcm(a, b));
	}

	@Test
	public void Test_HCF() {
		Assert.assertEquals(negativeresult, LCM_HCF.gcd(a, b));
	}

	@Test(expected = AssertionError.class)
	public void whenAssertionErrorThrowgcd() {
		int check[] = {};
		LCM_HCF.gcd(a, b);
	}

	@Test(expected = AssertionError.class)
	public void whenAssertionErrorThrowlcm() {
		int check[] = {};
		LCM_HCF.lcm(a, b);
	}

}
