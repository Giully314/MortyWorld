package javagame.gamehandler;

import javagame.graphics.camera.GameCamera;
import javagame.input.*;
import javagame.worlds.World;

/*
Questa classe ci permette di ottenere in modo semplice tutti gli oggetti necessari.
(Sia ringraziato e benedetto il tizio trovato in un forum alla 15 pagina di google che mi ha dato questo spunto.)
*/

public class Handler
{
    private GameHandler game_handler;
    private World world;

    public Handler(GameHandler game_handler_)
    {
        this.game_handler = game_handler_;
    }

    //**************** METODI GET ********************** */
    public int getGameWidth()
    {
        return this.game_handler.getWidth();
    }

    public int getGameHeight()
    {
        return this.game_handler.getHeight();
    }

    public GameHandler getGameHandler()
    {
        return this.game_handler;
    }

    public KeyHandler getKeyboardHandler()
    {
        return this.game_handler.getKeyboardHandler();
    }

    public GameCamera getGameCamera()
    {
        return this.game_handler.getGameCamera();
    }

    public World getWorld()
    {
        return this.world;
    }

    public MouseHandler getMouseHandler()
    {
        return this.game_handler.getMouseHandler();
    }

    //***************** METODI SET ******************** */
    public void setWorld(World world_)
    {
        this.world = world_;
    }

}