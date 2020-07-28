package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Scene;
import java.util.HashMap;
import static com.mygdx.game.Util.Utils.getScenesList;
import static com.mygdx.game.Util.fileSupport.takeStringFromFile;

public final class SceneManager {
    private Scene scene;
    private HashMap<Integer, String> scenesList;
    private int[][] squaresMatrix;
    private Music sceneTheme;
    private String fileOfScenesList;

    private int numbOfCurScene;

    public SceneManager(GameManager gameManager){
        scenesList = new HashMap<>();
        numbOfCurScene = gameManager.getNumbOfScene();
        fileOfScenesList = "resurs/scenesList.txt";
    }

    public void create( GameManager gameManager){ //инициализация scenes(загрузка из файла) + стартовая сцена
        getScenesList(takeStringFromFile(fileOfScenesList),scenesList);
        scene = new Scene();
        sceneTheme = Gdx.audio.newMusic(Gdx.files.internal(scene.create(scenesList.get(numbOfCurScene),squaresMatrix,gameManager, this)));//создание сцены и определение музыкальной темы
        sceneTheme.setLooping(true);
        sceneTheme.play();
    }

    public void drawScene(SpriteBatch batch){    //отрисовка сцены
        scene.draw(batch);
    }

    public void update(GameManager gameManager){       //Проверка сцены в каждую итерацию render
        scene.update(gameManager);
    }

    private void updateScene(){  //Смена сцены
        if(scene.remuveScene()){
            System.out.println("Ошибка удаления сцены " + scene.getId());
        }

    }

    public int[][] getSquaresMatrix() {
        return squaresMatrix;
    }

    public void setSquaresMatrix(int[][] squaresMatrix) {
        this.squaresMatrix = squaresMatrix;
    }
}
