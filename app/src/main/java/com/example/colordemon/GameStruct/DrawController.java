package com.example.colordemon.GameStruct;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.colordemon.GameStruct.Ability;
import com.example.colordemon.GameStruct.CentralObject;
import com.example.colordemon.GameStruct.GameObject;
import com.example.colordemon.GameStruct.GameObjectFactory;
import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.Hero;
import com.example.colordemon.R;

import java.util.ArrayList;
import java.util.Random;
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
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.RED);
            canvas.drawText("ПОРАЖЕНИЕ",width/6,height/2,paint);
        }
        Paint paint1 = new Paint();
        paint1.setColor(Color.MAGENTA);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);
        Rect rect1 = new Rect((int) (hero.x+addX+hero.scaleX/2-100),(int)(hero.y+addY+hero.scaleY/2-200),(int)(hero.x+addX+hero.scaleX/2+100),(int)(hero.y+addY+hero.scaleY/2-150));
        Rect rect = new Rect((int) (hero.x+addX+hero.scaleX/2-100),(int)(hero.y+addY+hero.scaleY/2-200),(int)(hero.x+addX+hero.scaleX/2+100*hero.hp/hero.maxHp),(int)(hero.y+addY+hero.scaleY/2-150));
        canvas.drawRect(rect1,paint1);
        if(hero.hp>0)canvas.drawRect(rect,paint);
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
