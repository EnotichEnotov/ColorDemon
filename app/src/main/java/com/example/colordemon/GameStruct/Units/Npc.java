package com.example.colordemon.GameStruct.Units;

import com.example.colordemon.GameStruct.colliders.Collider;
import com.example.colordemon.GameStruct.base.GameObjectType;

public class Npc extends Unit{
    public Npc(float x, float y, GameObjectType type, Collider collider) {
        super(x, y, 0,0,collider);
    }
}
