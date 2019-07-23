package javagame.entities.characters;

import javagame.entities.Entity;
import javagame.gamehandler.GameHandler;

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


    public CharacterBase(GameHandler game_handler_, float x, float y, int width, int height)
    {
        super(game_handler_, x, y, width, height);
        this.health_points = CharacterBase.DEFAULT_HEALT_POINTS;
        this.speed = CharacterBase.DEFAULT_SPEED;
        this.move_x = 0.0f;
        this.move_y = 0.0f;
    }


    public void move()
    {
        this.coord_x += this.move_x;
        this.coord_y += this.move_y;
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