package com.example.colordemon.GameStruct.colliders;

import com.example.colordemon.GameStruct.base.GameObject;

public class CircleCollider extends Collider {
    float radius;
    public CircleCollider(GameObject gameObject, float radius){
        super(gameObject);
        this.radius=radius;
    }
    @Override
    public boolean isCollision(float x, float y) {
        return (x-gameObject.x)*(x-gameObject.x)+(y-gameObject.y)*(y-gameObject.y)<=radius*radius;
    }
}
