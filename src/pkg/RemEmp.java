package pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemEmp extends JFrame implements ActionListener {
    Choice choiceEMPID;
    JButton delete, back;
    RemEmp(){

        JLabel label = new JLabel("Employee ID :");
        label.setBounds(50,50,150,30);
        label.setFont(new Font("SansSerif", Font.BOLD,20));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        choiceEMPID.setFont(new Font("SansSerif", Font.BOLD,20));
        add(choiceEMPID);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employees");
            while (resultSet.next()){
                choiceEMPID.add(resultSet.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,150,30);
        labelName.setFont(new Font("SansSerif", Font.BOLD,18));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,150,30);
        textName.setFont(new Font("SansSerif", Font.BOLD,18));
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50,150,150,30);
        labelPhone.setFont(new Font("SansSerif", Font.BOLD,18));
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200,150,150,30);
        textPhone.setFont(new Font("SansSerif", Font.BOLD,18));
        add(textPhone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,150,30);
        labelemail.setFont(new Font("SansSerif", Font.BOLD,18));
        add(labelemail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,150,30);
        textEmail.setFont(new Font("SansSerif", Font.BOLD,18));
        add(textEmail);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employees where empId = '"+choiceEMPID.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employees where empId = '"+choiceEMPID.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(100,300,100,30);
        delete.setFont(new Font("SansSerif", Font.PLAIN,20));
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(250,300,100,30);
        back.setFont(new Font("SansSerif", Font.PLAIN,20));
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400,75 ,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,1120,630);
        add(image);

        setSize(650,400);
        setLocation(450,150);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            try {
                Conn c = new Conn();
                String query = "delete from employees where empId = '"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Deleted Sucessfully");
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
        new RemEmp();
    }
}
