package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class GameNoUseObj extends GameObj {

    public GameNoUseObj createObj(int id, int type, float[] xy, Scene scene, GameManager gameManager, String... names){ // загрузка текстур в asstsList на вход все названия ассетов
        super.createObj(id, type, xy,scene, gameManager, names); //
        return this;
    }

    public boolean update(){    //изменение состояния объекта, если возвращено false должен быть удалён
        return super.update();
    }

    protected void updateTexture(){ //изменение текстуры, анимация
        super.updateTexture();
    }
    public void draw(Scene scene, SpriteBatch batch){
        batch.draw(scene.getSceneObjTextureStorage().get(id).get(nowTexture),position.x,position.y);
    }

    public float getX(){
        return position.x;
    }

    public  float getY(){
        return position.y;
    }

}
