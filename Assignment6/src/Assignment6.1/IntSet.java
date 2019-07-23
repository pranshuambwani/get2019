package Assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Pranshu name: IntSet DEsc: -->1.check whether x is a member of the
 *         set and return a boolean value --> 2.return the size of the set
 *         -->3.check whether s is a subset of the set -->4.return the
 *         complement set, you can assume that 1..1000 is the universal set
 *         -->5.return the union of s1 and s2
 */
public class IntSet {
	private final int UPPER_LIMIT = 1000;
	private final int LOWER_LIMIT = 1;
	public final Integer[] set;

	/**
	 * name: IntSet DEsc: initializing new set array
	 * 
	 * @param set
	 *            -array
	 */
	public IntSet(Integer[] set) {
		super();
		this.set = CreatenewSet(set);
	}

	/**
	 * Name: CreatenewSet Description: creating a new set
	 * 
	 * @return: list-Array usage:return Array
	 **/
	private Integer[] CreatenewSet(Integer[] input) {
		List<Integer> list = new ArrayList<Integer>();
		Integer[] set;
		for (int loop = 0; loop < input.length; loop++) {
			if (input[loop] < LOWER_LIMIT || input[loop] > UPPER_LIMIT) {
				throw new AssertionError();
			}
			if (list.contains(input[loop])) {
				continue;
			} else {
				list.add(input[loop]);
			}
		}
		set = new Integer[list.size()];
		return list.toArray(set);
	}

	/**
	 * name: isMember DEsc: find the Integer is a member of an array or not
	 * 
	 * @param value
	 *            -Integer-need to be find in Set
	 * @return-boolean-if number found then true else false
	 */
	public boolean isMember(Integer value) {
		if (value < LOWER_LIMIT || value > UPPER_LIMIT) {
			return false;
		}
		for (int loop = 0; loop < this.set.length; loop++) {
			if (value == set[loop]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * name: size
	 * 
	 * @return-size
	 */
	public Integer size() {
		return this.set.length;
	}

	/**
	 * name:
	 * 
	 * @param subSet
	 * @return
	 */
	public boolean isSubSet(IntSet subSet) {
		List<Integer> mainset = new ArrayList<Integer>(Arrays.asList(this.set));
		List<Integer> subset = new ArrayList<Integer>(Arrays.asList(subSet.set));
		if (mainset.containsAll(subset)) {
			return true;
		}
		return false;
	}

	/**
	 * name: getCompliment DEsc: finding the compliment of a set
	 * 
	 * @param: set-Array-input by user
	 * @return: compliment set-Array-(universal-set)
	 */
	public IntSet getCompliment() {
		List<Integer> setList = new ArrayList<Integer>(Arrays.asList(this.set));
		List<Integer> complimentList = new ArrayList<Integer>();
		Integer[] newSet;
		for (int loop = LOWER_LIMIT; loop <= UPPER_LIMIT; loop++) {
			if (setList.contains(loop)) {
				continue;
			} else {
				complimentList.add(loop);
			}
		}
		Object objarr[] = complimentList.toArray();
		newSet = Arrays.copyOf(objarr, objarr.length, Integer[].class);
		IntSet complimentSet = new IntSet(newSet);
		return complimentSet;
	}

	/**
	 * name: IntSet union DEsc: to find out union of two set
	 * 
	 * @param firstSet
	 *            -Array-input array
	 * @param secondSet
	 *            -Array-input by user
	 * @return union set-Array-union set of 2 input set.
	 */
	public static IntSet union(IntSet firstSet, IntSet secondSet) {
		List<Integer> set1 = new ArrayList<Integer>(Arrays.asList(firstSet.set));
		List<Integer> set2 = new ArrayList<Integer>(
				Arrays.asList(secondSet.set));
		List<Integer> unionSet = new ArrayList<Integer>();
		unionSet.addAll(set1);
		for (int loop = 0; loop < set2.size(); loop++) {
			if (!unionSet.contains(set2.get(loop))) {
				unionSet.add(set2.get(loop));
			}
		}
		Object objarr[] = unionSet.toArray();
		Integer intarr[] = Arrays
				.copyOf(objarr, objarr.length, Integer[].class);
		IntSet union = new IntSet(intarr);
		return union;

	}

}
