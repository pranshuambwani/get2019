package q1;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import q4.SplitArray;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountClumpsTest {
		
		public int array[];
		public int expectedResult;
		public int negativeresult;
		
		public CountClumpsTest(int [] array, int expectedResult, int negativeresult) {
			this.array = array;
			this.expectedResult = expectedResult;
			this.negativeresult= negativeresult;
		}
		
		@Parameters
		public static Collection<Object[]> data(){
			return Arrays.asList(new Object[][] {
					{new int[]{1, 1, 1, 2, 1},3,2},
					{new int[]{2, 1, 1, 2, 1},-1,7},
					{new int[]{10, 10},1,4},
					
					
					});
		 }
		
		
		@Test
		public void testSplitArray(){
			Assert.assertEquals(expectedResult,CountClumps.Countclumps(array));
		}

		@Test(expected = AssertionError.class)
		public void whenNullCountClumps(){
			int check[]={};
			CountClumps.Countclumps(check);
		}
	}
