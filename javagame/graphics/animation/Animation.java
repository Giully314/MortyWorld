package javagame.graphics.animation;

import java.awt.image.BufferedImage;

/*
Animazioni di un'entità. Prende come parametro un tempo che utilizza per cambiare animazione.
*/
public class Animation
{
    private int speed;
    private int index;
    private BufferedImage[] frames;
    private long timer;
    private long last_time;

    public Animation(int speed_, BufferedImage[] frames_)
    {
        this.speed = speed_;
        this.index = 0;
        this.frames = frames_;
        this.timer = 0L;
        this.last_time = System.currentTimeMillis();
    }

    public BufferedImage getCurrentAnimation()
    {
        return this.frames[this.index];
    }


    public void update()
    {
        this.timer += System.currentTimeMillis() - this.last_time;
        this.last_time = System.currentTimeMillis();

        if (this.timer > this.speed)
        {
            ++this.index;
            this.timer = 0;

            if (this.index >= this.frames.length)
            {
                this.index = 0;
            }
        }
    }   
}