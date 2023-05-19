package com.example.colordemon.MainMenuAdditionals;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.SeekBar;

import com.example.colordemon.databinding.ActivityMainBinding;

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