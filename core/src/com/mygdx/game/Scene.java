package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Scene {
    protected ArrayList<GameObj> sceneObj;
    protected String mainSound;
    protected int SceneId;
    protected GameObj gameObj;

    public String create(String sceneFileName, int[][] squaresMatrix, GameManager gameManager){
        sceneObj = new ArrayList<>();
        mainSound = getSceneObj(sceneFileName,sceneObj,squaresMatrix,gameManager);
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
            obj.draw(batch);
        }
    }

    public boolean remuveScene(){
        return false;
    }

    public int getId(){
        return SceneId;
    }

    public String getSceneObj(String sceneFileName, ArrayList<GameObj> sceneObj, int[][] squaresMatrix, GameManager gameManager){
        HashMap<Integer,Integer[]> xyAndIdObj = new HashMap<>();  //хранение номера квадрата и ид соотв объектов
        String theme = getSceneFromString(getSceneStringFromFile(sceneFileName),xyAndIdObj); //заполнение xyAndIdObj и получение имени аудио
        Set<Integer> keys = xyAndIdObj.keySet();                               //хранение всех ключей xyAndIdObj (ключ - номер квадрата)
        Integer[] objInSquare;
        for(Integer i : keys){
            float[] xy = {(float)squaresMatrix[1][i],(float)squaresMatrix[2][i]};
            objInSquare = xyAndIdObj.get(i);
            int ind = 0;
            for(Integer obj : objInSquare) {
                System.out.println("obj " + ind + " = " + obj);
                ind++;
                gameObj = gameManager.getGameOgjCreator().createObj(xy, gameManager.getObjsList().get(obj));
                if (gameObj != null) {
                    sceneObj.add(gameObj);
                }
            }
        }
        return theme;
    }

    protected String getSceneFromString(String stringFromFile, HashMap<Integer, Integer[]> objMap){ //возвращает название файла с музыкой, получает строку считанную из файла и ссылку на Hashmap
        stringFromFile = stringFromFile.replace("{","");// удаление кавычек
        stringFromFile =  stringFromFile.replace("}","");
        String[] supStrings = stringFromFile.split(" ",2);
        String sound = supStrings[0];  //название файла со звуковым сопровождением к сцене
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

}