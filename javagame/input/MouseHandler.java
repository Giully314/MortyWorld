package javagame.input;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javagame.userinterface.UIHandler;

import java.awt.event.MouseEvent;

/*
Gestore mouse.
*/
public class MouseHandler implements MouseListener, MouseMotionListener
{
    private boolean left_pressed;
    private boolean right_pressed;
    private int mouse_x;
    private int mouse_y;
    private UIHandler ui_handler;

    public MouseHandler()
    {
        this.left_pressed = false;
        this.right_pressed = false;
        this.mouse_x = 0;
        this.mouse_y = 0;
        this.ui_handler = null;
    }

    //********** METODI SET ******************* */
    public void setUIHandler(UIHandler ui_handler_)
    {
        this.ui_handler = ui_handler_;
    }

    //************** METODI GET ***************** */
    public boolean isLeftPressed()
    {
        return this.left_pressed;
    }

    public boolean isRightPressed()
    {
        return this.right_pressed;
    }

    public int getMouseX()
    {
        return this.mouse_x;
    }

    public int getMouseY()
    {
        return this.mouse_y;
    }

    //Metodi implementati delle interfacce

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        this.mouse_x = e.getX();
        this.mouse_y = e.getY();

        if (this.ui_handler != null)
        {
            this.ui_handler.onMouseMove(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON1)
        {
            this.left_pressed = true;
        }
        else if (e.getButton() == MouseEvent.BUTTON3)
        {
            this.right_pressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON1)
        {
            this.left_pressed = false;
        }
        else if (e.getButton() == MouseEvent.BUTTON3)
        {
            this.right_pressed = false;
        }

        if (this.ui_handler != null)
        {
            this.ui_handler.onMouseRelease(e);
        }
    }

}