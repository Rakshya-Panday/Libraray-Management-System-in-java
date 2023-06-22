
package lmc;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class returnbook  extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JPanel p1,p2;
    JButton back,cancel;
    JTextField t1,t2;
   
    
    
    returnbook()
    {
            
      addComponent();
         initUi();
    }
     public void addComponent(){
         p1 = new JPanel();
         add(p1);
         l1 = new JLabel("Return Book");
         l1.setBounds(100,15,100,50);
         l1.setForeground(Color.WHITE);
         p1.setBackground(Color.BLUE);
         p1.setBounds(0,0,750,50);
         p1.setLayout(new BorderLayout());
         p1.add(l1);
        
        p2 = new JPanel();
        add(p2);
        l2 = new JLabel("Book No");
        l2.setBounds(30,40,0,0);
        t1 = new JTextField(30);
        l3 = new JLabel("Student ID");
        t2 = new JTextField(30);
        back = new JButton("Return Book");
        back.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);

        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(back);
        p2.add(cancel);
        p2.setLayout(new FlowLayout());
        p2.setBounds(0,150,400,100);
          
    }
     
    public void initUi(){
           setTitle("Return Book ");
           setSize(500,500);
           setLayout(null);
           setVisible(true);
    }
    

     @Override
    
    public void actionPerformed(ActionEvent e)
       {
           if(e.getSource()==back)
           {
               int bnb = Integer.parseInt(t1.getText());
               int sid = Integer.parseInt(t2.getText());
               try
               {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
                   Statement st = con.createStatement();
                   String qry = "Delete from issuebook where booknb = '"+bnb+"' and sid = '"+sid+"'";
                   int res = st.executeUpdate(qry);
                   if(res==0)
                   {
                       JOptionPane.showMessageDialog(null,"Book is not issue");
                       
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null,"Return Book Sucessfull");
                       
                   }
                  
                   
               }
               catch(Exception ae)
               {
               }
           }
           if(e.getSource()==cancel)
           {
               JOptionPane.showMessageDialog(null,"Are u sure to exit");
               this.setVisible(false);
           }
        
       
       }
        
        
    
    
    public static void main(String[] args)
    {
        new returnbook();
    }
    
}
