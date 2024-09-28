package q3;

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
public class FixXYTest {
		
		public int array[];
		public int expectedResult[];
		public int negativeresult[];
		public int x=4, y=5;
		
		public FixXYTest(int [] array, int expectedResult[], int negativeresult[]) {
			this.array = array;
			this.expectedResult = expectedResult;
			this.negativeresult= negativeresult;
		}
		
		@Parameters
		public static Collection<Object[]> data(){
			return Arrays.asList(new Object[][] {
					{new int[]{5, 4, 9, 4, 9, 5},new int[]{9, 4, 5, 4, 5, 9},new int[]{9,5,5,5,5,4}},
					{new int[]{1, 4, 1, 5},new int[]{1, 4, 5, 1},new int[]{2, 1, 1, 2}},
					{new int[]{1, 4, 1, 5, 5, 4, 1},new int[]{1, 4, 5, 1, 1, 4, 5},new int[]{1, 5, 1, 6, 5, 4, 1}},
					
					
					});
		 }
		
		
		@Test
		public void testSplitArray(){
			Assert.assertArrayEquals(expectedResult,FixXY.Fixxy(array,x,y));
		}

		@Test(expected = AssertionError.class)
		public void whenNullFixXY(){
			int check[]={};
			int x=4;
			int y=5;
			FixXY.Fixxy(check,x,y);
		}
		
		@Test(expected = AssertionError.class)
		public void whenFixXY(){
			int lindex=expectedResult.length-1;
			if(expectedResult[lindex]==x){
				throw new AssertionError("X cannot be at last Index");
			}
			for(int loop=0; loop < expectedResult.length; loop++){
				if(expectedResult[loop]==expectedResult[loop+1]){
					throw new AssertionError("two X cannot be at adjacent index");	
				}
			}
			FixXY.Fixxy(expectedResult,x,y);
		}
	}

