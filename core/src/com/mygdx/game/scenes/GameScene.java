package com.mygdx.game.scenes;

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

public class GameScene implements Scene {
    private HashMap<String, ArrayList<GameObj>> sceneObjs;
    private String mainSound;
    private int sceneId;
    private GameObj gameObj;
    private HashMap<Integer,ArrayList<TextureAtlas.AtlasRegion>> sceneObjTextureStorage;
    private int numbOfSceneChangeButtons;
    private Integer[] transfers;
    private SceneManager sceneManager;

    @Override
    public Scene create(String sceneFileName, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager){
        this.sceneManager = sceneManager;
        sceneId = gameManager.getNumbOfCurScene();
        transfers = gameManager.getSceneTransferList().get(sceneId);
        sceneObjs = new HashMap<>();
        sceneObjs.put("backgraunds", new ArrayList<GameObj>());
        sceneObjs.put("buttons", new ArrayList<GameObj>());
        sceneObjs.put("walls", new ArrayList<GameObj>());
        sceneObjs.put("characters", new ArrayList<GameObj>());
        sceneObjTextureStorage = new HashMap<>();
        mainSound = getSceneObj(sceneFileName, sceneObjs, squaresMatrix, gameManager, sceneManager);
        return this;
    }

    public void update(GameManager gameManager){    //изменение состояния сцены
        for(GameObj obj : sceneObjs.get("backgraunds")){
            obj.update(this, gameManager);
        }
        for(GameObj obj : sceneObjs.get("buttons")){
            obj.update(this, gameManager);
        }
        for(GameObj obj : sceneObjs.get("walls")){
            obj.update(this, gameManager);
        }
        for(GameObj obj : sceneObjs.get("characters")){
            obj.update(this, gameManager);
        }
    }

    public void draw(SpriteBatch batch){
        for(GameObj obj : sceneObjs.get("backgraunds")){
            obj.draw(this, batch);
        }
        for(GameObj obj : sceneObjs.get("buttons")){
            obj.draw(this, batch);
        }
        for(GameObj obj : sceneObjs.get("walls")){
            obj.draw(this, batch);
        }
        for(GameObj obj : sceneObjs.get("characters")){
            obj.draw(this, batch);
        }
    }

    public String getSceneObj(String sceneFileName, HashMap<String, ArrayList<GameObj>> sceneObjs, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager){
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
                    //sceneObjs.add(gameObj);
                    int type = gameObj.getObjType();
                    switch (type){
                        case (1) : sceneObjs.get("backgraunds").add(gameObj);
                        case (2) : sceneObjs.get("buttons").add(gameObj);
                        case (3) : sceneObjs.get("walls").add(gameObj);
                        case (4) : sceneObjs.get("characters").add(gameObj);
                    }
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

    public int getNumbOfSceneChangeButtons() {
        return numbOfSceneChangeButtons;
    }

    public Integer getTransfer(int numb) {
        return transfers[numb];
    }

    public void remuveScene(){
        for(ArrayList<GameObj> list: sceneObjs.values()){
            for(GameObj obj : list){
                obj.dispose();
            }
        }
    }

    public String getMainSound(){
        return mainSound;
    }

    @Override
    public SceneManager getSceneManager() {
        return sceneManager;
    }

    @Override
    public void incrementsOfNumbOfSceneChangeButtons() {
        numbOfSceneChangeButtons++;
    }
}

/*package com.mygdx.game.scenes;

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

public class GameScene implements Scene {
    private HashMap<String, ArrayList<GameObj>> sceneObjs;
    private ArrayList<GameObj> backgraunds;
    private ArrayList<GameObj> buttons;
    private ArrayList<GameObj> walls;
    private ArrayList<GameObj> characters;
    private String mainSound;
    private int sceneId;
    private GameObj gameObj;
    private HashMap<Integer,ArrayList<TextureAtlas.AtlasRegion>> sceneObjTextureStorage;
    private int numbOfSceneChangeButtons;
    private Integer[] transfers;
    private SceneManager sceneManager;

    @Override
    public Scene create(String sceneFileName, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager){
        this.sceneManager = sceneManager;
        sceneId = gameManager.getNumbOfCurScene();
        transfers = gameManager.getSceneTransferList().get(sceneId);
        sceneObjs = new HashMap<>();
        backgraunds = new ArrayList<>();
        sceneObjTextureStorage = new HashMap<>();
        mainSound = getSceneObj(sceneFileName,backgraunds,squaresMatrix,gameManager, sceneManager);
        return this;
    }

    public void update(GameManager gameManager){    //изменение состояния сцены
        for(GameObj obj : backgraunds){
            obj.update(this, gameManager);
        }
    }

    public void draw(SpriteBatch batch){
        for(GameObj obj : backgraunds){
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

    public int getNumbOfSceneChangeButtons() {
        return numbOfSceneChangeButtons;
    }

    public Integer getTransfer(int numb) {
        return transfers[numb];
    }

    public void remuveScene(){
        for(GameObj gameObjI : backgraunds){
            gameObjI.dispose();
        }
    }

    public String getMainSound(){
        return mainSound;
    }

    @Override
    public SceneManager getSceneManager() {
        return sceneManager;
    }

    @Override
    public void incrementsOfNumbOfSceneChangeButtons() {
        numbOfSceneChangeButtons++;
    }

 */