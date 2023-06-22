
package lmc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LibrarianDashBoard extends JFrame implements ActionListener {
    JLabel l1;
    JButton add,view,issue,logout,viewissue,back;
    Font f;
    LibrarianDashBoard(){
        setTitle(" Librarian DashBoard");
        setSize(500,600);
        setVisible(true);
        setLayout(null);
        l1 = new JLabel("Dashboard of Librarian");
        l1.setBounds(150,0,200,50);
        f= new Font("Arial",Font.BOLD,20);
        l1.setBackground(Color.BLUE);
        l1.setFont(f);
        add(l1);
        
        add = new JButton("Add Book");
        add.setBounds(150,100,200,50);
        add.addActionListener(this);
        add(add);
        view = new JButton("View Book");
        view.setBounds(150,160,200,50);
        view.addActionListener(this);
        add(view);
        issue = new JButton("Issue Book");
        issue.setBounds(150,220,200,50);
        issue.addActionListener(this);
        add(issue);
        
        viewissue = new JButton("View Issued Book");
        viewissue.setBounds(150,280,200,50);
        viewissue.addActionListener(this);
        add(viewissue);
        
        back = new JButton("Return Book");
        back.setBounds(150,340,200,50);
        back.addActionListener(this);
        add(back);
        
        
        logout = new JButton("Logout");
        logout.setBounds(150,400,200,50);
        logout.addActionListener(this);
        add(logout);
        
       
        }
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==add){
                System.out.println("Add");
            }
            
            if(e.getSource()==view){
                System.out.println("View");
            }
            
            if(e.getSource()==issue){
            
                System.out.println("Issue Book");
            }
            if(e.getSource()==back){
                System.out.println("Return Book");
                
            
            }
        
        
        
    
    
    
    }
    public static void main(String[] args) {
        new LibrarianDashBoard();
    }
    
}
