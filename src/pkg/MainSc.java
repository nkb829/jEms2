package pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSc extends JFrame {
    MainSc(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/wallpaper.png"));
        Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,400);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(50,0,400,40);
        heading.setFont(new Font("SansSerif",Font.BOLD,25));
        img.add(heading);

        JButton add = new JButton("Add Employee");
        add.setFont(new Font("SansSerif",Font.BOLD,15));
        add.setBounds(50,75,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmp();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setFont(new Font("SansSerif",Font.BOLD,15));
        view.setBounds(50,125,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmp();
                setVisible(false);
            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setFont(new Font("SansSerif",Font.BOLD,15));
        rem.setBounds(50,175,150,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemEmp();
            }
        });
        img.add(rem);

        JButton close = new JButton("close");
        close.setFont(new Font("SansSerif",Font.BOLD,15));
        close.setBounds(290,185,125,30);
        close.setForeground(Color.WHITE);
        close.setBackground(Color.black);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(001);
            }
        });
        img.add(close);

        setSize(475,275);
        setLocation(475,150);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MainSc();
    }
}
