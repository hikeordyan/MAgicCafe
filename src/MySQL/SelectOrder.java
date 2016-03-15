
package MySQL;
import static MySQL.Insert.DB_URL;
import cafedesktop.Cafe;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import model.Meal;
import model.Report;
import net.proteanit.sql.DbUtils;

public class SelectOrder {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/cafe";
    final static String USER="root";
    final static String Password="";
    private static Connection conn;
    public static ResultSet res;
    private static Statement st;
    private static String success="";
    private static String query="";
    static Meal tmp = new Meal();
    public static ArrayList<Meal> mealList = new ArrayList<>();
    
    public static ResultSet getOrder(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, Password);
            query = "Select  * from `orders`";
            st = conn.createStatement();
            res = st.executeQuery(query);
          
        }
        catch(Exception e){
            System.err.println("Catch  "+e.getMessage());
        }
      return res;
    }
    
   
    public static ArrayList<Report> repList = new ArrayList<>();
    public static ArrayList<Report> getOrderForGraph(int year,int month) {
        try {
            repList.clear();
             Report rtmp;
            query = "SELect DAY(order_date_time),order_amount FROM orders  WHERE MONTH(order_date_time)="+month+" AND YEAR(order_date_time)="+year+"  GROUP BY DAY(order_date_time)";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, Password);
            st = conn.createStatement();
            res = st.executeQuery(query);
           // System.out.println(query);
            while(res.next()){
             rtmp = new Report(res.getInt(1),res.getDouble(2));
             repList.add(rtmp);
               // System.err.println(res.getInt(1)+" - " +res.getDouble(2));
            }
        } catch (Exception ex) {
            Logger.getLogger(SelectOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repList;
    }
}
