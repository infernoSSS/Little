package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public final class SceneManager {
    private Scene scene;
    private HashMap<Integer, String> scenesList;
    private int[][] squaresMatrix;
    private Music sceneTheme;
    private String fileOfScenesList;
    private int numbOfCurScene;

    public SceneManager(GameManager gameManager){
        scenesList = new HashMap<>();
        numbOfCurScene = gameManager.getNumbOfStartScene();
        fileOfScenesList = "resurs/scenesList.txt";
    }

    public void create( GameManager gameManager){ //инициализация scenes(загрузка из файла) + стартовая сцена
        squaresMatrix = createSquaresMatrix();
        getScenesList(gameManager.takeStringFromFile(fileOfScenesList),scenesList);
        scene = new Scene();
        sceneTheme = Gdx.audio.newMusic(Gdx.files.internal(scene.create(scenesList.get(numbOfCurScene),squaresMatrix,gameManager)));//создание сцены и определение музыкальной темы
        sceneTheme.setLooping(true);
        sceneTheme.play();
    }

    public void drawScene(SpriteBatch batch){    //отрисовка сцены
        scene.draw(batch);
    }

    public void update(){       //Проверка сцены в каждую итерацию render
        scenePause();
        if(scene.update()){
            updateScene();
        }
    }

    private void updateScene(){  //Смена сцены
        if(scene.remuveScene()){
            System.out.println("Ошибка удаления сцены " + scene.getId());
        }

    }

    private void scenePause(){

    }

    private int[][] createSquaresMatrix(){   //нужно модифицировать под любое разрешение
        int[][] matrix = new int[3][160];   //1й столбец матрицы номер квадрат, 2й его x0, 3й его y0
        int num = 0;                        //номер квадрата
        for(int j = 0; j < 800; j+=80){        //строки
            for (int i = 0; i < 1280; i+=80){   //столбцы в строке
                matrix[0][num] = num;
                matrix[1][num] = i;
                matrix[2][num] = j;
                num++;
            }
        }
        return matrix;
    }

    private void getScenesList(String stringFromFile, HashMap<Integer, String> objMap){ //возвращает название файла с музыкой, получает строку считанную из файла и ссылку на Hashmap
        stringFromFile = stringFromFile.replace("{","");// удаление кавычек
        stringFromFile =  stringFromFile.replace("}","");
        stringFromFile =  stringFromFile.replace(" ","");
        String[] supStrings = stringFromFile.split(",");
        String[] supStrings2;
        for(String s : supStrings){
            supStrings2 = s.split("=");
            objMap.put(Integer.parseInt(supStrings2[0]), supStrings2[1]);
        }
    }

}
