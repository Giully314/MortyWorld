package javagame.gamehandler.states;

import java.awt.Graphics;

import javagame.gamehandler.GameHandler;
import javagame.gamehandler.Handler;

public abstract class State
{   
    private static State current_state;

    protected Handler handler;

    public State(Handler handler_)
    {
        this.handler = handler_;
    }

    static
    {
        current_state = null;
    }

    public static void setState(State state)
    {
        State.current_state = state;
    }

    public static State getState()
    {
        return State.current_state;
    }


    //Ogni stato di gioco, ha due metodi in comune: update e render.

    public abstract void update();

    public abstract void render(Graphics graphics);
}