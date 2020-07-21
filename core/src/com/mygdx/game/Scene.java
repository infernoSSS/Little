package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;

public class Scene {
    protected ArrayList<GameObj> sceneObj;
    protected Sound mainSoud;
    protected int SceneId;

    public int create(){
        sceneObj = new ArrayList<GameObj>();
        return 0;
    }

    public boolean update(){    //изменение состояния сцены и проверка на выход из сцены
        for(GameObj obj : sceneObj){
            obj.update();
        }
        return false;
    }

    public void draw(SpriteBatch batch){
        for(GameObj obj : sceneObj){
            obj.draw(batch);
        }
    }

    public boolean remuveScene(){
        return false;
    }

    public int getId(){
        return SceneId;
    }
}
