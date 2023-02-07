package com.example.colordemon.GameStruct;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class GameObjectFactory {
    static ArrayList<GameObjectType> unitTypes;
    public static GameObjectType getUnitType(Integer name,ArrayList<Bitmap> sprite){
        for (GameObjectType type: unitTypes) {
            if(type.name.equals(name)){
                return type;
            }
        }
        GameObjectType unitType = new GameObjectType(sprite,name);
        unitTypes.add(unitType);
        return unitType;
    }
}
