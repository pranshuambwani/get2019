package q3;

import java.util.Arrays;

public class FixXY {
	/**
	* Name: FixXY
	* Description: fixing position of x and y.
	* @param:  (1) a - array - array provided by user
	(2)  x- integer - value that user wants at fix position
	(3)  y- integer - value that will follow x
	* @return: brr-array
	*  usage:return array  
	**/
	public static int[] Fixxy(int arr[], int x ,int y) throws AssertionError{
		if(arr.length<1){
			throw new AssertionError("Array is empty");
		}
			
		int lindex=arr.length-1;
		if(arr[lindex]==x){
			throw new AssertionError("X cannot be at last Index");
		}
		for(int loop=0; loop < arr.length; loop++){
			if(arr[loop]==arr[loop+1]){
				throw new AssertionError("two X cannot be at adjacent index");	
			}
		}
		int count=0;int pointer=0;
		for(int loop=0; loop <= arr.length-1; loop++){
			if(arr[loop]==x){
				
				count++;
				}
			if(arr[loop]==y){
				
				pointer++;
			}
		}
		if(count!=pointer){
			throw new AssertionError("X and Y are not equal in number");
		}
		int brr[]=new int[arr.length];
		Arrays.fill(brr,0);
		for(int index=0;index<arr.length;index++)
 		  {
 			 if(arr[index]== x){
 				 brr[index]= x;
 				 brr[index+1]= y;
 			  }
 		  }
		int index= 0;
 		  for(int i= 0;i<brr.length;i++)
 		  {
               if(brr[i]== 0)
               {
            	   for(int loop= index; loop < arr.length; loop++)
            	   {
            		   if((arr[loop]!= x) &&(arr[loop]!=y ))
            		   {
            			brr[i]= arr[loop];
            			 index= loop+1;
            			 break;
            		   }
            	   }
               }
 		  }
	 return brr;
	
	}
}

