package lmc;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JButton AdminLogin,UserLogin;
    JPanel p1,p2;
    Font f,f1;
    Login(){
       super("LoginPage");
       setLocation(500,300);
       setSize(500,300);
       f= new Font("Arial",Font.BOLD,25);
       f1 = new Font("Arial",Font.BOLD,20);
       
       l1 = new JLabel("Admin Login");
       l2 = new JLabel("Librarian Login");
       l3 = new JLabel("Library Management System");
       
       AdminLogin = new JButton("Login");
       UserLogin = new JButton("Login");
       AdminLogin.addActionListener(this);
       UserLogin.addActionListener(this);
       
       l1.setFont(f1);
       l2.setFont(f1);
       l3.setFont(f);
       AdminLogin.setFont(f1);
       UserLogin.setFont(f1);
       l3.setHorizontalAlignment(JLabel.CENTER);
       l3.setBackground(Color.blue);
      
       p1 = new JPanel();
       p1.setLayout(new GridLayout(2,2,10,10));
       p1.add(l1);
       p1.add(AdminLogin);
       p1.add(l2);
       p1.add(UserLogin);
      
       p2 = new JPanel();
       p2.setLayout(new GridLayout(1,1,10,10));
       p2.add(l3);
       
       setLayout(new BorderLayout(10,10));
       add(l3,BorderLayout.NORTH);
       add(p1,BorderLayout.CENTER);
       
      setVisible(true);
  }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==AdminLogin)
        {
            System.out.println("Admin Login");
            new Admin().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==UserLogin)
        {
            System.out.println("User Login");
            new Librarian().setVisible(true);
            this.setVisible(false);
        }
     }
    public static void main(String[] args)
    {
        new Login();
    }
    
}
