package com.example.colordemon.GameStruct.gameViews.mage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.mainHero.abilities.Ability;
import com.example.colordemon.GameStruct.Units.mainHero.first.Hero;
import com.example.colordemon.GameStruct.Units.mainHero.abilities.Point;
import com.example.colordemon.GameStruct.Units.mainHero.mage.Fireball;
import com.example.colordemon.GameStruct.Units.mainHero.mage.Mage;
import com.example.colordemon.GameStruct.base.GameObjectFactory;
import com.example.colordemon.GameStruct.colliders.BoxCollider;
import com.example.colordemon.GameStruct.colliders.CircleCollider;
import com.example.colordemon.GameStruct.controllers.CentralObject;
import com.example.colordemon.GameStruct.controllers.DrawController;
import com.example.colordemon.GameStruct.controllers.EnemySpauner;
import com.example.colordemon.R;

import java.util.ArrayList;

public class GameMageView extends SurfaceView implements SurfaceHolder.Callback {
    private DrawThreadMage myThreadMage;
    private DrawController drawController;
    private EnemySpauner enemySpauner;
    private ArrayList<Enemy> enemies;
    int score=0;
    private GameObjectFactory unitsFactory;
    private Enemy enemy;
    private SurfaceHolder surfaceHolder;
    private CentralObject centralObject;
    private final Bitmap background;
    private float xPress;
    private float yPress;
    private float xUnPress;
    private float yUnPress;
    private int timer;
    private Mage hero;
    public GameMageView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.white); // добавить бэкграунд
        unitsFactory = new GameObjectFactory(context);
        myThreadMage = new DrawThreadMage();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        init();
        myThreadMage.start();
    }
    public void init(){
        hero = new Mage(getWidth()/4,getHeight()/4,0f,0f,new BoxCollider(hero,100,100),
                150,150,100,100,5,100,20,enemies);
        hero.abilities[0] = new Ability(1,getWidth()*3/4,getHeight()*5/6,new CircleCollider(new Point(getWidth()*3/4+50,getHeight()*5/6+50),75),4,0);
        hero.abilities[1] = new Ability(5,getWidth()*3/4+100,getHeight()*5/6+100,new CircleCollider(new Point(getWidth()*3/4+150,getHeight()*5/6+150),75),5,1);
        hero.abilities[2] = new Ability(8,getWidth()*3/4-100,getHeight()*5/6+100,new CircleCollider(new Point(getWidth()*3/4-50,getHeight()*5/6+150),75),6,2);
        hero.abilities[3] = new Ability(10,getWidth()*3/4-100,getHeight()*5/6-100,new CircleCollider(new Point(getWidth()*3/4-50,getHeight()*5/6-50),75),7,3);
        centralObject = new CentralObject(hero);
        enemySpauner = new EnemySpauner(hero,getWidth(),getHeight());
        enemies = new ArrayList<>();
        drawController = new DrawController(centralObject,hero,enemies,null,unitsFactory,hero.fireballs);
    }
    public void drawFrames(Canvas canvas){
        Rect backgroundRect = new Rect(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(background, null, backgroundRect, null);
        drawController.draw(canvas,getWidth(),getHeight());
        drawController.drawScore(score,canvas);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                xPress=x;
                yPress=y;
                return true;
            case MotionEvent.ACTION_UP:
                xUnPress=x;
                yUnPress=y;
                return true;
        }
        return super.onTouchEvent(event);
    }
    public void tickLogic(){
        hero.update();
        for(Enemy i : enemies) {
            i.update(hero.cold);
            for(Fireball j : hero.fireballs){
                if(i.collider.isCollision(j.x,j.y)){
                    i.takeDamage(j.damage);
                    hero.fireballs.remove(j);
                }
            }
            if(i.collider.isCollision(hero.x,hero.y)) {Log.i("III",i.damage+" "+hero.velocityY+" "+hero.velocityX+" "+hero.nowDamageCooldown); hero.damageDeal(i);}
            if(i.collider.isCollision(hero.x,hero.y)) i.takeDamage(hero.damage);
            if(i.hp<=0) {enemies.remove(i); score+=50;}
        }
        for(Ability i : hero.abilities){
            i.updateCooldown();
            if(i.collider.isCollision(xUnPress,yUnPress)) {
                hero.damageType=i.number; xUnPress=0; yUnPress=0;
                break;
            }
        }
        switch (hero.damageType){
            case 0:
                if(xPress!=0 && yPress!=0 && yUnPress!=0 && xUnPress!=0){
                    hero.fireAttack(xUnPress-xPress,yUnPress-yPress);
                    xPress=0; yPress=0; xUnPress=0; yUnPress=0;
                }
            case 1:
                float addX=-centralObject.getCentralX()+getWidth()/2;
                float addY=-centralObject.getCentralY()+getHeight()/2;
                if(xUnPress==0 && yUnPress==0) break;
                hero.port(xUnPress-addX,yUnPress-addY);
                xUnPress=0; yUnPress=0;
                break;
            case 2:
                if(xUnPress==0 && yUnPress==0) break;
                hero.cold();
                xUnPress=0;yUnPress=0;
                break;
        }
        if(timer>10) {
            if(enemies.size()<15){
                enemies.add(enemySpauner.defaultSpaun());
            }
            else if(enemies.size()<20){
                enemies.add(enemySpauner.bossSpaun());
            }
            timer = 0;
        }
        else timer++;
    }
    private class DrawThreadMage extends Thread {
        private volatile boolean running = true;

        @Override
        public void run() {
            Canvas canvas;
            while (running) {
                canvas = surfaceHolder.lockCanvas();
                try {
                    drawFrames(canvas);
                    tickLogic();
                } catch (Exception e) {
                    Log.e("RRR", "run: ", e);
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            canvas = surfaceHolder.lockCanvas();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        myThreadMage.running=false;
    }
}
