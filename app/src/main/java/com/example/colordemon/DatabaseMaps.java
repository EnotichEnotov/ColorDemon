package com.example.colordemon;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MapOrCharacterEntity.class},version = 1)
public abstract class DatabaseMaps extends RoomDatabase {
    public abstract MCDAO mcDao();
}
