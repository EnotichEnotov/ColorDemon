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
import com.example.colordemon.MainMenuAdditionals.SettingsFragment;
import com.example.colordemon.MainMenuAdditionals.ShopFragment;
import com.example.colordemon.databinding.ActivityMainBinding;
import java.util.Locale;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    // music
    ActivityMainBinding binding;
    private float fromPosition;
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
        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Game.class);
                startActivity(intent);
                finish();
            }
        });
        binding.mainMenuIconButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Shop.class);
                startActivity(intent);
                finish();
            }
        });
        binding.mainMenuIconButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Settings.class);
                startActivity(intent);
                finish();
            }
        });
        binding.pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        binding.pager.setCurrentItem(1);
    // LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    //binding.flipper.setOnTouchListener(this);
    //int layouts[] = new int[]{ R.layout.shop, R.layout.settings};
    //    for (int layout : layouts)
    //        binding.flipper.addView(inflater.inflate(layout, null));
    }
    //@Override
    //public boolean onTouch(View view, MotionEvent event) {
    //    switch (event.getAction())
    //    {
    //        case MotionEvent.ACTION_DOWN:
    //            fromPosition = event.getX();
    //            break;
    //        case MotionEvent.ACTION_UP:
    //            float toPosition = event.getX();
    //            if (fromPosition > toPosition)
    //            {
    //                binding.flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.go_next_in));
    //                binding.flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.go_next_out));
    //                binding.flipper.showNext();
    //            }
    //            else if (fromPosition < toPosition)
    //            {
    //                binding.flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.go_prev_in));
    //                binding.flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.go_prev_out));
    //                binding.flipper.showPrevious();
    //            }
    //        default:
    //            break;
    //    }
    //    return true;
    //}

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
            switch (position) {
                case 0:
                    return new ShopFragment();
                case 1:
                    return new SettingsFragment();
                case 2:
                    return new ShopFragment();

                default:
                    return new SettingsFragment();
            }
        }
    }
}


