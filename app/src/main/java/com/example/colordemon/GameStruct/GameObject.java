package com.example.colordemon.GameStruct;

public abstract class GameObject {
    public float x,y,velocityX,velocityY;
    public GameObjectType type;
    public GameObject(float x,float y,float velocityX,float velocityY) {
        this(x,y);
        this.velocityX=velocityX;
        this.velocityY=velocityY;
    }
    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public abstract void update();
}
