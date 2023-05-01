package com.example.colordemon.GameStruct;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.mainHero.Ability;
import com.example.colordemon.GameStruct.Units.mainHero.Hero;
import com.example.colordemon.GameStruct.Units.mainHero.Point;
import com.example.colordemon.GameStruct.base.GameObjectFactory;
import com.example.colordemon.GameStruct.colliders.BoxCollider;
import com.example.colordemon.GameStruct.colliders.CircleCollider;
import com.example.colordemon.GameStruct.controllers.CentralObject;
import com.example.colordemon.GameStruct.controllers.DrawController;
import com.example.colordemon.GameStruct.controllers.EnemySpauner;
import com.example.colordemon.R;

import java.util.ArrayList;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private DrawThread myThread;
    private DrawController drawController;
    private EnemySpauner enemySpauner;
    private ArrayList<Enemy> enemies;
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
    private Hero hero;
    public GameView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.flag_german); // добавить бэкграунд
        unitsFactory = new GameObjectFactory(context);
        myThread = new DrawThread();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        init();
        myThread.start();
    }
    public void init(){
        hero = new Hero(getWidth()/4,getHeight()/4,0f,0f,new BoxCollider(hero,100,100),
                100,100,100,100,5,50,15);
        hero.abilities[0] = new Ability(2,getWidth()*3/4,getHeight()*5/6,new CircleCollider(new Point(getWidth()*3/4+50,getHeight()*5/6+50),75),1,0);
        hero.abilities[1] = new Ability(5,getWidth()*3/4+100,getHeight()*5/6+100,new CircleCollider(new Point(getWidth()*3/4+150,getHeight()*5/6+150),75),1,1);
        hero.abilities[2] = new Ability(8,getWidth()*3/4-100,getHeight()*5/6+100,new CircleCollider(new Point(getWidth()*3/4-50,getHeight()*5/6+150),75),1,2);
        hero.abilities[3] = new Ability(10,getWidth()*3/4-100,getHeight()*5/6-100,new CircleCollider(new Point(getWidth()*3/4-50,getHeight()*5/6-50),75),1,3);
        centralObject = new CentralObject(hero);
        enemySpauner = new EnemySpauner(hero,getWidth(),getHeight());
        enemies = new ArrayList<>();
        //enemy = new Enemy(0,0,5,5,new BoxCollider(enemy,100,100),100,100,hero);
        //enemies.add(enemy);
        //enemy = new Enemy(120,450,5,5,new BoxCollider(enemy,100,100),100,100,hero);
        //enemies.add(enemy);
        //enemy = new Enemy(50,50,5,5,new BoxCollider(enemy,100,100),100,100,hero);
        //enemies.add(enemy);
        drawController = new DrawController(centralObject,hero,enemies,null,unitsFactory);
    }
    public void drawFrames(Canvas canvas){
        Rect backgroundRect = new Rect(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(background, null, backgroundRect, null);
        drawController.draw(canvas,getWidth(),getHeight());
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
            i.update();
            if(i.collider.isCollision(hero.x,hero.y)) {Log.i("III",i.damage+" "+hero.velocityY+" "+hero.velocityX+" "+hero.nowDamageCooldown); hero.damageDeal(i);}
            if(i.collider.isCollision(hero.x,hero.y)) i.takeDamage(hero.damage);
            if(i.hp<=0) enemies.remove(i);
        }
        for(Ability i : hero.abilities){
            i.updateCooldown();
            if(i.collider.isCollision(xUnPress,yUnPress)) {
                hero.damageType=i.number; xUnPress=0; yUnPress=0;
                return;
            }
        }
        switch (hero.damageType){
            case 0:
                if(xPress!=0 && yPress!=0 && yUnPress!=0 && xUnPress!=0){
                    hero.dash(xUnPress-xPress,yUnPress-yPress);
                    xPress=0; yPress=0; xUnPress=0; yUnPress=0;
                }
            case 1:
                float minX=100000;
                float minY=100000;
                float addX=-centralObject.getCentralX()+getWidth()/2;
                float addY=-centralObject.getCentralY()+getHeight()/2;
                if(xUnPress==0 && yUnPress==0) break;
                for(Enemy i : enemies){
                    if(Math.pow(i.x+addX-xUnPress,2)+Math.pow(i.y+addY-yUnPress,2)<minX*minX+minY*minY){
                        minX=i.x+addX-xUnPress;
                        minY=i.y+addY-yUnPress;
                    }
                }
                //if(Math.pow(minX,2)+Math.pow(minY,2)>2500) break;
                hero.enemyPort(minX-addX+xUnPress,minY-addY+yUnPress);
                Log.i("III"," "+(minX+addX-xUnPress)+" "+(minY+addY-yUnPress));
                xUnPress=0; yUnPress=0;
                break;
            case 2:
                if(xUnPress!=0 && yUnPress!=0){
                    hero.circleDash(xUnPress,yUnPress,getWidth(),getHeight());
                    xUnPress=0; yUnPress=0;
                }
                break;
        }
        if(timer>10) {
            if(enemies.size()<50) enemies.add(enemySpauner.defaultSpaun());
            timer = 0;
        }
        else timer++;
    }
    private class DrawThread extends Thread {
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
        myThread.running=false;
    }
}
