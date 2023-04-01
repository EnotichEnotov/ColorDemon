package com.example.colordemon.GameStruct.Units;

import android.util.Log;

import com.example.colordemon.GameStruct.Ability;
import com.example.colordemon.GameStruct.Collider;

public abstract class MainCharacter extends Unit{
    public Ability[] abilities = new Ability[4];
    public int damageType = 0;
    public MainCharacter(float x, float y, float velocityX, float velocityY, Collider collider, float scaleX, float scaleY) {
        super(x, y, velocityX, velocityY, collider, scaleX, scaleY);
    }
}
