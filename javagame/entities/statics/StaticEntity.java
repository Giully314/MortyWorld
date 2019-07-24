package javagame.entities.statics;

import javagame.entities.Entity;
import javagame.gamehandler.Handler;

/*
Fa da classe base per le entità statiche.
*/
public abstract class StaticEntity extends Entity
{
    public StaticEntity(Handler handler_, float x, float y, int width, int height)
    {
        super(handler_, x, y, width, height);
    }
}