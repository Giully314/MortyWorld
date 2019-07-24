package javagame.gamehandler;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;

import javagame.gamehandler.states.*;
import javagame.graphics.Assets;
import javagame.graphics.SpriteLoader;
import javagame.graphics.SpriteSheet;
import javagame.input.KeyHandler;
import javagame.window.Window;
import javagame.graphics.camera.GameCamera;

public class GameHandler implements Runnable
{
    //Gestione display.
    private Window window;
    private BufferStrategy screen_buffer;
    private Graphics graphics;

    //Informazioni sulla finestra.
    private int window_width;
    private int window_height;
    private String window_title;

    //thread game.
    private Thread gamehandler_thread;

    //gioco "acceso".
    private boolean is_running;

    //Stati del gioco
    private State game_state;
    private State menu_state;

    //Inputs
    private KeyHandler keyboard_handler;

    //Camera
    private GameCamera game_camera;

    //Handler 
    private Handler handler;

    public GameHandler(String title, int width, int height)
    {
        this.window_title = title;
        this.window_width = width;
        this.window_height = height;
        this.is_running = false;
        
        this.keyboard_handler = new KeyHandler();
    }

    //************************ METODI GET **************************
    public int getWidth()
    {
        return this.window_width;
    }

    public int getHeight()
    {
        return this.window_height;
    }

    public String getTitle()
    {
        return this.window_title;
    }

    public KeyHandler getKeyboardHandler()
    {
        return this.keyboard_handler;
    }
    
    public GameCamera getGameCamera()
    {
        return this.game_camera;
    }

    
    //*********** FUNZIONI PER USO INTERNO DELLA CLASSE. PERMETTONO L'ESECUZIONE DEL LOOP DI GIOCO. */
    private void init()
    {
        this.window = new Window(this.window_title, this.window_width, this.window_height);
        this.window.getWindowFrame().addKeyListener(this.keyboard_handler);

        Assets.init();

        this.handler = new Handler(this);

        this.game_camera = new GameCamera(this, 0.0f, 0.0f);
        
        this.game_state = new GameState(this.handler);
        this.menu_state = new MenuState(this.handler);
        State.setState(this.game_state);
    }

    
    private void update()
    {
        this.keyboard_handler.update();

        if (State.getState() != null)
        {
            State.getState().update();
        }
    }


    private void render()
    {
        this.screen_buffer = this.window.getScreenCanvas().getBufferStrategy();
        //Questo ciclo assicura di renderizzare in maniera corretta e senza perdita di informazioni, le immagini da disegnare sullo schermo.
        do
        {
            do
            {
                this.graphics = this.screen_buffer.getDrawGraphics();
                
                //Clear screen
                graphics.clearRect(0, 0, this.window_width, this.window_height);

                if (State.getState() != null)
                {
                    State.getState().render(this.graphics);
                }
        
                this.graphics.dispose();

            }while (this.screen_buffer.contentsRestored());

            this.screen_buffer.show();

        }while (this.screen_buffer.contentsLost());
    }


    //********************** FUNZIONI PER FAR PARTIRE IL GIOCO    ******************************************
    public synchronized void start()
    {
        if (this.is_running)
        {
            return;
        }

        this.is_running = true;
        this.gamehandler_thread = new Thread(this);
        this.gamehandler_thread.start();
    }

    public synchronized void stop()
    {   
        if (!this.is_running)
        {
            return;
        }

        this.is_running = false;

        try
        {
            this.gamehandler_thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        this.init();

        /*
        time_per_update viene indicato in nanosecondi per avere un tempo più preciso.
        */
        int fps = 60;
        long nano_second = 1000000000L;
        double time_per_update = nano_second / fps;
        double elapsed_time = 0;
        long now;
        long last_time = System.nanoTime();
        long timer = 0;
        int updates = 0;

        while (this.is_running)
        {
            now = System.nanoTime();
            elapsed_time += (now - last_time) / time_per_update;
            //timer += now - last_time;
            last_time = now;

            if (elapsed_time >= 1)
            {
                this.update();
                this.render();
                //++updates;
                --elapsed_time;
            }

            // if (timer >= nano_second)
            // {
            //     System.out.println(updates);
            //     updates = 0;
            //     timer = 0;
            // }
        }

        this.stop();
    }
}