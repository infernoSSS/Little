package com.mygdx.game.creators;

import com.mygdx.game.scenes.SceneMakerScene;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.GameScene;
import com.mygdx.game.scenes.Scene;

public class SceneCreator {
    public Scene createScene(String sceneFileName, int[][] squaresMatrix, GameManager gameManager, SceneManager sceneManager){
        int sceneNumb = gameManager.getNumbOfCurScene();
        switch (sceneNumb){
            case (2): return new SceneMakerScene().create(sceneFileName, squaresMatrix, gameManager, sceneManager);
            default :
                return new GameScene().create(sceneFileName, squaresMatrix, gameManager, sceneManager);
        }
    }
}
