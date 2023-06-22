package lmc;
import java.awt.BorderLayout;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ViewLibrarian extends JFrame
{
    JTable table;
    String[] columnsNames = {"Name","Address","Email","Contact","City"};
    
    ViewLibrarian()
    {
        
        setTitle("Librarian Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers( columnsNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        int contact;
        String name,address,email,city;
        
        try
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String qry ="select * from addlibrarian";
            ResultSet rs = st.executeQuery(qry);
            while(rs.next())
            {
               name=rs.getString(1);
               address =rs.getString(2);
               email =rs.getString(3);
               contact = rs.getInt(4);
               city =rs.getString(5);
               model.addRow(new Object[] {name,address,email,contact,city});
                
            }
        }
            
        catch(Exception e)
        {
            System.out.println(e);
           
        }
        setVisible(true);
        add(scroll);
        setSize(500,500);
    }
   
    
    public static void main(String[] args)
    {
       ViewLibrarian v = new ViewLibrarian();
      
    }
    
}
