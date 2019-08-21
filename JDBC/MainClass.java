package JDBC;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {

    public static void main(String args[]){
        StoreFrontJDBC object=new StoreFrontJDBC();
        System.out.println("Enter user id: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        object.fetchOrders(id);
        List<String> listOfImages=new ArrayList<>();
        listOfImages.add("shirt1.jpg");
        listOfImages.add("shirt2.jpg");
        listOfImages.add("shirt3.jpg");
        listOfImages.add("shirt4.jpg");
        listOfImages.add("shirt5.jpg");
        object.addImage(1, listOfImages);
        int numOfInactives=object.setInactive();
        System.out.print("Number of inactives= " + numOfInactives);
        object.showCategories();
        input.close();
        
    }
}