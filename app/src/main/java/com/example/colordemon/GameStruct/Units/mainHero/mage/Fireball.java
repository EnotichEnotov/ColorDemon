package com.example.colordemon.GameStruct.Units.mainHero.mage;

import com.example.colordemon.GameStruct.base.GameObject;
import com.example.colordemon.GameStruct.colliders.Collider;

public class Fireball extends GameObject {

    public Fireball(float x, float y, float velocityX, float velocityY, Collider collider) {
        super(x, y, velocityX, velocityY, collider);
    }

    @Override
    public void update() {
        x+=velocityX;
        y+=velocityY;
    }
}
