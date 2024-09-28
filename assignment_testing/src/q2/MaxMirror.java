package q2;

public class MaxMirror {

	/**
	* Name: MaxMirror
	* Description: finding number of mirror in array.
	* @param:  (1) arr - array - array provided by user
	* @return: max-Integer
	*  usage:return Integer  
	**/
		public static int Maxmirror(int arr[]) throws AssertionError{
			int max=0;
			int count=0;
			if(arr.length<1){
				throw new AssertionError("Array is empty");
			}
			for(int loop1=0; loop1<=((arr.length)-1); loop1++){
				for(int loop2=((arr.length)-1); loop2>=0; loop2--){
					if(arr[loop1]==arr[loop2]){
						count=0;
						int index1=loop1;
						int index2=loop2;
						while(index1<=(arr.length-1) && index2>=0 && arr[index1] == arr[index2]){
							count++; 
							index1++; 
							index2--;
							}
						}
					if(count>=max){
						max=count;
						}
					}
				}
			return max;
			}
}
