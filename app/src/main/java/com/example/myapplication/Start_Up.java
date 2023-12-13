package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Start_Up extends AppCompatActivity
{
    public void onCreate(@Nullable Bundle SavedInstanceState)
    {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.start_up);
    }

    public void Start_Game(View view)
    {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
