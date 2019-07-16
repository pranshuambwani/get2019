package assignment4;

import java.util.Scanner;
public class AreaCalc {
	public static Scanner input = new Scanner(System.in);
	public static double pi=3.14;
	public static void main(String[] args) {
		Integer choice = null;	
		do{
			System.out.println("choose your choice");
			System.out.println(" 1. Area of Circle \n 2. Area of Triangle \n 3. Area of Rectangle \n 4. Area of Square \n 0. Exit \n ");
			choice=input.nextInt();
			
			if(choice==1){
				System.out.println("Enter radius: ");
				Double radius=input.nextDouble();
				circle(radius);
				}
			
			if(choice==3){
				System.out.println("Enter width: ");
				Double width= input.nextDouble();
				System.out.println("Enter Length: ");
				Double length = input.nextDouble();
				rectangle(width, length);
				}
			
			if(choice==4){
				System.out.println("Enter side of Square: ");
				Double side=input.nextDouble();
				square(side);
				}
			
			if(choice==0){
				System.exit(1);
				}
			
			if(choice==2){
				System.out.println("Enter base: ");
				double base=input.nextDouble();
				System.out.println("Enter height: ");
				double height=input.nextDouble();
				triangle(base, height);
			}
		  }while(choice!=0);
	}
	
	 public static void circle(Double radius){
		Double total = new Double(pi*(radius*radius));
		System.out.println("Area: " +total);
		}
	
	public static void rectangle(Double width, Double length){
		Double total = new Double(length*width);
		System.out.println("Area: " +total);
		}
	
    public static void square(Double side){
    	Double total = new Double(side*side);
    	System.out.println("Area: " +total);
    	}
    
    public static void triangle(Double base, Double height){
    	Double total = new Double((base*height)/2);
    	System.out.println("Area: " +total);
    	}

	}