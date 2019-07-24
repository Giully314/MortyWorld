package javagame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile
{
    public static Tile[] tiles;
    public static Tile grass_tile;
    public static Tile stone_tile;
    public static Tile stone_staircase;
    public static Tile flowers_tile;

    public static final int TILE_WIDTH;
    public static final int TILE_HEIGHT;

    static
    {
        TILE_WIDTH = 96;
        TILE_HEIGHT = 96;

        tiles = new Tile[4];
        grass_tile = new GrassTile(0);
        stone_tile = new StoneTile(1);
        flowers_tile = new FlowersTile(2);
        stone_staircase = new StoneStaircaseTile(3);
    }



    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture_, int id_)
    {
        this.texture = texture_;
        this.id = id_;

        //Imposto la tile nella posizione id uguale a se stessa.
        //Esempio: se creo GrassTile(0) imposterò in tiles[0] = GrassTile;
        Tile.tiles[id] = this;
    }

    public boolean isSolid()
    {
        return false;
    }

    //**************** METODI GET ******************** */
    public int getId()
    {
        return this.id;
    }


    //************* METODI DI UPDATE E RENDERING ************* */

    public void update()
    {

    }


    public void render(Graphics graphics, int x, int y)
    {
        graphics.drawImage(this.texture, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);
    }
}