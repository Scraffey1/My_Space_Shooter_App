package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Bullet
{
    Bitmap bullet;
    Context context;
    int Bullet_X, Bullet_Y;

    public Bullet(Context context, int Bullet_X, int Bullet_Y)
    {
        this.context = context;
        bullet = BitmapFactory.decodeResource(context.getResources(), R.drawable.shot);
        this.Bullet_X = Bullet_X;
        this.Bullet_Y = Bullet_Y;

    }

    public Bitmap getBullet()
    {
        return bullet;
    }

}
