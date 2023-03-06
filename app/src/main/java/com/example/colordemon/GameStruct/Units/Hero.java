package com.example.colordemon.GameStruct.Units;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;

import com.example.colordemon.GameStruct.GameObjectType;
import com.example.colordemon.R;

import java.util.ArrayList;

public class Hero extends Unit{
    public static final int Name = 0;
    private final float stopSpeed = 2.5f;
    private float xStop = 0f;
    public int[] cooldowns = new int[4]; // max 0 - 2, max 1 - 5, max 2 - 8, max 3 - 15
    private float yStop = 0f;
    public int damageType = 0; // 0 - dash, 1 - enemyPort, 2 - circleDash, 3 - ult
    public Hero(float x, float y, float velocityX, float velocityY) {
        super(x, y, velocityX,velocityY);
    }
    private void stopping(){
        if(Math.abs(velocityX-xStop)>50f) velocityX-=xStop;
        else velocityX=0;
        if(Math.abs(velocityY-yStop)>50f) velocityY-=yStop;
        else velocityY=0;
    }
    public void run(){
        x+=velocityX;
        y+=velocityY;
        stopping();
    }
    public void dash(float addVelocityX,float addVelocityY){
        if(Math.abs(addVelocityX)>150f) addVelocityX=150f;
        if(Math.abs(addVelocityY)>150f) addVelocityY=150f;
        velocityX=addVelocityX;
        velocityY=addVelocityY;
        xStop=addVelocityX/stopSpeed;
        yStop=addVelocityY/stopSpeed;
    }
    public void enemyPort(float newX,float newY){

    }
    public void circleDash(float radiusX,float radiusY){

    }
    public void ult(Float[][] Coord){

    }
}
