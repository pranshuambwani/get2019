package assignment4.c;

import java.util.Scanner;
import java.text.DecimalFormat;
public class Marksheet {
	private static DecimalFormat df = new DecimalFormat("0.00");
	public static void main(String[] args) {
		
		System.out.println("Enter number of STUDENTS: ");
		Scanner input=new Scanner(System.in);
		Integer number =input.nextInt();
		Double grades[]= new Double[number];
		
		for(Integer i=0; i <number; i++){
			System.out.println("Enter grade between 1 to 100: ");
			Double grade=input.nextDouble();
			{
				if(grade>100 || grade<0){
					System.out.println("wrong input");
					--i;}
			else
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
	 * @param grades
	 * @param number
	 * @return maximum_grades
	 */
	public static Double maximum(Double grades[], int number){
		double max; 
		max = grades[0];
		for(int w=1; w < number; w++){
			if(max < grades[w]){
				max = grades[w];
				}
			}
		return max;
	}
	
	/**
	 * 
	 * @param grades
	 * @param number
	 * @return minimum_grades
	 */
public static Double minimum(Double grades[], int number){
		double min; 
		min = grades[0];
		for(int w=1; w < number; w++){
			if(min > grades[w]){
				min = grades[w];
				}
			}
		return min;
	}
	
  /**
  * 
  * @param grades
  * @param number
  * @return averages_of_all_grades
  */
public static Double average(Double grades[], int number){
		double a= 0 ; double avg; 
		for(int w=0; w < number; w++){
			a= a + grades[w];
			}
		avg = ( a /number);
		return avg;
	}
	/**
	 * 
	 * @param grades
	 * @param number
	 * @return PERCTAGE_STUDENT_PASSED
	 */
public static Double percentage(Double grades[], int number){
		double a=0, pass; 
		for(int w=0; w < number; w++){
			if(grades[w]>=40)
				a++;
			}
		pass = (( a/ number)*100);
		return pass;
		}
	
	}

