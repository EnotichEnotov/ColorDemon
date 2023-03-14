package com.example.colordemon.GameStruct;

import com.example.colordemon.GameStruct.GameObject;

public class CentralObject {
    GameObject gameObject;
    CentralObject(GameObject gameObject){
        this.gameObject=gameObject;
    }

    public float getCentralX() {
        return gameObject.x+50;
    }

    public float getCentralY() {
        return gameObject.y+100;
    }
}
