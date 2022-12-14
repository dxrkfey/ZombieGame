package code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manage extends JFrame implements ActionListener {
    Home home = new Home();
    Play p = new Play();

    Manage() {
        this.setSize(1000,813);
        this.add(home);
        home.start.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home.start) {
            this.setLocationRelativeTo(null);
            this.remove(home);
            this.setSize(1000, 813);
            this.add(p);
            p.requestFocusInWindow();
            repaint();
            p.sttt=true;
        }
    }


    public static void main(String[] args) {
        JFrame jf = new Manage();
        jf.setSize(1000,813);
        jf.setTitle("Zombie Land");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }


}
