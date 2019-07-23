package javagame.gamehandler.states;

import java.awt.Graphics;

import javagame.gamehandler.GameHandler;

public abstract class State
{   
    private static State current_state;

    protected GameHandler game_handler;

    public State(GameHandler game_handler_)
    {
        this.game_handler = game_handler_;
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