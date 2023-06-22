
package lmc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class AddBook extends JFrame implements ActionListener{
    JLabel l1,booknb,bookname,author,publisher,quantity;
    JButton add,cancel;
    Font f1,f2;
    JTextField tnb,tname,tauthor,tpublisher,tquantity;
    
    
    
    AddBook(){
        setTitle("Add Book");
        setSize(800,600);
        setVisible(true);
        setLayout(null);
        f1= new Font("Arial",Font.BOLD,20);
        f2 = new Font("Arial",Font.BOLD,15);
        l1= new JLabel("ADD BOOK");
        l1.setBounds(350,0,250,50);
        add(l1);
        l1.setFont(f1);
        
        booknb = new JLabel("Book No");
        booknb.setBounds(200,80,250,50);
        booknb.setFont(f2);
        add(booknb);
        
        tnb = new JTextField(30);
        tnb.setBounds(300,80,250,50);
        tnb.setFont(f2);
        add(tnb);
        
         bookname = new JLabel("Book Name");
        bookname.setBounds(200,140,250,50);
        add(bookname);
        bookname.setFont(f2);
        
        tname = new JTextField(30);
        tname.setBounds(300,140,250,50);
        add(tname);
        tname.setFont(f2);
        
        author = new JLabel("Author");
        author.setBounds(200,200,250,50);
        add(author);
        author.setFont(f2);
        
        tauthor = new JTextField(30);
        tauthor.setBounds(300,200,250,50);
        add(tauthor);
        tauthor.setFont(f2);
        
        publisher = new JLabel("Publisher");
        publisher.setBounds(200,260,250,50);
        add(publisher);
        publisher.setFont(f2);
        
        tpublisher = new JTextField(30);
        tpublisher.setBounds(300,260,250,50);
        add(tpublisher);
        tpublisher.setFont(f2);

        quantity = new JLabel("Quantity");
        quantity.setBounds(200,320,250,50);
        add(quantity);
        quantity.setFont(f2);
        
        tquantity = new JTextField(30);
        tquantity.setBounds(300,320,250,50);
        add(tquantity);
        tquantity.setFont(f2);
        
        add = new JButton("Add");
        add.setBounds(200,400,200,50);
        add(add);
        add.setFont(f1);
        add.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450,400,200,50);
        add(cancel);
        cancel.setFont(f1);
        cancel.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent e){
        int booknb =Integer.parseInt( tnb.getText());
        String name = tname.getText();
        String author = tauthor.getText();
        String publisher = tpublisher.getText();
        String quantity = tquantity.getText();
        
        
        if(e.getSource()==add){
       
   try{
       
        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
       Statement st = con.createStatement();
       String qry = "Insert into addbook(booknb,bookname,author,publisher,quantity)VALUES('"+booknb+"','"+name+"','"+author+"','"+publisher+"','"+quantity+"')";
       int  a= st.executeUpdate(qry);
      if(a==1){
          JOptionPane.showMessageDialog(null,"Book added successfully");
      
      }
      else{
          JOptionPane.showMessageDialog(rootPane, "There is a error in insertion of book");
      
      }
   }
   catch(Exception ae){
       System.out.println(ae);
   }  
         }
        
        if(e.getSource()==cancel){
            this.setVisible(false);
        
        }
    }
    public static void main(String[] args) {
        new AddBook();
    }
    
}
