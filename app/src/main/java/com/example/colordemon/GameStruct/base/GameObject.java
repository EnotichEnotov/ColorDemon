package com.example.colordemon.GameStruct.base;

import com.example.colordemon.GameStruct.colliders.Collider;

public abstract class GameObject {
    public float x,y,velocityX,velocityY,scaleX,scaleY;
    public GameObjectType type;
    public Collider collider;
    public GameObject(float x,float y,float velocityX,float velocityY,Collider collider) {
        this(x,y);
        this.velocityX=velocityX;
        this.velocityY=velocityY;
        collider.gameObject=this;
        this.collider=collider;
    }
    public GameObject(float x,float y,float velocityX,float velocityY,Collider collider,float scaleX,float scaleY){
        this(x,y,velocityX,velocityY,collider);
        this.scaleX=scaleX;
        this.scaleY=scaleY;
    }
    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public abstract void update();
}
