package com.example.colordemon.GameStruct;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.colordemon.R;

import java.util.ArrayList;

public class GameObjectFactory {
    ArrayList<GameObjectType> unitTypes; // нужно подгружать все спрайты при создании объекта фабрики, дальше по имени находить

    public GameObjectFactory(Context context) {
        unitTypes = new ArrayList<>();
        ArrayList<Bitmap> pullPersons = new ArrayList<>();
        pullPersons.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.shop_skin_person1),100,200,false));
        unitTypes.add(new GameObjectType(pullPersons,0));
    }

    public GameObjectType getUnitType(Integer name){
        for (GameObjectType type: unitTypes) {
            if(type.name.equals(name)){
                return type;
            }
        }
        return new GameObjectType(unitTypes.get(0).sprite,-1);
    }
}
