package com.example.colordemon.GameStruct.Units.mainHero.mage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.Unit;
import com.example.colordemon.GameStruct.Units.mainHero.MainCharacter;
import com.example.colordemon.GameStruct.colliders.CircleCollider;
import com.example.colordemon.GameStruct.colliders.Collider;

import java.util.ArrayList;
import java.util.List;

public class Mage extends MainCharacter {
    public ArrayList<Fireball> fireballs;
    ArrayList<Enemy> enemies;
    float fireX=0,fireY=0;
    int coldTicker=0;
    int idleTicker=0;
    int attack1Ticker=0;
    int attack2Ticker=0;
    int attack3Ticker=0;
    int hurtTicker=0;
    int fireballSpeed=10;
    public boolean cold=false;
    public Mage(float x, float y, float velocityX, float velocityY, Collider collider, float scaleX, float scaleY, int maxHp, int maxMana, int armor, int damage, int damageCooldown,ArrayList<Enemy> enemies) {
        super(x, y, velocityX, velocityY, collider, scaleX, scaleY, maxHp, maxMana, armor, damage, damageCooldown);
        fireballs=new ArrayList<>();
        nowState=3;
        this.enemies=enemies;
        damageType=0;
        damageCooldown=5;
    }

    @Override
    public int nowSprite() {
        if(idleTicker>=15){
            idleTicker=0;
        }
        if(attack1Ticker>=5){
            attack1Ticker=0;
            nowState=3;
            postFireAttack();
        }
        if(attack2Ticker>=3){
            attack2Ticker=0;
            nowState=3;
        }
        if(attack3Ticker>=3){
            attack3Ticker=0;
            nowState=3;
        }
        if(hurtTicker>=3){
            hurtTicker=0;
            nowState=3;
        }
        switch (nowState){
            case 3:
                return (idleTicker++)/3;
            case 2:
                return (attack1Ticker++);
            case 5:
                return  (attack2Ticker++);
            case 6:
                return (attack3Ticker++);
            case 7:
                return (hurtTicker++);
        }
        return 0;
    }

    @Override
    public void update() {
        if(nowDamageCooldown>0) nowDamageCooldown--;
        for(Fireball i : fireballs){
            if(i.tick==i.lifeZikl){
                fireballs.remove(i);
            }
            i.update();
            if(i.velocityX==0 && i.velocityY==0){
                fireballs.remove(i);
            }
        }
        if(cold) coldTicker++;
        if(coldTicker>50){
            cold=false;
            coldTicker=0;
        }
    }
    public void fireAttack(float x,float y){ // -dash
        if(abilities[0].cooldownNow!=0) return;
        if(x!=0 && y!=0) fireX=x; fireY=y;
        abilities[0].setCooldownNow();
        nowState=2;
    }
    public void postFireAttack(){
        float koef = Math.min(Math.abs(100f/x),Math.abs(100f/y));
        if(Math.abs(fireX)>100f || Math.abs(fireY)>100f){
            fireX=fireX*koef*1.5f;
            fireY=fireY*koef*1.5f;
        }
        Fireball fireball = new Fireball(this.x+scaleX,this.y+scaleY/2,fireX,fireY,new CircleCollider(null,50),50);
        fireball.collider.gameObject=fireball;
        fireballs.add(fireball);
    }
    public void port(float x,float y){ // -port
        if(abilities[1].cooldownNow!=0) return;
        this.x=x;
        this.y=y;
        Fireball fireball = new Fireball(this.x+scaleX/2,this.y+scaleY/2,fireballSpeed,0,new CircleCollider(null,50),50);
        fireball.collider.gameObject=fireball;
        fireballs.add(fireball);
        fireball = new Fireball(this.x+scaleX/2,this.y+scaleY/2,fireballSpeed,fireballSpeed,new CircleCollider(null,50),50);
        fireball.collider.gameObject=fireball;
        fireballs.add(fireball);
        fireball = new Fireball(this.x+scaleX/2,this.y+scaleY/2,0,fireballSpeed,new CircleCollider(null,50),50);
        fireball.collider.gameObject=fireball;
        fireballs.add(fireball);
        fireball = new Fireball(this.x+scaleX/2,this.y+scaleY/2,-fireballSpeed,fireballSpeed,new CircleCollider(null,50),50);
        fireball.collider.gameObject=fireball;
        fireballs.add(fireball);
        fireball = new Fireball(this.x+scaleX/2,this.y+scaleY/2,-fireballSpeed,0,new CircleCollider(null,50),50);
        fireball.collider.gameObject=fireball;
        fireballs.add(fireball);
        fireball = new Fireball(this.x+scaleX/2,this.y+scaleY/2,-fireballSpeed,-fireballSpeed,new CircleCollider(null,50),50);
        fireball.collider.gameObject=fireball;
        fireballs.add(fireball);
        fireball = new Fireball(this.x+scaleX/2,this.y+scaleY/2,0,-fireballSpeed,new CircleCollider(null,50),50);
        fireball.collider.gameObject=fireball;
        fireballs.add(fireball);
        fireball = new Fireball(this.x+scaleX/2,this.y+scaleY/2,fireballSpeed,-fireballSpeed,new CircleCollider(null,50),50);
        fireball.collider.gameObject=fireball;
        fireballs.add(fireball);
        abilities[1].setCooldownNow();
        nowState=5;
    }
    public void cold(){ //circleDash - stops small units and slow big units
        if(abilities[2].cooldownNow!=0 || cold==true) return;
        cold=true;
        abilities[2].setCooldownNow();
        nowState=6;
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
        if(nowDamageCooldown<=0){
            super.damageDeal(enemy);
            nowState=7;
            nowDamageCooldown=damageCooldown;
        }
    }
}
