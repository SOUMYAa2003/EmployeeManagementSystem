package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class removeEmployee extends JFrame implements ActionListener {
    Choice choiceemp;
    JButton delete,back;
    removeEmployee(){
        super("Remove Employee");

        JLabel label=new JLabel("Employee Id");
        label.setBounds(50,20,150,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceemp=new Choice();
        choiceemp.setBounds(200,20,150,20);
        add(choiceemp);

        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceemp.add(resultSet.getString("empid"));
            }
        }catch (Exception  e){
            e.printStackTrace();
        }

        JLabel labelName=new JLabel("Name");
        labelName.setBounds(50,100,150,30);
        labelName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelName);

        JLabel textName=new JLabel();
        textName.setBounds(200,100,100,30);
        add(textName);

        JLabel labelPhone=new JLabel("Phone");
        labelPhone.setBounds(50,150,100,30);
        labelPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelPhone);

        JLabel textPhone=new JLabel();
        textPhone.setBounds(200,150,100,30);
        add(textPhone);

        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,200,150,30);
        labelemail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelemail);

        JLabel textemail=new JLabel();
        textemail.setBounds(200,200,100,30);
        add(textemail);

        try {
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee where empid='"+choiceemp.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        choiceemp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                try {
                    Conn c=new Conn();
                    ResultSet resultSet=c.statement.executeQuery("select * from employee where empid='"+choiceemp.getSelectedItem()+"'");
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete=new JButton("DELETE");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back=new JButton("BACK");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon("icons/delete.png");
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(600,80,200,200);
        add(img);

        ImageIcon i11=new ImageIcon("icons/rback.png");
        Image i22=i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel imgg=new JLabel(i33);
        imgg.setBounds(0,0,920,630);
        add(imgg);






        setLocation(300,50);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            try {
                Conn c=new Conn();
                String q=" delete from employee where empid ='"+choiceemp.getSelectedItem()+"'";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Employee deleted succesfully");
                setVisible(false);
                new Main();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new Main();
        }
    }

    public static void main(String[] args) {
        new removeEmployee();
    }
}
