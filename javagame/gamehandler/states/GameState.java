package javagame.gamehandler.states;

import java.awt.Graphics;

import javagame.entities.characters.Morty;
import javagame.entities.statics.Tree;
import javagame.graphics.Assets;
import javagame.gamehandler.Handler;
import javagame.tiles.*;
import javagame.worlds.World;

public class GameState extends State
{
    private World world_map;

    public GameState(Handler handler_)
    {
        super(handler_);
        this.world_map = new World(handler_, "../resource/worlds/world_1.txt");
        this.handler.setWorld(this.world_map);
    }


    @Override
    public void update()
    {
        this.world_map.update();
    }
    
    @Override
    public void render(Graphics graphics)
    {
        world_map.render(graphics);
    }
}