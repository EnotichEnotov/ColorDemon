package com.example.colordemon.MainMenuAdditionals;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.colordemon.activities.DataPushing;
import com.example.colordemon.databinding.SettingsBinding;

public class SettingsFragment extends Fragment {
    private SettingsInfo info;
    SettingsBinding binding;
    private DataPushing pushingManager;
    public SettingsFragment(String language,float volume) {
        info = new SettingsInfo(volume,language);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        pushingManager = (DataPushing) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SettingsBinding.inflate(inflater);
        hideAll();
        setNowLanguage();
        binding.flagEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.language="en";
                hideAll();
                setNowLanguage();
            }
        });
        binding.flagRus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.language="ru";
                hideAll();
                setNowLanguage();
            }
        });
        binding.flagGer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.language="gem";
                hideAll();
                setNowLanguage();
            }
        });
        binding.flagItaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.language="it";
                hideAll();
                setNowLanguage();
            }
        });
        binding.flagSpain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.language="pt";
                hideAll();
                setNowLanguage();
            }
        });
        binding.flagChina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.language="ch";
                hideAll();
                setNowLanguage();
            }
        });
        binding.apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushingManager.DataPush(info);
            }
        });
        return binding.getRoot();
    }
    private void hideAll(){
        binding.flagRus.setAlpha(128);
        binding.flagEn.setAlpha(128);
        binding.flagChina.setAlpha(128);
        binding.flagGer.setAlpha(128);
        binding.flagSpain.setAlpha(128);
        binding.flagItaly.setAlpha(128);
    }
    private void setNowLanguage(){
        switch (info.language){
            case "en":
                binding.flagEn.setAlpha(255);
                binding.languageChoose.setText("English");
                break;
            case "ru":
                binding.flagRus.setAlpha(255);
                binding.languageChoose.setText("Русский");
                break;
            case "gem":
                binding.flagGer.setAlpha(255);
                binding.languageChoose.setText("German");
                break;
            case "it":
                binding.flagItaly.setAlpha(255);
                binding.languageChoose.setText("Italian");
                break;
            case "pt":
                binding.flagSpain.setAlpha(255);
                binding.languageChoose.setText("Spanish");
                break;
            case "ch":
                binding.flagChina.setAlpha(255);
                binding.languageChoose.setText("China");
                break;
        }
    }
}
