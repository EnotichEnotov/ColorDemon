package com.example.colordemon.MainMenuAdditionals;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.colordemon.GameStruct.Game;
import com.example.colordemon.MainActivity;
import com.example.colordemon.R;
import com.example.colordemon.Settings;
import com.example.colordemon.Shop;
import com.example.colordemon.databinding.MenuFragmentBinding;

public class MenuFragment extends Fragment {
    public MenuFragment(){}
    MenuFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MenuFragmentBinding.inflate(inflater);
        Shader textShader = new LinearGradient(0, 0, binding.title.getPaint().measureText(String.valueOf(binding.title.getText())), binding.title.getTextSize(),
                new int[]{
                        getResources().getColor(R.color.red_rainbow),
                        getResources().getColor(R.color.orange_rainbow),
                        getResources().getColor(R.color.yellow_rainbow),
                        getResources().getColor(R.color.green_rainbow),
                        getResources().getColor(R.color.blue_rainbow),
                        getResources().getColor(R.color.violet_rainbow),
                }, null, Shader.TileMode.CLAMP);
        binding.title.getPaint().setShader(textShader);
        binding.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Settings.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        binding.shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Shop.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        binding.exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                //finishAndRemoveTask();
            }
        });
        binding.start.setOnClickListener(new View.OnClickListener() {
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
