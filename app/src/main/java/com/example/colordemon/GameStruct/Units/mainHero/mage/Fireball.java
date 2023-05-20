package com.example.colordemon.GameStruct.Units.mainHero.mage;

import com.example.colordemon.GameStruct.base.GameObject;
import com.example.colordemon.GameStruct.colliders.Collider;

public class Fireball extends GameObject {
    public int damage;
    protected int lifeZikl=100;
    protected int tick=0;
    public Fireball(float x, float y, float velocityX, float velocityY, Collider collider,int damage) {
        super(x, y, velocityX, velocityY, collider);
        this.damage=damage;
    }

    @Override
    public void update() {
        if(tick<lifeZikl){
            tick++;
        }
        else {
            return;
        }
        x+=velocityX;
        y+=velocityY;
    }
}
