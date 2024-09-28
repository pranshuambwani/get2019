package q2;

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
public class MaxMirrorTest {
		
		public int array[];
		public int expectedResult;
		public int negativeresult;
		
		public MaxMirrorTest(int [] array, int expectedResult, int negativeresult) {
			this.array = array;
			this.expectedResult = expectedResult;
			this.negativeresult= negativeresult;
		}
		
		@Parameters
		public static Collection<Object[]> data(){
			return Arrays.asList(new Object[][] {
					{new int[]{1, 2, 3, 8, 9, 3, 2, 1},3,2},
					{new int[]{7, 1, 4, 9, 7, 4, 1},2,7},
					{new int[]{1, 2, 1, 4},3,4},
					{new int[]{1, 4, 5, 3, 5, 4, 1},7,5},
					
					
					});
		 }
		
		
		@Test
		public void testSplitArray(){
			Assert.assertEquals(expectedResult,MaxMirror.Maxmirror(array));
		}

		@Test(expected = AssertionError.class)
		public void whenNullMaxMirror(){
			int check[]={};
			MaxMirror.Maxmirror(check);
		}
	}
