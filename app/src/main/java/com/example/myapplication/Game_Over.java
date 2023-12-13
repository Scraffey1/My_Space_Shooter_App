package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Game_Over extends AppCompatActivity
{
    TextView Score;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        int score = getIntent().getExtras().getInt("Score");
        Score = findViewById(R.id.score);
        Score.setText("" + score);
    }
    public void Restart(View view)
    {
        Intent intent = new Intent(Game_Over.this, Start_Up.class);
        startActivity(intent);
        finish();
    }

    public void Exit(View view)
    {
        finish();
    }
}
