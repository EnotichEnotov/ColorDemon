package com.example.colordemon.GameStruct.Stuffs;

import com.example.colordemon.GameStruct.GameObjectType;

public class Chest extends Stuff implements Openable{

    public Chest(float x, float y, GameObjectType type) {
        super(x, y, type);
    }

    @Override
    public void open() {

    }
}
