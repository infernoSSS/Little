package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Objs.GameObj;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static com.mygdx.game.Util.Utils.getSceneFromString;
import static com.mygdx.game.Util.fileSupport.getSceneStringFromFile;

public class Scene {
    private ArrayList<GameObj> sceneObj;
    private String mainSound;
    private int sceneId;
    private GameObj gameObj;
    private HashMap<Integer,ArrayList<TextureAtlas.AtlasRegion>> sceneObjTextureStorage;


    public String create(String sceneFileName, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager){
        sceneId = gameManager.getNumbOfScene();
        sceneObj = new ArrayList<>();
        sceneObjTextureStorage = new HashMap<>();
        mainSound = getSceneObj(sceneFileName,sceneObj,squaresMatrix,gameManager, sceneManager);
        return mainSound;
    }

    public void update(){    //изменение состояния сцены
        for(GameObj obj : sceneObj){
            obj.update(this);
        }
    }

    public void draw(SpriteBatch batch){
        for(GameObj obj : sceneObj){
            obj.draw(this, batch);
        }
    }

    public String getSceneObj(String sceneFileName, ArrayList<GameObj> sceneObj, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager){
        HashMap<Integer,Integer[]> xyAndIdObj = new HashMap<>();  //хранение номера квадрата и ид соотв объектов
        String theme = getSceneFromString(getSceneStringFromFile(sceneFileName),xyAndIdObj, sceneManager); //заполнение xyAndIdObj и получение имени аудио
        Set<Integer> keys = xyAndIdObj.keySet();                               //хранение всех ключей xyAndIdObj (ключ - номер квадрата)
        Integer[] objInSquare;
        for(Integer i : keys){
            float[] xy = {(float)sceneManager.getSquaresMatrix()[1][i], (float)sceneManager.getSquaresMatrix()[2][i]};
            objInSquare = xyAndIdObj.get(i);
            int ind = 0;
            for(Integer obj : objInSquare) {
                ind++;
                gameObj = gameManager.getGameOgjCreator().createObj(obj, xy,this, gameManager, gameManager.getObjsList().get(obj));
                if (gameObj != null) {
                    sceneObj.add(gameObj);
                }
            }
        }
        return theme;
    }

    public void addObjTextures(GameManager gameManager, int id, ArrayList<String> arrayList){
        ArrayList<TextureAtlas.AtlasRegion> arrayTextureList = new ArrayList<>();
        for (String s1 : arrayList) {
            arrayTextureList.add(gameManager.getTextureAtlas().findRegion(s1));
        }
        sceneObjTextureStorage.put(id, arrayTextureList);
    }

    public HashMap<Integer, ArrayList<TextureAtlas.AtlasRegion>> getSceneObjTextureStorage() {
        return sceneObjTextureStorage;
    }

    public int getId(){
        return sceneId;
    }

    public boolean remuveScene(){
        return false;
    }

}