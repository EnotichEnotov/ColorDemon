package com.example.colordemon.GameStruct.Units;

import com.example.colordemon.GameStruct.Collider;
import com.example.colordemon.GameStruct.GameObject;
import com.example.colordemon.GameStruct.GameObjectType;

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
        if(Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2))<10) return;
        x-=radius*(x-targetObject.x-targetObject.scaleX/2)/(float)Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2));
        y-=radius*(y-targetObject.y-targetObject.scaleY/2)/(float)Math.sqrt((x-targetObject.x-targetObject.scaleX/2)*(x-targetObject.x-targetObject.scaleX/2)+(y-targetObject.y-targetObject.scaleY/2)*(y-targetObject.y-targetObject.scaleY/2));

    }
}
