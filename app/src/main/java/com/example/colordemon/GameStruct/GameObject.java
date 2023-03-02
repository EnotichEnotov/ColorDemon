package com.example.colordemon.GameStruct;

public abstract class GameObject {
    public float x,y,velocityX,velocityY;
    public GameObjectType type;
    public GameObject(float x,float y,GameObjectType type,float velocityX,float velocityY) {
        this(x,y,type);
        this.velocityX=velocityX;
        this.velocityY=velocityY;
    }
    public GameObject(float x, float y, GameObjectType type) {
        this.x = x;
        this.y = y;
        this.type=type;
    }
    public abstract void update();
}
