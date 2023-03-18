package com.example.colordemon.GameStruct;

public abstract class Collider {
    public GameObject gameObject;
    abstract boolean isCollision(float x,float y);
}
