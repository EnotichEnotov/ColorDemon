package com.example.colordemon.MainMenuAdditionals;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        binding.languageEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.language="en";
                binding.languageChoose.setText("English");
                pushingManager.DataPush(info);
            }
        });
        binding.languageRus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.language="ru";
                binding.languageChoose.setText("Russian");
                pushingManager.DataPush(info);
            }
        });
        return binding.getRoot();
    }
}
