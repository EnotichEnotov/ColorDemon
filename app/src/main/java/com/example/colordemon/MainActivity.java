package com.example.colordemon;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.SeekBar;
import com.example.colordemon.databinding.ActivityMainBinding;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // music
    ActivityMainBinding binding;
    MediaPlayer mPlayer;
    SeekBar volumeControl;
    AudioManager audioManager;
    // пока не используется
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //music
        mPlayer=MediaPlayer.create(this, R.raw.main_menu_music);
        mPlayer.start();
        //TEST
        Locale locale = new Locale("en");
        changeLocale(locale);

        //TEST
        Shader textShader = new LinearGradient(0, 0, binding.title.getPaint().measureText(String.valueOf(binding.title.getText())), binding.title.getTextSize(),
                new int[]{
                        getColor(R.color.red_rainbow),
                        getColor(R.color.orange_rainbow),
                        getColor(R.color.yellow_rainbow),
                        getColor(R.color.green_rainbow),
                        getColor(R.color.blue_rainbow),
                        getColor(R.color.violet_rainbow),
                }, null, Shader.TileMode.CLAMP);
        binding.title.getPaint().setShader(textShader);
        binding.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Settings.class);
                startActivity(intent);
                finish();
            }
        });
        binding.shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Shop.class);
                startActivity(intent);
                finish();
            }
        });
        binding.exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finishAndRemoveTask();
            }
        });

    }
    @SuppressWarnings("deprecation")
    private void changeLocale(Locale locale){
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
    }
};


