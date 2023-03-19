package com.example.colordemon.GameStruct;

public abstract class Collider {
    public GameObject gameObject;
    public float centerX, centerY;

    public Collider(float centerX, float centerY) {
        this.centerX=centerX;
        this.centerY=centerY;
    }

    abstract boolean isCollision(float x,float y);
}
