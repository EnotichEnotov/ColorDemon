package com.example.colordemon;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;

import com.example.colordemon.GameStruct.Entry;
import com.example.colordemon.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import com.example.colordemon.databinding.ShopBinding;
public class Shop extends AppCompatActivity{
    private ListView listView;
    private  MyEntryAdapter adapter;
    ShopBinding binding;
    private Entry[] entries= new Entry[6];
    private Entry[] entries_weapons= new Entry[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ShopBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        entries[0] = new Entry(getResources().getString(R.string.author_shop_character_1),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_1));
        entries[1] = new Entry(getResources().getString(R.string.author_shop_character_2),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_2));
        entries[2] = new Entry(getResources().getString(R.string.author_shop_character_3),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_3));
        entries[3] = new Entry(getResources().getString(R.string.author_shop_character_4),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_4));
        entries[4] = new Entry(getResources().getString(R.string.author_shop_character_5),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_5));
        entries[5] = new Entry(getResources().getString(R.string.author_shop_character_6),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_6));
        listView = binding.listview;
        adapter = new MyEntryAdapter(this,entries);
        Context context = this;
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemClickListener());
        binding.buttonWeapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Shop.this, "sfdsd", Toast.LENGTH_SHORT).show();


                entries[0] = new Entry(getResources().getString(R.string.author_shop_weapon_1),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_1));
                entries[1] = new Entry(getResources().getString(R.string.author_shop_weapon_2),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_2));
                entries[2] = new Entry(getResources().getString(R.string.author_shop_weapon_3),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_3));
                entries[3] = new Entry(getResources().getString(R.string.author_shop_weapon_4),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_4));
                entries[4] = new Entry(getResources().getString(R.string.author_shop_weapon_5),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_5));
                entries[5] = new Entry(getResources().getString(R.string.author_shop_weapon_6),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_6));
                listView = binding.listview;

                adapter = new MyEntryAdapter(context,entries);
                listView.setAdapter(adapter);
            }
        });
        binding.buttonCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entries[0] = new Entry(getResources().getString(R.string.author_shop_character_1),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_1));
                entries[1] = new Entry(getResources().getString(R.string.author_shop_character_2),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_2));
                entries[2] = new Entry(getResources().getString(R.string.author_shop_character_3),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_3));
                entries[3] = new Entry(getResources().getString(R.string.author_shop_character_4),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_4));
                entries[4] = new Entry(getResources().getString(R.string.author_shop_character_5),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_5));
                entries[5] = new Entry(getResources().getString(R.string.author_shop_character_6),R.drawable.shop_skin_person1,R.drawable.shop_skin_person1, getResources().getString(R.string.character_story_6));

                adapter = new MyEntryAdapter(context,entries);
                listView.setAdapter(adapter);
            }
        });

    }




    class ItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.v("A","pochemy");
            Toast.makeText(Shop.this, "sfdsd", Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        }
    }
    class MyEntryAdapter extends ArrayAdapter<Entry>{
        final Entry[] entries;
        public MyEntryAdapter(@NonNull Context context, Entry[] entries){
            super(context,R.layout.list,entries);
            this.entries=entries;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Entry entry=entries[position];
            if(convertView==null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list,null);
            }
            /*
            convertView.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button likes = view.findViewById(R.id.like);
                    Drawable like = view.getResources().getDrawable(R.drawable.shop_skin_person1);
                    Drawable like2 = view.getResources().getDrawable(R.drawable.shop_skin_person1);
                    if(entry.getLiked()){
                        likes.setCompoundDrawablesWithIntrinsicBounds(like,null,null,null);
                        entry.setLikes(entry.getLikes()-1);
                        likes.setText(""+entry.getLikes());
                        entry.setLiked();
                    }


                    else{
                        likes.setCompoundDrawablesWithIntrinsicBounds(like2,null,null,null);
                        entry.setLikes(entry.getLikes()+1);
                        likes.setText(""+entry.getLikes());
                        entry.setLiked();
                    }
                }
            });
            */
            convertView.findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(Shop.this, "За всех, кто хотел меня убить", Toast.LENGTH_SHORT).show();
                }
            });
                /*
                convertView.findViewById(R.id.comments).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,ElprimoActivity.class);
                        intent.putExtra("Text",entry.getAuthor());
                        startActivity(intent);
                        finish();
                    }

                });
                */

            //ImageView authorArt = convertView.findViewById(R.id.author_art);
            //authorArt.setImageResource(entry.getAuthorArtid());
            ImageView memes = convertView.findViewById(R.id.memes);
            memes.setImageResource(entry.getMemeid());
            TextView author = convertView.findViewById(R.id.author);
            author.setText(entry.getAuthor());
            TextView char_story = convertView.findViewById(R.id.char_story);
            char_story.setText(entry.getChar_story());
            return convertView;
        }
    }
}