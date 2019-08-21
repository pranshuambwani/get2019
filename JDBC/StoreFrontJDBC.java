package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * This class performs certain queries on database Store Front
 * @author Twinkle-Garg
 *
 */
public class StoreFrontJDBC {

    /**
     * This method:
     * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user which are in shipped state.
     * Orders should be sorted by order date column in chronological order.
     * @param userId
     */
    public void fetchOrders(int userId) {
        String query = "select DISTINCT o.id, o.date_of_order_placed, o.amount from user u join orders o join ";
        query += "item_list i join product p where u.id=o.user_id AND o.id=i.order_number AND ";
        query += "o.id NOT IN(Select order_number from item_list where ";
        query += "status='Cancelled' OR status='Returned') AND ";
        query += "p.id=i.product_id AND u.id=? ORDER BY o.date_of_order_placed DESC";

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            System.out.println("The SQL query is: " + query);
            System.out.println();
            ResultSet rset = stmt.executeQuery();
            List<Orders> listOfOrders = new ArrayList<>();

            while (rset.next()) {
                listOfOrders.add(new Orders(rset.getInt("id"), rset
                        .getString("date_of_order_placed"), rset
                        .getInt("amount")));
            }
            System.out.println("Total number of records = "
                    + listOfOrders.size());
            for (Orders order : listOfOrders) {
                System.out.println(order.getId() + "\t" + order.getDate()
                        + "\t" + order.getAmount());
            }
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * This method inserts images of a product using batch insert technique
     * @param productId
     * @param image
     */
    public void addImage(int productId, List<String> image) {
        String query = "insert into image(product_id,image) values(?,?)";
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            conn.setAutoCommit(false);
            System.out.println("The SQL query is: " + query);
            System.out.println();

            for (int count = 0; count < image.size(); count++) {
                stmt.setInt(1, productId);
                stmt.setString(2, image.get(count));
                stmt.addBatch();
            }

            int[] result = stmt.executeBatch();
            System.out.println("The number of rows inserted: " + result.length);
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * This method change status as inactive of all those products which were not ordered by any Shopper in last 1 year.
     * Return the number of inactive products.
     * @return
     */
    public int setInactive() {
        String query = "update product set status='Inactive' WHERE id NOT IN(SELECT i.product_id FROM item_list i join orders o where"
                + " o.id=i.order_number AND DATEDIFF(CURDATE(),o.date_of_order_placed)<365)";
        int numOfInactives = 0;
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            System.out.println("The SQL query is: " + query);


            numOfInactives = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numOfInactives;
    }

    /**
     * This method:
     * Select and display the category title of all top parent categories
     * sorted alphabetically and the count of their child categories.
     */
    public void showCategories(){
        String query="select DISTINCT c.parent_category, COUNT(c.parent_id) AS Numbber_Of_Children FROM category c GROUP BY c.parent_id ORDER BY c.parent_category";
        try {
            
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            System.out.println("The SQL query is: " + query);
            ResultSet rset = stmt.executeQuery();
            List<Category> parentList=new ArrayList<>();
            while (rset.next()) {
                parentList.add(new Category(rset.getString("parent_category"),rset.getInt("Numbber_Of_Children")));
            }
            
            for(Category category:parentList){
                System.out.println(category.getName()+"\t"+category.getNumberOfChildren());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * This method establishes connection with database
     * @return connection instance
     */
    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/storefront", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(2);
        }
        return conn;
    }
}