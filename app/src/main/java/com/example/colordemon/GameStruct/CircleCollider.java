package com.example.colordemon.GameStruct;

public class CircleCollider extends Collider{
    float radius;
    public CircleCollider(float centerX,float centerY,float radius){
        super(centerX,centerY);
        this.radius=radius;
    }
    @Override
    public boolean isCollision(float x, float y) {
        return (x-centerX)*(x-centerX)+(y-centerY)*(y-centerY)<=radius*radius;
    }
}
