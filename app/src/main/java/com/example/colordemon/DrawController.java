package com.example.colordemon;

import android.graphics.Canvas;
import android.util.Log;

import com.example.colordemon.GameStruct.GameObject;
import com.example.colordemon.GameStruct.GameObjectFactory;
import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.Hero;

import java.util.ArrayList;

public class DrawController {
    Hero hero;
    GameObjectFactory unitsFactory;
    ArrayList<GameObject> gameObjects;
    ArrayList<Enemy> enemies;
    CentralObject centralObject;
    DrawController(CentralObject centralObject, Hero hero, ArrayList<Enemy> enemies,ArrayList<GameObject> gameObjects,GameObjectFactory unitsFactory){
        this.hero = hero;
        this.gameObjects = gameObjects;
        this.enemies =enemies;
        this.centralObject = centralObject;
        this.unitsFactory=unitsFactory;
    }
    public void draw(Canvas canvas,float width,float height){
        float addX=-centralObject.getCentralX()+width/2;
        float addY=-centralObject.getCentralY()+height/2;
        Log.i("III",addX+" "+addY+" "+centralObject.getCentralX());
        canvas.drawBitmap(unitsFactory.getUnitType(hero.Name).sprite.get(hero.nowSprite()),hero.x+addX,hero.y+addY,null);
        canvas.drawBitmap(unitsFactory.getUnitType(hero.Name).sprite.get(hero.nowSprite()),50+addX,70+addY,null);
        canvas.drawBitmap(unitsFactory.getUnitType(hero.Name).sprite.get(hero.nowSprite()),250+addX,400+addY,null);
        //for(Enemy i : enemies){
            //canvas.drawBitmap(unitsFactory.getUnitType(i.));
        //}
    }

}
