package javagame.graphics.camera;

import javagame.entities.Entity;
import javagame.gamehandler.Handler;
import javagame.tiles.Tile;

/*
Camera di gioco impostata sul giocatore principale.
*/
public class GameCamera
{

    private Handler handler;

    private float offset_x;
    private float offset_y;


    public GameCamera(Handler handler_, float offset_x_, float offset_y_)
    {
        this.handler = handler_;

        this.offset_x = offset_x_;
        this.offset_y = offset_y_;
    }


    public void centerOnEntity(Entity entity)
    {
        //Diviso 2 perchè il personaggio deve essere centrato e non messo nel bordo superiore.
        this.offset_x = entity.getCoordX() - this.handler.getGameWidth() / 2 + entity.getEntityWidth() / 2;
        this.offset_y = entity.getCoordY() - this.handler.getGameHeight() / 2 + entity.getEntityHeight() / 2;
        
        this.checkEndMap(); 
    }


    public void move(float amount_x, float amount_y)
    {
        this.offset_x += amount_x;
        this.offset_y += amount_y;
    }

    public void checkEndMap()
    {
        if (this.offset_x < 0)
        {
            this.offset_x = 0;
        }
        else if (this.offset_x > this.handler.getWorld().getWorldWidth() * Tile.TILE_WIDTH - this.handler.getGameWidth())
        {
            this.offset_x = this.handler.getWorld().getWorldWidth() * Tile.TILE_WIDTH - this.handler.getGameWidth();
        }

        if (this.offset_y < 0)
        {
            this.offset_y = 0;
        }
        else if (this.offset_y > this.handler.getWorld().getWorldHeight() * Tile.TILE_HEIGHT - this.handler.getGameHeight())
        {
            this.offset_y = this.handler.getWorld().getWorldHeight() * Tile.TILE_HEIGHT - this.handler.getGameHeight();
        }
    }


    //********************* METODI GET ****************** */
    public float getOffsetX()
    {
        return this.offset_x;
    }

    public float getOffsetY()
    {
        return this.offset_y;
    }


    //*********************** METODI SET *********************** */
    public void setOffsetX(float offset_x_)
    {   
        this.offset_x = offset_x_;
    }

    public void setOffsetY(float offset_y_)
    {
        this.offset_y  =offset_y_;
    }
}