package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateEmployee extends JFrame implements ActionListener {
    JTextField tname,tfname,taddress,tphone, tdesignation,temail,tsalary,taadhar,teducation;
    JLabel tempid;
    JButton add,back;
    String empIdnum;
    updateEmployee(String empIdnum) {

        this.empIdnum=empIdnum;

        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(220, 150, 200, 25);
        //  tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(470, 150, 200, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(680, 150, 200, 25);
        //tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 220, 200, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(220, 220, 200, 30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
        add(tdob);

        JLabel fsalary = new JLabel("Salary");
        fsalary.setBounds(470, 220, 200, 30);
        fsalary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fsalary);

        tsalary = new JTextField();
        tsalary.setBounds(680, 220, 200, 25);
        //  tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 290, 200, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(220, 290, 200, 25);
        //taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(470, 290, 200, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(680, 290, 200, 25);
        //tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 360, 200, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(220, 360, 200, 25);
        //temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel educat = new JLabel("Highest Education");
        educat.setBounds(470, 360, 250, 30);
        educat.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(educat);

        teducation = new JTextField();
        teducation.setBounds(680, 362, 200, 25);
        //te.setBackground(new Color(177,252,197));
        add(teducation);

        JLabel addhar = new JLabel("Aadhaar");
        addhar.setBounds(50, 430, 200, 30);
        addhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(addhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(220, 430, 200, 25);
        //taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel empid = new JLabel("Employee Id");
        empid.setBounds(470, 430, 200, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel("");
        tempid.setBounds(680, 430, 200, 25);
        tempid.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.red);
        add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 500, 200, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(220, 500, 200, 25);
        //taadhar.setBackground(new Color(177,252,197));
        add(tdesignation);

        try{
            Conn c=new Conn();
            String q="select * from employee where empid='"+empIdnum+"'";
            ResultSet resultSet=c.statement.executeQuery(q);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                tsalary.setText(resultSet.getString("salary"));
                taddress.setText(resultSet.getString("address"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                tdesignation.setText(resultSet.getString("designation"));
                taadhar.setText(resultSet.getString("aadhar"));
                tempid.setText(resultSet.getString("empid"));



            }
        }catch (Exception e){
            e.printStackTrace();
        }

        add = new JButton("UPDATE");
        add.setBounds(280, 600, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(500, 600, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setLocation(300, 50);
        setLayout(null);
        setSize(900, 700);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String fname=tfname.getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=teducation.getText();
            String designation=tdesignation.getText();

            try {
                Conn c=new Conn();
                String q="update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empid='"+empIdnum+"'";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details updated successfully");
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
        new updateEmployee("");
    }
}
