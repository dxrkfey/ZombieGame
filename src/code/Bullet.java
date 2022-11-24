package code;

import javax.swing.*;
import java.awt.geom.Rectangle2D;

public class Bullet {
    public ImageIcon bullet = new ImageIcon(this.getClass().getResource("../image/bullet.png"));
    int x;
    int y;
    int w = 10;
    int h = 30;
    public int count=0;
    Bullet(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void move(){
        this.y-=10;
    }

    public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,50,h));
    }

}
