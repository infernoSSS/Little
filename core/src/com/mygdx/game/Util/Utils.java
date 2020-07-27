package com.mygdx.game.Util;

import com.mygdx.game.managers.SceneManager;

import java.util.HashMap;

public class Utils {

    public static int[][] createSquaresMatrix(String resolution){   //нужно модифицировать под любое разрешение
        String[] supStrings = resolution.split("x");
        int weight = Integer.parseInt(supStrings[0]);
        int hight = Integer.parseInt(supStrings[1]);
        int[][] matrix = new int[3][weight*hight/80/80];   //1й столбец матрицы номер квадрат, 2й его x0, 3й его y0
        int num = 0;                        //номер квадрата
        for(int j = 40; j < hight; j+=80){        //строки
            for (int i = 40; i < weight; i+=80){   //столбцы в строке
                matrix[0][num] = num;
                matrix[1][num] = i;
                matrix[2][num] = j;
                num++;
            }
        }
        return matrix;
    }

    public static void getScenesList(String stringFromFile, HashMap<Integer, String> objMap){ //возвращает название файла с музыкой, получает строку считанную из файла и ссылку на Hashmap
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

    public static String getSceneFromString(String stringFromFile, HashMap<Integer, Integer[]> objMap, SceneManager sceneManager){ //возвращает название файла с музыкой, получает строку считанную из файла и ссылку на Hashmap
        stringFromFile = stringFromFile.replace("{","");// удаление кавычек
        stringFromFile =  stringFromFile.replace("}","");
        String[] supStrings = stringFromFile.split("~",3);
        String sound = supStrings[0];  //название файла со звуковым сопровождением к сцене
        sceneManager.setSquaresMatrix(createSquaresMatrix(supStrings[2]));
        supStrings[1] =  supStrings[1].replace(" ","");
        supStrings = supStrings[1].split(","); // разбиваем на пары ключ-значение
        String[] supStrings2; //для хранения пары номер квадрата - массив объектов для этого номера
        String[] supString3; //для хранения массива объектов перед отправкой
        Integer[] objMass;
        for(String s : supStrings){
            supStrings2 = s.split("=");
            supString3 = supStrings2[1].split("&");
            int i =0;
            objMass = new Integer[supString3.length];
            for(String s1 : supString3) {
                objMass[i] = Integer.parseInt(s1);
                i++;
            }
            objMap.put(Integer.parseInt(supStrings2[0]), objMass);
        }
        return sound;
    }
}
