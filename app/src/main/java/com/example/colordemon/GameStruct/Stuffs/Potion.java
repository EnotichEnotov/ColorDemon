package com.example.colordemon.GameStruct.Stuffs;

import com.example.colordemon.GameStruct.GameObjectType;

public class Potion extends Stuff implements Consumable{
    public Potion(float x, float y, GameObjectType type) {
        super(x, y, type);
    }

    @Override
    public void use() {

    }
}
