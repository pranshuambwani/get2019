package JDBC;

/**
* This class stores details of a category:
* name and number of children
* @author Pranshu
**/
public class Category {

    String name;
    int numberOfChildren;
   
    /**
    * Constructor initializes instance variables
    **/
    public Category(String name,int numberOfChildren){
        this.name=name;
        this.numberOfChildren=numberOfChildren;
    }
    
    /**
    * returns name of category
    **/
    public String getName(){
        return name;
    }
    
    /**
    * returns number of children of category
    **/
    public int getNumberOfChildren(){
        return numberOfChildren;
    }
    
    /**
    * sets name of category
    **/
    public void setName(String name){
        this.name=name;
    }
    
    /**
    * sets number of children of category
    **/
    public void setNumberOfChildren(int numberOfChildren){
        this.numberOfChildren=numberOfChildren;
    }
}