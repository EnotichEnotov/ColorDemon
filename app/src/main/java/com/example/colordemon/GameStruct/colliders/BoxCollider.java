package com.example.colordemon.GameStruct.colliders;

import com.example.colordemon.GameStruct.base.GameObject;

public class BoxCollider extends Collider {
    private float paddingX=100f;
    private float paddingY=100f;
    public BoxCollider(GameObject gameObject, float paddingX, float paddingY){
        super(gameObject);
        this.paddingX=paddingX;
        this.paddingY=paddingY;
    }

    @Override
    public boolean isCollision(float x,float y) {
        return Math.abs(x-gameObject.x+gameObject.scaleX/2)<=paddingX && Math.abs(y-gameObject.y+ gameObject.scaleY)<=paddingY;
    }
}