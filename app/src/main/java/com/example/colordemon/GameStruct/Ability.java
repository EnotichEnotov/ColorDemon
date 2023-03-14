package com.example.colordemon.GameStruct;

import android.graphics.Bitmap;

import com.example.colordemon.GameStruct.CircleCollider;

public class Ability{
    public int name;
    private float frame = 0.1f;
    public float cooldown;
    public int number;
    public float cooldownNow = 0;
    public float x;
    public float y;
    CircleCollider collider;
    Ability(float cooldown,float x,float y,CircleCollider collider,int name,int number){
        this.collider=collider;
        this.x=x;
        this.cooldown=cooldown;
        this.y=y;
        this.number=number;
        this.name=name;
    }
    public void updateCooldown(){
        if(cooldownNow-frame<0) cooldownNow=0;
        else cooldownNow-=frame;
    }
    public void setCooldownNow(){
        cooldownNow=cooldown;
    }
}
