package javagame.worlds;

import java.awt.Graphics;

import javagame.tiles.Tile;
import javagame.utility.Utility;
import javagame.gamehandler.Handler;

public class World
{
    private Handler handler;

    //Se world_width = 5, world_height = 5, la mappa sarà 5 x 5 tiles.
    private int world_width;
    private int world_height;
    
    //coordinate di spawn del personaggio
    private int spawn_x;
    private int spawn_y;

    //Accedo ad una tile in base all'id.
    private int[][] tiles;

    public World(Handler handler_, String world_path)
    {
        this.handler = handler_;
        this.loadWorld(world_path);
    }

    //load della mappa da file
    private void loadWorld(String world_path)
    {
        String file = Utility.loadFileAsString(world_path);
        String[] tokens = file.split("\\s+"); 
        this.world_width = Utility.parseInt(tokens[0]);
        this.world_height = Utility.parseInt(tokens[1]);    
        this.spawn_x = Utility.parseInt(tokens[2]);
        this.spawn_y = Utility.parseInt(tokens[3]);
    
        this.tiles = new int[this.world_height][this.world_width];

        for (int y = 0; y < this.world_height; ++y)
        {
            for (int x = 0; x < this.world_width; ++x)
            {
                //+4 perchè ho già calcolato i primi 4 elementi precedentemente.
                this.tiles[y][x] = Utility.parseInt(tokens[(x + y * this.world_width) + 4]);
            }
        }
    }


    //*********** METODI GET ********************** */
    public Tile getTile(int x, int y)
    {
        if (x < 0 || x >= this.world_width || y < 0 || y > this.world_height)
        {
            return Tile.grass_tile;
        }

        Tile t = Tile.tiles[this.tiles[y][x]];

        if (t == null)
        {
            return Tile.grass_tile;
        }

        return t;
    }

    public int getWorldWidth()
    {
        return this.world_width;
    }

    public int getWorldHeight()
    {
        return this.world_height;
    }


    //************** METODI PER UPDATE E RENDERING ****************** */
    
    public void update()
    {

    }
    

    public void render(Graphics graphics)
    {
        //Ottimizzazione del rendering della mappa. Faccio il rendering solo della porzione di mappa che vedo.
        int start_x = Math.max(0, (int)this.handler.getGameCamera().getOffsetX() / Tile.TILE_WIDTH /*+1*/ ); // se si aggiunge un +1 si nota come il rendering venga fatto solo nella parte di mappa visibile.
        int start_y = Math.max(0, (int)this.handler.getGameCamera().getOffsetY() / Tile.TILE_HEIGHT );
        int end_x = Math.min(this.world_width, (int)((this.handler.getGameCamera().getOffsetX() + this.handler.getGameWidth()) / Tile.TILE_WIDTH + 1));
        int end_y = Math.min(this.world_height, (int)((this.handler.getGameCamera().getOffsetY() + this.handler.getGameHeight()) / Tile.TILE_HEIGHT + 1));


        for (int y = start_y; y < end_y; ++y)
        {
            for (int x = start_x; x < end_x; ++x)
            {
                this.getTile(x, y).render(graphics, (int)(x * Tile.TILE_WIDTH - this.handler.getGameCamera().getOffsetX()), 
                (int)(y * Tile.TILE_HEIGHT - this.handler.getGameCamera().getOffsetY()));
            }
        }
    }
}