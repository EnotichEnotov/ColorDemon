package com.example.colordemon.GameStruct.Units.mainHero.mage;

import android.graphics.Canvas;
import android.graphics.Color;
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
        damageType=0;
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
    public void fireAttack(float x,float y){ // -dash
        if(abilities[0].cooldownNow!=0) return;
        float koef = Math.min(Math.abs(100f/x),Math.abs(100f/y));
        if(Math.abs(x)>100f || Math.abs(y)>100f){
            x=x*koef;
            y=y*koef;
        }
        Fireball fireball = new Fireball(this.x,this.y,x,y,new CircleCollider(null,1));
        fireball.collider.gameObject=fireball;
        fireballs.add(fireball);
        abilities[0].setCooldownNow();
    }
    public void port(float x,float y){ // -port
        if(abilities[1].cooldownNow!=0) return;
        this.x=x;
        this.y=y;
        abilities[1].setCooldownNow();
    }
    public void cold(){ //circleDash - stops small units and slow big units
        if(abilities[2].cooldownNow!=0) return;
        for(Enemy i : enemies){
            i.velocityX/=2;
            i.velocityY/=2;
            cold = true;
        }
        abilities[2].setCooldownNow();
    }
    @Override
    public void draw(Canvas canvas, float addX, float addY) {
        super.draw(canvas, addX, addY);
        for(Fireball i : fireballs){
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            canvas.drawCircle(i.x+addX,i.y+addY,50,paint);
        }
    }

    @Override
    public void damageDeal(Enemy enemy) {
        super.damageDeal(enemy);
    }
}
