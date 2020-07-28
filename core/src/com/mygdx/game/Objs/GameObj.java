package com.mygdx.game.Objs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.Scene;

import java.util.ArrayList;

public abstract class GameObj {
    protected Vector3 position;
    protected int nowTexture;
    protected int objType;
    protected int id;


    public GameObj createObj(int id, int type, float[] xy, Scene scene, GameManager gameManager, String names){
        objType = type;
        nowTexture = 0;
        this.position = new Vector3(xy[0], xy[1], 0);
        this.id = id;
        System.out.println(position);//
        loadTextures(scene, gameManager, getNames(names));
        return this;
    }

    public boolean update(Scene scene, GameManager gameManager){    //изменение состояния объекта, если возвращено false должен быть удалён
        updateTexture();
        return true;
    }

    protected void updateTexture(){ //изменение текстуры, анимация

    }

    public void draw(Scene scene, SpriteBatch batch){
       batch.draw(scene.getSceneObjTextureStorage().get(id).get(nowTexture),position.x - 40f, position.y - 40f);
    }

    protected void loadTextures(Scene scene, GameManager gameManager, String names){
        ArrayList<String> arrayList = new ArrayList<>();
        String[] supString = names.split("&");
        for(String s : supString){
            arrayList.add(s);
        }
       scene.addObjTextures(gameManager, id, arrayList);
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

}