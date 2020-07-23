package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class GameNoUseObj extends GameObj {

    public GameNoUseObj createObj(int type, float[] xy, String... names){ // загрузка текстур в asstsList на вход все названия ассетов
        super.createObj(type, xy, names); //
        return this;
    }

    public boolean update(){    //изменение состояния объекта, если возвращено false должен быть удалён
        return super.update();
    }

    protected void updateTexture(){ //изменение текстуры, анимация
        super.updateTexture();
    }

    public void draw(SpriteBatch batch){
        batch.draw(assetsList.get(nowTexture),cords.x,cords.y);
    }

    public float getX(){
        return cords.x;
    }

    public  float getY(){
        return cords.y;
    }

}
