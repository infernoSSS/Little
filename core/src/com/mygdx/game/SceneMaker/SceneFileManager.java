package com.mygdx.game.SceneMaker;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.scenes.SceneMakerScene;

public class SceneFileManager {
    private String sceneFileName;
    private SceneMakerScene sceneMakerScene;

    public void create(SceneMakerScene sceneMakerScene){
        this.sceneMakerScene = sceneMakerScene;
    }

    private int searchScene(String sceneId){
        if(sceneId.equals("new")){
            sceneMakerScene.getHideingWindowsList().get("inputNewSceneName").show();
            sceneMakerScene.getHideingWindowsList().get("newScene").show();
            return 1;
        }else {
            boolean exists = sceneMakerScene.getGameManager().getScenes().containsKey(Integer.parseInt(sceneId));
            if(exists){
                sceneMakerScene.getHideingWindowsList().get("sceneFound").show();
                return 2;
            }else {
                sceneMakerScene.getHideingWindowsList().get("sceneNotFound").show();
                return 3;
            }
        }
    }

    public String loadScene(String sceneName){
        searchScene(sceneName);
        return null;
    }

}
