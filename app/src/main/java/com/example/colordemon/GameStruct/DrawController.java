package com.example.colordemon.GameStruct;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.colordemon.GameStruct.Ability;
import com.example.colordemon.GameStruct.CentralObject;
import com.example.colordemon.GameStruct.GameObject;
import com.example.colordemon.GameStruct.GameObjectFactory;
import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.Hero;
import com.example.colordemon.R;

import java.util.ArrayList;
import java.util.jar.Pack200;

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
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);
        for(Ability i : hero.abilities){
            canvas.drawBitmap(createBitmap(i.name,0,100,100),i.x,i.y,null);
            if (i.cooldownNow!=0) canvas.drawText(Math.ceil(i.cooldownNow)+"",i.x+15,i.y+70,paint);
            if(hero.damageType==i.number) canvas.drawCircle(i.collider.gameObject.x,i.collider.gameObject.y,10,paint);
            //canvas.drawCircle(i.collider.centerX,i.collider.centerY,i.collider.radius,paint);
        }
    }
    private Bitmap createBitmap(int name,int number,float scaleX,float scaleY){
        return Bitmap.createScaledBitmap(unitsFactory.getUnitType(name).sprite.get(number),(int)scaleX,(int)scaleY,false);
    }
}
