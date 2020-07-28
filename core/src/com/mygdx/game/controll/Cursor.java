package com.mygdx.game.controll;

import com.badlogic.gdx.math.Vector2;

public class Cursor {
    private Vector2 vector2;
    private boolean isTapped;
    private boolean unTouchNear;

    public Cursor(){
        vector2 = new Vector2(0 , 0);
        isTapped = false;
        unTouchNear = false;
    }

    public void tap(int x, int y){
        vector2.x = x;
        vector2.y = y;
        isTapped = true;
        unTouchNear = false;
    }

    public void unTouch(int x, int y){
        if((Math.abs(vector2.x - x) < 10) && (Math.abs(vector2.y - y) < 10)){
            unTouchNear = true;
        }
        isTapped = false;
        vector2.x = x;
        vector2.y = y;
    }

    public Vector2 getVector2() {
        return vector2;
    }

    public boolean isTapped() {
        return isTapped;
    }

    public boolean isUnTouchNear() {
        return unTouchNear;
    }
}
