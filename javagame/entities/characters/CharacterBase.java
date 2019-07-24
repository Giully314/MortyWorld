package javagame.entities.characters;

import javagame.entities.Entity;
import javagame.gamehandler.Handler;
import javagame.tiles.Tile;

//Characterbase descrive gli oggetti che implementano dei punti vita. (personaggi in questo caso)
public abstract class CharacterBase extends Entity
{
    public static final int DEFAULT_HEALT_POINTS;
    public static final float DEFAULT_SPEED;
    public static final int DEFAULT_CHARACTERBASE_WIDTH;
    public static final int DEFAULT_CHARACTERBASE_HEIGHT;

    static 
    {
        DEFAULT_HEALT_POINTS = 5;
        DEFAULT_SPEED = 4.0f;
        DEFAULT_CHARACTERBASE_WIDTH = 96;
        DEFAULT_CHARACTERBASE_HEIGHT = 96;
    }

    
    protected int health_points;
    protected float speed;
    protected float move_x;
    protected float move_y;


    public CharacterBase(Handler handler_, float x, float y, int width, int height)
    {
        super(handler_, x, y, width, height);
        this.health_points = CharacterBase.DEFAULT_HEALT_POINTS;
        this.speed = CharacterBase.DEFAULT_SPEED;
        this.move_x = 0.0f;
        this.move_y = 0.0f;
    }


    public void move()
    {
        this.moveX();
        this.moveY();
    }

    public void moveX()
    {
        //Mi muovo verso destra.
        if (this.move_x > 0)
        {
                        //posizione  in pixel, divido per la larghezza della Tile per ottenere la posizione della Tile di cui stiamo facendo il check.
            int temp_x = (int) (this.coord_x + this.move_x + this.collision_rectangle.x + this.collision_rectangle.width) / Tile.TILE_WIDTH;
            int upper_bound_y = (int)(this.coord_y + this.collision_rectangle.y) /Tile.TILE_HEIGHT;
            int lower_bound_y = (int)(this.coord_y + this.collision_rectangle.y + this.collision_rectangle.height) / Tile.TILE_HEIGHT;

            if (!this.collisionWithTileObject(temp_x, upper_bound_y) && !this.collisionWithTileObject(temp_x, lower_bound_y))
            {
                this.coord_x += this.move_x;
            }
            else
            {
                this.coord_x = temp_x * Tile.TILE_WIDTH - this.collision_rectangle.x - this.collision_rectangle.width - 1;
            }
        }
        //Mi muovo verso sinistra.
        else if (this.move_x < 0)
        {
            int temp_x = (int) (this.coord_x + this.move_x + this.collision_rectangle.x) / Tile.TILE_WIDTH;
            int upper_bound_y = (int)(this.coord_y + this.collision_rectangle.y) /Tile.TILE_HEIGHT;
            int lower_bound_y = (int)(this.coord_y + this.collision_rectangle.y + this.collision_rectangle.height) / Tile.TILE_HEIGHT;

            if (!this.collisionWithTileObject(temp_x, upper_bound_y) && !this.collisionWithTileObject(temp_x, lower_bound_y))
            {
                this.coord_x += this.move_x;
            }
            else
            {
                this.coord_x = temp_x * Tile.TILE_WIDTH + Tile.TILE_HEIGHT - this.collision_rectangle.x;
            }
        }
    }

    public void moveY()
    {
        //Mi muovo verso sopra.
        if (this.move_y < 0)
        {
            int temp_y = (int)(this.coord_y + this.move_y + this.collision_rectangle.y) / Tile.TILE_HEIGHT; 
            int left_x = (int)(this.coord_x + this.collision_rectangle.x) / Tile.TILE_WIDTH;
            int right_x = (int)(this.coord_x + this.collision_rectangle.x + this.collision_rectangle.width) / Tile.TILE_WIDTH;

            if (!this.collisionWithTileObject(left_x, temp_y) && !this.collisionWithTileObject(right_x, temp_y))
            {
                this.coord_y += this.move_y;
            }
            else
            {
                this.coord_y = temp_y * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - this.collision_rectangle.y;
            }       
        }   
        //Verso sotto.
        else if (this.move_y > 0)
        {
            int temp_y = (int)(this.coord_y + this.move_y + this.collision_rectangle.y + this.collision_rectangle.height) / Tile.TILE_HEIGHT; 
            int left_x = (int)(this.coord_x + this.collision_rectangle.x) / Tile.TILE_WIDTH;
            int right_x = (int)(this.coord_x + this.collision_rectangle.x + this.collision_rectangle.width) / Tile.TILE_WIDTH;

            if (!this.collisionWithTileObject(left_x, temp_y) && !this.collisionWithTileObject(right_x, temp_y))
            {
                this.coord_y += this.move_y;
            }
            else
            {
                //Nel caso dovessi aggiungere un potere di teletrasporto, sommare dopo la moltiplicazione, Tile.TILE_HEIGHT;
                this.coord_y = temp_y * Tile.TILE_HEIGHT - this.collision_rectangle.y - this.collision_rectangle.height - 1;;
            }
        }
    }

    protected boolean collisionWithTileObject(int x, int y)
    {
        return handler.getWorld().getTile(x, y).isSolid();
    }


    //******************** METODI GET ******************* */
    public int getHealthPoints()
    {
        return this.health_points;
    }

    public float getSpeed()
    {
        return this.speed;
    }

    public float getMoveX()
    {
        return this.move_x;
    }

    public float getMoveY()
    {
        return this.move_y;
    }


    //********************* METODI SET ********************* */
    public void setHealthPoints(int hp)
    {
        this.health_points = hp;
    }

    public void setSpeed(float speed_)
    {
        this.speed = speed_;
    }

    public void setMoveX(float move_x_)
    {
        this.move_x = move_x_;
    }

    public void setMoveY(float move_y_)
    {
        this.move_y = move_y_;
    }
}