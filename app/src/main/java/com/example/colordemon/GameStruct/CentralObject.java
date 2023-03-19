package com.example.colordemon.GameStruct;

import com.example.colordemon.GameStruct.GameObject;

public class CentralObject {
    GameObject gameObject;
    CentralObject(GameObject gameObject){
        this.gameObject=gameObject;
    }

    public float getCentralX() {
        return gameObject.x+ gameObject.scaleY/2;
    }

    public float getCentralY() {
        return gameObject.y+ gameObject.scaleY/2;
    }
}
