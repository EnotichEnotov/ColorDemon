package com.example.colordemon.GameStruct.colliders;

import com.example.colordemon.GameStruct.base.GameObject;

public class BoxCollider extends Collider {
    private float paddingX=50f;
    private float paddingY=50f;
    public BoxCollider(GameObject gameObject, float paddingX, float paddingY){
        super(gameObject);
        this.paddingX=paddingX;
        this.paddingY=paddingY;
    }

    @Override
    public boolean isCollision(float x,float y) {
        return Math.abs(x-gameObject.x-gameObject.scaleX)<=paddingX && Math.abs(y-gameObject.y-gameObject.scaleY)<=paddingY;
    }
}
