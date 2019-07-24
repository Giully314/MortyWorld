package javagame.entities.statics;


import java.awt.Graphics;

import javagame.gamehandler.Handler;
import javagame.graphics.Assets;

public class Trunk3 extends StaticEntity
{
    public Trunk3(Handler handler, float x, float y)
    {
        super(handler, x, y, 64, 64);

        this.collision_rectangle.x = 10;
        this.collision_rectangle.y = 10;
        this.collision_rectangle.width = 50;
        this.collision_rectangle.height = 45;
    }

    @Override
    public void dead()
    {
        
    }

    @Override
    public void update()
    {

    }


    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(Assets.trunk_3, (int)(coord_x - handler.getGameCamera().getOffsetX()), (int)(coord_y - handler.getGameCamera().getOffsetY()), entity_width, entity_height,  null);
    }
}