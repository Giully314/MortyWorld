package javagame.graphics;

import java.awt.image.BufferedImage;

/*
Classe di supporto per gli sprite. Permette performance maggiori nel rendering poichè non devo ritagliare sempre la tileset.
*/
public class Assets
{
    private static final int width;
    private static final int height;

    static
    {
        width = 96;
        height = 96;
    }

    //Tile
    public static BufferedImage grass;
    public static BufferedImage flowers;
    public static BufferedImage stone;
    public static BufferedImage stone_staircase;

    public static BufferedImage tree;
    public static BufferedImage trunk_1;
    public static BufferedImage trunk_2;
    public static BufferedImage trunk_3;
    public static BufferedImage trunk_4;
    
    //Morty
    public static BufferedImage[] morty_down;
    public static BufferedImage[] morty_up;
    public static BufferedImage[] morty_left;
    public static BufferedImage[] morty_right;

    //Menu
    public static BufferedImage[] menu;


    public static void init()
    {
        SpriteSheet spritesheet = new SpriteSheet(SpriteLoader.loadSprite("../resource/TileSet.png"));
        SpriteSheet mortysheet = new SpriteSheet(SpriteLoader.loadSprite("../resource/MortySheet.png"));
        SpriteSheet staticsheet = new SpriteSheet(SpriteLoader.loadSprite("../resource/StaticEntities.png"));

        stone = spritesheet.cut(0, 0, width, height);
        flowers = spritesheet.cut(width, 0, width, height);
        grass = spritesheet.cut(width * 2, 0, width, height);
        stone_staircase = spritesheet.cut(width * 3, 0, width, height);
        
        tree = staticsheet.cut(0, 0, 140, 192);
        trunk_1 = staticsheet.cut(140, 0, 64, 64); 
        trunk_2 = staticsheet.cut(140, 64, 64, 64); 
        trunk_3 = staticsheet.cut(140, 64 * 2, 64, 64); 
        trunk_4 = staticsheet.cut(140, 64 * 3, 64, 64); 

        //MORTY SETUP
        morty_down = new BufferedImage[4];
        morty_down[0] = mortysheet.cut(0, height, width, height);
        morty_down[1] = mortysheet.cut(width, height, width, height);
        morty_down[2] = mortysheet.cut(width * 2, height, width, height);
        morty_down[3] = mortysheet.cut(width * 3, height, width, height);

        morty_up = new BufferedImage[4];
        morty_up[0] = mortysheet.cut(width * 12, height, width, height);
        morty_up[1] = mortysheet.cut(width * 13, height, width, height);
        morty_up[2] = mortysheet.cut(width * 14, height, width, height);
        morty_up[3] = mortysheet.cut(width * 15, height, width, height);

        morty_left = new BufferedImage[4];
        morty_left[0] = mortysheet.cut(width * 4, height, width, height);
        morty_left[1] = mortysheet.cut(width * 5, height, width, height);
        morty_left[2] = mortysheet.cut(width * 6, height, width, height);
        morty_left[3] = mortysheet.cut(width * 7, height, width, height);

        morty_right = new BufferedImage[4];
        morty_right[0] = mortysheet.cut(width * 8, height, width, height);
        morty_right[1] = mortysheet.cut(width * 9, height, width, height);
        morty_right[2] = mortysheet.cut(width * 10, height, width, height);
        morty_right[3] = mortysheet.cut(width * 11, height, width, height);

        //Menu setup
        menu = new BufferedImage[2];
        menu[0] = SpriteLoader.loadSprite("../resource/Menu/menu1.png");
        menu[1] = SpriteLoader.loadSprite("../resource/Menu/menu2.png");
    }
}