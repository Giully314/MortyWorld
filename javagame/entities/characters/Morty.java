package javagame.entities.characters;

import java.awt.Graphics;

import javagame.gamehandler.GameHandler;
import javagame.graphics.Assets;

public class Morty extends CharacterBase
{
    public Morty(GameHandler game_handler_, float x, float y)
    {
        super(game_handler_, x, y, CharacterBase.DEFAULT_CHARACTERBASE_WIDTH, CharacterBase.DEFAULT_CHARACTERBASE_HEIGHT);
    }

    //********* METODI PRIVATE PER UTILITA' INTERNA ********* */

    private void getInput()
    {
        this.move_x = 0.0f;
        this.move_y = 0.0f;

        if (this.game_handler.getKeyboardHander().getUp())
        {
            this.move_y = -this.speed;
        }
        else if (this.game_handler.getKeyboardHander().getDown())
        {
            this.move_y = this.speed;
        }

        if (this.game_handler.getKeyboardHander().getRight())
        {
            this.move_x = this.speed;
        }
        else if (this.game_handler.getKeyboardHander().getLeft())
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
    }


    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(Assets.morty, (int)coord_x, (int)coord_y, this.entity_width, this.entity_height, null);
    }
}