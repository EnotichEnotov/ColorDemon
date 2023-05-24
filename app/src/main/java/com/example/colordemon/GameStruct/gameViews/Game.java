package com.example.colordemon.GameStruct.gameViews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.colordemon.GameStruct.gameViews.first.GameView;
import com.example.colordemon.GameStruct.gameViews.mage.GameMageView;
import com.example.colordemon.R;
import com.example.colordemon.activities.MainActivity;
import com.example.colordemon.database.entity.MapOrCharacterEntity;
import com.example.colordemon.database.entity.bd.App;

public class Game extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button button = new Button(this);
        button.setText("<-");
        button.setTextSize(50);
        button.setX(100);
        button.setY(100);
        button.setWidth(50);
        button.setHeight(50);
        button.setBackground(getResources().getDrawable(R.drawable.shop_activatedbut));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        switch (App.getDatabase().getChosen()){
            case 0:
                setContentView(new GameView(this));
                break;
            default:
                setContentView(new GameMageView(this));
                break;
        }
    }
}
