package com.example.colordemon;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MCDAO {
    @Query("SELECT * FROM MapOrCharacterEntity")
    List<MapOrCharacterEntity> getAll();

    @Insert
    void save(MapOrCharacterEntity mc);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MapOrCharacterEntity> mc);

    @Query("SELECT * FROM MapOrCharacterEntity WHERE id = :id")
    MapOrCharacterEntity getId(int id);

    @Delete
    void delete(MapOrCharacterEntity mc);

    @Update
    void update(MapOrCharacterEntity mc);
}
