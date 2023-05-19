package com.example.colordemon.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MapOrCharacterEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int sprite;
    public boolean purchased;
    public int description;
    public boolean chosen;

    public MapOrCharacterEntity(int sprite, int description) {
        this.sprite = sprite;
        purchased = false;
        this.description = description;
        chosen = false;
    }
}