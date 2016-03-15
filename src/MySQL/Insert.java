package MySQL;
import com.sun.net.httpserver.Authenticator;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Meal;

public class Insert {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/cafe";
    final static String USER="root";
    final static String Password="";
    private static Connection conn=null;
    private static Statement st=null;
    private static String success="";
    
    public static String InsertData(Meal m){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, Password);
            st = conn.createStatement();
            st.executeUpdate("INSERT INTO `meals` (meal_name , meal_price ,meal_category ,img , details) "
                    + "Values "+m.toString());
            //System.out.println(m.toString());
            JOptionPane.showMessageDialog(null, "Տվյալները հաջողությամբ ավելացված են");
        }
        catch(Exception e){
       //     System.out.println("exeption  "+e.getMessage()+"\n"+m.toString());
            success = e.getMessage()+"\n"+m.toString();
            JOptionPane.showMessageDialog(null, "Սխալ \n"+e.getMessage());
        }
        
        return success;
    }
    
}
