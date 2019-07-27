package javagame.entities.statics;


import java.awt.Graphics;

import javagame.gamehandler.Handler;
import javagame.graphics.Assets;
import javagame.items.Item;

public class Trunk4 extends StaticEntity
{
    public Trunk4(Handler handler, float x, float y)
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
        this.handler.getWorld().getItemHandler().addItem(Item.trunk_item_4.createNewItem((int)this.coord_x + this.entity_width / 2, 
        (int)this.coord_y + this.entity_height / 2));
    }

    @Override
    public void update()
    {

    }


    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(Assets.trunk_4, (int)(coord_x - handler.getGameCamera().getOffsetX()), (int)(coord_y - handler.getGameCamera().getOffsetY()), entity_width, entity_height,  null);
    }
}