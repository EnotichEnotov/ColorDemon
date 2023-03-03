package com.example.colordemon.GameStruct;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class GameObjectFactory {
    ArrayList<GameObjectType> unitTypes; // нужно подгружать все спрайты при создании объекта фабрики, дальше по имени находить
    public GameObjectType getUnitType(Integer name){
        for (GameObjectType type: unitTypes) {
            if(type.name.equals(name)){
                return type;
            }
        }
        return new GameObjectType(unitTypes.get(0).sprite,0);
    }
}
