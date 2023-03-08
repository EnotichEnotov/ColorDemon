package com.example.colordemon.GameStruct.Units;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;

import com.example.colordemon.GameStruct.GameObjectType;
import com.example.colordemon.R;

import java.util.ArrayList;

public class Hero extends Unit{
    public static final int Name = 0;
    private final float stopTime = 2f;
    private float tickTime = 0f;
    public int[] cooldowns = new int[4]; // max 0 - 2, max 1 - 5, max 2 - 8, max 3 - 15
    public int damageType = 0; // 0 - dash, 1 - enemyPort, 2 - circleDash, 3 - ult
    public Hero(float x, float y, float velocityX, float velocityY) {
        super(x, y, velocityX,velocityY);
    }
    public void run(){
        if(tickTime<=stopTime){
            x+=velocityX;
            y+=velocityY;
            tickTime+=1f;
        }
        else{
            tickTime=0f;
            velocityX=0f;
            velocityY=0f;
        }
    }
    public int nowSprite(){
        return 0;
    }
    public void dash(float addVelocityX,float addVelocityY){
        float koef = Math.min(Math.abs(300f/addVelocityX),Math.abs(300f/addVelocityY));
        if(Math.abs(addVelocityX)>300f) addVelocityX=addVelocityX*koef;
        if(Math.abs(addVelocityY)>300f) addVelocityY=addVelocityY*koef;
        velocityX=addVelocityX/stopTime;
        velocityY=addVelocityY/stopTime;
    }
    public void enemyPort(float newX,float newY){

    }
    public void circleDash(float radiusX,float radiusY){

    }
    public void ult(Float[][] Coord){

    }
}
