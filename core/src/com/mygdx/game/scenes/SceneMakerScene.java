package com.mygdx.game.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Objs.GameObj;
import com.mygdx.game.SceneMaker.*;
import com.mygdx.game.SceneMaker.SceneMakerElements.*;
import com.mygdx.game.SceneMaker.utils.Dialogue;
import com.mygdx.game.SceneMaker.utils.HidingWindow;
import com.mygdx.game.SceneMaker.utils.Tip;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class SceneMakerScene implements Scene {
    private GameManager gameManager;
    private SceneManager sceneManager;
    private SceneFileManager sceneFileManager;
    private Stage stage;
    private SceneSimulator sceneSimulator;
    private String mainSound;
    private int thisSceneId;
    private ObjSelectionSheet objSelectionSheet;
    private SceneSettingsSheet sceneSettingsSheet;
    private SceneRedZone sceneRedZone;
    private ToStart toStart;
    private ArrayList<SceneMakerElement> scenesElemets;
    private HashMap<String, HidingWindow> hidingWindowMap;

    @Override
    public Scene create(String sceneFileName, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager) {
        this.gameManager = gameManager;
        this.sceneManager = sceneManager;
        this.stage = new Stage();
        gameManager.getGameController().getInputMultiplexer().addProcessor(stage);
        sceneFileManager = new SceneFileManager();
        sceneSimulator = new SceneSimulator();
        sceneFileManager.create(this);
        sceneSimulator.create(gameManager, this);
        thisSceneId = gameManager.getNumbOfCurScene();
        mainSound = "audio/SceneMakerMusic.wav";
        scenesElemets = new ArrayList<>();
        scenesElemets.add(sceneSettingsSheet = new SceneSettingsSheet());
        scenesElemets.add(sceneRedZone = new SceneRedZone());
        scenesElemets.add(objSelectionSheet = new ObjSelectionSheet());
        scenesElemets.add(toStart = new ToStart());
        for(SceneMakerElement s : scenesElemets){
            s.create(this, gameManager, sceneManager);
        }

        hidingWindowMap = new HashMap<>();
        hidingWindowMap.put("newScene", new Tip("New scene created!", this, gameManager));
        hidingWindowMap.put("sceneFound", new Tip("The scene found!", this, gameManager));
        hidingWindowMap.put("sceneNotFound", new Tip("The scene was not found!", Color.RED, this, gameManager));
        hidingWindowMap.put("inputNewSceneName", new Dialogue("Input your scene name", 640, 400, gameManager));
        for(HidingWindow hidingWindow : hidingWindowMap.values()){
            hidingWindow.create(this, gameManager, sceneManager);
        }

        return this;
    }

    @Override
    public void update(GameManager gameManager) {
        for(SceneMakerElement s : scenesElemets){
            s.update();
        }
        for(HidingWindow t : hidingWindowMap.values()){
            t.update();
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        for(SceneMakerElement s : scenesElemets){
            s.draw(batch);
        }
        for(HidingWindow t : hidingWindowMap.values()){
            t.draw(batch);
        }
    }

    @Override
    public String getSceneObj(String sceneFileName, HashMap<String, ArrayList<GameObj>> sceneObjs, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager) {
        return null;
    }

    @Override
    public void addObjTextures(GameManager gameManager, int id, ArrayList<String> arrayList) {

    }

    public HashMap<Integer, ArrayList<TextureAtlas.AtlasRegion>> getSceneObjTextureStorage() {
        return null;
    }

    public int getId(){
        return thisSceneId;
    }

    public int getNumbOfSceneChangeButtons() {
        return 0;
    }

    public Integer getTransfer(int numb) {
        return null;
    }

    public String getMainSound(){
        return mainSound;
    }

    @Override
    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public HashMap<String, HidingWindow> getHideingWindowsList() {
        return hidingWindowMap;
    }

    public SceneFileManager getSceneFileManager() {
        return sceneFileManager;
    }

    public SceneSimulator getSceneSimulator() {
        return sceneSimulator;
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void incrementsOfNumbOfSceneChangeButtons() {

    }

    public void remuveScene(){
        for(SceneMakerElement s : scenesElemets){
            s.dispose();
        }
        gameManager.getGameController().getInputMultiplexer().removeProcessor(stage);
    }

}
