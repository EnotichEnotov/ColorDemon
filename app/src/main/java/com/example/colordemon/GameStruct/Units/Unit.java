package com.example.colordemon.GameStruct.Units;

import com.example.colordemon.GameStruct.colliders.Collider;
import com.example.colordemon.GameStruct.base.GameObject;


public class Unit extends GameObject {
    public int maxHp;
    public int hp;
    public int damage;
    public int armor;
    public int maxMana;
    public int mana;
    public int damageCooldown;
    public int nowDamageCooldown;
    public Unit(float x, float y, float velocityX, float velocityY, Collider collider) {
        super(x, y,velocityX,velocityY,collider);
    }
    public Unit(float x, float y, float velocityX, float velocityY, Collider collider,float scaleX,float scaleY) {
        super(x, y,velocityX,velocityY,collider,scaleX,scaleY);
    }
    public Unit(float x, float y, float velocityX, float velocityY, Collider collider,float scaleX,float scaleY,int maxHp,int maxMana,int armor,int damage,int damageCooldown) {
        super(x, y,velocityX,velocityY,collider,scaleX,scaleY);
        this.maxHp=maxHp;
        this.maxMana=maxMana;
        mana=maxMana;
        hp=maxHp;
        this.armor=armor;
        this.damage=damage;
        this.nowDamageCooldown=damageCooldown;
        this.damageCooldown=damageCooldown;
    }
    @Override
    public void update() {

    }
}
