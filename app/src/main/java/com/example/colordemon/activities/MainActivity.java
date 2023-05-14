package com.example.colordemon.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.OnSwipe;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.SeekBar;

import com.example.colordemon.MainMenuAdditionals.DownloadActivity;
import com.example.colordemon.MainMenuAdditionals.MenuFragment;
import com.example.colordemon.MainMenuAdditionals.MenuFragment1;
import com.example.colordemon.MainMenuAdditionals.SettingsFragment;
import com.example.colordemon.MainMenuAdditionals.SettingsInfo;
import com.example.colordemon.MainMenuAdditionals.ShopFragment;
import com.example.colordemon.R;
import com.example.colordemon.database.entity.bd.App;
import com.example.colordemon.databinding.ActivityMainBinding;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DataPushing{
    // music
    ActivityMainBinding binding;

    MediaPlayer mPlayer;
    SeekBar volumeControl;
    AudioManager audioManager;
    // пока не используется
    protected void change_navigation_icons(int a1, int a2, int a3, boolean c1, boolean c2, boolean c3){
        binding.mainMenuPictureButton1.setImageAlpha(a1);
        binding.mainMenuPictureButton2.setImageAlpha(a2);
        binding.mainMenuPictureButton3.setImageAlpha(a3);
        if (c1) {
            binding.mainTextIconButton1.setTextColor(getColor(R.color.black));
        }
        else {
            binding.mainTextIconButton1.setTextColor(getColor(R.color.grey));
        }
        if (c2) {
            binding.mainTextIconButton2.setTextColor(getColor(R.color.black));
        }
        else {
            binding.mainTextIconButton2.setTextColor(getColor(R.color.grey));
        }
        if (c3) {
            binding.mainTextIconButton3.setTextColor(getColor(R.color.black));
        }
        else {
            binding.mainTextIconButton3.setTextColor(getColor(R.color.grey));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //music
        mPlayer=MediaPlayer.create(this, R.raw.main_menu_music);
        mPlayer.start();
        //TEST
        Locale locale = new Locale(App.getDatabase().getLanguage());
        changeLocale(locale);

        binding.pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        binding.pager.setCurrentItem(1);
        binding.mainMenuIconButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change_navigation_icons(255, 50, 50, true, false, false);
                binding.pager.setCurrentItem(0);

            }
        });
        binding.mainMenuIconButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change_navigation_icons(50, 255, 50, false, true, false);
                binding.pager.setCurrentItem(1);
            }
        });
        binding.mainMenuIconButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change_navigation_icons(50, 50, 255, false, false, true);
                binding.pager.setCurrentItem(2);
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

    @Override
    public void DataPush(SettingsInfo settingsInfo) {
        //changeLocale(new Locale(settingsInfo.getLanguage()));
        App.getDatabase().save(settingsInfo.getLanguage(),settingsInfo.getVolume());
        // + настройка звука, можно будет тягать доп штуки с настроек
        Intent intent = new Intent(MainActivity.this, DownloadActivity.class);
        startActivity(intent);
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
                    //binding.mainMenuPictureButton1.setImageAlpha(255);
                    //binding.mainMenuPictureButton2.setImageAlpha(50);
                    //binding.mainMenuPictureButton3.setImageAlpha(50);
                    return new ShopFragment();
                case 1:
                    //binding.mainMenuPictureButton1.setImageAlpha(50);
                    //binding.mainMenuPictureButton2.setImageAlpha(255);
                    //binding.mainMenuPictureButton3.setImageAlpha(50);
                    return new MenuFragment1();
                case 2:
                    //binding.mainMenuPictureButton1.setImageAlpha(50);
                    //binding.mainMenuPictureButton2.setImageAlpha(50);
                    //binding.mainMenuPictureButton3.setImageAlpha(255);
                    return new SettingsFragment(App.getDatabase().getLanguage(),App.getDatabase().getVolume());
                default:
                    //binding.mainMenuPictureButton1.setImageAlpha(50);
                    //binding.mainMenuPictureButton2.setImageAlpha(255);
                    //binding.mainMenuPictureButton3.setImageAlpha(50);
                    return new MenuFragment();
            }
        }
    }
}


