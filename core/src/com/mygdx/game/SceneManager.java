package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class SceneManager {
    private String[] scenes;
    private Scene scene;
    public HashMap<Integer, String> objList;
    private HashMap<Integer, String> scenesList;

    public SceneManager(){
        scenesList = new HashMap<Integer, String>();
    }

    public void create(){ //инициализация scenes(загрузка из файла) + стартовая сцена

    }

    public void drawScene(SpriteBatch batch){    //отрисовка сцены
        scene.draw(batch);
    }

    public void update(){       //Проверка сцены в каждую итерацию render
        if(scene.update()){
            updateScene();
        }
    }

    public void updateScene(){  //Смена сцены
        if(scene.remuveScene()){
            System.out.println("Ошибка удаления сцены " + scene.getId());
        }

    }
}
