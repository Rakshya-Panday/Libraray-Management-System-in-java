
package lmc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class IssueBook extends JFrame implements ActionListener {
    JLabel l1,bookid,booknb,bookname,studentid,studentname,studentcontact,bquantity;
    JButton issue,cancel;
    Font f1,f2;
    JTextField tid, tnb,tname,tsid,tsname,tscontact,tquantity;
    Choice ch;
    
    
    IssueBook(){
        setTitle("Issue Book");
        setSize(800,800);
        setVisible(true);
        setLayout(null);
        f1= new Font("Arial",Font.BOLD,20);
        f2 = new Font("Arial",Font.BOLD,15);
        l1= new JLabel("ISSUE BOOK");
        l1.setBounds(350,0,250,50);
        add(l1);
        l1.setFont(f1);
        
        bookid = new JLabel("Book Id");
        bookid.setBounds(200,80,250,50);
        bookid.setFont(f2);
        add(bookid);
        
        tid = new JTextField(30);
        tid.setBounds(350,80,250,50);
        tid.setFont(f2);
        add(tid);
        
         booknb = new JLabel("Book Nb");
        booknb.setBounds(200,140,250,50);
        add(booknb);
        booknb.setFont(f2);
        
        tnb = new JTextField(30);
        tnb.setBounds(350,140,250,50);
        add(tnb);
        tnb.setFont(f2);
        
        bookname = new JLabel("Book Name");
        bookname.setBounds(200,200,250,50);
        add(bookname);
        bookname.setFont(f2);
        
        tname = new JTextField(30);
        tname.setBounds(350,200,250,50);
        add(tname);
        tname.setFont(f2);
        
        studentid = new JLabel("Student Id");
        studentid.setBounds(200,260,250,50);
        add(studentid);
        studentid.setFont(f2);
        
        tsid = new JTextField(30);
        tsid.setBounds(350,260,250,50);
        add(tsid);
        tsid.setFont(f2);

        studentname = new JLabel("Student Name");
        studentname.setBounds(200,320,250,50);
        add(studentname);
        studentname.setFont(f2);
        
        tsname = new JTextField(30);
        tsname.setBounds(350,320,250,50);
        add(tsname);
        tsname.setFont(f2);
        
        studentcontact = new JLabel("Student Contact");
        studentcontact.setBounds(200,400,250,50);
        add(studentcontact);
        studentcontact.setFont(f2);
        
        tscontact = new JTextField(30);
        tscontact.setBounds(350,400,250,50);
        add(tscontact);
        tscontact.setFont(f2);
        
        bquantity = new JLabel("Quantity");
        bquantity.setBounds(200,480,250,50);
        add(bquantity);
        bquantity.setFont(f2);
        
        tquantity = new JTextField(30);
        tquantity.setBounds(350,480,250,50);
        add(tquantity);
        tquantity.setFont(f2);
       // tquantity.setEditable(false);
        
        issue = new JButton("Issue Book");
        issue.setBounds(200,600,200,50);
        add(issue);
        issue.setFont(f1);
        issue.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450,600,200,50);
        add(cancel);
        cancel.setFont(f1);
        cancel.addActionListener(this);
     }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==issue)
        {
           int quantity =0;
            int id = Integer.parseInt(tid.getText());
            String bookno = tnb.getText();
            String bookname = tname.getText();
            int studentid = Integer.parseInt(tsid.getText());
            String studentname = tsname.getText();
            String studentcontact = tscontact.getText();
            
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
                Statement st = con.createStatement();
                String qry = "select quantity from addbook where booknb = '"+id+"'";
                ResultSet res = st.executeQuery(qry);
                while(res.next())
                {
                    quantity = Integer.parseInt(res.getString("quantity"));
                   
                    
                }
                
                if(quantity <=0)
                {
                     JOptionPane.showMessageDialog(null,"Book quantity is less than 0 ");
                      this.setVisible(false);
                }
                else
                {
                    String q1 = "Insert into issuebook (bookid,booknb,bname,sid,sname,contact,quantity)VALUES('"+id+"','"+bookno+"','"+bookname+"','"+studentid+"','"+studentname+"','"+studentcontact+"','"+quantity+"')";
                    //String q2 = "Update addbook set quantity = quantity-1 where booknb = '"+id+"'";
                    //String q3 = "Update addbok set issuebook = issuebook+1 where booknb = '"+id+"'";
                    int a = st.executeUpdate(q1);
                    //int aa= st.executeUpdate(q2);
                    //int aaa = st.executeUpdate(q3);
                    if(a==1)
                    {
                        JOptionPane.showMessageDialog(null,"Book issue Successfully");
//                        if(aa==1)
//                        {
//                            if(aaa==1)
//                            {
//                                JOptionPane.showMessageDialog(null,"Your data update sucessfully ");
//                            }
//                            else
//                            {
//                                JOptionPane.showMessageDialog(null,"Please fill all details ");
//                            }
//                        }
//                        else
//                        {
//                            JOptionPane.showMessageDialog(null,"Please fill all data carefully ");
//                        }
                    }else
                    {
                       JOptionPane.showMessageDialog(null," Please fill all data carefully"); 
                    }
                }
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
    
    }
    public static void main(String[] args) {
        new IssueBook();
    }

    
}
