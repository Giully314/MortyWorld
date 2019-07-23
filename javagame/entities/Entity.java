package javagame.entities;

import java.awt.Graphics;

import javagame.gamehandler.GameHandler;

//La classe Entity è una classe astratta che rappresenta qualunque cosa che abbia posizione, update e render.
public abstract class Entity
{
    protected GameHandler game_handler;

    protected float coord_x;
    protected float coord_y;

    protected int entity_width;
    protected int entity_height;

    public Entity(GameHandler game_handler_, float x, float y, int width, int height)
    {
        this.game_handler = game_handler_;
        this.coord_x = x;
        this.coord_y = y;
        this.entity_width = width;
        this.entity_height = height;
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

    //********* Metodi per update e rendering *************
    public abstract void update();

    public abstract void render(Graphics graphics);
}