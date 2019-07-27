package javagame.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Optional;

import javagame.gamehandler.Handler;
import javagame.items.Item;

public class Inventory
{
    private Handler handler;
    private boolean is_active;
    private LinkedList<Item> inventory_items;

    public Inventory(Handler handler_)
    {
        this.handler = handler_;
        this.is_active = false;
        this.inventory_items = new LinkedList<>();
    }


    //Metodi per update e render

    public void update()
    {
        if (this.handler.getKeyboardHandler().getKeyJustPressed(KeyEvent.VK_E))
        {
            this.is_active = !this.is_active;
        }

        if (!this.is_active)
        {
            return;
        }
        
        this.inventory_items.forEach(i -> System.out.println(i.getItemName() + " : " + i.getItemCount()));
    }

    public void render(Graphics graphics)
    {
        if (!this.is_active)
        {
            return;
        }
    }


    //Metodi dell'inventario
    public void addItem(Item item_)
    {
        //Possibile (ma pessimo) sistema per interrompere un forEach, se non si ha la possiblità di usare gli stream.
        // try
        // {
        //     this.inventory_items.forEach(i -> 
        //     {
        //         if (i.getItemId() == item_.getItemId())
        //         {
        //             i.setItemCount(i.getItemCount() + 1);
        //             throw new BreakException();
        //         }
        //     });
        // }
        // catch (BreakException e)
        // {

        // }


        //Poichè mi serve solo sapere se c'è o no l'item, uso anyMatch. Altrimenti avrei usato filter se mi fosse servito l'item in questione.
        //Nota personale: Nel caso di tanti item nell'inventario potrei considerare l'uso di parallelStream.
        boolean found = this.inventory_items.stream().anyMatch(i -> {
            if (i.getItemId() == item_.getItemId())
            {
                i.setItemCount(i.getItemCount() + 1);
                return true;
            }
            return false;
        });

        if (found)
        {
            return;
        }

        this.inventory_items.add(item_);
    }


    //************************** METODI GET **************************** */
    public Handler getHandler()
    {
        return this.handler;
    }

    public boolean getIsActive()
    {
        return this.is_active;
    }

    //***************************** METODI SET ***************************** */
    public void setHandler(Handler handler_)
    {
        this.handler = handler_;
    }

    public void setIsActive(boolean is_active_)
    {
        this.is_active = is_active_;
    }

}