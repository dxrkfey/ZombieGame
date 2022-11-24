package code;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Home extends JPanel{
    private ImageIcon homebg = new ImageIcon(this.getClass().getResource("../image/home.jpg"));
    private ImageIcon bts = new ImageIcon(this.getClass().getResource("../image/start.png"));
    public JButton start = new JButton(bts);
    Home(){
        setLayout(null);
        start.setBounds(425, 250, 170,90);
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        add(start);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(homebg.getImage(),0,0,1000,813,this);
    }
}
