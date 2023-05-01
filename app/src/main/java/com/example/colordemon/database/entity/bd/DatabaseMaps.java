package com.example.colordemon.database.entity.bd;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.colordemon.database.entity.DAO.MCDAO;
import com.example.colordemon.database.entity.MapOrCharacterEntity;

@Database(entities = {MapOrCharacterEntity.class},version = 1)
public abstract class DatabaseMaps extends RoomDatabase {
    public abstract MCDAO mcDao();
}
