package javagame.entities;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Comparator;
import java.awt.Graphics;

import javagame.entities.characters.Morty;
import javagame.gamehandler.Handler;

public class EntityHandler
{
    private Handler handler;
    private Morty morty;
    private LinkedList<Entity> entities;
    private Comparator<Entity> rendering_order;

    private class RenderingOrderComparator implements Comparator<Entity>
    {
        @Override
        public int compare(Entity a, Entity b)
        {
            if (a.getCoordY() + a.getEntityHeight() < b.getCoordY() + b.getEntityHeight())
            {
                return -1;
            }
            return 1;
        }
    }

    public EntityHandler(Handler handler_, Morty morty_)
    {
        this.handler = handler_;
        this.morty = morty_;
        this.entities = new LinkedList<>();
        this.entities.add(this.morty);
        this.rendering_order = new RenderingOrderComparator();
    }


    public void update()
    {
        // Iterator<Entity> it = this.entities.iterator();
        
        // while (it.hasNext())
        // {
        //     Entity e = it.next();
        //     e.update();

        //     if (!e.isActive())
        //     {
        //          it.remove();
        //     }
        // }
        
        this.entities.forEach(Entity::update);
        this.entities.removeIf(e -> 
        {
            return !e.isActive();
        });

        this.entities.sort(this.rendering_order);
    }

    public void render(Graphics graphics)
    {
        this.entities.forEach(entity -> entity.render(graphics));
    }

    public void addEntity(Entity e)
    {
        this.entities.add(e);
    }

    //**************** METODI GET ********************* */

    public Morty getMorty()
    {
        return this.morty;
    }

    public LinkedList<Entity> getEntities()
    {
        return this.entities;
    }
}