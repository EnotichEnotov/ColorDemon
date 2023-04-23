package com.example.colordemon.MainMenuAdditionals;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colordemon.App;
import com.example.colordemon.Entry;
import com.example.colordemon.GameStruct.Game;
import com.example.colordemon.MapOrCharacterEntity;
import com.example.colordemon.R;
import com.example.colordemon.databinding.MenuFragment2Binding;

import java.util.ArrayList;
import java.util.List;

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

        MyMapOrCharAdapter adapter= new MyMapOrCharAdapter(App.getMaps().mcDao().getAll());
        binding.recyclerMaps.setAdapter(adapter);
        binding.recyclerMaps.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        return binding.getRoot();
    }
    class MyMapOrCharAdapter extends RecyclerView.Adapter<MyMapOrCharAdapter.MyViewHolder> {
        final List<MapOrCharacterEntity> mapsOrChars;

        public MyMapOrCharAdapter(List<MapOrCharacterEntity> mapsOrChars) {
            this.mapsOrChars = mapsOrChars;
        }

        @NonNull
        @Override
        public MyMapOrCharAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_maps, parent, false);
            return new MyMapOrCharAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyMapOrCharAdapter.MyViewHolder holder, int position) {
            holder.sprite.setImageResource(mapsOrChars.get(position).sprite);
            holder.description.setText(getContext().getResources().getString(mapsOrChars.get(position).description));
            holder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"Bebra",Toast.LENGTH_LONG);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mapsOrChars.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView sprite;
            TextView description;
            Button item;

            public MyViewHolder(View v) {
                super(v);
                sprite = v.findViewById(R.id.map);
                description = v.findViewById(R.id.map_descrip);
                item = v.findViewById(R.id.choose);
            }
        }
    }
}
