package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    TextField tusername;
    JPasswordField tpassword;
    JButton b1,b2;
    Login(){

        JLabel username=new JLabel("Username");
        username.setBounds(40,30,100,30);
        add(username);

        tusername=new TextField();
        tusername.setBounds(150,30,200,25);
        add(tusername);

        JLabel password=new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword=new JPasswordField();
        tpassword.setBounds(150,70,200,25);
        add(tpassword);


        b1=new JButton("LOG IN");
        b1.setBounds(120,160,150,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("EXIT");
        b2.setBounds(120,200,150,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image ii2=ii1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel imagee=new JLabel(ii3);
        imagee.setBounds(400,0,600,380);
        add(imagee);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,600,300);
        add(image);








        setSize(600,300);
        setLayout(null);
        setVisible(true);
        setLocation(450,200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try {
                String username=tusername.getText();
                String password=tpassword.getText();
                Conn c=new Conn();
                String q="select * from login where useername='"+username+"' and password='"+password+"'";
                ResultSet resultSet=c.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new Main();
                }else {
                    JOptionPane.showMessageDialog(null,"Inavlid username or password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }
        }else if (e.getSource()==b2){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
