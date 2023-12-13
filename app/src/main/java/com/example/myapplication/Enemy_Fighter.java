package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Enemy_Fighter {
    Context context;
    Bitmap enemy_Fighter;
    int ex, ey;
    int enemy_Velocity;
    Random random;

    public Enemy_Fighter(Context context)
    {
    this.context = context;
    enemy_Fighter = BitmapFactory.decodeResource(context.getResources(),R.drawable.rocket2);
    random = new Random();
    reset_Enemy_Fighter();
    }
    public Bitmap getEnemy_Fighter()
    {
        return enemy_Fighter;
    }
    int getEnemy_Fighter_Width()
    {
        return enemy_Fighter.getWidth();
    }
    int getEnemy_Fighter_Height()
    {
        return enemy_Fighter.getHeight();
    }
    private void reset_Enemy_Fighter()
    {
        ex = 200 + random.nextInt(400);
        ey = 0;
        enemy_Velocity = 14 + random.nextInt(10);
    }
}
