package javagame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
Gestore tastiera.
*/
public class KeyHandler implements KeyListener
{
    private boolean[] keyboard_state;
    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;

    private boolean attack_up;
    private boolean attack_down;
    private boolean attack_left;
    private boolean attack_right;

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

        this.attack_up = this.keyboard_state[KeyEvent.VK_W];
        this.attack_down = this.keyboard_state[KeyEvent.VK_S];
        this.attack_left = this.keyboard_state[KeyEvent.VK_A];
        this.attack_right = this.keyboard_state[KeyEvent.VK_D];
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

    public boolean getAttackUp()
    {
        return this.attack_up;
    }

    public boolean getAttackDown()
    {
        return this.attack_down;
    }

    public boolean getAttackLeft()
    {
        return this.attack_left;
    }

    public boolean getAttackRight()
    {
        return this.attack_right;
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