package com.example.colordemon.GameStruct.gameViews;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.example.colordemon.GameStruct.gameViews.first.GameView;
import com.example.colordemon.GameStruct.gameViews.mage.GameMageView;
import com.example.colordemon.database.entity.MapOrCharacterEntity;
import com.example.colordemon.database.entity.bd.App;

public class Game extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        switch (App.getDatabase().getChosen()){
            case 0:
                setContentView(new GameView(this));
                break;
            case 1:
                setContentView(new GameMageView(this));
                break;
            default:
                setContentView(new GameMageView(this));
                break;
        }
    }
}
