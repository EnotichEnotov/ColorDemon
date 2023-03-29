package com.example.colordemon;

import android.app.Application;

import androidx.room.Room;

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
        if (maps.mcDao().getAll().isEmpty()){
            List<MapOrCharacterEntity> entities = new ArrayList<>();
            entities.add(new MapOrCharacterEntity(R.drawable.shop_skin_person3,R.string.character_story_1));
            entities.add(new MapOrCharacterEntity(R.drawable.shop_skin_person3,R.string.character_story_1));
            entities.add(new MapOrCharacterEntity(R.drawable.shop_skin_person3,R.string.character_story_1));
            entities.add(new MapOrCharacterEntity(R.drawable.shop_skin_person3,R.string.character_story_1));
            entities.add(new MapOrCharacterEntity(R.drawable.shop_skin_person3,R.string.character_story_1));
            maps.mcDao().insertAll(entities);
        }
        characters = Room.databaseBuilder(this,DatabaseMaps.class,"characters").allowMainThreadQueries().build();
        if (characters.mcDao().getAll().isEmpty()){
            List<MapOrCharacterEntity> entities = new ArrayList<>();
            entities.add(new MapOrCharacterEntity(R.drawable.shop_skin_person4,R.string.character_story_1));
            entities.add(new MapOrCharacterEntity(R.drawable.shop_skin_person2,R.string.character_story_2));
            entities.add(new MapOrCharacterEntity(R.drawable.shop_skin_person3,R.string.character_story_3));
            entities.add(new MapOrCharacterEntity(R.drawable.shop_skin_person5,R.string.character_story_4));
            entities.add(new MapOrCharacterEntity(R.drawable.shop_skin_person1,R.string.character_story_5));
            characters.mcDao().insertAll(entities);
        }
        database = new SettingsDatabase(this);
        super.onCreate();
    }
}
