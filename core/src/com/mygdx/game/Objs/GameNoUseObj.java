package com.mygdx.game.Objs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.Scene;

public class GameNoUseObj extends GameObj {

    public GameNoUseObj createObj(int id, int type, float[] xy, Scene scene, GameManager gameManager, String names){ // загрузка текстур в asstsList на вход все названия ассетов
        super.createObj(id, type, xy, scene, gameManager, names);
        return this;
    }

    public boolean update(Scene scene){    //изменение состояния объекта, если возвращено false должен быть удалён
        return super.update(scene);
    }

    protected void updateTexture(){ //изменение текстуры, анимация
        super.updateTexture();
    }
    public void draw(Scene scene, SpriteBatch batch){
        batch.draw(scene.getSceneObjTextureStorage().get(id).get(nowTexture),position.x - 40f,position.y - 40f);
    }

    public float getX(){
        return position.x;
    }

    public  float getY(){
        return position.y;
    }

}
