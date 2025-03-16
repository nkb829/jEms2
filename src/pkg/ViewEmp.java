package pkg;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmp extends JFrame implements ActionListener {

    JTable table;
    Choice choiceEMP;
    JButton searchbtn, print, update, back;
    ViewEmp(){

        getContentPane().setBackground(Color.CYAN);
        JLabel search = new JLabel("Search by employee id:");
        search.setBounds(50,50,225,25);
        search.setFont(new Font("SansSerif", Font.BOLD,20));
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(300,50,150,20);
        choiceEMP.setFont(new Font("SansSerif", Font.BOLD,15));
        add(choiceEMP);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employees");
            while (resultSet.next()){
                choiceEMP.add(resultSet.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        table.setFont(new Font("SansSerif", Font.PLAIN,15));
        try{
            Conn c= new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employees");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(30,150,725,250);
        jp.setFont(new Font("SansSerif", Font.PLAIN,15));
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(50,100,100,25);
        searchbtn.addActionListener(this);
        searchbtn.setFont(new Font("SansSerif", Font.BOLD,15));
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(200,100,100,25);
        print.setFont(new Font("SansSerif", Font.BOLD,15));
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(350,100,100,25);
        update.setFont(new Font("SansSerif", Font.BOLD,15));
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(625,100,100,25);
        back.setFont(new Font("SansSerif", Font.BOLD,15));
        back.addActionListener(this);
        add(back);


        setSize(800,500);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn){
            String query = "select * from employees where empId = '"+choiceEMP.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == update){
            setVisible(false);
            new UpdateEmp(choiceEMP.getSelectedItem());
        } else {
            setVisible(false);
            new MainSc();
        }
    }

    public static void main(String[] args) {
        new ViewEmp();
    }
}
