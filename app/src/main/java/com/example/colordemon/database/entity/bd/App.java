package com.example.colordemon.database.entity.bd;

import android.app.Application;

import androidx.room.Room;

import com.example.colordemon.R;
import com.example.colordemon.database.entity.MapOrCharacterEntity;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private static App instance;
    private static SettingsDatabase database;
    private static DatabaseMaps maps;

    public static DatabaseMaps getCharacters() { return characters; }

    private static DatabaseMaps characters;
    public static App getInstance() {
        return instance;
    }

    public static SettingsDatabase getDatabase() {
        return database;
    }
    public static DatabaseMaps getMaps() {
        return maps;
    }

    @Override
    public void onCreate() {
        instance = this;
        maps = Room.databaseBuilder(this,DatabaseMaps.class,"maps").allowMainThreadQueries().build();
        maps.mcDao().deleteAll();
        if (maps.mcDao().getAll().isEmpty()){
            List<MapOrCharacterEntity> entities = new ArrayList<>();
            entities.add(new MapOrCharacterEntity((int) R.drawable.idle_first1,1));
            entities.add(new MapOrCharacterEntity((int) R.drawable.idle_1,1));
            maps.mcDao().insertAll(entities);
        }
        characters = Room.databaseBuilder(this,DatabaseMaps.class,"characters").allowMainThreadQueries().build();
        if (characters.mcDao().getAll().isEmpty()){
            List<MapOrCharacterEntity> entities = new ArrayList<>();
            entities.add(new MapOrCharacterEntity((int) R.drawable.idle_first1,1));
            entities.add(new MapOrCharacterEntity((int) R.drawable.idle_1,1));
            characters.mcDao().insertAll(entities);
        }
        database = new SettingsDatabase(this);
        super.onCreate();
    }
}
