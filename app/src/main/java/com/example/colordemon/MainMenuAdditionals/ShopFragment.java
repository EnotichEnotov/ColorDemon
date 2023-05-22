package com.example.colordemon.MainMenuAdditionals;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.colordemon.database.entity.Entry;
import com.example.colordemon.R;
import com.example.colordemon.databinding.ShopBinding;

public class ShopFragment extends Fragment {
    private ListView listView;
    private ListView listView2;
    private MyEntryAdapter1 adapter;
    ShopBinding binding;
    private Entry[] entries= new Entry[6];
    private Entry[] entries2= new Entry[6];
    public ShopFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ShopBinding.inflate(inflater);
        entries[0] = new Entry(getResources().getString(R.string.author_shop_character_1),R.drawable.shop_skin_person1);
        entries[1] = new Entry(getResources().getString(R.string.author_shop_character_2),R.drawable.shop_skin_person2);
        entries[2] = new Entry(getResources().getString(R.string.author_shop_character_3),R.drawable.shop_skin_person3);
        entries[3] = new Entry(getResources().getString(R.string.author_shop_character_1),R.drawable.shop_skin_person4);
        entries[4] = new Entry(getResources().getString(R.string.author_shop_character_2),R.drawable.shop_skin_person5);
        entries[5] = new Entry(getResources().getString(R.string.author_shop_character_3),R.drawable.shop_skin_person6);

        entries2[0] = new Entry(getResources().getString(R.string.author_shop_equipment_4),R.drawable.shop_equipment1);
        entries2[1] = new Entry(getResources().getString(R.string.author_shop_weapon_5),R.drawable.shop_skin_weapon2);
        entries2[2] = new Entry(getResources().getString(R.string.author_shop_weapon_6),R.drawable.shop_skin_weapon3);
        entries2[3] = new Entry(getResources().getString(R.string.author_shop_equipment_4),R.drawable.shop_equipment4);
        entries2[4] = new Entry(getResources().getString(R.string.author_shop_weapon_5),R.drawable.shop_skin_weapon5);
        entries2[5] = new Entry(getResources().getString(R.string.author_shop_weapon_6),R.drawable.shop_skin_weapon6);

        adapter = new MyEntryAdapter1(getActivity(),entries);
        Context context = getActivity();
        binding.listview.setAdapter(adapter);

        adapter = new MyEntryAdapter1(getActivity(),entries2);
        binding.listview2.setAdapter(adapter);
        binding.listview.setOnItemClickListener(new ItemClickListener());
        binding.listview2.setOnItemClickListener(new ItemClickListener());


        return binding.getRoot();
    }
    class ItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.v("A","pochemy");
            //Toast.makeText(Shop.this, "sfdsd", Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        }
    }
    class MyEntryAdapter1 extends ArrayAdapter<Entry> {
        final Entry[] entries;
        public MyEntryAdapter1(@NonNull Context context, Entry[] entries){
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

            convertView.findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button choosen = view.findViewById(R.id.send);
                    if(!entry.getLiked()){
                        for (Entry x: entries){
                            x.setConditionZero();
                        }
                        choosen.setBackground(getResources().getDrawable(R.drawable.shop_activatedbut));
                        entry.setLiked();
                        MyEntryAdapter1.super.notifyDataSetChanged();
                    }

                }
            });
            ImageView memes = convertView.findViewById(R.id.memes);
            memes.setImageResource(entry.getMemeid());
            TextView author = convertView.findViewById(R.id.author);
            author.setText(entry.getAuthor());

            return convertView;
        }
    }
}
