package com.example.colordemon.GameStruct;

public class CircleCollider implements Collider{
    float centerX;
    float centerY;
    float radius;
    public CircleCollider(float centerX,float centerY,float radius){
        this.centerX=centerX;
        this.centerY=centerY;
        this.radius=radius;
    }
    @Override
    public boolean isCollision(float x, float y) {
        return (x-centerX)*(x-centerX)+(y-centerY)*(y-centerY)<=radius*radius;
    }
}
