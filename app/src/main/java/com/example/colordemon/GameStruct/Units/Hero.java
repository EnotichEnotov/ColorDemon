package com.example.colordemon.GameStruct.Units;

import com.example.colordemon.GameStruct.GameObjectType;

public class Hero extends Unit{
    private float stopSpeed = 5f;
    public Hero(float x, float y, GameObjectType type, float velocityX,float velocityY) {
        super(x, y, type, velocityX,velocityY);
    }
    private void stopping(){
        if(velocityX-stopSpeed>0) velocityX-=stopSpeed;
        else velocityY=0;
        if(velocityY-stopSpeed>0) velocityY-=stopSpeed;
        else velocityY=0;
    }
    public void dash(float addVelocityx,float addVelocityY){
        velocityX+=addVelocityx;
        velocityY+=addVelocityY;
    }
}
