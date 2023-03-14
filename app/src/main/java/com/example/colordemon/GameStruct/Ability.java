package com.example.colordemon.GameStruct;

import android.graphics.Bitmap;

import com.example.colordemon.GameStruct.CircleCollider;

public class Ability{
    public int name;
    public float cooldown;
    public float x;
    public float y;
    CircleCollider collider;
    Ability(float cooldown,float x,float y,CircleCollider collider,int name){
        this.collider=collider;
        this.x=x;
        this.cooldown=cooldown;
        this.y=y;
        this.name=name;
    }
}
