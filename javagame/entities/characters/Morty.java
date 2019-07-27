package javagame.entities.characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


import javagame.gamehandler.Handler;
import javagame.graphics.Assets;
import javagame.graphics.animation.Animation;
import javagame.entities.Entity;

public class Morty extends CharacterBase
{
    //Timer, in millisecondi, per la gestione degli attacchi.
    private long last_attack_timer;
    private long attack_cooldown;
    private long attack_timer;


    public Morty(Handler handler_, float x, float y)
    {
        super(handler_, x, y, CharacterBase.DEFAULT_CHARACTERBASE_WIDTH, CharacterBase.DEFAULT_CHARACTERBASE_HEIGHT);
        
        this.collision_rectangle.x = 33;
        this.collision_rectangle.y = 64;
        this.collision_rectangle.width = 28;
        this.collision_rectangle.height = 29;

        //Creazione delle animazioni.
        this.animation_down = new Animation(250, Assets.morty_down);
        this.animation_up = new Animation(250, Assets.morty_up);
        this.animation_left = new Animation(250, Assets.morty_left);
        this.animation_right = new Animation(250, Assets.morty_right);

        //Setup dei timer per l'attacco.
        this.last_attack_timer = System.currentTimeMillis();
        this.attack_cooldown = 700L;
        this.attack_timer = 0L;
    }

    //********* METODI PRIVATE PER UTILITA' INTERNA ********* */

    private void getInput()
    {
        this.move_x = 0.0f;
        this.move_y = 0.0f;

        if (this.handler.getKeyboardHandler().getUp())
        {
            this.move_y = -this.speed;
        }
        else if (this.handler.getKeyboardHandler().getDown())
        {
            this.move_y = this.speed;
        }
        else if (this.handler.getKeyboardHandler().getRight())
        {
            this.move_x = this.speed;
        }
        else if (this.handler.getKeyboardHandler().getLeft())
        {
            this.move_x = -this.speed;
        }
    }


    //************* METODI PER UPDATE E RENDERING DEL PERSONAGGIO */
    @Override
    public void update()
    {
        this.animation_down.update();
        this.animation_up.update();
        this.animation_right.update();
        this.animation_left.update();
        this.getInput();
        this.move();
        this.handler.getGameCamera().centerOnEntity(this);

        //Check attack
        this.checkAttack();
    }

    /*
    Calcolo le coordinate di un rettangolo attaccato al rettangolo dell'hibox. La dimensione di questo nuovo rettangolo determina il range dell'attacco.
    In questo modo basterà fare il calcolo delle collisioni con questo nuovo rettangolo e vedere se l'attacco ha colpito oppure no.
    */
    private void checkAttack()
    {
        this.attack_timer += System.currentTimeMillis() - this.last_attack_timer;
        this.last_attack_timer = System.currentTimeMillis();

        if (this.attack_timer < this.attack_cooldown)
        {
            return;
        }

        var collision_bounds = this.getCollisionBounds(0, 0);

        var attack_hitbox = new Rectangle();
        int attack_hitbox_size = 20;

        attack_hitbox.width = attack_hitbox_size;
        attack_hitbox.height = attack_hitbox_size;
        
        if (this.handler.getKeyboardHandler().getAttackUp())
        {
            attack_hitbox.x = collision_bounds.x + collision_bounds.width / 2 - attack_hitbox_size / 2;
            attack_hitbox.y = collision_bounds.y - attack_hitbox_size;
        }
        else if (this.handler.getKeyboardHandler().getAttackDown())
        {
            attack_hitbox.x = collision_bounds.x + collision_bounds.width / 2 - attack_hitbox_size / 2;
            attack_hitbox.y = collision_bounds.y + collision_bounds.height;
        }
        else if (this.handler.getKeyboardHandler().getAttackLeft())
        {
            attack_hitbox.x = collision_bounds.x - attack_hitbox_size;
            attack_hitbox.y = collision_bounds.y + collision_bounds.height / 2 - attack_hitbox_size / 2;
        }
        else if (this.handler.getKeyboardHandler().getAttackRight())
        {
            attack_hitbox.x = collision_bounds.x + collision_bounds.width;
            attack_hitbox.y = collision_bounds.y + collision_bounds.height / 2 - attack_hitbox_size / 2;
        }
        else
        {
            return;
        }

        this.attack_timer = 0L;

        //Se l'attacco è avvenuto fare il check, altrimenti usciamo dalla funzione con l'else.
        for (Entity e : this.handler.getWorld().getEntityHandler().getEntities())
        {
            if (e.equals(this))
            {
                continue;
            }

            if (e.getCollisionBounds(0, 0).intersects(attack_hitbox))
            {
                e.damageReceived(2);
                return;
            }
        }
    }


    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(this.getCurrentAnimationFrame(), (int)(this.coord_x - this.handler.getGameCamera().getOffsetX()), 
        (int)(this.coord_y - this.handler.getGameCamera().getOffsetY()), this.entity_width, this.entity_height, null);
    
        // graphics.setColor(Color.BLUE);
        // graphics.fillRect((int)(coord_x + collision_rectangle.x - handler.getGameCamera().getOffsetX()), 
        //                     (int)(coord_y + collision_rectangle.y - handler.getGameCamera().getOffsetY()), collision_rectangle.width,
        //                     collision_rectangle.height);
    }


    private BufferedImage getCurrentAnimationFrame()
    {
        if (this.move_x < 0)
        {
            return this.animation_left.getCurrentAnimation();
        }
        else if (this.move_x > 0)
        {
            return this.animation_right.getCurrentAnimation();
        }
        else if (this.move_y < 0)
        {
            return this.animation_up.getCurrentAnimation();
        }
        else //(this.move_y < 0)
        {
            return this.animation_down.getCurrentAnimation();
        }
        // else
        // {
        //     //animazione di stand
        // }
    }

    @Override
    public void dead()
    {
        System.out.println("morto");
    } 
}