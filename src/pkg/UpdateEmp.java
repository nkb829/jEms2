package pkg;
import com.sun.tools.javac.Main;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmp extends JFrame implements ActionListener {
    JTextField teducation, taddress, tphone, temail, tsalary, tdesignation;
    JLabel tempid;
    JButton add,back;
    String number;
    UpdateEmp(String number){

        this.number = number;
        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Update Employee Details :");
        heading.setBounds(125,25,500,50);
        heading.setFont(new Font("Serif", Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name :");
        name.setBounds(50,100,75,25);
        name.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(125,100,125,25);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel phone = new JLabel("Phone :");
        phone.setBounds(50,150,75,25);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(phone);

        tphone= new JTextField();
        tphone.setBounds(125,150,125,25);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email = new JLabel("Email :");
        email.setBounds(50,200,75,25);
        email.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(email);

        temail= new JTextField();
        temail.setBounds(125,200,125,25);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel dob = new JLabel("D O B :");
        dob.setBounds(300,100,75,25);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(375,100,125,25);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tdob);

        JLabel salary = new JLabel("Salary :");
        salary.setBounds(300,250,75,25);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(375,250,125,25);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,75,25);
        address.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(address);

        taddress= new JTextField();
        taddress.setBounds(125,250,125,25);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel education = new JLabel("HighestEd :");
        education.setBounds(300,150,75,25);
        education.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(education);

        teducation= new JTextField();
        teducation.setBounds(375,150,125,25);
        teducation.setBackground(new Color(177,252,197));
        add(teducation);

        JLabel empid = new JLabel("EmpID :");
        empid.setBounds(50,325,75,25);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(empid);

        tempid= new JLabel();
        tempid.setBounds(125,325,125,25);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel designation = new JLabel("Desg :");
        designation.setBounds(300,200,75,25);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(designation);

        tdesignation= new JTextField();
        tdesignation.setBounds(375,200,125,25);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        try {
            Conn c = new Conn();
            String query = "select * from employees where empId = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));;
                tempid.setText(resultSet.getString("empId"));
                tdesignation.setText(resultSet.getString("designation"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        add = new JButton("UPDATE");
        add.setBounds(300,400,125,30);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(125,400,125,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(575,500);
        setLayout(null);
        setLocation(450,100);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try {
                Conn c = new Conn();
                String query = "update employees set salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new MainSc();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new ViewEmp();
        }
    }

    public static void main(String[] args) {
        new UpdateEmp("");
    }
}
