package Employee.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewEmployee extends JFrame implements ActionListener {
    Choice choiceemp;
    JButton sear,print,update,back;
    JTable table;
    viewEmployee(){
        super("View Employee");

        getContentPane().setBackground(new Color(141, 243, 207));

        JLabel search=new JLabel("Search by employee Id");
        search.setBounds(20,20,180,20);
        add(search);

        choiceemp=new Choice();
        choiceemp.setBounds(210,20,100,20);
        add(choiceemp);


        try {
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceemp.add((resultSet.getString("empid")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table=new JTable();
        try {
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp=new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        sear=new JButton("SEARCH");
        sear.setBounds(20,70,100,20);
        sear.addActionListener(this);
        add(sear);

        print=new JButton("PRINT");
        print.setBounds(140,70,100,20);
        print.addActionListener(this);
        add(print);

        update=new JButton("UPDATE");
        update.setBounds(260,70,100,20);
        update.addActionListener(this);
        add(update);

        back=new JButton("BACK");
        back.setBounds(380,70,100,20);
        back.addActionListener(this);
        add(back);














        setLocation(300,50);
        setLayout(null);
        setSize(900,700);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==sear){
            String q="select * from employee where empid='"+choiceemp.getSelectedItem()+"'";
            try {
                Conn c=new Conn();
                ResultSet resultSet=c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==update) {
            setVisible(false);
            new updateEmployee(choiceemp.getSelectedItem());
        }else {
            setVisible(false);
            new Main();
        }
    }

    public static void main(String[] args) {
        new viewEmployee();
    }
}
