package com.mygdx.game.Objs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.scenes.Scene;
import com.mygdx.game.managers.GameManager;

import java.util.ArrayList;

public abstract class GameObj {
    protected Vector3 position;
    protected int nowTexture;
    protected int objType;
    protected int id;
    protected int weight;
    protected int hight;
    protected Rectangle hitBox;


    public GameObj createObj(int id, int type, float[] xy, Scene gameScene, GameManager gameManager, String names){
        objType = type;
        nowTexture = 0;
        this.position = new Vector3(xy[0], xy[1], 0);
        this.id = id;
        loadTextures(gameScene, gameManager, getNames(names));
        weight = gameScene.getSceneObjTextureStorage().get(id).get(nowTexture).getRegionWidth();
        hight = gameScene.getSceneObjTextureStorage().get(id).get(nowTexture).getRegionHeight();
        hitBox = new Rectangle(position.x, position.y, weight, hight);
        return this;
    }

    public boolean update(Scene Scene, GameManager gameManager){    //изменение состояния объекта, если возвращено false должен быть удалён
        updateTexture(nowTexture);
        hitBox.setCenter(position.x, position.y);
        weight = Scene.getSceneObjTextureStorage().get(id).get(nowTexture).getRegionWidth();
        hight = Scene.getSceneObjTextureStorage().get(id).get(nowTexture).getRegionHeight();
        hitBox.setWidth(weight);
        hitBox.setHeight(hight);
        return true;
    }

    protected void updateTexture(int textureNumb){ //изменение текстуры, анимация

    }

    public void draw(Scene gameScene, SpriteBatch batch){
       batch.draw(gameScene.getSceneObjTextureStorage().get(id).get(nowTexture),position.x - 40f, position.y - 40f);
    }

    protected void loadTextures(Scene gameScene, GameManager gameManager, String names){
        ArrayList<String> arrayList = new ArrayList<>();
        String[] supString = names.split("&");
        for(String s : supString){
            arrayList.add(s);
        }
       gameScene.addObjTextures(gameManager, id, arrayList);
    }

    public float getX(){
        return position.x;
    }

    public  float getY(){
        return position.y;
    }

    protected String getNames(String... names){
        return names[0];
    }

    public int getObjType() {
        return objType;
    }

    public void dispose(){

    }
}