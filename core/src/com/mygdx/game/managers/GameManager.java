package com.mygdx.game.managers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.GameOgjCreator;
import com.mygdx.game.controll.GameController;

import java.util.HashMap;

import static com.mygdx.game.Util.fileSupport.takeStringFromFile;

public final class GameManager {
    private int numbOfScene;
    private String lastSave;
    private HashMap<Integer, String> objsList;
    private String objsListFileName;
    private TextureAtlas textureAtlas;
    private TextureManager textureManager;
    private SaveManager saveManager;
    private LoadManager loadManager;
    private GameOgjCreator gameOgjCreator;
    private GameController gameController;

    public void create(){
        gameController = new GameController();
        gameOgjCreator = new GameOgjCreator();
        textureManager = new TextureManager();
        loadManager = new LoadManager();
        saveManager = new SaveManager();
        objsListFileName = "resurs/objFile.txt"; //здесь лежит HashMap с key - id, val - String описание объекта
        objsList = new HashMap<>();
        loadManager.loadObjsFromFile(takeStringFromFile(objsListFileName),objsList);
        numbOfScene = saveManager.getNumbOfStartScene();
        textureAtlas = textureManager.createTextureAtlas();
    }



    public HashMap<Integer, String> getObjsList(){
        return objsList;
    }

    public GameOgjCreator getGameOgjCreator() {
        return gameOgjCreator;
    }

    public int getNumbOfScene() {
        return numbOfScene;
    }

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void delete(){

    }

}
