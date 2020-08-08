package com.mygdx.game.creators;

import com.mygdx.game.Objs.Backgraund;
import com.mygdx.game.Objs.Character;
import com.mygdx.game.Objs.GameObj;
import com.mygdx.game.Objs.SceneChangeButton;
import com.mygdx.game.Objs.Wall;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.scenes.Scene;

public class GameOgjCreator {
    public GameObj createObj(int id, float[] xy, Scene scene, GameManager gameManager, String... names){
        String[] supStringsToGetType = names;
        String[] supStr2 = supStringsToGetType[0].split("!", 2);
        supStringsToGetType[0] = supStr2[1];
        int type = Integer.parseInt(supStr2[0]);
        switch (type){
            case (0) :
                return null;
            case (1) :
                return new Backgraund().createObj(id, type, xy, scene, gameManager,  supStringsToGetType[0]);
            case  (2) :
                GameObj sceneChangeButton = new SceneChangeButton().createObj(id, type, xy, scene, gameManager,  supStringsToGetType[0]);
                scene.incrementsOfNumbOfSceneChangeButtons();
                return sceneChangeButton;
            case (3) :
                return new Wall().createObj(id, type, xy, scene, gameManager,  supStringsToGetType[0]);
            case (4) :
                return new Character().createObj(id, type, xy, scene, gameManager,  supStringsToGetType[0]);
            default: return null;
        }
    }
}
