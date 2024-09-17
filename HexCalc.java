 package assignment2;

import java.util.Scanner;

public class HexCalc {

public static String hexaDecimals="0123456789ABCDEF";
public static Integer base=16;
public static void main(String[] args) {
// TODO Auto-generated method stub

Scanner input = new Scanner(System.in);

Integer choice=null;
System.out.println("Enter HexaDacimal Number1:");
String number1=input.next();

System.out.println("Enter HexaDacimal Number2:");
String number2=input.next();

number1=number1.toUpperCase();
number2=number2.toUpperCase();

do{

System.out.println("Select Option: ");
System.out.println("1. Arithmetic ");
System.out.println("2. Compare");
System.out.println("0. Exit");
System.out.println("Ënter Your Choice:");
choice=input.nextInt();
if(choice==1)
{
System.out.println("Choice Arithmetic Expression");
System.out.println("1. Addition ");
System.out.println("2. Subtraction");
System.out.println("3. Multiply");
System.out.println("4. Divide");
System.out.println("Choice Option: ");
Integer option=input.nextInt();
if(option == 1){
String hexAddtion=Addition(number1,number2);
System.out.println("Addition is "+hexAddtion);
}
else if(option == 2){
String hexSubraction=Subtraction(number1,number2);
System.out.println("Subtraction is "+hexSubraction);
}
else if(option == 3){
String hexMultiply=Multiply(number1,number2);
System.out.println("Multiply is "+hexMultiply);
}
else if(option == 4){
String hexDivision=Division(number1,number2);
System.out.println("Division is "+hexDivision);
}
else{
System.out.println("Wrong Option");
}
}
else if(choice==2){
System.out.println("Choice Comparison Opertor");
System.out.println("1. EqualTo(==) ");
System.out.println("2. Greater Than (>)");
System.out.println("3. Less Than (<)");
System.out.println("Choice Option: ");
Integer option=input.nextInt();

if(option==1){
if(EqualTo(number1,number2))
System.out.println("Hexadecimal Number are equal");
else
System.out.println("Not Equal");

}
else if(option==2){
if(GreaterThan(number1,number2))
System.out.println("Number 1 is Greater");
else
System.out.println("Number 1 is not Greater");

}
else if(option==3){
if(LessThan(number1,number2))
System.out.println("Number 1 is Smaller");
else
System.out.println("Number 1 is not Smaller");
}


}



}while(choice!=0);



}



private static boolean LessThan(String number1, String number2) {
// TODO Auto-generated method stub
Integer index=0;
Integer lengthNum1=number1.length()-1,lengthNum2=number2.length()-1;
if(lengthNum1>lengthNum2)
return false;
else if(lengthNum2>lengthNum1)
return true;
else{
while(index<=lengthNum1){
if(number1.charAt(index)<number2.charAt(index))
return true;
else if(number1.charAt(index)>number2.charAt(index))
return false;
index++;
}
}

return true;

}



private static boolean GreaterThan(String number1, String number2) {
// TODO Auto-generated method stub
Integer index=0;
Integer lengthNum1=number1.length()-1,lengthNum2=number2.length()-1;
if(lengthNum1>lengthNum2)
return true;
else if(lengthNum2>lengthNum1)
return false;
else{
while(index<=lengthNum1){
if(number1.charAt(index)>number2.charAt(index))
return true;
else if(number1.charAt(index)<number2.charAt(index))
return false;
index++;
}

}
return false;


}



private static boolean EqualTo(String number1, String number2) {
// TODO Auto-generated method stub
if(number1.length()!=number2.length())
return false;
else{
Integer index=number1.length()-1;
while(index>=0){
if(number1.charAt(index)!=number2.charAt(index))
return false;
index--;
}
}
return true;
}



public static String Addition(String number1,String number2){
Integer num1=HexaToDecimal(number1);
Integer num2=HexaToDecimal(number2);
System.out.println(num1+num2);
return DecimalToHexa(num1+num2);

}

public static String Subtraction(String number1,String number2){
Integer num1=HexaToDecimal(number1);
Integer num2=HexaToDecimal(number2);
return DecimalToHexa(num1-
num2);

}


private static String Division(String number1, String number2) {
// TODO Auto-generated method stub
Integer num1=HexaToDecimal(number1);
Integer num2=HexaToDecimal(number2);
return DecimalToHexa(num1/num2);
}



private static String Multiply(String number1, String number2) {
// TODO Auto-generated method stub
Integer num1=HexaToDecimal(number1);
Integer num2=HexaToDecimal(number2);
return DecimalToHexa(num1*num2);
}

public static Integer HexaToDecimal(String hexaNumber){

Integer decimalNumber=0,loop,position=0;
Integer length=hexaNumber.length()-1;
for(loop=length;loop>=0;loop--){

char ch = hexaNumber.charAt(loop);
decimalNumber=decimalNumber + ((Power(16,position)) * hexaDecimals.indexOf(ch));
position++;
}
return decimalNumber;

}


public static String DecimalToHexa(Integer decimalNumber){
String hexaNumber="";
while(decimalNumber>0){
	Integer mode = decimalNumber%16;
	char hexa = hexaDecimals.charAt(mode);
	hexaNumber=(Character.toString(hexa))+hexaNumber;
	decimalNumber=decimalNumber/16;
}
return hexaNumber;

}

public static Integer Power(Integer number,Integer power){

if(power==0)
return 1;
else
{
Integer result=1;
while(power!=0){
result*=number;
power--;
}
return result;
}

}
}
