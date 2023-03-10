package com.example.colordemon.GameStruct;

public class BoxCollider implements Collider{
    private GameObject gameObject;
    private float paddingX=100f;
    private float paddingY=100f;
    public BoxCollider(GameObject gameObject, float paddingX, float paddingY){
        this.paddingX=paddingX;
        this.paddingY=paddingY;
        this.gameObject=gameObject;
    }

    @Override
    public boolean isCollision(float x,float y) {
        if(Math.abs(x-gameObject.x+gameObject.scaleX/2)<=paddingX && Math.abs(y-gameObject.y+ gameObject.scaleY)<=paddingY) return true;
        return false;
    }
}
