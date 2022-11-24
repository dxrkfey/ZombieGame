package code;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {
    Play sc = new Play();

    GameOver(){
        this.setSize(1000,813);
        this.setBackground(new Color(241, 98, 69));
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TH Chakra Petch", Font.CENTER_BASELINE, 80));
        g.drawString("Game Over",600,300);
    }
}
