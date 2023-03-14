package com.example.colordemon.GameStruct.Units;

import android.util.Log;

import com.example.colordemon.GameStruct.Ability;
import com.example.colordemon.GameStruct.Collider;

public class Hero extends Unit{
    public static final int Name = 0;
    private final float stopTime = 5f;
    private float radius;
    private float angle;
    private float startAngle;
    private float radiusX;
    private float radiusY;
    private float angleSpeed = 2*(float)Math.PI/20f;
    private float addX;
    private float addY;
    private float tickTime = 1f;
    public Ability[] abilities = new Ability[4]; // max 0 - 2, max 1 - 5, max 2 - 8, max 3 - 15
    public int damageType = 0; // 0 - dash, 1 - enemyPort, 2 - circleDash, 3 - ult
    public Hero(float x, float y, float velocityX, float velocityY, Collider collider,float scaleX,float scaleY) {
        super(x, y, velocityX,velocityY,collider,scaleX,scaleY);
    }
    public void run(){
        switch (damageType){
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
                Log.wtf("WTF",damageType +"");
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
            velocityX=0f;
            velocityY=0f;
        }
    }
    private void ultUpdate(){

    }
    private void circleUpdate(){
        if(angle<=startAngle+2*Math.PI){
            angle+=angleSpeed;
            x=radiusX+radius*(float)Math.cos(angle);
            y=radiusY+radius*(float)Math.sin(angle);
        }
        Log.i("III",x+" "+y);
    }
    private void enemyPortUpdate(){
        x=addX;
        y=addY;
        addY=0;
        addX=0;
    }
    public int nowSprite(){
        return 0;
    }
    public void dash(float addVelocityX,float addVelocityY){
        if(abilities[0].cooldownNow!=0) return;
        float koef = Math.min(Math.abs(400f/addVelocityX),Math.abs(400f/addVelocityY));
        if(Math.abs(addVelocityX)>400f) addVelocityX=addVelocityX*koef;
        if(Math.abs(addVelocityY)>400f) addVelocityY=addVelocityY*koef;
        velocityX=addVelocityX/stopTime;
        velocityY=addVelocityY/stopTime;
        abilities[0].setCooldownNow();
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
