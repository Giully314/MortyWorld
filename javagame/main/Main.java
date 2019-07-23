package javagame.main;

import javagame.gamehandler.GameHandler;

public class Main
{
    public static void main(String ...args)
    {
        var game = new GameHandler("Ramanujan", 1920, 1080);

        game.start();
    }
}