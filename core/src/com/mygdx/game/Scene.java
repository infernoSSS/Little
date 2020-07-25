package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Scene {
    protected ArrayList<GameObj> sceneObj;
    protected String mainSound;
    protected int SceneId;
    protected GameObj gameObj;
    protected HashMap<Integer,ArrayList<TextureAtlas.AtlasRegion>> sceneObjTextureStorage;


    public String create(String sceneFileName, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager){
        sceneObj = new ArrayList<>();
        sceneObjTextureStorage = new HashMap<>();
        mainSound = getSceneObj(sceneFileName,sceneObj,squaresMatrix,gameManager, sceneManager);
        return mainSound;
    }

    public boolean update(){    //изменение состояния сцены и проверка на выход из сцены
        for(GameObj obj : sceneObj){
            obj.update();
        }
        return false;
    }

    public void draw(SpriteBatch batch){
        for(GameObj obj : sceneObj){
            obj.draw(this, batch);
        }
    }

    public boolean remuveScene(){
        return false;
    }

    public int getId(){
        return SceneId;
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

    protected String getSceneFromString(String stringFromFile, HashMap<Integer, Integer[]> objMap, SceneManager sceneManager){ //возвращает название файла с музыкой, получает строку считанную из файла и ссылку на Hashmap
        stringFromFile = stringFromFile.replace("{","");// удаление кавычек
        stringFromFile =  stringFromFile.replace("}","");
        String[] supStrings = stringFromFile.split("~",3);
        String sound = supStrings[0];  //название файла со звуковым сопровождением к сцене
        sceneManager.createSquaresMatrix(supStrings[2]);
        supStrings[1] =  supStrings[1].replace(" ","");
        supStrings = supStrings[1].split(","); // разбиваем на пары ключ-значение
        String[] supStrings2; //для хранения пары номер квадрата - массив объектов для этого номера
        String[] supString3; //для хранения массива объектов перед отправкой
        Integer[] objMass;
        for(String s : supStrings){
            supStrings2 = s.split("=");
            supString3 = supStrings2[1].split("&");
            int i =0;
            objMass = new Integer[supString3.length];
            for(String s1 : supString3) {
                 objMass[i] = Integer.parseInt(s1);
                 i++;
            }
            objMap.put(Integer.parseInt(supStrings2[0]), objMass);
        }
        return sound;
    }

    protected String getSceneStringFromFile(String fileName){
        FileHandle sceneFile = Gdx.files.local(fileName);
        return sceneFile.readString();
    }

    public HashMap<Integer, ArrayList<TextureAtlas.AtlasRegion>> getSceneObjTextureStorage() {
        return sceneObjTextureStorage;
    }

    public void addObjTextures(GameManager gameManager, int id, ArrayList<String> arrayList){
        ArrayList<TextureAtlas.AtlasRegion> arrayTextureList = new ArrayList<>();
        for (String s1 : arrayList) {
            arrayTextureList.add(gameManager.getTextureAtlas().findRegion(s1));
        }
        sceneObjTextureStorage.put(id, arrayTextureList);
    }

}