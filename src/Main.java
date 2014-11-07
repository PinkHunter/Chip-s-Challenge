
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class Main extends JFrame {

    BufferedImage sprite;
    Animator mario;

    public Main() {
        setSize(300, 400 );
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        ChipsImageLoader loader = new ChipsImageLoader();
        BufferedImage spriteSheet = null;
        try {
            spriteSheet = loader.loadImage("images.jpg");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        SpriteSheet sS = new SpriteSheet(spriteSheet);
        //this.sprite = sS.getSprite(0, 0, 13, 25);
        ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
        
        sprites.add(sS.getSprite(7, 4, 19, 30));
        sprites.remove(sS.getSprite(7, 4, 19, 30));
        sprites.add(sS.getSprite(40, 5, 54, 30));
        sprites.remove(sS.getSprite(40, 5, 54, 30));
        sprites.add(sS.getSprite(71, 5, 86, 32));
        sprites.remove(sS.getSprite(71, 5, 86, 32));
        
        mario = new Animator(sprites);
        mario.setSpeed(500);
        mario.play();
    }
    
    Image dbImage;
    Graphics dbg;
    
    @Override
    public void paint(Graphics g) {
//        g.drawImage(sprite, 50, 200, null);
//        repaint();
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, rootPane);
    }
    
    public void paintComponent(Graphics g) {
        if(mario != null) {
            mario.update(System.currentTimeMillis());
            g.drawImage(mario.sprite, 100, 100, 50, 50, null);
        }
        repaint();
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
