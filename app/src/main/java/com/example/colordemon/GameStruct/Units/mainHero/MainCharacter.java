package com.example.colordemon.GameStruct.Units.mainHero;

import android.graphics.Canvas;

import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.Unit;
import com.example.colordemon.GameStruct.Units.mainHero.abilities.Ability;
import com.example.colordemon.GameStruct.base.GameObjectFactory;
import com.example.colordemon.GameStruct.colliders.Collider;

public abstract class MainCharacter extends Unit {
    public int nowState=3;
    public int sprite=0;
    public Ability[] abilities = new Ability[4];
    public int damageType = 0;
    public MainCharacter(float x, float y, float velocityX, float velocityY, Collider collider, float scaleX, float scaleY) {
        super(x, y, velocityX, velocityY, collider, scaleX, scaleY);
    }
    public int nowSprite(){
        return sprite;
    }
    public MainCharacter(float x, float y, float velocityX, float velocityY, Collider collider,float scaleX,float scaleY,int maxHp,int maxMana,int armor,int damage,int damageCooldown) {
        super(x, y, velocityX,velocityY,collider,scaleX,scaleY,maxHp,maxMana,armor,damage,damageCooldown);
    }

    public void draw(Canvas canvas, float addX, float addY, GameObjectFactory unitsFactory) {
    }
    public void damageDeal(Enemy enemy){
        if(nowDamageCooldown<=0 && velocityX==0 && velocityY==0){ hp-=enemy.damage*(enemy.damage-1)/(enemy.damage+armor); nowDamageCooldown=damageCooldown;}
    }
}
