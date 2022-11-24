package code;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;

public class Zombie {
    Image img;
    Image zd;
    public int x = (int) ((Math.random() * 900));
    public int y = 0;
    public int count = 0;
    int w = 100;
    int h = 113;

    Zombie(){
        String imageLocation = "../image/zombie.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        String image = "../image/dead.png";
        URL imageUR = this.getClass().getResource(image);
        zd = Toolkit.getDefaultToolkit().getImage(imageUR);
        rdZom.start();
    }
    Zombie(int x,int y){
        this.x=x;
        this.y=y;
        String image = "../image/dead.png";
        URL imageUR = this.getClass().getResource(image);
        zd = Toolkit.getDefaultToolkit().getImage(imageUR);
    }

    Thread rdZom = new Thread(new Runnable() {
        public void run() {
            while (true) {
                y += 5;
                if (y >= 1000) {
                    img = null;
                    rdZom = null;
                    x = (int) ((Math.random() * 200)+400);;
                    y = -10;
                }
                try {
                     rdZom.sleep(20);
                } catch (InterruptedException e) {
                }
            }
        }
    });


    public Image getImage() {
        return img;
    }

    public Image getImageDead() {
        return zd;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, w, h));
    }

}
