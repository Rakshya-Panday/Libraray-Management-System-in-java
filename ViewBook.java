
package lmc;

import java.awt.BorderLayout;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
public class ViewBook extends JFrame {
    JTable table;
    String[] columnsNames = {"Book Nb","BookName","Author","Publisher","Quantity"};
    
    ViewBook(){
        
        setTitle("Book Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers( columnsNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        int booknb,quantity;
        String bookname,author,publisher;
        
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String qry ="select * from addbook";
            ResultSet rs = st.executeQuery(qry);
            while(rs.next()){
               booknb=rs.getInt(1);
               bookname =rs.getString(2);
               author =rs.getString(3);
               publisher = rs.getString(4);
               quantity = rs.getInt(5);
              
               model.addRow(new Object[] {booknb,bookname,author,publisher,quantity});
                
            }
        }
            
        catch(Exception e){
            System.out.println(e);
           
        }
       setVisible(true);
        add(scroll);
        setSize(500,500);
        
        
        
        
    }
   
    
    public static void main(String[] args) {
       ViewBook v = new ViewBook();
       //v.createGUI();
    }
    
    
    
}
