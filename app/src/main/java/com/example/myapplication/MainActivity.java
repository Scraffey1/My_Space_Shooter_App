package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Space_Shooter_Game spaceShooterGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spaceShooterGame = new Space_Shooter_Game(this);
        setContentView(spaceShooterGame);
    }

    @Override
    protected void onResume() {
        super.onResume();
        spaceShooterGame.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        spaceShooterGame.pause();
    }
}