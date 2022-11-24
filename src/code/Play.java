package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class Play extends JPanel{
    int delay = 6;

    public boolean over = false;
    private int score=0;
    private int t = 0;
    public ImageIcon bg1 = new ImageIcon(this.getClass().getResource("../image/bg.png"));
    public ImageIcon bgover = new ImageIcon(this.getClass().getResource("../image/red.png"));

    Shooter me = new Shooter();

    public ArrayList<Bullet> bull = new ArrayList<Bullet>();
    public ArrayList<Zombie> zom = new ArrayList<Zombie>();
    public ArrayList<Zombie> dead = new ArrayList<Zombie>();
    Play(){
        this.setFocusable(true);
        this.setSize(1000,813);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int a = e.getKeyCode();
               if (e.getKeyCode()==KeyEvent.VK_D|e.getKeyCode()==KeyEvent.VK_RIGHT) {
                   me.x += 50;
                } else if (e.getKeyCode()==KeyEvent.VK_A|e.getKeyCode()==KeyEvent.VK_LEFT) {
                   me.x -= 50;
               } else if (e.getKeyCode()==KeyEvent.VK_SPACE) {
                   bull.add(new Bullet(me.x, 550));
                   Shoot.start();
               }
               repaint();
               actor.start();
            }
        });
        delayTime.start();
        time.start();
        newX.start();
        addZom.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg1.getImage(), 0, 0, 1000, 813, this);
        g.drawImage(me.shooter.getImage(), me.x, me.y, me.w, me.h, this);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TH Chakra Petch", Font.CENTER_BASELINE, 50));
        g.drawString("SCORE : " + score, 50, 50);
        g.drawString("Time : " + t, 800, 50);

        for(int i=delay;i>0;i--){
            g.setColor(Color.WHITE);
            g.setFont(new Font("TH Chakra Petch", Font.CENTER_BASELINE, 300));
            g.drawString(""+delay,450,400);
        }

        for (int i = 0; i < dead.size(); i++) {
            g.drawImage(dead.get(i).getImageDead(), dead.get(i).getX(), dead.get(i).getY(), 95, 148, this);
        }

        for (int i = 0; i < bull.size(); i++) {
            Bullet shoot = bull.get(i);
            g.drawImage(shoot.bullet.getImage(), shoot.x + 47, shoot.y, shoot.w, shoot.h, null);
            shoot.move();
            if (shoot.y < 0) {
                bull.remove(i);
            }
        }

        for (int i = 0; i < zom.size(); i++) {
            g.drawImage(zom.get(i).getImage(), zom.get(i).getX(), zom.get(i).getY(), 100, 113, this);
        }

        for (int i = 0; i < bull.size(); i++) {
            for (int j = 0; j < zom.size(); j++) {
                if (Intersect(bull.get(i).getbound(), zom.get(j).getbound())) {
                    dead.add(new Zombie(zom.get(j).getX(), zom.get(j).getY()));
                    zom.remove(j);
                    bull.remove(i);
                    score += 10;
                }
            }
        }

        for (int j = 0; j < zom.size(); j++) {
            if (Intersect(me.getbound(), zom.get(j).getbound())|zom.get(j).getY()>900) {
                this.setLayout(null);
                over = true;
                System.out.println(over);
            }
         }
        if(over){
            this.setLayout(null);
            g.drawImage(bgover.getImage(), 0, 0, 1000, 813, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("TH Chakra Petch", Font.CENTER_BASELINE, 80));
            g.drawString("Game Over",340,300);
            g.drawString("Score "+score,360,400);
        }
       }

    Thread actor = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    actor.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    Thread newX = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if(me.x>=1100){
                        me.x=-30;
                    }else if (me.x < -30){
                        me.x = 1050;
                    }
                    repaint();
                    Thread.sleep(10);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });

    Thread Shoot = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });

    Thread time = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if(delay<1){
                        t++;
                    }
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    });

    Thread addZom = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (delay < 1) {
                        if(t<=30){
                            zom.add(new Zombie());
                            Thread.sleep(2000);
                        } else if(t<=50) {
                            zom.add(new Zombie());
                            Thread.sleep(1000);
                        }else {
                            zom.add(new Zombie());
                            Thread.sleep(500);
                        }
                    }
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });

    Thread delayTime = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    delay--;
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    });



    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}