package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;

public class GameObj {
    protected HashMap<String,Texture> assetsList;
    protected float[] xy;
    protected int objId;
    protected String nowTexture;

    public void createObj(float[] xy, String... names){ // загрузка текстур в asstsList на вход все названия ассетов
        nowTexture = names[0];
        assetsList = new HashMap<String,Texture>();
        for(String nowName : names) {
            assetsList.put(nowName,new Texture(Gdx.files.internal(nowName)));
        }
    }

    public boolean update(){    //изменение состояния объекта, если возвращено false должен быть удалён
        updateTexture();
        return true;
    }

    protected void updateTexture(){

    }

    public void draw(SpriteBatch batch){
        // нет xy
        batch.draw(assetsList.get(nowTexture),xy[0],xy[1]);

    }

    public float getX(){
        return xy[0];
    }

    public  float getY(){
        return xy[1];
    }

}
