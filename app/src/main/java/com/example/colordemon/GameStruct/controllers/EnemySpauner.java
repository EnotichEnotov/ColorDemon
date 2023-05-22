package com.example.colordemon.GameStruct.controllers;

import com.example.colordemon.GameStruct.base.GameObject;
import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.colliders.BoxCollider;

public class EnemySpauner {
    GameObject defaultTarget;
    float width;
    Enemy enemy;
    public int maxHp=75, maxMana=100, scaleX=150,scaleY=150,armor=2,damage=50,velocityX=6,velocityY=6;
    float height;
    public EnemySpauner(GameObject defaultTarget,float width,float height){
        this.defaultTarget=defaultTarget;
        this.width=width;
        this.height=height;
    }
    public Enemy defaultSpaun(){
        int znakX=Math.random() > 0.5 ? -1 : 1;
        int znakY=Math.random() > 0.5 ? -1 : 1;
        enemy = new Enemy(defaultTarget.x+(float)(width+Math.random()*300)*znakX,defaultTarget.y+(float)(width+Math.random()*300)*znakY,velocityX,velocityY,
                new BoxCollider(enemy,100,100),
                scaleX,scaleY,maxHp,maxMana,armor,damage,
                10,defaultTarget);
        enemy.collider.gameObject=enemy;
        return enemy;
    }
    public Enemy customSpaun(GameObject target,int scaleX,int scaleY,int maxHp,int maxMana,int armor, int damage,int velocityX,int velocityY){
        int znakX=Math.random() > 0.5 ? -1 : 1;
        int znakY=Math.random() > 0.5 ? -1 : 1;
        enemy = new Enemy(defaultTarget.x+(float)(width+Math.random()*300)*znakX,defaultTarget.y+(float)(width+Math.random()*300)*znakY,velocityX,velocityY,
                new BoxCollider(enemy,scaleX,scaleY),
                scaleX,scaleY,maxHp,maxMana,armor,damage,
                10,target);
        enemy.collider.gameObject=enemy;
        return enemy;
    }
    public Enemy bossSpaun(){
        int znakX=Math.random() > 0.5 ? -1 : 1;
        int znakY=Math.random() > 0.5 ? -1 : 1;
        enemy = new Enemy(defaultTarget.x+(float)(width+Math.random()*300)*znakX,defaultTarget.y+(float)(width+Math.random()*300)*znakY,3,3,
                new BoxCollider(enemy,150,150),
                150,150,200,100,4,100,
                15,defaultTarget);
        enemy.collider.gameObject=enemy;
        return enemy;
    }
}
