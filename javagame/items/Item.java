package javagame.items;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

import javagame.gamehandler.Handler;

public class Item
{
    public final static int DEFAULT_ITEM_WIDTH;
    public final static int DEFAULT_ITEM_HEIGHT;
    public static Item[] items;
    public static Item tree_item;
    public static Item trunk_item_1;
    public static Item trunk_item_2;
    public static Item trunk_item_3;
    public static Item trunk_item_4;

    static
    {
        DEFAULT_ITEM_WIDTH = 32;
        DEFAULT_ITEM_HEIGHT = 32;

        items = new Item[5];

        tree_item = new TreeItem();
        trunk_item_1 = new TrunkItem1();
        trunk_item_2 = new TrunkItem2();
        trunk_item_3 = new TrunkItem3();
        trunk_item_4 = new TrunkItem4();
    }


    //Dimensione item.
    protected int item_width;
    protected int item_height;
    
    //item preso.
    protected int picked_up;

    protected Handler handler;

    //Caratteristiche generali.
    protected BufferedImage item_texture;
    protected String item_name;
    protected final int item_id;

    //Coordinate e quantità presente nell'invetario.
    protected int coord_x;
    protected int coord_y;
    protected int item_count;

    public Item(int item_width_, int item_height_, Handler handler_, BufferedImage item_texture_, String item_name_, int id_)
    {
        this.item_width = item_width_;
        this.item_height = item_height_;

        this.picked_up = -1;
        
        this.handler = handler_;

        this.item_texture = item_texture_;

        this.item_name = item_name_;

        this.item_id = id_;
    }

    //Metodi per update e rendering dell'item.

    public void update()
    {

    }

    public void render(Graphics graphics)
    {
        if (this.handler == null)
        {
            return;
        }
        this.render(graphics, (int)(this.coord_x - this.handler.getGameCamera().getOffsetX()), 
        (int)(this.coord_y - this.handler.getGameCamera().getOffsetY()));
    }

    //Questo metodo è usato sia per sistemare la posizione dell'oggetto in base alla camera e sia per posizionarlo nell'inventario.
    public void render(Graphics graphics, int x, int y)
    {
        graphics.drawImage(this.item_texture, x, y, this.item_width, this.item_height, null);
    }

    //Metodi utility

    public Item createNewItem(int x_, int y_)
    {
        Item item = new Item(this.item_width, this.item_height, this.handler, this.item_texture, this.item_name, this.item_id);
        item.setItemPosition(x_, y_);

        return item;
    }

    //****************** METODI GET ********************** */
    public int getItemCount()
    {
        return this.item_count;
    }

    public int getCoordX()
    {
        return this.coord_x;
    }

    public int getCoordY()
    {
        return this.coord_y;
    }

    public int getItemId()
    {
        return this.item_id;
    }

    public Handler getHandler()
    {
        return this.handler;
    }

    public BufferedImage getItemTexture()
    {
        return this.item_texture;
    }

    public String getItemName()
    {
        return this.item_name;
    }

    //**************** METODI SET ******************************* */
    public void setCoordX(int x_)
    {
        this.coord_x = x_;
    }

    public void setCoordY(int y_)
    {
        this.coord_y = y_;
    }

    public void setHandler(Handler handler_)
    {
        this.handler = handler_;
    }

    public void setItemCount(int count_)
    {
        this.item_count = count_;
    }

    public void setItemTexture(BufferedImage texture_)
    {
        this.item_texture = texture_;
    }

    public void setItemPosition(int x_, int y_)
    {
        this.coord_x = x_;
        this.coord_y = y_;
    }

}