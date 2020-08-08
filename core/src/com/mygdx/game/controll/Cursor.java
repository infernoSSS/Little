package com.mygdx.game.controll;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Cursor {
    private Vector3 vector3;
    private boolean isTapped;
    private boolean unTouchNear;
    OrthographicCamera camera;

    public Cursor(OrthographicCamera camera){
        vector3 = new Vector3(0, 0, 0);
        isTapped = false;
        unTouchNear = false;
        this.camera = camera;
    }

    public void tap(int x, int y){
        vector3.x = x;
        vector3.y = y;
        vector3 = camera.unproject(vector3);
        isTapped = true;
        unTouchNear = false;
    }

    public void unTouch(int x, int y){
        if((Math.abs(vector3.x - x) < 10) && (Math.abs(vector3.y - y) < 10)){
            unTouchNear = true;
        }
        isTapped = false;
        vector3.x = x;
        vector3.y = y;
        vector3 = camera.unproject(vector3);
    }

    public Vector3 getVector3() {
        return vector3;
    }

    public boolean isTapped() {
        return isTapped;
    }

    public boolean isUnTouchNear() {
        return unTouchNear;
    }
}
