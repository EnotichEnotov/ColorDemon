package com.example.colordemon.GameStruct;

public abstract class Collider {
    public GameObject gameObject;

    public Collider(GameObject gameObject) {
        this.gameObject=gameObject;
    }
    abstract boolean isCollision(float x,float y);
}
