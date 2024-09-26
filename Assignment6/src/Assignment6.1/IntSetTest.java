package Assignment6;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Ignore;
import org.junit.Test;

public class IntSetTest {
	@Test
	public void isMember () {
		Integer[] input = {1,2,3,4,5,5,5,5}; 
		IntSet set =new IntSet(input);
		assertEquals(true,set.isMember(3));
	}
	
	@Test
	public void sizeTest() {
		Integer[] input = {1,2,3,4,5,5,6,5}; 
		IntSet set = new IntSet(input);
		assertEquals((Integer)6,(Integer)set.size());
	}
	@Test
	public void subset() {
		Integer[] input1 = {1,2,3,4,5,5,6,5};
		Integer[] input2 = {2,3,4,6,4};
		IntSet set = new IntSet(input1);
		IntSet subSet = new IntSet(input2);
		assertEquals(true,set.isSubSet(subSet));
	}
	
	@Test
	public void union() {
		Integer[] unionset = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Integer[] input1 = { 1, 2, 3, 4, 5, 5, 6, 5 };
		Integer[] input2 = { 7, 8, 9, 10 };
		IntSet firstset = new IntSet(input1);
		IntSet secondset = new IntSet(input2);
		IntSet unionobj = new IntSet(unionset);
		Assert.assertArrayEquals(unionobj.set,IntSet.union(firstset, secondset).set);
	}

	@Test(expected=AssertionError.class)
	public void checkRange() {
		Integer[] input = {12,1002};
		IntSet set = new IntSet(input);
	}

}