package com.example.colordemon.MainMenuAdditionals;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.colordemon.R;
import com.example.colordemon.databinding.SettingsBinding;
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
import com.example.colordemon.databinding.SettingsBinding;
import java.util.Locale;
import java.util.zip.Inflater;

public class SettingsFragment extends Fragment {
    public SettingsFragment() {
    }
    SettingsBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SettingsBinding.inflate(getLayoutInflater());

        binding.flagRus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale = new Locale("ru");
            }
        });
        binding.flagEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale = new Locale("en");
            }
        });

        return binding.getRoot();
    }


}
