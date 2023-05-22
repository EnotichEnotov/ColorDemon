package com.example.colordemon.GameStruct.Units;

import android.util.Log;

import com.example.colordemon.GameStruct.colliders.Collider;
import com.example.colordemon.GameStruct.base.GameObject;

public class Enemy extends Unit{
    private GameObject targetObject;
    private float radius;
    public Enemy(float x, float y, float velocityX, float velocityY, Collider collider,float scaleX,float scaleY,GameObject targetObject) {
        super(x, y, velocityX,velocityY,collider,scaleX,scaleY);
        this.targetObject=targetObject;
        radius=(float) Math.sqrt(velocityX*velocityX+velocityY*velocityY);
    }

    public Enemy(float x, float y, float velocityX, float velocityY, Collider collider, float scaleX, float scaleY, int maxHp, int maxMana, int armor, int damage, int damageCooldown,GameObject targetObject) {
        super(x, y, velocityX, velocityY, collider, scaleX, scaleY, maxHp, maxMana, armor, damage, damageCooldown);
        this.targetObject=targetObject;
        radius=(float) Math.sqrt(velocityX*velocityX+velocityY*velocityY);
    }

    @Override
    public void update() {
        super.update();
        if(nowDamageCooldown>0) nowDamageCooldown--;
        if(Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2))<10) return;
        x-=radius*(x-targetObject.x-targetObject.scaleX/2)/(float)Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2));
        y-=radius*(y-targetObject.y-targetObject.scaleY/2)/(float)Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2));
    }
    public void update(boolean cold) {
        if(nowDamageCooldown>0) nowDamageCooldown--;
        if(Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2))<10) return;
        if(!cold){
            x-=radius*(x-targetObject.x-targetObject.scaleX/2)/(float)Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2));
            y-=radius*(y-targetObject.y-targetObject.scaleY/2)/(float)Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2));
        }
        else{
            x-=radius*(x-targetObject.x-targetObject.scaleX/2)/(float)Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2))/2;
            y-=radius*(y-targetObject.y-targetObject.scaleY/2)/(float)Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2))/2;
        }
    }
    public void takeDamage(float damage){
        if(hp>=damage && nowDamageCooldown==0){ hp-=damage*(damage-1)/(damage+armor); nowDamageCooldown=damageCooldown;
            Log.i("AAA",damageCooldown+"");}
        else if(hp<=damage && nowDamageCooldown==0) hp = 0;
    }
}
