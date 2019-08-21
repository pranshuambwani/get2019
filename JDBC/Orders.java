package JDBC;

/**
* This class stores details of order:
* id, amount and date of order placed
* @author Twinkle-Garg
**/
public class Orders {

    int id,amount;
    String date;
    
    /**
    * Constructor initializes instance variables
    *
    **/
    public Orders(int id,String date,int amount){
        this.id=id;
        this.amount=amount;
        this.date=date;
    }
    
    /**
    * returns id of order
    **/
    public int getId(){
        return id;
    }
    
    /**
    * returns amount of order
    **/
    public int getAmount(){
        return amount;
    }
    
    /**
    * returns date of orer placed
    **/
    public String getDate(){
        return date;
    }
    
    /**
    * this method sets id of order
    **/
    public void setId(int id){
        this.id=id;
    }
    
    /**
    * This method set order amount
    **/
    public void setAmount(int amount){
        this.amount=amount;
    }
    
    /**
    * This method sets date of order placed
    **/
    public void setDate(String date){
        this.date=date;
    }
}