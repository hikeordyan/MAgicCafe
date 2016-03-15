/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Stuff;
import net.proteanit.sql.DbUtils;
public class SelectStuff {
    
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
    public static ArrayList<Stuff> stuffList = new ArrayList<>();
    
    public static ResultSet getStuff(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, Password);
            query = "Select  * from `stuff`";
            st = conn.createStatement();
            res = st.executeQuery(query);
            
            while(res.next()){
             stuffList.add(new Stuff(
                     res.getString(1),
                     res.getString(2),
                     res.getString(3),
                     res.getInt(4),
                     res.getString(5),
                     res.getInt(6)
                    
             ));
            }
          res = st.executeQuery(query);
        }
        catch(Exception e){
            System.err.println("Catch  Stuff"+e.getMessage());
        }
      return res;
    }
    
    
   
   
    
}