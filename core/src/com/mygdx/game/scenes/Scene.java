package com.mygdx.game.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Objs.GameObj;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;

import java.util.ArrayList;
import java.util.HashMap;

public interface Scene {

    public Scene create(String sceneFileName, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager);

    public void update(GameManager gameManager);

    public void draw(SpriteBatch batch);

    public String getSceneObj(String sceneFileName, HashMap<String, ArrayList<GameObj>> sceneObjs, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager);

    public void addObjTextures(GameManager gameManager, int id, ArrayList<String> arrayList);

    public HashMap<Integer, ArrayList<TextureAtlas.AtlasRegion>> getSceneObjTextureStorage();

    public int getId();

    public int getNumbOfSceneChangeButtons();

    public Integer getTransfer(int numb);

    public void remuveScene();

    public String getMainSound();

    public SceneManager getSceneManager();

    public void incrementsOfNumbOfSceneChangeButtons();

}
