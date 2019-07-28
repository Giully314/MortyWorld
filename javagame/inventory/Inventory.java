package javagame.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Optional;

import javagame.gamehandler.Handler;
import javagame.graphics.Assets;
import javagame.graphics.Text;
import javagame.items.Item;

public class Inventory
{
    private Handler handler;
    private boolean is_active;
    private LinkedList<Item> inventory_items;

    private int x;
    private int y;
    private int inventory_width;
    private int inventory_height;
    private int inventory_center_x;
    private int inventory_center_y;
    private int inventory_list_space;

    private int inventory_image_x;
    private int inventory_image_y;
    private int inventory_image_width;
    private int inventory_image_height;

    private int inventory_count_x;
    private int inventory_count_y;

    private int selected_item;


    public Inventory(Handler handler_)
    {
        this.handler = handler_;
        this.is_active = false;
        this.inventory_items = new LinkedList<>();

        this.x = 500;
        this.y = 400;
        this.inventory_width = 512;
        this.inventory_height = 384;
        this.inventory_center_x = this.x + 171;
        this.inventory_center_y = this.y + this.inventory_height / 2 + 10;
        this.inventory_list_space = 30;

        this.inventory_image_x = this.x + 452;
        this.inventory_image_y = this.y + 82;

        this.inventory_image_width = 64;
        this.inventory_image_height = 64;
        
        this.inventory_count_x = this.x + 484;
        this.inventory_count_y = this.y + 172;

        this.selected_item = 0;

        this.addItem(Item.tree_item.createNewItem(3));
        this.addItem(Item.tree_item.createNewItem(3));
        this.addItem(Item.trunk_item_1.createNewItem(6));
        this.addItem(Item.trunk_item_1.createNewItem(6));
        
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

        if (this.handler.getKeyboardHandler().getKeyJustPressed(KeyEvent.VK_UP))
        {
            --this.selected_item;
        }
        else if (this.handler.getKeyboardHandler().getKeyJustPressed(KeyEvent.VK_DOWN))
        {
            ++this.selected_item;
        }

        if (this.selected_item < 0)
        {
            this.selected_item = this.inventory_items.size() - 1;
        }
        else if (this.selected_item >= this.inventory_items.size())
        {
            this.selected_item = 0;
        }
        
        //this.inventory_items.forEach(i -> System.out.println(i.getItemName() + " : " + i.getItemCount()));
    }

    public void render(Graphics graphics)
    {
        if (!this.is_active)
        {
            return;
        }

        graphics.drawImage(Assets.inventory, this.x, this.y, this.inventory_width, this.inventory_height, null);

        
        int len = this.inventory_items.size();

        if (len == 0)
        {
            return;
        }

        //Il ciclo parte da -5 poichè considero la riga centrale dell'inventario come posizione 0.
        for (int i = -5; i < 6; ++i)
        {
            if (this.selected_item + i < 0 || this.selected_item + i >= len)
            {
                continue;
            }
            if (i == 0)
            {
                Text.drawString(graphics, "> " + this.inventory_items.get(this.selected_item + i).getItemName() + " <", this.inventory_center_x,
                    this.inventory_center_y + i * this.inventory_list_space, true, Color.GREEN, Assets.font_30);   
            }
            else
            {
                Text.drawString(graphics, this.inventory_items.get(this.selected_item + i).getItemName(), this.inventory_center_x,
                    this.inventory_center_y + i * this.inventory_list_space, true, Color.WHITE, Assets.font_30);  
            }
        }

        Item item = this.inventory_items.get(this.selected_item);
        graphics.drawImage(item.getItemTexture(), this.inventory_image_x, this.inventory_image_y, 
            this.inventory_image_width, this.inventory_image_height, null);

        Text.drawString(graphics, Integer.toString(item.getItemCount()), this.inventory_count_x, this.inventory_count_y, true, Color.WHITE, Assets.font_30);
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