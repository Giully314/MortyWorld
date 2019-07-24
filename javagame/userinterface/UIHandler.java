package javagame.userinterface;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javagame.gamehandler.Handler;

/*
Questa classe si occupa della gestione dell'interfaccia utente. Utilizzata nel menu e nell'inventario che doveva essere aggiunto
ma che per mancanza di tempo non è stato ultimato.
*/
public class UIHandler
{
    private Handler handler;
    private ArrayList<UIObject> objects;

    public UIHandler(Handler handler_)
    {
        this.handler = handler_;
        this.objects = new ArrayList<>();
    }

    //************ METODI GET ***************** */
    public Handler getHandler()
    {
        return this.handler;
    }

    public ArrayList<UIObject> getUIObjects()
    {
        return this.objects;
    }



    public void update()
    {
        this.objects.forEach(UIObject::update);
    }

    public void render(Graphics graphics)
    {
        this.objects.forEach(object -> object.render(graphics));
    }

    public void onMouseMove(MouseEvent e)
    {
        this.objects.forEach(object -> object.onMouseMove(e));
    }

    public void onMouseRelease(MouseEvent e)
    {
        this.objects.forEach(object -> object.onMouseRelease(e));
    }

    public void addObject(UIObject o)
    {
        this.objects.add(o);
    }

    public void removeObject(UIObject o)
    {
        this.objects.remove(o);
    }
}