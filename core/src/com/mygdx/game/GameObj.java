package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public abstract class GameObj {
    protected Vector2 position;
    protected int nowTexture;
    protected int objType;
    protected int id;


    public GameObj createObj(int id, int type, float[] xy, Scene scene, GameManager gameManager, String... names){ // загрузка текстур в asstsList на вход все названия ассетов
        objType = type;
        nowTexture = 0;
        this.position = new Vector2(xy[0],xy[1]);
        this.id = id;
        loadTextures(scene, gameManager, getNames(names));
        return this;
    }

    public boolean update(){    //изменение состояния объекта, если возвращено false должен быть удалён
        updateTexture();
        return true;
    }

    protected void updateTexture(){ //изменение текстуры, анимация

    }

    public void draw(Scene scene, SpriteBatch batch){
       batch.draw(scene.getSceneObjTextureStorage().get(id).get(nowTexture),position.x,position.y);
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

/*
public class GameObj {
    protected ArrayList<Texture> assetsList;
    protected Vector2 position;
    protected int nowTexture;
    private int objType;

    public GameObj createObj(int type, float[] xy, Scene scene, GameManager gameManager, String... names){ // загрузка текстур в asstsList на вход все названия ассетов
        objType = type;
        nowTexture = 0;
        this.position = new Vector2(xy[0],xy[1]);
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
        batch.draw(assetsList.get(nowTexture),position.x,position.y);
    }

    public float getX(){
        return position.x;
    }

    public  float getY(){
        return position.y;
    }

}

 */