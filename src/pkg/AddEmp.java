package pkg;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmp extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tname, taddress, tphone, temail, tsalary, tdesignation;
    JLabel tempid;
    JDateChooser tdob;

    JButton add, back;

    JComboBox Boxeducation;

    AddEmp() {

        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Add Employee Details :");
        heading.setBounds(225, 0, 325, 50);
        heading.setFont(new Font("SansSerif", Font.BOLD, 28));
        add(heading);

        JLabel name = new JLabel("Name :");
        name.setBounds(300, 75, 75, 25);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(400, 75, 125, 25);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        JLabel phone = new JLabel("Phone :");
        phone.setBounds(300, 125, 75, 25);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(400, 125, 125, 25);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        JLabel email = new JLabel("Email :");
        email.setBounds(300, 175, 75, 25);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(400, 175, 125, 25);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        JLabel dob = new JLabel("D O B :");
        dob.setBounds(50, 225, 100, 25);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(150, 225, 100, 25);
        tdob.setBackground(new Color(177, 252, 197));
        add(tdob);

        JLabel address = new JLabel("Address :");
        address.setBounds(50, 275, 100, 25);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(150, 275, 100, 25);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel empid = new JLabel("Emp ID :");
        empid.setBounds(50, 325, 100, 25);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel("" + number);
        tempid.setBounds(150, 325, 100, 25);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel education = new JLabel("Highest Education :");
        education.setBounds(300, 225, 100, 25);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        String items[] = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177, 252, 197));
        Boxeducation.setBounds(400, 225, 125, 25);
        add(Boxeducation);

        JLabel designation = new JLabel("Desg :");
        designation.setBounds(300, 275, 100, 25);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(400, 275, 125, 25);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        JLabel salary = new JLabel("Salary :");
        salary.setBounds(300, 325, 100, 25);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(400, 325, 125, 25);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        add = new JButton("ADD");
        add.setBounds(300, 400, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(125, 400, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/useradd.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(50, 50, 150, 150);
        add(img);

        setSize(600, 525);
        setLayout(null);
        setLocation(425, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empID = tempid.getText();

            try {
                Conn c = new Conn();
                String query = "insert into employees values('" + name + "', '" + dob + "', '" + salary + "','" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "', '" + empID + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new MainSc();

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            setVisible(false);
            new MainSc();
        }
    }

    public static void main(String[] args) {
        new AddEmp();
    }
}
