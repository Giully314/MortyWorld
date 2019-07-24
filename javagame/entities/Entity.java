package javagame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import javagame.gamehandler.Handler;

//La classe Entity è una classe astratta che rappresenta qualunque cosa che abbia posizione, update e render.
public abstract class Entity
{
    public static final int DEFAULT_HEALT_POINTS;

    static
    {
        DEFAULT_HEALT_POINTS = 5;
    }

    protected Handler handler;

    protected float coord_x;
    protected float coord_y;

    protected int entity_width;
    protected int entity_height;

    protected int health_points;

    //Variabile che comunica se un oggetto è presente nel mondo o se è stato rimosso.
    protected boolean active_on_world;

    //Rettangolo per il check delle collisioni.
    protected Rectangle collision_rectangle;

    public Entity(Handler handler_, float x, float y, int width, int height)
    {
        this.handler = handler_;
        this.coord_x = x;
        this.coord_y = y;
        this.entity_width = width;
        this.entity_height = height;
        this.health_points = Entity.DEFAULT_HEALT_POINTS;
        this.active_on_world = true;

        //imporsto di default il rettangolo come la dimensione dell'immagine. Da cambiare i parametri nella classe specifica.
        this.collision_rectangle = new Rectangle(0, 0, this.entity_width, this.entity_height);
    }

    //********************** METODI GET *****************
    public float getCoordX()
    {
        return this.coord_x;
    }
    
    public float getCoordY()
    {
        return this.coord_y;
    }

    public float getEntityWidth()
    {
        return this.entity_width;
    }

    public float getEntityHeight()
    {
        return this.entity_height;
    }

    public int getHealthPoints()
    {
        return this.health_points;
    }

    public boolean isActive()
    {
        return this.active_on_world;
    }

    public Rectangle getCollisionBounds(float offset_x, float offset_y)
    {
        return new Rectangle((int)(this.coord_x + this.collision_rectangle.x + offset_x), (int)(this.coord_y + this.collision_rectangle.y + offset_y),
                            this.collision_rectangle.width, this.collision_rectangle.height);
    }
    
    
    //****************** METODI SET ********************** */
    public void setCoordX(float coord_x_)
    {
        this.coord_x = coord_x_;
    }

    public void setCoordY(float coord_y_)
    {
        this.coord_y = coord_y_;
    }

    public void setEntityWidth(int width)
    {
        this.entity_width = width;
    }

    public void setEntityHeight(int height)
    {
        this.entity_height = height;
    }

    public void setHealthPoints(int hp)
    {
        this.health_points = hp;
    }

    public void setActive(boolean active_)
    {
        this.active_on_world = active_;
    }


    public void damageReceived(int amount)
    {
        this.health_points -= amount;

        if (this.health_points <= 0)
        {
            this.active_on_world = false;
            this.dead();
        }
    }

    public abstract void dead();

    //Collisions
    public boolean checkEntityCollision(float offset_x, float offset_y)
    {
        for (Entity e : this.handler.getWorld().getEntityHandler().getEntities())
        {
            if (e.equals(this)) 
            {
                continue;
            }
            
            if (e.getCollisionBounds(0.0f, 0.0f).intersects(getCollisionBounds(offset_x, offset_y)))
            {
                return true;
            }
        }
        return false;
    }

    //********* Metodi per update e rendering *************
    public abstract void update();

    public abstract void render(Graphics graphics);
}