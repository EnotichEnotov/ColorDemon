package com.example.colordemon.GameStruct;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.colordemon.GameView;

public class Game extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }
}
