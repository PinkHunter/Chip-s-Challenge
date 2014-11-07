
import java.awt.image.BufferedImage;

import java.io.IOException;

import java.net.URL;

import javax.imageio.ImageIO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ACER
 */
public class ChipsImageLoader {

    /**
     *
     * @param pathRelativeToThis
     * @return
     * @throws IOException
     */
    public BufferedImage loadImage(String pathRelativeToThis) throws IOException {
        URL url = this.getClass().getResource(pathRelativeToThis);
        BufferedImage img = ImageIO.read(url);
        return img;
    }
}
