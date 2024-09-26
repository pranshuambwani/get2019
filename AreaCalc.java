package assignment4;

import java.util.Scanner;
public class AreaCalc {
	public static Scanner input = new Scanner(System.in);
	public static double pi=3.14, total;
	public static Double radius, width, length, side, base, height;
	public static void main(String[] args) throws Exception {
		
		Integer choice = null;	
		do{
			System.out.println("choose your choice");
			System.out.println(" 1. Area of Circle \n 2. Area of Triangle \n 3. Area of Rectangle \n 4. Area of Square \n 0. Exit \n ");
			choice=input.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter radius: ");
				radius=input.nextDouble();
				circle(radius);
				double cc= circle(radius);
				System.out.println("Area of Circle: " +(cc));
				break;
			
			 case 3:
				System.out.println("Enter width: ");
				width= input.nextDouble();
				System.out.println("Enter Length: ");
				length = input.nextDouble();
				rectangle(width, length);
				double rr=rectangle(width, length);
				System.out.println("Area of Rectangle: " +(rr));
				break;
			
			  case 4:
				System.out.println("Enter side of Square: ");
				side=input.nextDouble();
				square(side);
				double ss=square(side);
				System.out.println("Area of Square: " +(ss));
				break;
			
			  case 0:
				System.out.println("BYE!");
				System.exit(1);
				
			
			  case 2:
				System.out.println("Enter base: ");
				base=input.nextDouble();
				System.out.println("Enter height: ");
				height=input.nextDouble();
				triangle(base, height);
				double tt=triangle(base, height);
				System.out.println("Area of Triangle: " +(tt));
				break;
			}
		  }while(choice!=0);
	}
		
		/**
		 * 
		 * @name circle
		 * DEsc: method used to calculate the area of circle
		 * @param radius-Double-positive number-used for calculating area of circle
		 * @return total-Double-contain area_of_circle
		 */
	 public static Double circle(Double radius){
		 try{
			  total = new Double(pi*(radius*radius));	 
		 	}
		 catch(ArithmeticException ex){
			 System.out.println("exception occurs");
		 	}
		return total;
		}
	
	 	/**
		 * 
		 * @name rectangle
		 * DEsc: method used to calculate the area of rectangle
		 * @param1 width-Double-positive number-used for calculating area of rectangle
		 * @param2 length-Double-positive number-used for calculating area of rectangle
		 * @return total-Double-contain area_of_circle
		 */
	public static Double rectangle(Double width, Double length){
		try{
			total = new Double(length*width);
			}
		catch(ArithmeticException ex){
			 System.out.println("exception occurs");
			}
		return total;
		}
		/**
	 * 
	 * @name square
	 * DEsc: method used to calculate the area of square
	 * @param1 side-Double-positive number-used for calculating area of square
	 * @return total-Double-contain area_of_circle
	 */
	 public static Double square(Double side){
    	try{total = new Double(side*side);
    		}
    	catch(ArithmeticException ex){
			 System.out.println("exception occurs");
			 }
    	return total;
    	}
   
	 	/**
		 * 
		 * @name triangle
		 * DEsc: method used to calculate the area of triangle
		 * @param1 width-Double-positive number-used for calculating area of triangle
		 * @param2 length-Double-positive number-used for calculating area of triangle
		 * @return total-Double-contain area_of_circle
		 */
	 public static Double triangle(Double base, Double height){
    	try{
    		total = new Double((base*height)/2);
    		}
    	catch(ArithmeticException ex){
			 System.out.println("exception occurs");
    		}
    	return total;
    	}

	}