package com.mygdx.game.Objs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.scenes.Scene;
import com.mygdx.game.managers.GameManager;

public class Backgraund extends GameObj {

    public Backgraund createObj(int id, int type, float[] xy, Scene gameScene, GameManager gameManager, String names){ // загрузка текстур в asstsList на вход все названия ассетов
        super.createObj(id, type, xy, gameScene, gameManager, names);
        return this;
    }

    public boolean update(Scene scene, GameManager gameManager){    //изменение состояния объекта, если возвращено false должен быть удалён
        return super.update(scene, gameManager);
    }

    protected void updateTexture(int nowTexture){ //изменение текстуры, анимация
        super.updateTexture(nowTexture);
    }
    public void draw(Scene gameScene, SpriteBatch batch){
        batch.draw(gameScene.getSceneObjTextureStorage().get(id).get(nowTexture),position.x - 40f,position.y - 40f);
    }

    public float getX(){
        return position.x;
    }

    public  float getY(){
        return position.y;
    }

}
