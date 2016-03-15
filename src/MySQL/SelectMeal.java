
package MySQL;

import static MySQL.Insert.DB_URL;
import cafedesktop.Cafe;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import model.Meal;
import net.proteanit.sql.DbUtils;
public class SelectMeal {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/cafe";
    final static String USER="root";
    final static String Password="";
    private static Connection conn;
    public static ResultSet res;
    public static ResultSet res1;
    private static Statement st;
    private static String success="";
    private static String query="";
    static Meal tmp = new Meal();
    public static ArrayList<Meal> mealList = new ArrayList<>();
    
    public static ResultSet getMeal(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, Password);
            query = "Select  * from `meals`";
            st = conn.createStatement();
            res = st.executeQuery(query);
            
            while(res.next()){
             mealList.add(new Meal(
                     res.getInt(1),
                     res.getString(2),
                     res.getString(4),
                     res.getDouble(3),
                     res.getInt(5),
                     res.getString(7),
                     res.getString(6)
             ));
            }
          res = st.executeQuery(query);
        }
        catch(Exception e){
            System.err.println("Catch  "+e.getMessage());
        }
      return res;
    }
    
    
   
    public static BufferedImage  getImage(int row){
            ResultSet resi;
             Blob blob =null;
             BufferedImage im=null;
            try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, Password);
            query = "Select * from `meals`";
            st = conn.createStatement();
            resi = st.executeQuery(query);
               
                for (int i=0 ;resi.next();i++) {
                
                    if(i == row){
                     blob = resi.getBlob(1);
                     im = ImageIO.read(resi.getBinaryStream("img"));
                    } 
                }
        }
        catch(Exception e){
            System.err.println("Catch image "+e);
        }
            return im;
    }
    
}
