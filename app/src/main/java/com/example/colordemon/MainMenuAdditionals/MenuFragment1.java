package com.example.colordemon.MainMenuAdditionals;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.colordemon.GameStruct.Game;
import com.example.colordemon.databinding.MenuFragment2Binding;

public class MenuFragment1 extends Fragment {
    MenuFragment2Binding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MenuFragment2Binding.inflate(inflater);
        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Game.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        binding.random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Game.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        binding.tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Game.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return binding.getRoot();
    }
}
