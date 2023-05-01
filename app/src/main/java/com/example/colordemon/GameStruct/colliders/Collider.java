package com.example.colordemon.GameStruct.colliders;

import com.example.colordemon.GameStruct.base.GameObject;

public abstract class Collider {
    public GameObject gameObject;

    public Collider(GameObject gameObject) {
        this.gameObject=gameObject;
    }
    abstract public boolean isCollision(float x,float y);
}
