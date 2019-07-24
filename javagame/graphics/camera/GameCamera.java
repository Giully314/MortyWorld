package javagame.graphics.camera;

import javagame.entities.Entity;
import javagame.gamehandler.GameHandler;

public class GameCamera
{

    private GameHandler game_handler;

    private float offset_x;
    private float offset_y;


    public GameCamera(GameHandler game_handler_, float offset_x_, float offset_y_)
    {
        this.game_handler = game_handler_;

        this.offset_x = offset_x_;
        this.offset_y = offset_y_;
    }


    public void centerOnEntity(Entity entity)
    {
        //Diviso 2 perchè il personaggio deve essere centrato e non messo nel bordo superiore.
        this.offset_x = entity.getCoordX() - this.game_handler.getWidth() / 2 + entity.getEntityWidth() / 2;
        this.offset_y = entity.getCoordY() - this.game_handler.getHeight() / 2 + entity.getEntityHeight() / 2;
    }


    public void move(float amount_x, float amount_y)
    {
        this.offset_x += amount_x;
        this.offset_y += amount_y;
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