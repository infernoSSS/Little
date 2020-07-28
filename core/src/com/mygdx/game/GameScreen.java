package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;

public class GameScreen {
    SceneManager sceneManager;
    GameManager gameManager;
    boolean pause;

    public void createScreen(){
        gameManager = new GameManager();
        gameManager.create();
        sceneManager = new SceneManager(gameManager);
        sceneManager.create(gameManager);
        pause = false;
    }

    public void draw(SpriteBatch batch){
        sceneManager.drawScene(batch);
    }

    public void update(){

    }


    public void dispose() {
    }
}
