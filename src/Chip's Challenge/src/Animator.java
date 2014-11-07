
import java.awt.image.BufferedImage;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ACER
 */
public class Animator {

    private ArrayList<BufferedImage> frames;
    public BufferedImage sprite;
    private volatile boolean walking = false;
    private long previousTime, speed;
    private int frameAtPause, currentFrame;

    public Animator(ArrayList<BufferedImage> frames) {
        this.frames = frames;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public void update(long time) {
        if (walking) {
            if (time - previousTime >= speed) {
                this.currentFrame++;
                try {
                    sprite = frames.get(currentFrame);
                } catch (IndexOutOfBoundsException e) {
                    currentFrame = 0;
                    sprite = frames.get(currentFrame);
                }
                previousTime = time;
            }
        }
    }

    public void play() {
        walking = true;
        previousTime = 0;
        frameAtPause = 0;
        currentFrame = 0;
    }

    public void stop() {
        walking = false;
        previousTime = 0;
        frameAtPause = 0;
        currentFrame = 0;
    }

    public void pause() {
        frameAtPause = currentFrame;
        walking = false;
    }

    public void resume() {
        currentFrame = frameAtPause;
        walking = true;
    }
}
