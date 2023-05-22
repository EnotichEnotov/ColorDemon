package com.example.colordemon.GameStruct.controllers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.colordemon.GameStruct.Units.mainHero.abilities.Ability;
import com.example.colordemon.GameStruct.Units.mainHero.MainCharacter;
import com.example.colordemon.GameStruct.base.GameObject;
import com.example.colordemon.GameStruct.base.GameObjectFactory;
import com.example.colordemon.GameStruct.Units.Enemy;

import java.util.ArrayList;

public class DrawController {
    MainCharacter hero;
    GameObjectFactory unitsFactory;
    ArrayList<GameObject> gameObjects;
    ArrayList<Enemy> enemies;
    CentralObject centralObject;
    public DrawController(CentralObject centralObject, MainCharacter hero, ArrayList<Enemy> enemies, ArrayList<GameObject> gameObjects, GameObjectFactory unitsFactory){
        this.hero = hero;
        this.gameObjects = gameObjects;
        this.enemies =enemies;
        this.centralObject = centralObject;
        this.unitsFactory=unitsFactory;
    }
    public void draw(Canvas canvas,float width,float height){
        float addX=-centralObject.getCentralX()+width/2;
        float addY=-centralObject.getCentralY()+height/2;
        Paint paint1 = new Paint();
        paint1.setColor(Color.MAGENTA);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawBitmap(createBitmap(hero.Name,hero.nowSprite(),hero.scaleX,hero.scaleY),hero.x+addX,hero.y+addY,null);
        for(Enemy i : enemies){
            Rect rect1 = new Rect((int) (i.x+addX+i.scaleX/2-100),(int)(i.y+addY+i.scaleY/2-150),(int)(i.x+addX+i.scaleX/2+100),(int)(i.y+addY+i.scaleY/2-125));
            Rect rect = new Rect((int) (i.x+addX+i.scaleX/2-100),(int)(i.y+addY+i.scaleY/2-150),(int)(i.x+addX+i.scaleX/2+100*i.hp/i.maxHp),(int)(i.y+addY+i.scaleY/2-125));
            canvas.drawRect(rect1,paint1);
            if(i.hp>0)canvas.drawRect(rect,paint);
            if (Math.random() > 0.5) {
                canvas.drawBitmap(Bitmap.createScaledBitmap
                        (unitsFactory.getUnitType(2).sprite.get(hero.nowSprite())
                                , (int) i.scaleX, (int) i.scaleY, false), i.x + addX, i.y + addY, null);
            } else {
                canvas.drawBitmap(Bitmap.createScaledBitmap
                        (unitsFactory.getUnitType(1).sprite.get(hero.nowSprite())
                                , (int) i.scaleX, (int) i.scaleY, false), i.x + addX, i.y + addY, null);
            }
        }
        if(hero.hp<=0){
            Paint paint2 = new Paint();
            paint2.setTextSize(100);
            paint2.setColor(Color.RED);
            canvas.drawText("ПОРАЖЕНИЕ",width/6,height/2,paint2);
        }
        paint.setTextSize(50);
        Rect rect1 = new Rect((int) (hero.x+addX+hero.scaleX/2-100),(int)(hero.y+addY+hero.scaleY/2-200),(int)(hero.x+addX+hero.scaleX/2+100),(int)(hero.y+addY+hero.scaleY/2-150));
        Rect rect = new Rect((int) (hero.x+addX+hero.scaleX/2-100),(int)(hero.y+addY+hero.scaleY/2-200),(int)(hero.x+addX+hero.scaleX/2+100*hero.hp/hero.maxHp),(int)(hero.y+addY+hero.scaleY/2-150));
        canvas.drawRect(rect1,paint1);
        if(hero.hp>0)canvas.drawRect(rect,paint);
        for(Ability i : hero.abilities){
            canvas.drawBitmap(createBitmap(4,i.name-4,100,100),i.x,i.y,null);
            if (i.cooldownNow!=0) canvas.drawText(Math.ceil(i.cooldownNow)+"",i.x+15,i.y+70,paint);
            if(hero.damageType==i.number) canvas.drawCircle(i.collider.gameObject.x,i.collider.gameObject.y,10,paint);
            //canvas.drawCircle(i.collider.centerX,i.collider.centerY,i.collider.radius,paint);
        }
        hero.draw(canvas,addX,addY);
    }
    private Bitmap createBitmap(int name,int number,float scaleX,float scaleY){
        return Bitmap.createScaledBitmap(unitsFactory.getUnitType(name).sprite.get(number),(int)scaleX,(int)scaleY,false);
    }
}
