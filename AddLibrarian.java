package lmc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class AddLibrarian extends JFrame implements ActionListener
{
    JLabel l1,name,address,contact,email,city ,password;
    JButton add;
    Font f1,f2;
    JTextField tname,taddress,tcontact,temail,tcity;
    JPasswordField tp1;
    
    AddLibrarian()
    {
        setTitle("Add Librarian");
        setSize(800,800);
        setVisible(true);
        setLayout(null);
        f1= new Font("Arial",Font.BOLD,20);
        f2 = new Font("Arial",Font.BOLD,15);
        l1= new JLabel("ADD LIBRARIAN");
        l1.setBounds(200,0,250,50);
        add(l1);
        l1.setFont(f1);
        
        name = new JLabel("Name");
        name.setBounds(200,80,250,50);
        name.setFont(f2);
        add(name);
        
        tname = new JTextField(30);
        tname.setBounds(280,80,250,50);
        tname.setFont(f2);
        add(tname);
        
         password = new JLabel("Password");
        password.setBounds(200,140,250,50);
        add(password);
        password.setFont(f2);
        
        tp1 = new JPasswordField(30);
        tp1.setBounds(280,140,250,50);
        add(tp1);
        tp1.setFont(f2);
        
        address = new JLabel("Address");
        address.setBounds(200,200,250,50);
        add(address);
        address.setFont(f2);
        
        taddress = new JTextField(30);
        taddress.setBounds(280,200,250,50);
        add(taddress);
        taddress.setFont(f2);
        
        contact = new JLabel("Contact");
        contact.setBounds(200,260,250,50);
        add(contact);
        contact.setFont(f2);
        
        tcontact = new JTextField(30);
        tcontact.setBounds(280,260,250,50);
        add(tcontact);
        tcontact.setFont(f2);

        email = new JLabel("Email");
        email.setBounds(200,320,250,50);
        add(email);
        email.setFont(f2);
        
        temail = new JTextField(30);
        temail.setBounds(280,320,250,50);
        add(temail);
        temail.setFont(f2);
        
        city = new JLabel("City");
        city.setBounds(200,390,250,50);
        add(city);
        city.setFont(f2);
        
        tcity = new JTextField(30);
        tcity.setBounds(280,390,250,50);
        add(tcity);
        tcity.setFont(f2);
        
        add = new JButton("Add");
        add.setBounds(280,480,200,50);
        add(add);
        add.setFont(f1);
        add.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent e)
    {
        
        String name = tname.getText();
        String passwords =  new String(tp1.getPassword());
        String address = taddress.getText();
        String city = tcity.getText();
        String email = temail.getText();
        String contact = tcontact.getText();
        if(e.getSource()==add)
        {
            
   
                try{

                     Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
                    Statement st = con.createStatement();
                    String qry = "Insert into addlibrarian(name,password,address,email,contact,city)VALUES('"+name+"','"+passwords+"','"+address+"','"+email+"','"+contact+"','"+city+"')";
                    int  a= st.executeUpdate(qry);
                   if(a==1)
                   {
                       JOptionPane.showMessageDialog(null,"Librarian Added successfully");

                   }
                   else
                   {
                       JOptionPane.showMessageDialog(rootPane, "There is a error in insertion of data");

                   }
                }
                catch(Exception ae)
                {
                    System.out.println(ae);
                }
    
         }
    }
    public static void main(String[] args) 
    {
        new AddLibrarian();
    }
}
            
        
    
    
    
    
    

