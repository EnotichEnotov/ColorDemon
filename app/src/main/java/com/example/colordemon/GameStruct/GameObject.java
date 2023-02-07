package com.example.colordemon.GameStruct;

public abstract class GameObject {
    public float x,y,velocity;
    public GameObjectType type;
    public GameObject(float x,float y,GameObjectType type,float velocity) {
        this(x,y,type);
        this.velocity=velocity;
    }
    public GameObject(float x, float y, GameObjectType type) {
        this.x = x;
        this.y = y;
        this.type=type;
    }
    public abstract void update();
}
