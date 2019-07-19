package assign_recur2;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SearchTest {

	public int first;
	public int last;
	public int expectedResult;
	public int expectedresult;
	public int x;
	public int arr[];

	public SearchTest(int arr[], int first, int last, int x,
			int expectedResult, int expectedresult) {
		this.arr = arr;
		this.first = first;
		this.last = last;
		this.x = x;
		this.expectedResult = expectedResult;
		this.expectedresult = expectedresult;

	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 0, 7, 6, 5, 5 },
				{ new int[] { 10, 20, 30, 40, 50 }, 0, 4, 10, 0, 0 },

		});
	}

	@Test
	public void Test_Search() {
		Assert.assertEquals(expectedResult,
				Search.binarySearch(arr, first, last, x));
	}

	@Test
	public void Test_Search2() {
		Assert.assertEquals(expectedresult,
				Search.linearSearch(arr, first, last, x));
	}

	@Test(expected = AssertionError.class)
	public void whenAssertionErrorTrowbinarySearch() {
		int check[] = {};
		Search.binarySearch(check, first, last, expectedResult);
	}

	@Test(expected = AssertionError.class)
	public void whenAssertionErrorThrowlinearSearch() {
		int check[] = {};
		Search.linearSearch(check, first, last, expectedresult);
	}
}
