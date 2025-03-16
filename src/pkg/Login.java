package pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, close;

    Login(){

        JLabel username = new JLabel("USERNAME");
        username.setFont(new Font("SansSerif",Font.BOLD, 15));
        username.setBounds(30,140,125,30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(130,140,125,30);
        add(tusername);

        JLabel password = new JLabel("PASSWORD");
        password.setFont(new Font("SansSerif", Font.BOLD, 15));
        password.setBounds(30,180,125,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(130,180,125,30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(80,250,125,30);
        login.setBackground(Color.GREEN);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        close = new JButton("CLOSE");
        close.setBounds(80,300,125,30);
        close.setBackground(Color.ORANGE);
        close.setForeground(Color.BLACK);
        close.addActionListener(this);
        add(close);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(100,0,250,200);
        add(imgg);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,300,400);
        add(img);

        setSize(300,400);
        setLocation(600 ,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            try {
                String username = tusername.getText();
                String password = tpassword.getText();

                Conn conn = new Conn();
                String query = "select * from login where username = '"+ username +"' and password = '"+password+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new MainSc();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == close) {
            System.exit(524);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
