package javagame.entities.statics;


import java.awt.Graphics;

import javagame.gamehandler.Handler;
import javagame.graphics.Assets;
import javagame.items.Item;

public class Tree extends StaticEntity
{
    public Tree(Handler handler, float x, float y)
    {
        super(handler, x, y, 140, 192);

        this.collision_rectangle.x = 50;
        this.collision_rectangle.y = 142;
        this.collision_rectangle.width = 40;
        this.collision_rectangle.height = 42;
    }

    @Override
    public void dead()
    {
        this.handler.getWorld().getItemHandler().addItem(Item.tree_item.createNewItem((int)this.coord_x + this.entity_width / 2, 
        (int)this.coord_y + this.entity_height));
    }

    @Override
    public void update()
    {

    }


    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(Assets.tree, (int)(coord_x - handler.getGameCamera().getOffsetX()), (int)(coord_y - handler.getGameCamera().getOffsetY()), entity_width, entity_height,  null);
    }
}