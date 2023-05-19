package com.example.colordemon.GameStruct.Units.mainHero.mage;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.Unit;
import com.example.colordemon.GameStruct.Units.mainHero.MainCharacter;
import com.example.colordemon.GameStruct.colliders.CircleCollider;
import com.example.colordemon.GameStruct.colliders.Collider;

import java.util.ArrayList;
import java.util.List;

public class Mage extends MainCharacter {
    ArrayList<Fireball> fireballs;
    ArrayList<Enemy> enemies;
    int coldTicker=0;
    boolean cold=false;
    public Mage(float x, float y, float velocityX, float velocityY, Collider collider, float scaleX, float scaleY, int maxHp, int maxMana, int armor, int damage, int damageCooldown,ArrayList<Enemy> enemies) {
        super(x, y, velocityX, velocityY, collider, scaleX, scaleY, maxHp, maxMana, armor, damage, damageCooldown);
        Name=2;
        fireballs=new ArrayList<>();
        this.enemies=enemies;
    }

    @Override
    public void update() {
        if(nowDamageCooldown>0) nowDamageCooldown--;
        for(Fireball i : fireballs){
            i.update();
        }
        switch (damageType){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        if(cold) coldTicker++;
        if(coldTicker>50){
            cold=false;
            coldTicker=0;
            for(Enemy i : enemies){
                i.velocityX*=2;
                i.velocityY*=2;
            }
        }
    }
    public void fireAttack(int x,int y){ // -dash
        fireballs.add(new Fireball(this.x,this.y,x,y,new CircleCollider(null,1)));
    }
    public void port(int x,int y){ // -port
        this.x=x;
        this.y=y;
    }
    public void cold(){ //circleDash - stops small units and slow big units
        for(Enemy i : enemies){
            i.velocityX/=2;
            i.velocityY/=2;
            cold = true;
        }
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
