package assign_recur2;

public class Search {

	/**
	 * Name: binarySearch Description: finding x from an array
	 * 
	 * @param: arr-Array-as input
	 * @param: first-Integer-Integer as input
	 * @param: last-Integer-Integer as input
	 * @param: x-Integer-number want to find in array
	 * @return: retvalue-Integer-index of an array where we find x:return
	 *          Integer
	 **/
	public static int binarySearch(int arr[], int first, int last, int x) {
		int mid, retvalue = 0;

		if (first > last) {
			retvalue = -1;
		}
		mid = (first + last) / 2;
		if (arr[mid] == x) {
			retvalue = mid;
		} else if (arr[mid] > x) {
			return binarySearch(arr, first, mid - 1, x);
		} else if (arr[mid] < x) {
			return binarySearch(arr, mid + 1, last, x);
		}
		return retvalue;
	}

	/**
	 * Name: lineraSearch Description: finding x from an array
	 * 
	 * @param: arr-Array-as input
	 * @param: first-Integer-Integer as input
	 * @param: last-Integer-Integer as input
	 * @param: x-Integer-number want to find in array
	 * @return: retvalue-Integer-index of an array where we find x:return
	 *          Integer
	 **/
	public static int linearSearch(int arr[], int first, int last, int x) {
		int retvalue = -1;
		if (arr[first] == x) {
			retvalue = first;
		}

		if (arr[last] == x) {
			retvalue = last;
		}

		else {
			return linearSearch(arr, first + 1, last - 1, x);
		}

		return retvalue;
	}
}
