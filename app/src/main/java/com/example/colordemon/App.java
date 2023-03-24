package com.example.colordemon;

import android.app.Application;

public class App extends Application {
    private static App instance;
    private static SettingsDatabase database;

    public static App getInstance() {
        return instance;
    }

    public static SettingsDatabase getDatabase() {
        return database;
    }

    @Override
    public void onCreate() {
        instance = this;
        database = new SettingsDatabase(this);
        super.onCreate();
    }
}
