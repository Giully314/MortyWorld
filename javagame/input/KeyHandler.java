package javagame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener
{
    private boolean[] keyboard_state;
    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;

    public KeyHandler()
    {
        this.keyboard_state = new boolean[256];
    }


    public void update()
    {
        this.up = this.keyboard_state[KeyEvent.VK_UP];
        this.down = this.keyboard_state[KeyEvent.VK_DOWN];
        this.right = this.keyboard_state[KeyEvent.VK_RIGHT];
        this.left = this.keyboard_state[KeyEvent.VK_LEFT];
    }


    //******************** METODI GET *************************
    public boolean getUp()
    {
        return this.up;
    }

    public boolean getDown()
    {
        return this.down;
    }

    public boolean getRight()
    {
        return this.right;
    }

    public boolean getLeft()
    {
        return this.left;
    }


    //************** METODI KEYLISTENER ***********************
    @Override
    public void keyPressed(KeyEvent event)
    {
        this.keyboard_state[event.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent event)
    {
        this.keyboard_state[event.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent event)
    {

    }
}