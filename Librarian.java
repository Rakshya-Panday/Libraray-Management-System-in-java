
package lmc;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Librarian extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JPanel p1,p2;
    JButton login,cancel;
    JTextField t1;
    JPasswordField tp1;
    ResultSet rs;
    Statement st;
    
    Librarian(){
            addComponent();
            initUi();

    }
    public void addComponent(){
         p1 = new JPanel();
        add(p1);
        l1 = new JLabel("Librarian Login");
        l1.setBounds(5,15,100,50);
        p1.setBackground(Color.BLUE);
        p1.setBounds(0,0,750,50);
        p1.setLayout(new BorderLayout());
        p1.add(l1);
        p2 = new JPanel();
        add(p2);
        l2 = new JLabel("username");
        l2.setBounds(30,40,0,0);
        t1 = new JTextField(30);
        l3 = new JLabel("passowrd");
        tp1 = new JPasswordField(30);
        login = new JButton("Login");
        login.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);

        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(tp1);
        p2.add(login);
        p2.add(cancel);
        p2.setLayout(new FlowLayout());
        p2.setBounds(0,150,400,100);
          
    }
     
    public void initUi(){
           setTitle("Librarian Login");
        setSize(500,500);
        setLayout(null);
                setVisible(true);
    }
    
     @Override
    
    public void actionPerformed(ActionEvent e){
         
        
        
        if(e.getSource()==login){
            
        String name = t1.getText();
        String pass = new String(tp1.getPassword());
       
        
            try{
                
//                Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            Statement st = con.createStatement();
                String qry = "Select name,password from addlibrarian where name ='"+name+"' and password='"+pass+"'";
                System.out.println(qry);
            st.executeQuery(qry);
                rs = st.executeQuery(qry);
            //Insert the data into database.

                if(rs.next()==true)
                {
                    System.out.println("Librarian Login");
//                    new AdminDashboard().setVisible(true);
                     this.setVisible(false);
                      dispose();
                    LibrarianDashBoard ad = new LibrarianDashBoard();
                    
                
                }
                else{
                    JOptionPane.showMessageDialog(null,"ur name n password is wrng" );
                    this.setVisible(true);
                }
            }
            catch(Exception ae){
                ae.printStackTrace();
            
            }
       
       }
        
        if(e.getSource()==cancel){
        this.setVisible(false);
        }
        
    
    }
    
    public static void main(String[] args) {
        new Librarian();
    }
    
    
}
