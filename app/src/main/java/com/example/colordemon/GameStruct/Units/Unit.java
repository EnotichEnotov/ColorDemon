package com.example.colordemon.GameStruct.Units;

import com.example.colordemon.GameStruct.GameObject;
import com.example.colordemon.GameStruct.GameObjectType;


public class Unit extends GameObject {
    public Unit(float x, float y,GameObjectType type, float velocityX,float velocityY) {
        super(x, y, type,velocityX,velocityY);
    }

    @Override
    public void update() {

    }
}
