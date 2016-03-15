
package MySQL;
import com.sun.net.httpserver.Authenticator;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Meal;

public class UpdateMealData {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/cafe";
    final static String USER="root";
    final static String Password="";
    private static Connection conn=null;
    private static Statement st=null;
    private static String success="";
    
    public static String Update(String query){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, Password);
            st = conn.createStatement();
            st.executeUpdate(query);
           
        }
        catch(Exception e){
            System.out.println("update exeption  "+e.getMessage()+"\n");
            success = e.getMessage()+"\n";
        }
        
        return success;
    }
}
