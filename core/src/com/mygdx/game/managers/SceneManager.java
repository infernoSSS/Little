package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.creators.SceneCreator;
import com.mygdx.game.scenes.Scene;

import java.sql.Struct;
import java.util.HashMap;
import static com.mygdx.game.Util.Utils.getScenesList;
import static com.mygdx.game.Util.fileSupport.takeStringFromFile;

public final class SceneManager {
    private Scene scene;
    private HashMap<Integer, String> scenesList;
    private int[][] squaresMatrix;
    private Music sceneTheme;
    private SceneCreator sceneCreator;
    private GameManager gameManager;
    private boolean flagOfFirsScene;
    private boolean drawUI;

    private int numbOfCurScene;

    public SceneManager(GameManager gameManager){
        flagOfFirsScene = true;
        drawUI = false;
        sceneCreator = new SceneCreator();
        scenesList = new HashMap<>();
        numbOfCurScene = gameManager.getNumbOfCurScene();
    }

    public void create( GameManager gameManager){ //инициализация scene(загрузка из файла)
        this.gameManager = gameManager;
        updateScene(gameManager.getNumbOfCurScene());
        flagOfFirsScene = false;
    }

    public void drawScene(SpriteBatch batch){    //отрисовка сцены
        scene.draw(batch);
    }

    public void update(GameManager gameManager){       //Проверка сцены в каждую итерацию render
        scene.update(gameManager);
    }

    public void updateScene(int newSceneId){  //Смена сцены
        gameManager.setNumbOCurfScene(newSceneId);
        if(!flagOfFirsScene) {
            dispose();
        }
        scenesList =gameManager.getScenes();
        numbOfCurScene = gameManager.getNumbOfCurScene();
        scene = sceneCreator.createScene(scenesList.get(numbOfCurScene),squaresMatrix,gameManager, this);//создание сцены
        sceneTheme = Gdx.audio.newMusic(Gdx.files.internal(scene.getMainSound()));//определение музыкальной темы
        sceneTheme.setLooping(true);
        sceneTheme.play();
    }

    public int[][] getSquaresMatrix() {
        return squaresMatrix;
    }

    public void setSquaresMatrix(int[][] squaresMatrix) {
        this.squaresMatrix = squaresMatrix;
    }

    public boolean isDrawUI() {
        return drawUI;
    }

    public void setDrawUI(int onOff) {
        if(onOff == 1){
            this.drawUI = true;
        }else {
            this.drawUI = false;
        }
    }

    public void dispose(){
        sceneTheme.stop();
        sceneTheme.dispose();
        scene.remuveScene();
    }
}
