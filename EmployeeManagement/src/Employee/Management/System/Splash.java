package Employee.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame{
    Splash(){
        super("Employee Management");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image i2= i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);








        setSize(1170,650);
        setLayout(null);
        setVisible(true);
        setLocation(100,50);

        try{
            Thread.sleep(4500);
            setVisible(false);
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
