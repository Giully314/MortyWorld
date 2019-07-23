package javagame.graphics;

import java.awt.image.BufferedImage;

public class Assets
{
    private static final int width;
    private static final int height;

    static
    {
        width = 96;
        height = 96;
    }

    public static BufferedImage grass;
    public static BufferedImage stone;
    public static BufferedImage morty;

    public static void init()
    {
        SpriteSheet spritesheet = new SpriteSheet(SpriteLoader.loadSprite("../resource/map_tile.png"));

        grass = spritesheet.cut(0, 32, width, height);
        stone = spritesheet.cut(96, 32, width, height);
        morty = SpriteLoader.loadSprite("../resource/morty.png");
    }
}