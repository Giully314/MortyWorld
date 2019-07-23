package javagame.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private BufferedImage spritesheet;

    public SpriteSheet(BufferedImage spritesheet_)
    {
        this.spritesheet = spritesheet_;
    }

    //Prende una porzione della spritesheet.
    public BufferedImage cut(int x, int y, int width, int height)
    {
        return this.spritesheet.getSubimage(x, y, width, height);
    }
}