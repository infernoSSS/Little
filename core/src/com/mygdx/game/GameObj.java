package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class GameObj {
    protected ArrayList<Texture> assetsList;
    protected Vector2 cords;
    protected int nowTexture;
    private int objType;

    public GameObj createObj(int type, float[] xy, String... names){ // загрузка текстур в asstsList на вход все названия ассетов
        objType = type;
        nowTexture = 0;
        this.cords = new Vector2(xy[0],xy[1]);
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
        batch.draw(assetsList.get(nowTexture),cords.x,cords.y);

    }

    public float getX(){
        return cords.x;
    }

    public  float getY(){
        return cords.y;
    }

}
