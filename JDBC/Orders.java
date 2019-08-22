package JDBC;
public class Orders {

    int id,amount;
    String date;
    
    public Orders(int id,String date,int amount){
        this.id=id;
        this.amount=amount;
        this.date=date;
    }
    
    public int getId(){
        return id;
    }

    public int getAmount(){
        return amount;
    }

    public String getDate(){
        return date;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void setAmount(int amount){
        this.amount=amount;
    }

    public void setDate(String date){
        this.date=date;
    }
}
