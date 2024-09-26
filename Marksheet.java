package marksheet;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Marksheet {
	private static DecimalFormat df = new DecimalFormat("0.00");
	public static void main(String[] args)throws Exception {
		
		System.out.println("Enter number of STUDENTS: ");
		Scanner input=new Scanner(System.in);
		Integer number =input.nextInt();
		Double grades[]= new Double[number];
		
		for(Integer i=0; i <number; i++){
			System.out.println("Enter grade between 1 to 100: ");
			Double grade=input.nextDouble();
				if(grade>100 || grade<0){
					System.out.println("wrong input");
					--i;
					}
			else{
				grades[i]= grade;
				}
			}
		
		double gmax= maximum(grades, number);
		double gmin=minimum(grades, number);
		double gavg=average(grades, number);
		double gpass=percentage(grades,number);
		System.out.println("average of all grades: " +df.format(gavg) +"%");
		System.out.println("maximum of all grades: " +df.format(gmax) +"%");
		System.out.println("minimum of all grades: " +df.format(gmin) +"%");
		System.out.println("Return percentage of students passed: " +df.format(gpass) +"%");
		
	}
	
	/**
	 * 
	 * @name maximum
	 * DEsc: method used to find maximum grade
	 * @param grades-Double-positive number-used for storing all marks
	 * @param number-Integer-positive number, greater than 0-used for storing number of students
	 * @return max-Double-contain maximum percentage
	 */
	public static Double maximum(Double grades[], int number){
		double max; 
		max = grades[0];
		try{
			for(int loop=1; loop < number; loop++){
			if(max < grades[loop]){
				max = grades[loop];
					}
				}
			}
			catch(ArithmeticException ex){
				 System.out.println("exception occurs");
			}
		return max;
	}
	
	/**
	 * 
	 * @name minimum
	 * DEsc: method used to find minimum grade
	 * @param grades-Double-positive number-used for storing all marks
	 * @param number-Integer-positive number, greater than 0-used for storing number of students
	 * @return min-Double-contain minimum percentage
	 */
	public static Double minimum(Double grades[], int number){
		double min; 
		min = grades[0];
		try{for(int loop=1; loop < number; loop++){
			if(min > grades[loop]){
				min = grades[loop];
				}
			}
		}
		catch(ArithmeticException ex){
			 System.out.println("exception occurs");
		}
		return min;
	}
	
/**
 * 
 * @name minimum
 * DEsc: method used to find average of all grades
 * @param grades-Double-positive number-used for storing all marks
 * @param number-Integer-positive number, greater than 0-used for storing number of students
 * @return avg-Double-contain average percentage
 */
	public static Double average(Double grades[], int number){
		double pointer= 0 ; double avg=0; 
		try{
			for(int loop=0; loop < number; loop++){
			pointer= pointer + grades[loop];
			}
		avg = ( pointer /number);
			}
		catch(ArithmeticException ex){
			 System.out.println("exception occurs");
			}
		return avg;
	}
/**
 * 
 * @name minimum
 * DEsc: method used to find the percentage of student passed
 * @param grades-Double-positive number-used for storing all marks
 * @param number-Integer-positive number, greater than 0-used for storing number of students
 * @return pass-Double-contain student passed percentage
 */
	public static Double percentage(Double grades[], int number){
		double pointer=0, pass=0; 
		try{
			for(int loop=0; loop< number; loop++){
			if(grades[loop]>=40)
				pointer++;
			}
		pass = (( pointer/ number)*100);
		}
		catch(ArithmeticException ex){
			 System.out.println("exception occurs");
		}
		return pass;
		}
	
	}

