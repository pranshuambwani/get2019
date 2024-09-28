package q1;
import java.util.Arrays;
public class CountClumps {
	
	/**
	* Name: CountClumps
	* Description: finding same number of groups or chunks in array.
	* @param:  (1) arr - array - array provided by user
	* @return: count-Integer
	*  usage:return Integer  
	**/
	public static int Countclumps(int arr[]) throws AssertionError{
		   int count=0;
		   if(arr.length<1){
				throw new AssertionError("Array is empty");
			}
		   for (int loop= 0; loop <arr.length-1; loop++) {
			   if(arr[loop]==arr[loop+1])
			   {
	    		  count++;
	    		  while(loop<(arr.length-1) && arr[loop] == arr[loop+1])
	    		  {
	    			  loop++;
	    		  }
	    	  }
	      }
	      return count;
	   }
}


	
	
	