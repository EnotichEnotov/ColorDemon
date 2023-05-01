package com.example.colordemon.GameStruct.base;

import android.graphics.Bitmap;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class GameObjectType {
    public ArrayList<Bitmap> sprite;
    Integer name;

    public GameObjectType(ArrayList<Bitmap> sprite, Integer name) {
        this.sprite = sprite;
        this.name = name;
    }
}
