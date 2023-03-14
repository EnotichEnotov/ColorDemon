package com.example.colordemon.GameStruct;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.colordemon.GameStruct.Ability;
import com.example.colordemon.GameStruct.CentralObject;
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
        //Log.i("III",addX+" "+addY+" "+centralObject.getCentralX());
        canvas.drawBitmap(createBitmap(hero.Name,hero.nowSprite(),hero.scaleX,hero.scaleY),hero.x+addX,hero.y+addY,null);
        for(Enemy i : enemies){
            canvas.drawBitmap(Bitmap.createScaledBitmap(unitsFactory.getUnitType(2).sprite.get(hero.nowSprite()),(int)i.scaleX,(int)i.scaleY,false),i.x+addX,i.y+addY,null);
        }
        for(Ability i : hero.abilities){
            canvas.drawBitmap(createBitmap(i.name,0,100,100),i.x,i.y,null);
        }
    }
    private Bitmap createBitmap(int name,int number,float scaleX,float scaleY){
        return Bitmap.createScaledBitmap(unitsFactory.getUnitType(name).sprite.get(number),(int)scaleX,(int)scaleY,false);
    }
}
