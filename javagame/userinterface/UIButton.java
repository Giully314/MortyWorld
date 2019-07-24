package javagame.userinterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIButton extends UIObject
{
    private BufferedImage[] images;
    private ClickListener click_listener;

    public UIButton(float x, float y, int width, int height, BufferedImage[] images_, ClickListener click_listener_)
    {
        super(x, y, width, height);
        this.images = images_;
        this.click_listener = click_listener_;
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(Graphics graphics)
    {
        if (this.hovering)
        {
            graphics.drawImage(this.images[1], (int)this.x, (int)this.y, this.width, this.height, null);
        }
        else
        {
            graphics.drawImage(this.images[0], (int)this.x, (int)this.y, this.width, this.height, null);
        }
    }

    @Override
    public void onClick()
    {
        this.click_listener.onClick();
    }
    
}