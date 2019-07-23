package javagame.gamehandler.states;

import java.awt.Graphics;

import javagame.entities.characters.Morty;
import javagame.graphics.Assets;
import javagame.gamehandler.GameHandler;
import javagame.tiles.*;
import javagame.worlds.World;

public class GameState extends State
{
    private Morty morty;
    private World world_map;

    public GameState(GameHandler game_handler_)
    {
        super(game_handler_);
        this.morty = new Morty(game_handler_, 40, 40);
        this.world_map = new World(game_handler_, "../resource/worlds/world_1.txt");
    }


    @Override
    public void update()
    {
        this.morty.update();
    }
    
    @Override
    public void render(Graphics graphics)
    {
        world_map.render(graphics);
        this.morty.render(graphics);
    }
}