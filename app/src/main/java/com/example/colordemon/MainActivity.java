package com.example.colordemon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.res.Configuration;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.example.colordemon.GameStruct.Game;
import com.example.colordemon.GameStruct.GameView;
import com.example.colordemon.MainMenuAdditionals.MenuFragment;
import com.example.colordemon.MainMenuAdditionals.SettingsFragment;
import com.example.colordemon.MainMenuAdditionals.ShopFragment;
import com.example.colordemon.databinding.ActivityMainBinding;
import java.util.Locale;
import java.util.zip.Inflater;

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

        binding.pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        binding.pager.setCurrentItem(1);
        binding.mainMenuIconButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this,Shop.class);
                //startActivity(intent);
                //finish();
                binding.pager.setCurrentItem(2);
            }
        });
        binding.mainMenuIconButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this,Game.class);
                //startActivity(intent);
                //finish();
                binding.pager.setCurrentItem(0);
            }
        });
        binding.mainMenuIconButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this,Settings.class);
                //startActivity(intent);
                //finish();
                binding.pager.setCurrentItem(1);
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
    class MyPagerAdapter extends FragmentPagerAdapter {

        MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position%3) {
                case 0:
                    return new ShopFragment();

                case 1:
                    return new MenuFragment();

                case 2:
                    return new SettingsFragment();
                default:
                    return new MenuFragment();
            }
        }
    }
}


