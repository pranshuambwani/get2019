package q4;

public class SplitArray {
	/**
	* Name: SplitArray
	* Description: finding index number of split array in equal.
	* @param:  (1) arr - array - array provided by user
	* @return: count-Integer
	* @return: -1
	*  usage:return Integer  
	**/
	public static int Splitarray(int arr[]) throws AssertionError{
		int total=0,Imgtotal=0;
		int count=0;
		int retvalue= -1;
		if(arr.length<1){
			throw new AssertionError("Array is empty");
		}
		for (int loop= 0; loop <=arr.length-1; loop++) {
			   total=total+arr[loop];
			}
		if((total%2)==0)
		{
			for (int loop= 0; loop <=arr.length-1; loop++) {
			Imgtotal=Imgtotal+arr[loop];
			
			count++;
			if(Imgtotal==(total/2)){
				retvalue=count;
				return retvalue;	
			}
		}
	}
			return retvalue;
		}

}
