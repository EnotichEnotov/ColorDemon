package com.example.colordemon.GameStruct.Units;

import com.example.colordemon.GameStruct.Collider;
import com.example.colordemon.GameStruct.GameObjectType;

public class Npc extends Unit{
    public Npc(float x, float y, GameObjectType type, Collider collider) {
        super(x, y, 0,0,collider);
    }
}
