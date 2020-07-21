package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class SceneManager {
    private String[] scenes;
    private Scene scene;
    public HashMap<Integer, String> objList;
    private HashMap<Integer, String> scenesList;
    private int[][] squaresMatrix;

    public SceneManager(){
        scenesList = new HashMap<>();
    }

    public void create(){ //инициализация scenes(загрузка из файла) + стартовая сцена
        squaresMatrix = createSquaresMatrix();
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

    public void updateScene(){  //Смена сцены
        if(scene.remuveScene()){
            System.out.println("Ошибка удаления сцены " + scene.getId());
        }

    }

    private void scenePause(){

    }

    public int[][] createSquaresMatrix(){
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

}
