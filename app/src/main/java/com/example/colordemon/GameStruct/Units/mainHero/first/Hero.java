package com.example.colordemon.GameStruct.Units.mainHero.first;

import android.util.Log;

import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.mainHero.MainCharacter;
import com.example.colordemon.GameStruct.colliders.Collider;

public class Hero extends MainCharacter {
    private final float stopTime = 10f;
    private float radius;
    private float angle;
    private float startAngle;
    private float radiusX;
    private float radiusY;
    private float angleSpeed = 2*(float)Math.PI/20f;
    private float addX;
    private float addY;
    int idleTicker=0;
    int attack1Ticker=0;
    int attack2Ticker=0;
    int attack3Ticker=0;
    int hurtTicker=0;
    private float tickTime = 1f;
    // abilities: max 0 - 2, max 1 - 5, max 2 - 8, max 3 - 15
    // damage type: 0 - dash, 1 - enemyPort, 2 - circleDash, 3 - ult
    public Hero(float x, float y, float velocityX, float velocityY, Collider collider,float scaleX,float scaleY,int maxHp,int maxMana,int armor,int damage,int damageCooldown) {
        super(x, y, velocityX,velocityY,collider,scaleX,scaleY,maxHp,maxMana,armor,damage,damageCooldown);
        nowState=3;
    }
    @Override
    public int nowSprite(){
        if(idleTicker>=15){
            idleTicker=0;
        }
        if(attack1Ticker>=15){
            attack1Ticker=0;
            nowState=3;
        }
        if(attack2Ticker>=3){
            attack2Ticker=0;
            nowState=3;
        }
        if(attack3Ticker>=15){
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
                return (attack1Ticker++)/3;
            case 5:
                return  (attack2Ticker++);
            case 6:
                return (attack3Ticker++)/3;
            case 7:
                return (hurtTicker++);
        }
        return 0;
    }
    @Override
    public void update() {
        if(nowDamageCooldown>0) nowDamageCooldown--;
        switch (damageType) {
            case 0:
                dashUpdate();
                break;
            case 1:
                enemyPortUpdate();
                break;
            case 2:
                circleUpdate();
                break;
            case 3:
                ultUpdate();
                break;
            default:
                Log.wtf("WTF", damageType + "");
        }
        if(hp<=0){ Log.i("III","GAME OVER");}
    }

    @Override
    public void damageDeal(Enemy enemy) {
        if(nowDamageCooldown<=0){
            super.damageDeal(enemy);
            nowState=7;
            nowDamageCooldown=damageCooldown;
        }
    }

    private void dashUpdate(){
        if(tickTime<=stopTime){
            x+=velocityX;
            y+=velocityY;
            tickTime+=1f;
        }
        else{
            tickTime=1f;
            if(velocityX>0 || velocityY>0) nowDamageCooldown=damageCooldown;
            velocityX=0f;
            velocityY=0f;
        }
    }
    private void ultUpdate(){
        nowDamageCooldown=damageCooldown;
    }
    private void circleUpdate(){
        if(angle<=startAngle+2*Math.PI){
            angle+=angleSpeed;
            x=radiusX+radius*(float)Math.cos(angle);
            y=radiusY+radius*(float)Math.sin(angle);
        }
        else{nowDamageCooldown=damageCooldown;}
        Log.i("III",x+" "+y);
        nowState=6;
    }
    private void enemyPortUpdate(){
        if(addX==0 || addY==0) return;
        x=addX;
        y=addY;
        addY=0;
        addX=0;
        nowDamageCooldown=damageCooldown;
        nowState=5;
    }
    public void dash(float addVelocityX,float addVelocityY){
        if(abilities[0].cooldownNow!=0) return;
        float koef = Math.min(Math.abs(400f/addVelocityX),Math.abs(400f/addVelocityY));
        if(Math.abs(addVelocityX)>400f || Math.abs(addVelocityY)>400f){
            addVelocityX=addVelocityX*koef/2;
            addVelocityY=addVelocityY*koef/2;
        }
        velocityX=addVelocityX;
        velocityY=addVelocityY;
        abilities[0].setCooldownNow();
        nowState=2;
    }
    public void enemyPort(float newX,float newY){
        if(abilities[1].cooldownNow!=0) return;

        addX=newX;
        addY=newY;
        abilities[1].setCooldownNow();
    }
    public void circleDash(float radiusX,float radiusY,float width,float height){
        if(abilities[2].cooldownNow!=0) return;
        float addX=x-width/2;
        float addY=y-height/2;
        this.radiusX=radiusX+addX;
        this.radiusY=radiusY+addY;
        radiusX+=addX;
        radiusY+=addY;
        radius = (float) Math.sqrt((radiusX-x)*(radiusX-x)+ (radiusY-y)*(radiusY-y));
        startAngle = radiusY-y>=0 ? (float) Math.acos(Math.max(-1,Math.min(1,(x-radiusX)/radius)))
                : (float)-Math.acos(Math.max(-1,Math.min(1,(x-radiusX)/radius)));
        //startAngle=0;
        angle=startAngle;
        abilities[2].setCooldownNow();
    }
    public void ult(Float[][] Coord){
        if(abilities[3].cooldownNow!=0) return;
        abilities[3].setCooldownNow();
    }
}
