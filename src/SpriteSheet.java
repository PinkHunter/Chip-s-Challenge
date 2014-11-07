
import java.awt.image.BufferedImage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class SpriteSheet {

    public BufferedImage spriteSheet;

    public SpriteSheet(BufferedImage sS) {
        this.spriteSheet = sS;
    }

    public BufferedImage getSprite(int x, int y, int width, int height) {
        BufferedImage sprite = this.spriteSheet.getSubimage(x, y, width, height);
        return sprite;
    }
}
