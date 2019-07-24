package javagame.gamehandler.states;

import java.awt.Graphics;

import javagame.gamehandler.Handler;
import javagame.graphics.Assets;
import javagame.userinterface.*;
import javagame.userinterface.UIButton;

public class MenuState extends State
{
    private UIHandler ui_handler;
    
    public MenuState(Handler handler_)
    {
        super(handler_);
        this.ui_handler = new javagame.userinterface.UIHandler(handler_);

        handler.getMouseHandler().setUIHandler(this.ui_handler);

        this.ui_handler.addObject(new UIButton(0, 0, 1920, 1080, Assets.menu, () -> { 
            handler.getMouseHandler().setUIHandler(null);
            State.setState(handler.getGameHandler().getGameState());
        }));
    }


    @Override
    public void update()
    {
        this.ui_handler.update();
    }
    
    @Override
    public void render(Graphics graphics)
    {
        this.ui_handler.render(graphics);
    }
}