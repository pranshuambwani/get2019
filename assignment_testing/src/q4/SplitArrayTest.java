package q4;

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
public class SplitArrayTest {
		
		public int array[];
		public int expectedResult;
		public int negativeresult;
		
		public SplitArrayTest(int [] array, int expectedResult, int negativeresult) {
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
			Assert.assertEquals(expectedResult,SplitArray.Splitarray(array));
		}

		@Test(expected = AssertionError.class)
		public void whenNullSplitArray(){
			int check[]={};
			SplitArray.Splitarray(check);
		}
	}
