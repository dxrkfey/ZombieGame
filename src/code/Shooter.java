package code;

import javax.swing.*;
import java.awt.geom.Rectangle2D;

public class Shooter {
    int x = 443;
    int y = 600;
    int w = 100;
    int h = 141;

    public ImageIcon shooter = new ImageIcon(this.getClass().getResource("../image/up.png"));
    Shooter(){
    }
    public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,100,130));
    }
}
