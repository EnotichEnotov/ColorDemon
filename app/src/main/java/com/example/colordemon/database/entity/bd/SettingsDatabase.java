package com.example.colordemon.database.entity.bd;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsDatabase {
    public static final String LANGUAGE="language";
    public static final String VOLUME="volume";
    public static final String CHOSEN="Chosen";
    private final SharedPreferences storage;

    public SettingsDatabase(Context context) {
        storage = context.getSharedPreferences("storage",Context.MODE_PRIVATE);
    }
    public void save(String language){
        SharedPreferences.Editor editor = storage.edit();
        editor.putString(SettingsDatabase.LANGUAGE,language);
        editor.apply();
    }
    public void save(float volume){
        SharedPreferences.Editor editor = storage.edit();
        editor.putFloat(SettingsDatabase.VOLUME,volume);
        //editor.apply();
    }
    public void save(String language,float volume){
        save(language);
        save(volume);
    }
    public void save(int chosen){
        SharedPreferences.Editor editor = storage.edit();
        editor.putInt(SettingsDatabase.CHOSEN,chosen);
        editor.apply();
    }
    public String getLanguage(){
        return storage.getString(LANGUAGE,"");
    }
    public Integer getVolume(){
        return storage.getInt(VOLUME,50);
    }
    public Integer getChosen(){
        return storage.getInt(CHOSEN,6);
    }
}
