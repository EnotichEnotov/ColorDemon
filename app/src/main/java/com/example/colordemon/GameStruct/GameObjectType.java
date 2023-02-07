package com.example.colordemon.GameStruct;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class GameObjectType {
    ArrayList<Bitmap> sprite;
    Integer name;

    public GameObjectType(ArrayList<Bitmap> sprite, Integer name) {
        this.sprite = sprite;
        this.name = name;
    }
}
