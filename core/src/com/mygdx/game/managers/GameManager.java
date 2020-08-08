package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.creators.GameOgjCreator;
import com.mygdx.game.controll.GameController;

import java.util.HashMap;

import static com.mygdx.game.Util.HashMapTranslator.intMassTranslateHashMapToOneString;
import static com.mygdx.game.Util.Utils.getScenesList;
import static com.mygdx.game.Util.fileSupport.takeStringFromFile;

public final class GameManager {
    private float deltaTime;
    private int numbOCurfScene;
    private String lastSave;
    private HashMap<Integer, String> objsList;
    private HashMap<Integer, Integer[]> sceneTransferList;
    private HashMap<Integer, String> scenesList;
    private String objsListFileName;
    private String sceneTransferListFileName;
    private String fileOfScenesList;
    private TextureAtlas textureAtlas;
    private TextureManager textureManager;
    private SaveManager saveManager;
    private LoadManager loadManager;
    private GameOgjCreator gameOgjCreator;
    private GameController gameController;
    private Skin skin;

    public void create(OrthographicCamera camera){
        deltaTime = 0;
        gameController = new GameController(camera);
        gameOgjCreator = new GameOgjCreator();
        textureManager = new TextureManager();
        loadManager = new LoadManager();
        saveManager = new SaveManager();
        objsListFileName = "resurs/objFile.txt"; //здесь лежит HashMap с key - id, val - String описание объекта
        sceneTransferListFileName = "resurs/sceneTransfersFile.txt";
        fileOfScenesList = "resurs/scenesList.txt";
        objsList = new HashMap<>();
        sceneTransferList = new HashMap<>();
        scenesList = new HashMap<>();
        getScenesList(takeStringFromFile(fileOfScenesList),scenesList);
        loadManager.loadObjsFromFile(takeStringFromFile(objsListFileName),objsList);
        loadManager.loadSceneTransfersFromFile(takeStringFromFile(sceneTransferListFileName), sceneTransferList);
        numbOCurfScene = saveManager.getNumbOfStartScene();
        textureAtlas = textureManager.createTextureAtlas();
        skin = new Skin(Gdx.files.internal("uiskin.json"));
    }

    public void update(){
        deltaTime = Gdx.graphics.getDeltaTime();
    }

    public HashMap<Integer, String> getObjsList(){
        return objsList;
    }

    public HashMap<Integer, Integer[]> getSceneTransferList() {
        return sceneTransferList;
    }

    public GameOgjCreator getGameOgjCreator() {
        return gameOgjCreator;
    }

    public int getNumbOfCurScene() {
        return numbOCurfScene;
    }

    public void setNumbOCurfScene(int numbOCurfScene) {
        this.numbOCurfScene = numbOCurfScene;
    }

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public GameController getGameController() {
        return gameController;
    }

    public float getDeltaTime() {
        return deltaTime;
    }

    public Skin getSkin() {
        return skin;
    }

    public HashMap<Integer, String> getScenes() {
        return scenesList;
    }

    public SaveManager getSaveManager() {
        return saveManager;
    }

    public void delete(){

    }

}
