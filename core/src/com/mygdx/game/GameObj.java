package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;

public class GameObj {
    protected ArrayList<Texture> assetsList;
    protected float[] xy;
    protected int nowTexture;

    public GameObj createObj(float[] xy, String... names){ // загрузка текстур в asstsList на вход все названия ассетов
        nowTexture = 0;
        this.xy = xy;
        assetsList = new ArrayList<>();
        for(String nowName : names) {
            assetsList.add(new Texture(Gdx.files.internal(nowName)));
        }
        return this;
    }

    public boolean update(){    //изменение состояния объекта, если возвращено false должен быть удалён
        updateTexture();
        return true;
    }

    protected void updateTexture(){ //изменение текстуры, анимация

    }

    public void draw(SpriteBatch batch){
        batch.draw(assetsList.get(nowTexture),xy[0],xy[1]);

    }

    public float getX(){
        return xy[0];
    }

    public  float getY(){
        return xy[1];
    }

}
