package javagame.entities.characters;

import java.awt.Color;
import java.awt.Graphics;

import javagame.gamehandler.Handler;
import javagame.graphics.Assets;

public class Morty extends CharacterBase
{
    public Morty(Handler handler_, float x, float y)
    {
        super(handler_, x, y, CharacterBase.DEFAULT_CHARACTERBASE_WIDTH, CharacterBase.DEFAULT_CHARACTERBASE_HEIGHT);
        
        this.collision_rectangle.x = 33;
        this.collision_rectangle.y = 64;
        this.collision_rectangle.width = 28;
        this.collision_rectangle.height = 29;
    }

    //********* METODI PRIVATE PER UTILITA' INTERNA ********* */

    private void getInput()
    {
        this.move_x = 0.0f;
        this.move_y = 0.0f;

        if (this.handler.getKeyboardHandler().getUp())
        {
            this.move_y = -this.speed;
        }
        else if (this.handler.getKeyboardHandler().getDown())
        {
            this.move_y = this.speed;
        }

        if (this.handler.getKeyboardHandler().getRight())
        {
            this.move_x = this.speed;
        }
        else if (this.handler.getKeyboardHandler().getLeft())
        {
            this.move_x = -this.speed;
        }
    }


    //************* METODI PER UPDATE E RENDERING DEL PERSONAGGIO */
    @Override
    public void update()
    {
        this.getInput();
        this.move();
        this.handler.getGameCamera().centerOnEntity(this);
    }


    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(Assets.morty, (int)(this.coord_x - this.handler.getGameCamera().getOffsetX()), 
        (int)(this.coord_y - this.handler.getGameCamera().getOffsetY()), this.entity_width, this.entity_height, null);
    
        // graphics.setColor(Color.BLUE);
        // graphics.fillRect((int)(coord_x + collision_rectangle.x - handler.getGameCamera().getOffsetX()), 
        //                     (int)(coord_y + collision_rectangle.y - handler.getGameCamera().getOffsetY()), collision_rectangle.width,
        //                     collision_rectangle.height);
    }
}