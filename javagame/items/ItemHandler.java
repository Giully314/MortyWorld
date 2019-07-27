package javagame.items;

import java.util.LinkedList;
import java.awt.Graphics;

import javagame.gamehandler.Handler;

public class ItemHandler
{
    private Handler handler;
    private LinkedList<Item> items;

    public ItemHandler(Handler handler_)
    {
        this.handler = handler_;
        this.items = new LinkedList<>();
    }

    //Metodi per update e render.
    public void update()
    {
        this.items.forEach(Item::update);
        this.items.removeIf(item_ -> item_.getItemCount() == item_.picked_up);
    }

    public void render(Graphics graphics)
    {
        this.items.forEach(item_ -> item_.render(graphics));
    }

    
    //Aggiunta di items.
    public void addItem(Item item_)
    {
        item_.setHandler(this.handler);
        items.add(item_);
    }


    //***************** METODI GET ************************ */
    public Handler getHandler()
    {
        return this.handler;
    }


    //******************** METODI SET ********************* */
    public void setHandler(Handler handler_)
    {
        this.handler = handler_;
    }
}