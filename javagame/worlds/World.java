package javagame.worlds;

import java.awt.Graphics;

import javagame.tiles.Tile;
import javagame.utility.Utility;
import javagame.gamehandler.GameHandler;

public class World
{
    private GameHandler game_handler;

    //Se world_width = 5, world_height = 5, la mappa sarà 5 x 5 tiles.
    private int world_width;
    private int world_height;
    
    //coordinate di spawn del personaggio
    private int spawn_x;
    private int spawn_y;

    //Accedo ad una tile in base all'id.
    private int[][] tiles;

    public World(GameHandler game_handler_, String world_path)
    {
        this.game_handler = game_handler_;
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
                this.tiles[y][x] = Utility.parseInt(tokens[(x + y * this.world_width) +4]);
            }
        }
    }


    //*********** METODI GET ********************** */
    public Tile getTile(int x, int y)
    {
        Tile t = Tile.tiles[this.tiles[x][y]];

        if (t == null)
        {
            return Tile.stone_tile;
        }

        return t;
    }


    //************** METODI PER UPDATE E RENDERING ****************** */
    
    public void update()
    {

    }
    

    public void render(Graphics graphics)
    {
        for (int y = 0; y < this.world_height; ++y)
        {
            for (int x = 0; x < this.world_width; ++x)
            {
                this.getTile(y, x).render(graphics, (int)(x * Tile.TILE_WIDTH - this.game_handler.getGameCamera().getOffsetX()), 
                (int)(y * Tile.TILE_HEIGHT - this.game_handler.getGameCamera().getOffsetY()));
            }
        }
    }
}