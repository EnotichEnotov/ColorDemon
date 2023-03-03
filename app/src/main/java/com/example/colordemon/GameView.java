package com.example.colordemon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colordemon.GameStruct.GameObjectFactory;
import com.example.colordemon.GameStruct.Units.Enemy;
import com.example.colordemon.GameStruct.Units.Hero;

import java.util.ArrayList;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private Button[] abilities = new Button[4];
    private DrawThread myThread;
    private ArrayList<Enemy> enemies;
    private GameObjectFactory unitsFactory = new GameObjectFactory();
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
        myThread = new DrawThread();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }
    public void init(){
        hero = new Hero(getWidth()/2,getHeight()/2,0f,0f,getContext());
    }
    private void CreateButton(float xStart,float yStart,float xEnd,float yEnd){
        // создание кнопки по параметрам, потом пнем в массив кнопок - кнопки для способностей
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (hero.damageType){
            case 0:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        xPress=event.getX();
                        yPress=event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        xUnPress=event.getX();
                        yUnPress=event.getY();
                        break;
                }
                if(xPress!=0 && yPress!=0 && yUnPress!=0 && xUnPress!=0){
                    hero.dash(xUnPress-xPress,yUnPress-yPress);
                    xPress=0; yPress=0; xUnPress=0; yUnPress=0;
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private class DrawThread extends Thread {
        private volatile boolean running = true;

        @Override
        public void run() {
            Canvas canvas;
            while (running) {
                canvas = surfaceHolder.lockCanvas();
                try {
                    sleep(1000);
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

    }
}
