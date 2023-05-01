package com.example.colordemon.GameStruct.controllers;

import com.example.colordemon.GameStruct.base.GameObject;
import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.colliders.BoxCollider;

public class EnemySpauner {
    GameObject defaultTarget;
    float width;
    Enemy enemy;
    float height;
    public EnemySpauner(GameObject defaultTarget,float width,float height){
        this.defaultTarget=defaultTarget;
        this.width=width;
        this.height=height;
    }
    public Enemy defaultSpaun(){
        int znakX=Math.random() > 0.5 ? -1 : 1;
        int znakY=Math.random() > 0.5 ? -1 : 1;
        enemy = new Enemy(defaultTarget.x+(float)(width+Math.random()*300)*znakX,defaultTarget.y+(float)(width+Math.random()*300)*znakY,5,5,
                new BoxCollider(enemy,100,100),
                100,100,100,100,1,50,
                50,defaultTarget);
        return enemy;
    }
}
