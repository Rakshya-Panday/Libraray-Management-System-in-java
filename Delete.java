package lmc;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class Delete extends JFrame implements ActionListener{
    JLabel l;
    JButton delete;
    JTextField t1;
     JTable table;
    String[] columnsNames = {"Name","Address","Email","Contact","City"};
    
     Delete(){
        
        setTitle("Librarian Details");
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
        int contact;
        String name,address,email,city;
        
        l= new JLabel("Delete Librarian");
        l.setBounds(10,360,100,35);
        add(l);
          t1 = new JTextField("");
        t1.setBounds(110,360,150,35);
        add(t1);
         
        delete = new JButton("Delete");
        delete.addActionListener(this);
        delete.setBounds(350,400,100,30);
        add(delete);
        t1 = new JTextField("30");
        t1.setBounds(150,360,250,50);
        add(t1);
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String qry ="select * from addlibrarian";
            ResultSet rs = st.executeQuery(qry);
            while(rs.next()){
               name=rs.getString(1);
               address =rs.getString(2);
               email =rs.getString(3);
               contact = rs.getInt(4);
               city =rs.getString(5);
               model.addRow(new Object[] {name,address,email,contact,city});
                
            }
        }
            
        catch(Exception e){
            System.out.println(e);
           
        }
        
       setVisible(true);
        add(scroll);
        setSize(500,500);
    
    }
      public void actionPerformed(ActionEvent e){
          if(e.getSource()==delete){
              System.out.println("delete");
              String name = t1.getText();
              try{
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
                  Statement st = con.createStatement();
                 String str = "Delete From addlibrarian Where name = '"+name+"'";
                 int a = st.executeUpdate(str);
                 if(a ==1){
                     JOptionPane.showMessageDialog(null,"Data deleted successfully");
                 
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Librarian Deleted Successfully");
                 
                 }
                  
              
              }
              catch(Exception ee){
                  System.out.println(ee);
              
              }
          
          }
      
      }
   
    
    public static void main(String[] args) {
        new Delete();
       
    }
    
}

