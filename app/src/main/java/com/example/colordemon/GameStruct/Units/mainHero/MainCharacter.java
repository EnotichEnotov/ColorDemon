package com.example.colordemon.GameStruct.Units.mainHero;

import com.example.colordemon.GameStruct.Units.Unit;
import com.example.colordemon.GameStruct.colliders.Collider;

public abstract class MainCharacter extends Unit {
    public Ability[] abilities = new Ability[4];
    public int damageType = 0;
    public MainCharacter(float x, float y, float velocityX, float velocityY, Collider collider, float scaleX, float scaleY) {
        super(x, y, velocityX, velocityY, collider, scaleX, scaleY);
    }
    public MainCharacter(float x, float y, float velocityX, float velocityY, Collider collider,float scaleX,float scaleY,int maxHp,int maxMana,int armor,int damage,int damageCooldown) {
        super(x, y, velocityX,velocityY,collider,scaleX,scaleY,maxHp,maxMana,armor,damage,damageCooldown);
    }
}
