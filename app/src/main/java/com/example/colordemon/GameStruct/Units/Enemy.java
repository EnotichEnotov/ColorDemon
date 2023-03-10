package com.example.colordemon.GameStruct.Units;

import com.example.colordemon.GameStruct.Collider;
import com.example.colordemon.GameStruct.GameObjectType;

public class Enemy extends Unit{
    public Enemy(float x, float y, float velocityX, float velocityY, Collider collider) {
        super(x, y, velocityX,velocityY,collider);
    }
}
