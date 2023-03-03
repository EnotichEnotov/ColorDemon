package com.example.colordemon.GameStruct.Units;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.colordemon.GameStruct.GameObjectType;
import com.example.colordemon.R;

import java.util.ArrayList;

public class Hero extends Unit{
    private ArrayList<Bitmap> sprites; // расписать - какие данные - какие
    private float stopSpeed = 5f;
    public int damageType = 0;
    public Hero(float x, float y, float velocityX, float velocityY, Context context) {
        super(x, y, velocityX,velocityY);
    }
    private void addSprites(Context context){
        sprites.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.app)); // сделать отдельный выбор спрайтов для персонажа
    }
    private void stopping(){
        if(velocityX-stopSpeed>0) velocityX-=stopSpeed;
        else velocityY=0;
        if(velocityY-stopSpeed>0) velocityY-=stopSpeed;
        else velocityY=0;
    }
    public void dash(float addVelocityX,float addVelocityY){
        velocityX+=addVelocityX;
        velocityY+=addVelocityY;
    }
}
