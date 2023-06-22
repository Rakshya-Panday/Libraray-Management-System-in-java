//
package lmc;
//
import java.sql.*;
public class connection {
     
    
 public void   connection(){
   String url = "jdbc:mysql://localhost:3306/library";
   String username = "root";
   String password = "";
   
   try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,username,password);
       Statement st = con.createStatement();
   
   }
   catch(Exception e){
       System.out.println(e);
   }
    
    
    }

}
