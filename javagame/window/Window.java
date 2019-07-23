package javagame.window;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;


public class Window
{
    private JFrame window;
    private Canvas screen;


    private String window_title;
    private int window_width;
    private int window_height;

    public Window(String title, int width, int height)
    {
        this.window_title = title;
        this.window_width = width;
        this.window_height = height;

        this.initWindow();
    }

    //****** FUNZIONI GET *****************
    public Canvas getScreenCanvas()
    {
        return this.screen;
    }

    public JFrame getWindowFrame()
    {
        return this.window;
    }


    // ********************* FUNZIONI PRIVATE PER INIZIALIZZAZIONE ***************

    //Semplice inizializzazione finestra e setup di alcune impostazioni base
    private void initWindow()
    {
        this.window = new JFrame(this.window_title);
        this.window.setSize(this.window_width, this.window_height);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.window.setResizable(false);
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);

        this.initCanvas();

        this.window.add(this.screen);
        this.window.pack(); 

        //Creazione buffers
        this.screen.createBufferStrategy(3);
    }

    //Inizializzazione componente Canvas
    private void initCanvas()
    {
        this.screen = new Canvas();
        var dimension = new Dimension(this.window_width, this.window_height);
        this.screen.setPreferredSize(dimension);
        this.screen.setMaximumSize(dimension);
        this.screen.setMinimumSize(dimension);
        this.screen.setFocusable(false);
    }
}