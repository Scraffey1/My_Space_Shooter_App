package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Player_SpaceShip
{
    Context context;
    Bitmap player_SpaceShip;
    int px, py;
    boolean is_Alive;
    int Player_Velocity;
    Random random;

    public Player_SpaceShip(Context context)
    {
        this.context = context;
        player_SpaceShip = BitmapFactory.decodeResource(context.getResources(),R.drawable.rocket1);
        random = new Random();
        reset_Player_Space_Ship();

    }
    public Bitmap getPlayer_SpaceShip()
    {
        return player_SpaceShip;
    }
    int get_Player_SpaceShip_Width()
    {
        return player_SpaceShip.getWidth();
    }
    int get_Player_SpaceShip_Height()
    {
        return player_SpaceShip.getHeight();
    }
    private void reset_Player_Space_Ship()
    {
        px = random.nextInt(Space_Shooter_Game.screen_Width);
        py = Space_Shooter_Game.screen_Height - player_SpaceShip.getHeight();
        Player_Velocity = 10 + random.nextInt(6);
    }
}
