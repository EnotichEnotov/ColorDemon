package com.example.colordemon.GameStruct.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.colordemon.R;

import java.util.ArrayList;

public class GameObjectFactory {
    ArrayList<GameObjectType> unitTypes; // нужно подгружать все спрайты при создании объекта фабрики, дальше по имени находить

    public GameObjectFactory(Context context) { // 2 - атака1, 3 - обычное состояние, 5 - атака2, 6 - атака3, 7 - получение урона
        unitTypes = new ArrayList<>();
        ArrayList<Bitmap> pullPersons = new ArrayList<>();
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.shop_skin_person1)); // для каждого типа персонажей свой пулл спрайтов
        unitTypes.add(new GameObjectType(pullPersons,0));
        pullPersons = new ArrayList<>();
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.shop_skin_person2));
        unitTypes.add(new GameObjectType(pullPersons,1));
        pullPersons = new ArrayList<>();
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_1_1));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_1_2));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_1_3));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_1_4));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_1_5));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_1_6));
        unitTypes.add(new GameObjectType(pullPersons,2));
        pullPersons = new ArrayList<>();
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.idle_1));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.idle_2));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.idle_3));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.idle_4));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.idle_5));
        unitTypes.add(new GameObjectType(pullPersons,3));
        pullPersons = new ArrayList<>();
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.dash)); // для каждого типа персонажей свой пулл спрайтов
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.portal));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.circledash));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.ultimate));
        unitTypes.add(new GameObjectType(pullPersons,4));
        pullPersons = new ArrayList<>();
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_4_1)); // для каждого типа персонажей свой пулл спрайтов
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_4_2));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_4_3));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_4_4));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_4_5));
        unitTypes.add(new GameObjectType(pullPersons,5));
        pullPersons = new ArrayList<>();
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_5_1)); // для каждого типа персонажей свой пулл спрайтов
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_5_2));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_5_3));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_5_4));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.attack_5_5));
        unitTypes.add(new GameObjectType(pullPersons,6));
        pullPersons = new ArrayList<>();
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.hurt_1));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.hurt_2));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.hurt_1));
        pullPersons.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.hurt_2));
        unitTypes.add(new GameObjectType(pullPersons,7));
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
