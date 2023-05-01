package com.example.colordemon.GameStruct.controllers;

import com.example.colordemon.GameStruct.base.GameObject;

public class CentralObject {
    GameObject gameObject;
    public CentralObject(GameObject gameObject){
        this.gameObject=gameObject;
    }

    public float getCentralX() {
        return gameObject.x+ gameObject.scaleY/2;
    }

    public float getCentralY() {
        return gameObject.y+ gameObject.scaleY/2;
    }
}
