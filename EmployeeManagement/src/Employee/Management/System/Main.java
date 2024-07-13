package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    Main(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);


        JLabel label1=new JLabel("Employee Management System");
        label1.setBounds(320,155,500,30);
        label1.setFont(new Font("Raleway",Font.BOLD,23));
        image.add(label1);

        JButton add=new JButton("Add Employee");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(335,270,150,40);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addEmployee();
                setVisible(false);
            }
        });
        image.add(add);

        JButton view=new JButton("View Employee");
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.setBounds(565,270,150,40);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new viewEmployee();
                setVisible(false);
            }
        });
        image.add(view);

        JButton remove=new JButton("Remove Employee");
        remove.setForeground(Color.white);
        remove.setBackground(Color.black);
        remove.setBounds(440,370,200,40);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new removeEmployee();
            }
        });
        image.add(remove);




        setLocation(150,80);
        setLayout(null);
        setSize(1120,630);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Main();
    }
}
