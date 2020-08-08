package com.mygdx.game.SceneMaker;

import com.mygdx.game.Objs.GameObj;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.scenes.SceneMakerScene;

import java.util.ArrayList;
import java.util.HashMap;

public class SceneSimulator {
    private GameManager gameManager;
    private SceneMakerScene sceneMakerScene;
    private int id;
    private String sceneName;
    private String audioTheme;
    private int hight;
    private int weight;
    private Integer[] transfers;
    private HashMap<String, ArrayList<ObjSimulator>> sceneObjs;

    public void create(GameManager gameManager, SceneMakerScene sceneMakerScene){
        this.gameManager = gameManager;
        this.sceneMakerScene = sceneMakerScene;
        sceneObjs = new HashMap<>();
        sceneObjs.put("backgraunds", new ArrayList<ObjSimulator>());
        sceneObjs.put("buttons", new ArrayList<ObjSimulator>());
        sceneObjs.put("walls", new ArrayList<ObjSimulator>());
        sceneObjs.put("characters", new ArrayList<ObjSimulator>());
    }

    public void createNewScene(String sceneName, String sceneString){
        this.sceneName = sceneName;
        id = gameManager.getSaveManager().getLastSceneId()+1;
        hight = 800;
        weight = 1280;
        transfers = new Integer[]{0, 0, 0, 0, 0};
        audioTheme = "audio/Motivated.mp3";
    }
}
