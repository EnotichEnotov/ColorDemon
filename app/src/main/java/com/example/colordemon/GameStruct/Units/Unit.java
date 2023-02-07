package com.example.colordemon.GameStruct.Units;

import com.example.colordemon.GameStruct.GameObject;
import com.example.colordemon.GameStruct.GameObjectType;


public class Unit extends GameObject {
    private GameObjectType type;
    public Unit(float x, float y,GameObjectType type, float velocity) {
        super(x, y, type,velocity);
        this.type=type;
    }

    @Override
    public void update() {

    }
}
