package com.example.colordemon.GameStruct.Stuffs;

import com.example.colordemon.GameStruct.GameObjectType;

public class Door extends Stuff implements Openable{
    public Door(float x, float y, GameObjectType type) {
        super(x, y, type);
    }

    @Override
    public void open() {

    }
}
