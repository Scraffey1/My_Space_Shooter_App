package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Explosion
{
    Bitmap explosion[] = new Bitmap[9];
    int explosion_Frame;
    int Explosion_x, Explosion_y;

    public Explosion(Context context, int explosion_x,int explosion_y)
    {
       explosion[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explosion0);
        explosion[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explosion1);
        explosion[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explosion2);
        explosion[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explosion3);
        explosion[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explosion4);
        explosion[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explosion5);
        explosion[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explosion6);
        explosion[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explosion7);
        explosion[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explosion8);
        explosion_Frame = 0;
        this.Explosion_x = explosion_x;
        this.Explosion_y = explosion_y;

    }

    public Bitmap getExplosion(int explosion_Frame)
    {
        return explosion[explosion_Frame];
    }

}
