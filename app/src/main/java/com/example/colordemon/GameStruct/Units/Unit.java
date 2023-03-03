package com.example.colordemon.GameStruct.Units;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.colordemon.GameStruct.GameObject;
import com.example.colordemon.GameStruct.GameObjectType;

import java.util.ArrayList;


public class Unit extends GameObject {
    public Unit(float x, float y, float velocityX,float velocityY) {
        super(x, y,velocityX,velocityY);
    }

    @Override
    public void update() {

    }
}
