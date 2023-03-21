package com.example.colordemon.MainMenuAdditionals;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
public class MainThemeMusic extends AppCompatActivity implements MusicInterface{
    ActivityMainBinding binding;
    public boolean InProcess = false;
    MediaPlayer mPlayer;
    SeekBar volumeControl;
    AudioManager audioManager;

    MainThemeMusic (boolean InProcess, MediaPlayer mPlayer, SeekBar volumeControl, AudioManager audioManager){
        this.InProcess = InProcess;
        this.mPlayer = mPlayer;
        this.volumeControl = volumeControl;
        this.audioManager = audioManager;

    }




    }