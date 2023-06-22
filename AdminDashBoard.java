package lmc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashBoard extends JFrame implements ActionListener
{
    JLabel l1;
    JButton add,view,delete,logout;
    Font f;
    AdminDashBoard(){
        setTitle("DashBoard");
        setSize(500,500);
        setVisible(true);
        setLayout(null);
        l1 = new JLabel("Dashboard of Admin");
        l1.setBounds(150,0,200,50);
        f= new Font("Arial",Font.BOLD,20);
        l1.setBackground(Color.BLUE);
        l1.setFont(f);
        add(l1);
        
        add = new JButton("Add");
        add.setBounds(150,100,200,50);
        add.addActionListener(this);
        add(add);
        view = new JButton("View");
        view.setBounds(150,160,200,50);
        view.addActionListener(this);
        add(view);
        delete = new JButton("Delete");
        delete.setBounds(150,220,200,50);
        delete.addActionListener(this);
        add(delete);
        logout = new JButton("Logout");
        logout.setBounds(150,280,200,50);
        logout.addActionListener(this);
        add(logout);
        
    
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add){
            System.out.println("Add");
            new AddLibrarian();
        }
        
         if(e.getSource()== view){
        
            System.out.println("View");
            new ViewLibrarian();
        }
         
         if(e.getSource()==delete){
             System.out.println("Delete");
             new Delete();
         
         }
    
    }
    public static void main(String[] args)
    {
        new AdminDashBoard();
    }
    
}
