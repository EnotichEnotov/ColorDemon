package com.example.colordemon.MainMenuAdditionals;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.colordemon.App;
import com.example.colordemon.DataPushing;
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
                binding.languageChoose.setText("English");
                hideAll();
                setNowLanguage();
            }
        });
        binding.flagRus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.language="ru";
                binding.languageChoose.setText("Russian");
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
                binding.languageChoose.setText("Russian");
                break;
        }
    }
}
