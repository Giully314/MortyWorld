package javagame.userinterface;

import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
Classe che fa da base agli oggetti gestiti dall'handler dell'interfaccia utente.
*/
public abstract class UIObject
{
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected boolean hovering;

    protected Rectangle bounds;

    public UIObject(float x_, float y_, int width_, int height_)
    {
        this.x = x_;
        this.y = y_;
        this.width = width_;
        this.height = height_;
        this.hovering = false;

        this.bounds = new Rectangle((int)this.x, (int)this.y, this.width, this.height);
    }

    public abstract void update();

    public abstract void render(Graphics graphics);

    public abstract void onClick();

    public void onMouseMove(MouseEvent e)
    {
        if (this.bounds.contains(e.getX(), e.getY()))
        {
            this.hovering = true;
        }
        else 
        {
            this.hovering = false;
        }
    }

    public void onMouseRelease(MouseEvent e)
    {
        if (this.hovering)
        {
            this.onClick();
        }
    }

    //*************** METODI GET *************** */
    public float getX()
    {
        return this.x;
    }

    public float getY()
    {
        return this.y;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }

    public boolean getHovering()
    {
        return this.hovering;
    }

    //*************** METODI SET **************** */
    public void setX(float x_)
    {
        this.x = x_;
    }

    public void setY(float y_)
    {
        this.y = y_;
    }

    public void setWidth(int width_)
    {
        this.width = width_;
    }

    public void setHeight(int height_)
    {
        this.height = height_;
    }

    public void setHovering(boolean hovering_)
    {
        this.hovering = hovering_;
    }
}