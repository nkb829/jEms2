package pkg;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/EMScreen.png"));
        Image i2 = i1.getImage().getScaledInstance(1000,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,500);
        add(image);


        setSize(1000,500);
        setLocation(275,100);
        setLayout(null);
        setVisible(true);

        try{
            Thread.sleep(2000);
            setVisible(false);
            new MainSc();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Splash();
    }
}