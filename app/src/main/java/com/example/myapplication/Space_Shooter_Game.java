package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


import java.util.ArrayList;
import java.util.Random;

public class Space_Shooter_Game extends SurfaceView implements Runnable
{
    Context context;
    Bitmap background, life_Image;
    Handler handler;
    //long UPDATE_MILLIS = 30;
    static int screen_Width, screen_Height;
    int points = 0;
    int lives = 3;
    Paint score_Paint;
    int TEXT_SIZE = 80;
    boolean paused = false;
    boolean isRunning = false;
    Player_SpaceShip player_spaceShip;
    Enemy_Fighter enemy_fighter;
    Random random;
    ArrayList<Bullet> Enemy_Bullet, Player_Bullet;
    boolean enemy_Explosion = false;
    Explosion explosion;
    ArrayList<Explosion> explosions;
    SurfaceHolder holder;
    boolean enemy_Shot_Action = false;
    private Canvas canvas;
    private Thread thread;
   final Runnable runnable = new Runnable() {
       @Override
      public void run() {
            invalidate();
        }
    };

    public Space_Shooter_Game(Context context) {
        super(context);
      //  holder = getHolder();
        this.context = context;
        random = new Random();
        Enemy_Bullet = new ArrayList<>();
        Player_Bullet = new ArrayList<>();
        explosions = new ArrayList<>();
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screen_Width = size.x;
        screen_Height = size.y;
        player_spaceShip = new Player_SpaceShip(context);
        enemy_fighter = new Enemy_Fighter(context);
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.background);
        life_Image = BitmapFactory.decodeResource(context.getResources(), R.drawable.life);
        handler = new Handler();
        score_Paint = new Paint();
        score_Paint.setColor(Color.RED);
        score_Paint.setTextSize(TEXT_SIZE);
        score_Paint.setTextAlign(Paint.Align.LEFT);


    }
   @Override
    protected void onDraw(Canvas canvas)
   {
       if (holder.getSurface().isValid()) {
           canvas = holder.lockCanvas();
           // draw
           holder.unlockCanvasAndPost(canvas);

//
           canvas.drawBitmap(background, 0, 0, null);
           canvas.drawText("Score: " + points, 0, TEXT_SIZE, score_Paint);

           for (int i = lives; i > 1; i--) {
               canvas.drawBitmap(life_Image, screen_Width - life_Image.getWidth() * i, 0, null);
           }

           for (int i = 0; i < Enemy_Bullet.size(); i++) {
               Enemy_Bullet.get(i).Bullet_Y += 15;
               canvas.drawBitmap(Enemy_Bullet.get(i).getBullet(), Enemy_Bullet.get(i).Bullet_X, Enemy_Bullet.get(i).Bullet_Y, null);
               if ((Enemy_Bullet.get(i).Bullet_X >= player_spaceShip.px) && (Enemy_Bullet.get(i).Bullet_X <= player_spaceShip.px + player_spaceShip.get_Player_SpaceShip_Width()) && (Enemy_Bullet.get(i).Bullet_Y >= player_spaceShip.py) && (Enemy_Bullet.get(i).Bullet_Y <= screen_Height)) {
                   lives--;
                   Enemy_Bullet.remove(i);
                   explosion = new Explosion(context, player_spaceShip.px, player_spaceShip.py);
                   explosions.add(explosion);
               } else if (Enemy_Bullet.get(i).Bullet_Y >= screen_Height) {
                   Enemy_Bullet.remove(i);
               }
               if (Enemy_Bullet.size() == 0) {
                   enemy_Shot_Action = false;
               }
           }

           for (int i = 0; i < explosions.size(); i++)
           {
               {
                   canvas.drawBitmap(explosions.get(i).getExplosion(explosions.get(i).explosion_Frame), explosions.get(i).Explosion_x, explosions.get(i).Explosion_y, null);
                   explosions.get(i).explosion_Frame++;
                   if (explosions.get(i).explosion_Frame > 8) {
                       explosions.remove(i);

                   }
               }
           }



       }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

            int touch_X = (int) event.getX();
            if(event.getAction() == MotionEvent.ACTION_UP)
            {
                if(Player_Bullet.size()<3)
                {
                    Bullet player_Bullet = new Bullet(context,player_spaceShip.px +player_spaceShip.get_Player_SpaceShip_Width()/2,player_spaceShip.py);
                    Player_Bullet.add(player_Bullet);
                }
            }
            if(event.getAction() == MotionEvent.ACTION_DOWN)
            {
                player_spaceShip.px = touch_X;
            }
            if(event.getAction() == MotionEvent.ACTION_MOVE)
            {
                player_spaceShip.px = touch_X;
            }
            return true;

    }

    @Override
    public void run() {
        while(isRunning)
        {
            // check framerate
            update();
           draw(canvas);
           //draw();
        }
    }

    private void draw() {
        if (holder.getSurface().isValid()) {
            canvas = holder.lockCanvas();
            // draw
            holder.unlockCanvasAndPost(canvas);

           holder = getHolder();
            this.context = context;
            random = new Random();
            Enemy_Bullet = new ArrayList<>();
            Player_Bullet = new ArrayList<>();
            explosions = new ArrayList<>();
            Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screen_Width = size.x;
            screen_Height = size.y;
            player_spaceShip = new Player_SpaceShip(context);
            enemy_fighter = new Enemy_Fighter(context);
            background = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
            life_Image = BitmapFactory.decodeResource(context.getResources(), R.drawable.life);
            handler = new Handler();
            score_Paint = new Paint();
            score_Paint.setColor(Color.RED);
            score_Paint.setTextSize(TEXT_SIZE);
            score_Paint.setTextAlign(Paint.Align.LEFT);
            canvas.drawBitmap(background, 0, 0, null);
            canvas.drawText("Score: " + points, 0, TEXT_SIZE, score_Paint);

            for (int i = lives; i > 1; i--) {
                canvas.drawBitmap(life_Image, screen_Width - life_Image.getWidth() * i, 0, null);
            }

            for (int i = 0; i < Enemy_Bullet.size(); i++) {
                Enemy_Bullet.get(i).Bullet_Y += 15;
                canvas.drawBitmap(Enemy_Bullet.get(i).getBullet(), Enemy_Bullet.get(i).Bullet_X, Enemy_Bullet.get(i).Bullet_Y, null);
                if ((Enemy_Bullet.get(i).Bullet_X >= player_spaceShip.px) && (Enemy_Bullet.get(i).Bullet_X <= player_spaceShip.px + player_spaceShip.get_Player_SpaceShip_Width()) && (Enemy_Bullet.get(i).Bullet_Y >= player_spaceShip.py) && (Enemy_Bullet.get(i).Bullet_Y <= screen_Height)) {
                    lives--;
                    Enemy_Bullet.remove(i);
                    explosion = new Explosion(context, player_spaceShip.px, player_spaceShip.py);
                    explosions.add(explosion);
                } else if (Enemy_Bullet.get(i).Bullet_Y >= screen_Height) {
                    Enemy_Bullet.remove(i);
                }
                if (Enemy_Bullet.size() == 0) {
                    enemy_Shot_Action = false;
                }
            }

            for (int i = 0; i < explosions.size(); i++)
            {
                {
                    canvas.drawBitmap(explosions.get(i).getExplosion(explosions.get(i).explosion_Frame), explosions.get(i).Explosion_x, explosions.get(i).Explosion_y, null);
                    explosions.get(i).explosion_Frame++;
                    if (explosions.get(i).explosion_Frame > 8) {
                        explosions.remove(i);

                    }
                }
            }



        }
    }

    private void update() {
//                draw();


        if (lives == 0) {
            paused = true;
            handler = null;
            Intent intent = new Intent(context, Game_Over.class);
            intent.putExtra("points", points);
            context.startActivity(intent);
            ((Activity) context).finish();
        }

        enemy_fighter.ex += enemy_fighter.enemy_Velocity;
        if (enemy_fighter.ex + enemy_fighter.getEnemy_Fighter_Width() >= screen_Width) {
            enemy_fighter.enemy_Velocity *= -1;
        }
        if (enemy_fighter.ex <= 0) {
            enemy_fighter.enemy_Velocity *= -1;
        }

        if (player_spaceShip.is_Alive = true)
        {
            if (player_spaceShip.px > screen_Width - player_spaceShip.get_Player_SpaceShip_Width()) {
                player_spaceShip.px = screen_Width - player_spaceShip.get_Player_SpaceShip_Width();

            } else if (player_spaceShip.px <= 0) {
                player_spaceShip.px = 0;
            }
            canvas.drawBitmap(player_spaceShip.getPlayer_SpaceShip(), player_spaceShip.px, player_spaceShip.py, null);

        }

        for (int i = 0; i < Player_Bullet.size(); i++) {
            Player_Bullet.get(i).Bullet_Y -= 15;

            if ((Player_Bullet.get(i).Bullet_X >= enemy_fighter.ex) && (Player_Bullet.get(i).Bullet_X <= enemy_fighter.ex + enemy_fighter.getEnemy_Fighter_Width()) && (Player_Bullet.get(i).Bullet_Y >= enemy_fighter.ey) && (Player_Bullet.get(i).Bullet_Y <= screen_Height)) {
                lives--;
                Player_Bullet.remove(i);
                explosion = new Explosion(context, enemy_fighter.ex, enemy_fighter.ey);
                explosions.add(explosion);
            } else if (Player_Bullet.get(i).Bullet_Y >= screen_Height)
            {
                Player_Bullet.remove(i);
            }

        }

      // if (paused) {
        //      handler.postDelayed(runnable, UPDATE_MILLIS);
         // }
    }


    public void resume()
    {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        isRunning = false;
        try {
            thread.join();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }


}

