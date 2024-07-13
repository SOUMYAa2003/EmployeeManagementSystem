package Employee.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class addEmployee extends JFrame implements ActionListener {
    Random ran=new Random();
    int number=ran.nextInt(999999);
    JTextField tname,tfname,taddress,tphone, tdesignation,temail,tsalary,taadhar;
    JLabel tempid;
    JButton add,back;
    JDateChooser tdob;
    JComboBox Boxeducation;
    addEmployee(){
        super("Add Employee");


        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name=new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname=new JTextField();
        tname.setBounds(220,150,200,25);
      //  tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(470,150,200,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname=new JTextField();
        tfname.setBounds(680,150,200,25);
        //tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50,220,200,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        tdob=new JDateChooser();
        tdob.setBounds(220,220,200,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        JLabel fsalary=new JLabel("Salary");
        fsalary.setBounds(470,220,200,30);
        fsalary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fsalary);

        tsalary=new JTextField();
        tsalary.setBounds(680,220,200,25);
      //  tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address=new JLabel("Address");
        address.setBounds(50, 290,200,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress=new JTextField();
        taddress.setBounds(220,290,200,25);
        //taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone=new JLabel("Phone Number");
        phone.setBounds(470,290,200,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(680,290,200,25);
        //tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email=new JLabel("Email");
        email.setBounds(50,360,200,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail=new JTextField();
        temail.setBounds(220,360,200,25);
        //temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel educat=new JLabel("Highest Education");
        educat.setBounds(470,360,250,30);
        educat.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(educat);

        String items[]={"BBA","B.Tech","BCA","BA","BSC,B.COM","MBA","MCA","MA","M.Tech","MSC","PHD"};
        Boxeducation=new JComboBox(items);
        Boxeducation.setBounds(680,360,150,30);
        //education.setBackground(new Color(177,252,197));
        add(Boxeducation);

        JLabel addhar=new JLabel("Aadhaar");
        addhar.setBounds(50,430,200,30);
        addhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(addhar);

        taadhar =new JTextField();
        taadhar.setBounds(220,430,200,25);
        //taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel empid=new JLabel("Employee Id");
        empid.setBounds(470,430,200,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid=new JLabel(""+number);
        tempid.setBounds(680,430,200,25);
        tempid.setFont(new Font("SANS_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.red);
        add(tempid);

        JLabel designation=new JLabel("Designation");
        designation.setBounds(50,500,200,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation=new JTextField();
        tdesignation.setBounds(220,500,200,25);
        //taadhar.setBackground(new Color(177,252,197));
        add(tdesignation);

        add=new JButton("ADD");
        add.setBounds(280,600,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back=new JButton("BACK");
        back.setBounds(500,600,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);




        setLocation(300,50);
        setLayout(null);
        setSize(900,700);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String name=tname.getText();
            String fname=tfname.getText();
            String dob=((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=(String)Boxeducation.getSelectedItem();
            String designation=tdesignation.getText();
            String empid=tempid.getText();
            String aadhar=taadhar.getText();

            try {
                Conn c=new Conn();
                String q="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details added");
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
        new addEmployee();
    }
}
