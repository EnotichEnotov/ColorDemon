package com.example.colordemon;

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

import com.example.colordemon.GameStruct.GameObjectFactory;
import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.Hero;

import java.util.ArrayList;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private Button[] abilities = new Button[4];
    private DrawThread myThread;
    private ArrayList<Enemy> enemies;
    private GameObjectFactory unitsFactory;
    private SurfaceHolder surfaceHolder;
    private final Bitmap background;
    private float xPress;
    private float yPress;
    private float xUnPress;
    private float yUnPress;
    private Hero hero;
    public GameView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.app); // добавить бэкграунд
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
        hero = new Hero(getWidth()/2,getHeight()/2,0f,0f);
        enemies = new ArrayList<>();
    }
    //private Button createButton(float x, float y,int id){
    //    Button button;
    //    button = findViewById(id);
    //    button.setY(y);
    //    button.setX(x);
    //    button.setHeight(50);
    //    button.setWidth(50);
    //// создание кнопки по параметрам, потом пнем в массив кнопок - кнопки для способностей БРЕД
    //    return button;
    //}
    public void drawFrames(Canvas canvas){
        Rect backgroundRect = new Rect(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(background, null, backgroundRect, null);
        canvas.drawBitmap(unitsFactory.getUnitType(Hero.Name).sprite.get(0),hero.x,hero.y,null);
        for(Enemy i : enemies){}
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (hero.damageType){
            case 0:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        xPress=x;
                        yPress=y;
                        return true;
                    case MotionEvent.ACTION_UP:
                        xUnPress=x;
                        yUnPress=y;
                        break;
                }
        }
        return super.onTouchEvent(event);
    }
    public void tickLogic(){
        hero.run();
        if(xPress!=0 && yPress!=0 && yUnPress!=0 && xUnPress!=0){
            hero.dash(xUnPress-xPress,yUnPress-yPress);
            xPress=0; yPress=0; xUnPress=0; yUnPress=0;
        }
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
